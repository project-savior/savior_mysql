package com.jerry.mysql.entity;

import com.github.pagehelper.Page;
import com.jerry.mysql.interfaces.Convertible;
import com.jerry.mysql.interfaces.Suitable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 22454
 */
public class PageResult<T> {
    private Integer totalPage;
    private Long totalRows;
    private List<T> list;

    public PageResult() {
        totalPage = 0;
        totalRows = 0L;
        list = new ArrayList<>();
    }

    @Deprecated
    public static <SR, TG> PageResult<TG> createPage(Page<SR> page, Convertible<SR, TG> convertible) {
        PageResult<TG> pageResult = new PageResult<>();
        pageResult.setTotalPage(page.getPages());
        pageResult.setTotalRows(page.getTotal());
        List<TG> list = page
                .getResult()
                .stream()
                .map(convertible::convert)
                .collect(Collectors.toList());
        pageResult.setList(list);
        return pageResult;
    }

    @Deprecated
    public static <SR, TG> PageResult<TG> createPage(Page<SR> page, Convertible<SR, TG> convertible, Suitable<SR> suitable) {
        PageResult<TG> pageResult = new PageResult<>();
        pageResult.setTotalPage(page.getPages());
        pageResult.setTotalRows(page.getTotal());
        List<TG> list = page
                .getResult()
                .stream()
                .filter(suitable::test)
                .map(convertible::convert)
                .collect(Collectors.toList());
        pageResult.setList(list);
        return pageResult;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Long totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "totalPage=" + totalPage +
                ", totalRow=" + totalRows +
                ", list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PageResult<?> that = (PageResult<?>) o;
        return Objects.equals(totalPage, that.totalPage) &&
                Objects.equals(totalRows, that.totalRows) &&
                Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalPage, totalRows, list);
    }
}
