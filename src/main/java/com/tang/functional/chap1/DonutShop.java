package com.tang.functional.chap1;


import com.tang.functional.fpinjava.common.List;

import static com.tang.functional.fpinjava.common.List.fill;

/**
 * @Title: DountShop
 * @Description:
 * @author: tangyao
 * @date: 2022/12/16 15:45
 * @Version: 1.0
 */

public class DonutShop {
    public static Tuple<Donut, Payment> buyDonut(CreditCard creditCard) {
        Donut donut = new Donut();
        Payment payment = new Payment(creditCard, Donut.price);
        return new Tuple<>(donut, payment);
    }

    public static Tuple<List<Donut>, Payment> buyDonuts(final int quantity, final CreditCard creditCard) {
        return new Tuple<>(fill(quantity, Donut::new),
                new Payment(creditCard, Donut.price * quantity));
    }

//    public static Tuple<java.util.List<Donut>, Payment> bugDonuts(final int quantity, final CreditCard creditCard) {
//        return new Tuple<>(Collections.nCopies(quantity, new Donut()),
//                new Payment(creditCard, Donut.price * quantity));
//    }


}