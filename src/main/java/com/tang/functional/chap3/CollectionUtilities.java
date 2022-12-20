package com.tang.functional.chap3;


import com.tang.functional.fpinjava.common.Function;

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
        List<T> copy = copy(list);
        copy.add(t);
        return Collections.unmodifiableList(copy);
    }

    public static void main(String[] args) {
        List<Integer> list = list(1, 2, 3, 4, 5);
        List<Integer> integers = List.of(1, 3, 4, 5, 6);
        Integer fold = fold(list, 0, x -> y -> x + y);
        System.out.println("fold = " + fold);

    }

    public static Integer fold(List<Integer> is, Integer identity, Function<Integer, Function<Integer, Integer>> f) {

        int result = identity;
        for (Integer i : is) {
            result = f.apply(result).apply(i);
        }
        return result;
    }


}