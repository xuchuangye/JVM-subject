package com.mashibing.jvm.classloader.interview;

/**
 * 测试类加载的过程中静态变量的赋值变化
 */
public class T001_ClassLoadingProcedure {
    public static void main(String[] args) {
        System.out.println(T.count);
    }
}

class T {
    public static int count = 2; //0
    public static T t = new T(); // null

    //private int m = 8;

    private T() {
        count ++;
        //System.out.println("--" + count);
    }
}
