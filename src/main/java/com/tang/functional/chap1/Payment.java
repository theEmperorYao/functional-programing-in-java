package com.tang.functional.chap1;


import com.tang.functional.fpinjava.common.List;

/**
 * @Title: Payment
 * @Description:
 * @author: tangyao
 * @date: 2022/12/16 15:28
 * @Version: 1.0
 */

public record Payment(CreditCard creditCard, int amount) {

    public Payment combine(Payment payment) {
        if (creditCard.equals(payment.creditCard)) {
            return new Payment(creditCard, amount + payment.amount);
        } else {
            throw new IllegalArgumentException("Card don't match");
        }
    }

    public static List<Payment> groupByCard(List<Payment> payments) {
        return payments
                .groupBy(x -> x.creditCard())
                .values()
                .map(x -> x.reduce(c1 -> c2 -> c1.combine(c2)));
    }

}