package com.tang.functional.chap3;


import com.tang.functional.chap1.Tuple;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Title: Case
 * @Description:
 * @author: tangyao
 * @date: 2022/12/19 17:31
 * @Version: 1.0
 */

public class Case<T> extends Tuple<Supplier<Boolean>, Supplier<Result<T>>> {

    public Case(Supplier<Boolean> _1, Supplier<Result<T>> _2) {
        super(_1, _2);
    }

    private static class DefaultCase<T> extends Case<T> {


        public DefaultCase(Supplier<Boolean> _1, Supplier<Result<T>> _2) {
            super(_1, _2);
        }
    }

    public static <T> Case<T> mcase(Supplier<Boolean> condition, Supplier<Result<T>> value) {
        return new Case<>(condition, value);
    }

    public static <T> DefaultCase<T> mcase(Supplier<Result<T>> value) {
        return new DefaultCase<>(() -> true, value);
    }

    @SafeVarargs
    public static <T> Result<T> match(DefaultCase<T> defaultCase, Case<T>... mathers) {

        for (Case<T> aCase : mathers) {
            if (aCase.get_1().get()) {
                return aCase.get_2().get();
            }
        }
        return defaultCase.get_2().get();

    }


}