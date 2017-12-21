package com.eternal.design.service.impl;

import com.eternal.design.entity.Command;
import com.eternal.design.entity.CommandExample;
import com.eternal.design.mapper.CommandMapper;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandServiceImpl implements CommandService {
    @Autowired
    private CommandMapper commandMapper;

    @Override
    public PageResult<Command> findByPage(CommandExample example) {
        return PageUtil.queryByPage(() -> commandMapper.countByExample(example), () -> commandMapper.selectByExample(example));
    }

    @Override
    public Command findById(Integer id) {
        return commandMapper.selectByPrimaryKey(id);
    }

    @Override
    public Command insertOrUpdate(Command command) {
        if(command.getId() == null) {
            commandMapper.insertSelective(command);
        } else {
            commandMapper.updateByPrimaryKeySelective(command);
        }
        return command;
    }

    @Override
    public int deleteById(Integer id) {
        return commandMapper.deleteByPrimaryKey(id);
    }
}
