package com.tang.functional.fpinjava.state;

import com.tang.functional.fpinjava.common.Tuple;


public interface RNG {

  Tuple<Integer, RNG> nextInt();
}
