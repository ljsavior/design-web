package com.eternal.design.service.impl;

import com.eternal.design.entity.Action;
import com.eternal.design.entity.ActionExample;
import com.eternal.design.mapper.ActionMapper;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionMapper actionMapper;

    @Override
    public PageResult<Action> findByPage(ActionExample example) {
        return PageUtil.queryByPage(() -> actionMapper.countByExample(example), () -> actionMapper.selectByExample(example));

    }

    @Override
    public Action findById(Integer id) {
        return actionMapper.selectByPrimaryKey(id);
    }

    @Override
    public Action insertOrUpdate(Action posture) {
        if(posture.getId() == null) {
            actionMapper.insertSelective(posture);
        } else {
            actionMapper.updateByPrimaryKeySelective(posture);
        }
        return posture;
    }

    @Override
    public int deleteById(Integer id) {
        return actionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Action> findByIds(List<Integer> idList) {
        ActionExample example = new ActionExample();
        example.createCriteria().andIdIn(idList);

        return actionMapper.selectByExample(example);
    }
}
