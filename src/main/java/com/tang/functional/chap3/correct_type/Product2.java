package com.tang.functional.chap3.correct_type;

import lombok.Data;

/**
 * @Title:Product2
 * @Author: tangyao
 * @CreateTime: 2023/01/20  11:44
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class Product2 {
    public final String name;
    public final Price price;
    public final Weight weight;

    public Product2(String name, Price price, Weight weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
}
