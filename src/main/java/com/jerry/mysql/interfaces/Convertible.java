package com.jerry.mysql.interfaces;

/**
 * @author 22454
 */
public interface Convertible<SR, TG> {
    /**
     * 转换方法
     *
     * @param source 源对象
     * @return 转换后的对象
     */
    TG convert(SR source);
}
