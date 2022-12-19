package com.tang.functional.chap2;


//import java.util.function.Function;


import com.tang.functional.fpinjava.common.Function;
import com.tang.functional.fpinjava.common.Function.*;

import java.util.function.BinaryOperator;


/**
 * @Classname Test2
 * @Description
 * @Date 2022/12/18 17:16
 * @Author by tangyao
 */
public class Test2 {

    public static void main(String[] args) {
//        BinaryOperator add = x -> y -> x + y;
        Function<Integer, Function<Integer, Integer>> add3 = x -> y -> x + y;

        Integer apply = add3.apply(3).apply(4);

        System.out.println("apply = " + apply);

        Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>> compose
                = x -> y -> z -> x.apply(y.apply(z));

        Function<Integer, Integer> triple = x -> x * 3;
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> f = compose.apply(square).apply(triple);

        Integer apply1 = f.apply(10);
        System.out.println("apply1 = " + apply1);


        Function<Double, Integer> f2 = a -> (int) (a * 3);
        Function<Long, Double> g = a -> a + 2.0;
        Function.<Long, Double, Integer>higherCompose().apply(f2).apply(g).apply(2L);

        Function<Double, Double> doubleDoubleFunction = x -> Math.PI / 2 - x;
        Function<Double, Double> sin = Math::sin;
        Function<Double, Double> compose1 = Function.compose(doubleDoubleFunction, sin);



    }

    static <T, U, V> Function<Function<U, V>,
            Function<Function<T, U>,
                    Function<T, V>>> higherCompose() {

        return x -> y -> z -> x.apply(y.apply(z));
    }

}