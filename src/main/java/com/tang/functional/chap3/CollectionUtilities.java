package com.tang.functional.chap3;


import com.tang.functional.fpinjava.common.Function;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Title: CollectionUtilities
 * @Description:
 * @author: tangyao
 * @date: 2022/12/19 18:25
 * @Version: 1.0
 */

public class CollectionUtilities {
    public static <T> List<T> list() {
        return Collections.emptyList();
    }

    public static <T> List<T> list(T t) {
        return Collections.singletonList(t);
    }

    public static <T> List<T> list(List<T> ts) {
        return Collections.unmodifiableList(new ArrayList<>(ts));
    }

    public static <T> List<T> list(T... t) {
        return List.of(Arrays.copyOf(t, t.length));
    }

    public static <T> T head(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalStateException("head of empty list");
        }
        return list.get(0);
    }


    private static <T> List<T> copy(List<T> list) {
        return new ArrayList<>(list);
    }

    public static <T> List<T> tail(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalStateException("tail of empty list");
        }
        List<T> workList = copy(list);
        workList.remove(0);
        return Collections.unmodifiableList(workList);
    }

    public static <T> List<T> append(List<T> list, T t) {
        List<T> ts = copy(list);
        ts.add(t);
        System.out.println("ts = " + ts);
        return Collections.unmodifiableList(ts);
    }

    public static Integer fold(List<Integer> list, Integer identity, Function<Integer, Function<Integer, Integer>> fun) {
        int result = identity;
        for (Integer i : list) {
            result = fun.apply(result).apply(i);
        }
        return result;
    }

//    public static <T, U> U foldLeft(List<T> list, U identity, Function<U, Function<T, U>> fun) {
//        U result = identity;
//        for (T t : list) {
//            result = fun.apply(result).apply(t);
//        }
//        return result;
//    }

    public static <T, U> U foldRight(List<T> list, U identity, Function<T, Function<U, U>> fun) {
        U result = identity;

        for (int i = list.size() - 1; i >= 0; i--) {
            result = fun.apply(list.get(i)).apply(result);
        }
        return result;
    }

    public static <T, U> U foldRight2(List<T> ts, U identity, Function<T, Function<U, U>> f) {

        return ts.isEmpty() ? identity : f.apply(head(ts)).apply(foldRight2(tail(ts), identity, f));

    }

    //    public static <T> List<T> reverse(List<T> list) {
//        List<T> result = new ArrayList<>();
//        for (int i = list.size() - 1; i >= 0; i--) {
//            result.add(list.get(i));
//        }
//        return Collections.unmodifiableList(result);
//    }
    @Data
    static class D {
        String a;
        int b;
    }

    public static <T, U> U foldLeft(List<T> list, U identity, Function<U, Function<T, U>> f) {
        U result = identity;
        for (T t : list) {
            result = f.apply(identity).apply(t);
        }
        return result;
    }

    /**
     * 在 前面插入一个值
     *
     * @param t
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> prepend(T t, List<T> list) {
        return foldLeft(list, list(t), x -> y -> append(x, y));
    }

    public static <T> List<T> reverse(List<T> list) {
        return foldLeft(list, list(), x -> y -> prepend(y, x));
    }


    public static void main(String[] args) {
//        test01();


        List<Integer> list = List.of(1, 2, 3, 4, 5);
//        List<Integer> prepend = prepend(5, list);
//        System.out.println("prepend = " + prepend);
//
//        List<Integer> reverse = reverse(list);
//        System.out.println("reverse = " + reverse);


    }

    private static void test01() {
        List<Integer> list = list(1, 2, 3, 4, 5);

        List<Integer> append = append(list, 45);


        List<Integer> integers = List.of(1, 3, 4, 5, 6);
        Integer fold = fold(list, 0, x -> y -> x + y);
        System.out.println("fold = " + fold);

        D d = new D();
        d.setA("abc");
        d.setB(10);

        D d1 = new D();
        d1.setA("def");
        d1.setB(3);

        D d2 = new D();
        d2.setA("hij");
        d2.setB(34);

        List<D> list1 = list(d, d1, d2);

        Function<String, Function<D, String>> f = x -> y -> getString(x, y);


//        String l = foldLeft(list1, "0", f);
//        System.out.println("l = " + l);

        Function<D, Function<String, String>> f2 = x -> y -> getString2(x.getB(), y);

        String r = foldRight(list1, "0", f2);
        System.out.println("r = " + r);

        String r2 = foldRight2(list1, "0", f2);
        System.out.println("r2 = " + r2);
    }

    private static String getString2(Integer x, String y) {
        return "(" + x + "+" + y + ")";
    }

    private static String getString(String x, D y) {
        return "(" + x + "+" + y.getB() + ")";
    }


}