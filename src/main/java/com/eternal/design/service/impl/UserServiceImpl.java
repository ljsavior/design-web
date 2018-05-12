package com.eternal.design.service.impl;

import com.eternal.design.entity.CoachPatientRelationship;
import com.eternal.design.entity.CoachPatientRelationshipExample;
import com.eternal.design.entity.User;
import com.eternal.design.entity.UserExample;
import com.eternal.design.mapper.CoachPatientRelationshipMapper;
import com.eternal.design.mapper.UserMapper;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CoachPatientRelationshipMapper coachPatientRelationshipMapper;

    @Override
    public PageResult<User> findByPage(UserExample example) {
        return PageUtil.queryByPage(() -> userMapper.countByExample(example), () -> userMapper.selectByExample(example));
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User insertOrUpdate(User user) {
        if(user.getId() == null) {
            userMapper.insertSelective(user);
        } else {
            userMapper.updateByPrimaryKeySelective(user);
        }
        return user;
    }

    @Override
    public int deleteById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if(user == null) {
            return 0;
        }
        CoachPatientRelationshipExample example = new CoachPatientRelationshipExample();
        if(user.getRole() == 2) {
            example.createCriteria().andCoachUserIdEqualTo(id);
        } else if(user.getRole() == 3) {
            example.createCriteria().andPatientUserIdEqualTo(id);
        }
        coachPatientRelationshipMapper.deleteByExample(example);
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User findByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);

        return userMapper.selectByExample(example).stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public User findCoachByPatientId(Integer id) {
        CoachPatientRelationshipExample example = new CoachPatientRelationshipExample();
        example.createCriteria().andPatientUserIdEqualTo(id);
        List<CoachPatientRelationship> coachPatientRelationships = coachPatientRelationshipMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(coachPatientRelationships)) {
            return userMapper.selectByPrimaryKey(coachPatientRelationships.get(0).getCoachUserId());
        }
        return null;
    }

    @Override
    public Map<Integer, User> findCoachByPatientIdList(List<Integer> idList) {
        if(CollectionUtils.isEmpty(idList)) {
            return Collections.emptyMap();
        }

        CoachPatientRelationshipExample coachPatientRelationshipExample = new CoachPatientRelationshipExample();
        coachPatientRelationshipExample.createCriteria().andPatientUserIdIn(idList);
        List<CoachPatientRelationship> coachPatientRelationships = coachPatientRelationshipMapper.selectByExample(coachPatientRelationshipExample);

        if(CollectionUtils.isEmpty(coachPatientRelationships)) {
            return Collections.emptyMap();
        }

        List<Integer> coachIdList = coachPatientRelationships.stream()
                .map(CoachPatientRelationship::getCoachUserId)
                .collect(Collectors.toList());

        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(coachIdList);
        Map<Integer, User> coachMap = userMapper.selectByExample(userExample)
                .stream()
                .collect(Collectors.toMap(User::getId, u -> u));

        return coachPatientRelationships.stream()
                .collect(Collectors.toMap(CoachPatientRelationship::getPatientUserId, r -> coachMap.get(r.getCoachUserId())));
    }

    @Override
    public List<User> findByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public void seCoachPatientRelationship(Integer coachId, Integer patientId) {
        if(coachId == null || patientId == null) {
            return;
        }

        CoachPatientRelationship record = new CoachPatientRelationship();
        record.setCoachUserId(coachId);
        record.setPatientUserId(patientId);

        CoachPatientRelationshipExample example = new CoachPatientRelationshipExample();
        example.createCriteria().andPatientUserIdEqualTo(patientId);

        int count = coachPatientRelationshipMapper.updateByExampleSelective(record, example);
        if(count == 0) {
            coachPatientRelationshipMapper.insertSelective(record);
        }
    }

    @Override
    public List<Integer> findPatientIdListByCoachId(Integer coachId) {
        CoachPatientRelationshipExample example = new CoachPatientRelationshipExample();
        example.createCriteria().andCoachUserIdEqualTo(coachId);
        return coachPatientRelationshipMapper.selectByExample(example).stream()
                .map(CoachPatientRelationship::getPatientUserId)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findPatientListByCoachId(Integer coachId) {
        List<Integer> patientIdList = findPatientIdListByCoachId(coachId);
        if(CollectionUtils.isEmpty(patientIdList)) {
            return Collections.emptyList();
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(patientIdList);
        return userMapper.selectByExample(userExample);
    }
}
