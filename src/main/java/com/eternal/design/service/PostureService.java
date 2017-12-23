package com.eternal.design.service;


import com.eternal.design.entity.Posture;
import com.eternal.design.entity.PostureExample;
import com.eternal.design.page.PageResult;

import java.util.List;

public interface PostureService {
    PageResult<Posture> findByPage(PostureExample example);

    Posture findById(Integer id);

    Posture insertOrUpdate(Posture posture);

    int deleteById(Integer id);

    List<Posture> findByIds(List<Integer> idList);
}
