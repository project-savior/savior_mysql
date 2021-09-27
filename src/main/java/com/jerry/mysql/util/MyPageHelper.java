package com.jerry.mysql.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jerry.mysql.entity.PageResult;

import java.util.List;

/**
 * @author 22454
 */
public class MyPageHelper extends PageHelper {

    public static <T> PageResult<T> getPageList(int pageNo, int pageSize, PageCallable<T> pageCallable) {
        Page<Object> page = startPage(pageNo, pageSize);
        List<T> list = pageCallable.call();
        PageResult<T> result = new PageResult<>();
        result.setList(list);
        result.setTotalPage(page.getPages());
        result.setTotalRows(page.getTotal());
        return result;
    }

    public interface PageCallable<T> {
        /**
         * 回调函数
         *
         * @return 列表
         */
        List<T> call();
    }
}
