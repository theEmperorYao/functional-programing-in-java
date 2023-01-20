package com.tang.functional.chap3.correct_type;

import org.springframework.core.annotation.Order;

import java.util.List;

import static com.tang.functional.chap3.CollectionUtilities.*;

/**
 * @Title:Store
 * @Author: tangyao
 * @CreateTime: 2023/01/20  11:02
 * @Description: TODO
 * @Version: 1.0
 */
public class Store {
    public static void main(String[] args) {
        Product toothPaste = new Product("Tooth paste", 1.5, 0.5);
        Product toothBrush = new Product("Tooth brush", 3.5, 0.3);
        List<OrderLine> order = list(new OrderLine(toothPaste, 2), new OrderLine(toothBrush, 3));

        Double price = foldLeft(order, 0.0, x -> y -> x + y.getAmount());
        Double weight = foldLeft(order, 0.0, x -> y -> x + y.getWeight());

        System.out.println(String.format("Total price: %s", price));
        System.out.println(String.format("Total weight: %s", weight));

    }
}
