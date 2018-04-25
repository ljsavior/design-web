package com.eternal.design.service.impl;

import com.eternal.design.entity.Posture;
import com.eternal.design.entity.PostureExample;
import com.eternal.design.mapper.PostureMapper;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.PostureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostureServiceImpl implements PostureService {
    @Autowired
    private PostureMapper postureMapper;

    @Override
    public PageResult<Posture> findByPage(PostureExample example) {
        return PageUtil.queryByPage(() -> postureMapper.countByExample(example), () -> postureMapper.selectByExampleWithBLOBs(example));
    }

    @Override
    public Posture findById(Integer id) {
        return postureMapper.selectByPrimaryKey(id);
    }

    @Override
    public Posture insertOrUpdate(Posture posture) {
        if(posture.getId() == null) {
            postureMapper.insertSelective(posture);
        } else {
            postureMapper.updateByPrimaryKeySelective(posture);
        }
        return posture;
    }

    @Override
    public int deleteById(Integer id) {
        return postureMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Posture> findByIds(List<Integer> idList) {
        PostureExample example = new PostureExample();
        example.createCriteria().andIdIn(idList);

        return postureMapper.selectByExampleWithBLOBs(example);
    }
}
