package com.tang.functional.chap3.correct_type;

/**
 * @Title:OrderLine2
 * @Author: tangyao
 * @CreateTime: 2023/01/20  11:47
 * @Description: TODO
 * @Version: 1.0
 */
public class OrderLine2 {
    private Product2 product;
    private int count;


    public OrderLine2(Product2 product, int count) {
        super();
        this.product = product;
        this.count = count;
    }

    public Weight getWeight() {
        return this.product.getWeight().mult(this.count);
    }

    public Price getAmount() {
        return this.product.getPrice().mult(this.count);
    }
}
