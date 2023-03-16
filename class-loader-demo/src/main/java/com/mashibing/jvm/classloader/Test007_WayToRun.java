package com.mashibing.jvm.classloader;

/**
 * 测试JVM的模式：混合模式:-Xmixed、纯解释:-Xint、纯编译:-Xcomp
 * @author xcy
 * @date 2023/3/16 - 8:43
 */
public class Test007_WayToRun {
	public static void main(String[] args) {
		for (int i = 0; i < 10_0000; i++) {
			method();
		}
		long start = System.currentTimeMillis();

		for (int i = 0; i < 10_0000; i++) {
			method();
		}

		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}
	private static void method() {
		for (long i = 0; i < 10_0000L; i++) {
			long j = i % 3;
		}
	}
}
