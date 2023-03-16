package com.mashibing.jvm.classloader;

/**
 * 测试懒加载
 * @author xcy
 * @date 2023/3/16 - 9:06
 */
public class Test008_LazyLoading {
	static {
		System.out.println("LazyLoading的静态代码块被加载进来了");
	}
	public static void main(String[] args) {
		new Demo1();
		System.out.println("--------------------------");
		Demo2 demo2 = null;
	}

	static class Demo1 {
		static {
			System.out.println("Demo1静态代码块被加载进来了");
		}

		public Demo1() {
			System.out.println("Demo1的构造方法被加载进来了");
		}
	}

	static class Demo2 {
		static {
			System.out.println("Demo2静态代码块被加载进来了");
		}

		public Demo2() {
			System.out.println("Demo2的构造方法被加载进来了");
		}
	}
}
