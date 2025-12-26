package com.misstilo.cloth_erp_api.dto.base;

import java.util.List;

import com.github.pagehelper.PageInfo;

import lombok.Data;

@Data
public class PageResult<T> {
    private int pageNum;
    private int pageSize;
    private long total;
    private int pages;
    private List<T> list;

    /**
     * 將 PageHelper 的 PageInfo 轉換為我們自定義的格式
     * 這樣可以解耦，未來不使用 PageHelper 時前端不受影響
     */
    public static <T> PageResult<T> restPage(List<T> list) {
        PageResult<T> result = new PageResult<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);

        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setPages(pageInfo.getPages());
        result.setList(pageInfo.getList());

        return result;
    }
}
