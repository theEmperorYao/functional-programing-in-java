package com.tang.functional.chap1;


import lombok.Data;

/**
 * @Title: Tuple
 * @Description:
 * @author: tangyao
 * @date: 2022/12/16 15:43
 * @Version: 1.0
 */
@Data
public class Tuple<T, U> {
    T _1;
    U _2;

    public Tuple(T _1, U _2) {
        this._1 = _1;
        this._2 = _2;
    }


}