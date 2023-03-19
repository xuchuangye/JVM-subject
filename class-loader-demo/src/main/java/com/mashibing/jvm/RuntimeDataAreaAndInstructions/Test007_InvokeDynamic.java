package com.mashibing.jvm.RuntimeDataAreaAndInstructions;

/**
 * 测试invoke dynamic指令
 * @author xcy
 * @date 2023/3/19 - 11:21
 */
public class Test007_InvokeDynamic {
	public static void main(String[] args) {
		/*Thread thread1 = new Thread(() -> System.out.println("thread1"));

		thread1.start();

		Thread thread2 = new Thread(() -> System.out.println("thread2"));

		thread2.start();

		Thread thread3 = new Thread(() -> System.out.println("thread3"));

		thread3.start();

		System.out.println("hello");*/

		A a1 = B::n;
		A a2 = B::n;
		A a3 = B::n;
		A a4 = () -> {
			B.n();
		};

		System.out.println(a1.getClass());
		System.out.println(a2.getClass());
		System.out.println(a3.getClass());
		System.out.println(a4.getClass());

		//1.8之前的巨大Bug，MethodArea在1.8之前的具体实现是Perm Space，FGC不会回收
		for(;;) {
			A a = B::n;
		}
	}

	public interface A {
		void m();
	}

	public static class B {
		public static void n() {
			System.out.println("hello");
		}
	}
}
