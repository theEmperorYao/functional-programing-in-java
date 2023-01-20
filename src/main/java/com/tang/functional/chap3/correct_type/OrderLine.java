package com.tang.functional.chap3.correct_type;

/**
 * @Title:OrderLine
 * @Author: tangyao
 * @CreateTime: 2023/01/20  11:01
 * @Description: TODO
 * @Version: 1.0
 */

import lombok.Data;

@Data
public class OrderLine {
    private Product product;
    private int count;

    public OrderLine(Product product, int count) {
        super();
        this.product = product;
        this.count = count;
    }

    public double getWeight() {
        return this.product.getWeight() * this.count;
    }

    public double getAmount() {
        return this.product.getPrice() * this.count;
    }

}
