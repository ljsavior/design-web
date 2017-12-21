package com.eternal.design.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.eternal.design.common.DateFormatUtil;
import com.eternal.design.entity.Command;
import com.eternal.design.entity.CommandExample;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.CommandService;
import com.eternal.design.web.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommandController {
    @Autowired
    private CommandService commandService;

    @RequestMapping("/command/list.htm")
    public String list() {
        return "command/list";
    }

    @RequestMapping("/command/query.json")
    @ResponseBody
    public Object query(String commandFunction, String description) {
        CommandExample commandExample = new CommandExample();
        CommandExample.Criteria criteria = commandExample.createCriteria();

        if(StringUtils.isNotEmpty(commandFunction)) {
            criteria.andCommandFunctionEqualTo(Byte.parseByte(commandFunction));
        }

        if(StringUtils.isNotEmpty(description)) {
            criteria.andCommandDescriptionLike("%" + description + "%");
        }


        PageResult<Command> pageResult = commandService.findByPage(commandExample);
        JSONObject result = PageUtil.parseResult(pageResult, command -> {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(command.getId()));
            row.add(String.format("%02d", command.getCommandFunction()));
            row.add(command.getCommandDescription());
            row.add(command.getReturnDataDescription());
            row.add(DateFormatUtil.format(command.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
            row.add(DateFormatUtil.format(command.getLastModTime(), "yyyy-MM-dd HH:mm:ss"));
            row.add(String.valueOf(command.getModUserId()));
            row.add(command.getRemarks());
            return row;
        });

        return result;
    }

    @RequestMapping("/command/addOrUpdate.htm")
    public String addOrUpdate(Integer id, Model model) {
        if(id != null) {
            Command command = commandService.findById(id);
            model.addAttribute("command", command);
        }
        return "command/info";
    }

    @RequestMapping("/command/addOrUpdate.json")
    @ResponseBody
    public Object addOrUpdate(String id, Byte commandFunction, String commandDescription, String returnDataDescription,
                              String modUserId, String remarks,  Model model) {
        Command command = new Command();
        command.setCommandFunction(commandFunction);
        command.setCommandDescription(commandDescription);
        command.setReturnDataDescription(returnDataDescription);
        command.setModUserId(modUserId);
        command.setRemarks(remarks);

        if(StringUtils.isNotEmpty(id)) {
            command.setId(Integer.parseInt(id));
        }

        commandService.insertOrUpdate(command);

        return new Result(true, "提交成功", null);
    }

    @RequestMapping("/command/delete.json")
    @ResponseBody
    public Object delete(Integer id) {
        int res = commandService.deleteById(id);
        boolean success = res == 1;
        String msg = success ? "删除成功" : "删除失败";
        return new Result(success, msg, null);
    }
}
