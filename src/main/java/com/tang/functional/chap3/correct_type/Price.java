package com.tang.functional.chap3.correct_type;

/**
 * @Title:Price
 * @Author: tangyao
 * @CreateTime: 2023/01/20  11:45
 * @Description: TODO
 * @Version: 1.0
 */
public class Price {
    public final double value;

    public static final Price ZERO = new Price(0.0);

    public Price(double value) {
        this.value = value;
    }

    public Price add(Price that) {
        return new Price(this.value + that.value);
    }

    public Price mult(int count) {
        return new Price(this.value * count);
    }


}
