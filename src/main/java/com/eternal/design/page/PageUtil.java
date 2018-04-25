package com.eternal.design.page;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PageUtil {
    public static <T> PageResult<T> queryByPage(Supplier<Long> count, Supplier<List<T>> query) {
        Long countAll = count.get();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        int pageNum = start / length + 1;

        PageHelper.startPage(pageNum, length);
        List<T> data = query.get();

        return new PageResult<>(data, countAll, pageNum, length, draw);
    }

    public static <T> JSONObject parseResult(PageResult<T> pageResult, Function<T, List<String>> parser) {
        List<List<String>> data = pageResult.getData().stream()
                .map(parser::apply)
                .collect(Collectors.toList());
        JSONObject result = new JSONObject();
        result.put("data", data);
        result.put("draw", pageResult.getDraw());
        result.put("recordsFiltered", pageResult.getCount());
        result.put("recordsTotal", pageResult.getCount());
        return result;
    }

    public static <T> JSONObject emptyResult() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        int draw = Integer.parseInt(request.getParameter("draw"));

        JSONObject result = new JSONObject();
        result.put("data", Collections.emptyList());
        result.put("draw", draw);
        result.put("recordsFiltered",0);
        result.put("recordsTotal", 0);
        return result;
    }

}
