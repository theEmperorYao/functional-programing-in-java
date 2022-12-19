package com.tang.functional.chap3;


/**
 * @Title: Effect
 * @Description:
 * @author: tangyao
 * @date: 2022/12/19 15:12
 * @Version: 1.0
 */

public interface Effect<T> {
    void apply(T t);
}