package com.tang.functional.chap3;


/**
 * @Title: Result
 * @Description:
 * @author: tangyao
 * @date: 2022/12/19 15:11 2022/12/19
 * @Version: 1.0
 */

public interface Result<T> {
    void bind(Effect<T> success, Effect<String> failure);

    static <T> Result<T> failure(String message) {
        return new Failure<>(message);
    }

    static <T> Result<T> success(T value) {
        return new Success<>(value);
    }

    class Failure<T> implements Result<T> {
        private final String errorMessage;

        private Failure(String errorMessage) {
            this.errorMessage = errorMessage;
        }


        @Override
        public void bind(Effect<T> success, Effect<String> failure) {
            failure.apply(errorMessage);
        }
    }

    class Success<T> implements Result<T> {
        private final T value;

        private Success(T value) {
            this.value = value;
        }

        @Override
        public void bind(Effect<T> success, Effect<String> failure) {
            success.apply(value);
        }
    }


}
