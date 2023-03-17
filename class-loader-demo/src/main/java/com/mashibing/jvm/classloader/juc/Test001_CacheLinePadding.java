package com.mashibing.jvm.classloader.juc;

/**
 * 缓存行-伪共享的问题
 * 测试arr[0]和arr[1]两个不相关的数据在同一个缓存行中
 *
 * @author xcy
 * @date 2023/3/17 - 10:06
 */
public class Test001_CacheLinePadding {
	private static class T {
		public volatile long x = 0L;
	}

	public static T[] arr = new T[2];

	static {
		arr[0] = new T();
		arr[1] = new T();
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(() -> {
			for (long i = 0; i < 1000_0000L; i++) {
				arr[0].x = i;
			}
		});


		Thread thread2 = new Thread(() -> {
			for (long i = 0; i < 1000_0000L; i++) {
				arr[1].x = i;
			}
		});

		final long start = System.nanoTime();
		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println((System.nanoTime() - start) / 100_0000L);
	}
}
