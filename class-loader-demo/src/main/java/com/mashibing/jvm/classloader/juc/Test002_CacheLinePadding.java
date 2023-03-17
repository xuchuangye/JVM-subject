package com.mashibing.jvm.classloader.juc;

/**
 * 缓存行-伪共享问题的解决方案：缓存行对齐（利用空间换时间）
 * 测试arr[0]和arr[1]两个不相关的数据不在同一个缓存行中
 *
 * @author xcy
 * @date 2023/3/17 - 10:06
 */
public class Test002_CacheLinePadding {
	private static class Padding {
		/**
		 * 占用56个字节
		 */
		public volatile long p1, p2, p3, p4, p5, p6, p7;
	}

	private static class T extends Padding {
		public volatile long x = 0L;
	}

	public static T[] arr = new T[2];

	static {
		//让arr[0]的x占据第一个缓存行的最后8个字节，让arr[0]的x和arr[1]的x处于不同的缓存行
		arr[0] = new T();
		//让arr[1]的x处于第二个缓存行
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
