package com.tang.functional.chap1;

/**
 * @Classname SideEffectTest
 * @Description TODO
 * @Date 2022/7/30 23:38
 * @Author by tangyao
 */
public class SideEffectTest {

    public static int div(int a, int b) {
        return a / b;
    }

    public static int div2(int a, int b) {
        return (int) (a / (float) b);
    }


    public static void main(String[] args) {

//        int div = div(1, 0);
//        System.out.println("div = " + div);
        // 浮点数除以零，根据 IEEE-754 的有关规定，其结果需要是 NaN（Not a Number）或 Infinity，Java 只是遵守了这一规定罢了。
        int i = div2(1, 0);
        // 结果为Integer.MAX_VALUE
        System.out.println("i = " + i);
    }
}
