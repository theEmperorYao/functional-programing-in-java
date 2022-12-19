package com.tang.functional.fpinjava.actors;


import com.tang.functional.fpinjava.common.Result;

public interface MessageProcessor<T> {

  void process(T t, Result<Actor<T>> sender);
}
