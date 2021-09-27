package com.jerry.mysql.interfaces;

/**
 * @author 22454
 */
public interface Suitable<T> {
    /**
     * 适配条件
     *
     * @param data 源数据
     * @return 是否适配
     */
    boolean test(T data);
}
