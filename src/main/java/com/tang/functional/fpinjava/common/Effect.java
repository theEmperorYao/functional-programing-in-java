package com.tang.functional.fpinjava.common;

public interface Effect<T> {
  void apply(T t);
}