package com.eternal.design.page;

import java.util.List;

public class PageResult<T> {
    private final List<T> data;
    private final long count;
    private final int pageNum;
    private final int pageSize;
    private final int draw;

    public PageResult(List<T> data, long count, int pageNum, int pageSize, int draw) {
        this.data = data;
        this.count = count;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.draw = draw;
    }

    public List<T> getData() {
        return data;
    }

    public long getCount() {
        return count;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getDraw() {
        return draw;
    }
}
