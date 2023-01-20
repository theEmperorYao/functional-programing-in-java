package com.tang.functional.chap3.correct_type;

/**
 * @Title:Weight
 * @Author: tangyao
 * @CreateTime: 2023/01/20  11:45
 * @Description: TODO
 * @Version: 1.0
 */
public class Weight {
    public final double value;

    public static final Weight ZERO = new Weight(0.0);

    public Weight(double value) {
        this.value = value;
    }

    public Weight mult(int count) {
        return new Weight(this.value * count);
    }
}
