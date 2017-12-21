package com.eternal.design.service;


import com.eternal.design.entity.Command;
import com.eternal.design.entity.CommandExample;
import com.eternal.design.page.PageResult;

public interface CommandService {
    PageResult<Command> findByPage(CommandExample example);

    Command findById(Integer id);

    Command insertOrUpdate(Command command);

    int deleteById(Integer id);
}
