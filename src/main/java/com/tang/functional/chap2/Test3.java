package com.tang.functional.chap2;


import com.tang.functional.chap1.Tuple;

import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * @Classname Test3
 * @Description
 * @Date 2022/12/18 20:21
 * @Author by tangyao
 */
public class Test3 {


    final Function<Integer, Integer> factorial = n -> n <= 1 ? n : n * this.factorial.apply(n - 1);

    public static final Function<Integer, Integer> factorial2 = n -> n <= 1 ? n : n * Test3.factorial2.apply(n - 1);

//     {
//        factorial = n -> n <= 1 ? n : n * this.factorial.apply(n - 1);
//    }

    public static void main(String[] args) {

        Integer apply4 = factorial2.apply(10);
        System.out.println("apply4 = " + apply4);

        BinaryOperator<Double> function = (taxRate, price) -> price + price * taxRate;

        Function<Double, Function<Double, Double>> f1 = taxRate -> price -> price + price * taxRate;

        Function<Double, Double> apply = f1.apply(10.0);
        Double apply1 = apply.apply(1.0);
        System.out.println("apply1 = " + apply1);
        Function<Double, Function<Integer, Integer>> f = a -> b -> (int) (a * b);
        Function<Integer, Integer> integerIntegerFunction = partialA(1.2, f);

        Integer apply2 = integerIntegerFunction.apply(19);
        System.out.println("apply2 = " + apply2);
        Function<Double, Integer> doubleIntegerFunction = partialB(2, f);
        Integer apply3 = doubleIntegerFunction.apply(1.6);
        System.out.println("apply3 = " + apply3);


    }

    static <A, B, C> Function<B, C> partialA(A a, Function<A, Function<B, C>> f) {
        return f.apply(a);
    }

    static <A, B, C> Function<A, C> partialB(B b, Function<A, Function<B, C>> f) {
        return a -> f.apply(a).apply(b);
    }

    static <A, B, C, D> Function<A, Function<B, Function<C, Function<D, String>>>> function() {
        return a -> b -> c -> d -> String.format("%s,%s,%s ,%s", a, b, c, d);
    }

    static <A, B, C> Function<A, Function<B, C>> f1(Function<Tuple<A, B>, C> function) {
        return a -> b -> function.apply(new Tuple<>(a, b));
    }

}
