package com.eternal.design.service;


import com.eternal.design.entity.CoachPatientRelationship;
import com.eternal.design.entity.User;
import com.eternal.design.entity.UserExample;
import com.eternal.design.page.PageResult;

import java.util.List;
import java.util.Map;

public interface UserService {
    PageResult<User> findByPage(UserExample example);

    User findById(Integer id);

    User insertOrUpdate(User user);

    int deleteById(Integer id);

    User findByUsername(String username);

    List<User> findAll();

    User findCoachByPatientId(Integer id);

    Map<Integer, User> findCoachByPatientIdList(List<Integer> idList);

    List<User> findByExample(UserExample example);

    void seCoachPatientRelationship(Integer coachId, Integer patientId);

    List<Integer> findPatientIdListByCoachId(Integer coachId);
}
