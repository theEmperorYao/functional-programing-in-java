package com.tang.functional;


import com.tang.functional.chap1.*;
import com.tang.functional.fpinjava.common.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Title: Test01
 * @Description:
 * @author: tangyao
 * @date: 2022/12/16 16:28
 * @Version: 1.0
 */

public class Test01 {

    @Test
    void testBuyDonuts() {
        CreditCard creditCard = new CreditCard();
        Tuple<List<Donut>, Payment> purchase = DonutShop.buyDonuts(5, creditCard);
        assertEquals(Donut.price * 5, purchase._2().amount());
        assertEquals(creditCard, purchase._2().creditCard());

        List<String> fill = List.fill(3, String::new);



    }
}