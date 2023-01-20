package com.tang.functional.chap3.correct_type;

import lombok.Data;

/**
 * @Title:Product
 * @Author: tangyao
 * @CreateTime: 2023/01/20  10:58
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class Product {

    private final String name;
    private final double price;
    private final double weight;

    public Product(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

}


