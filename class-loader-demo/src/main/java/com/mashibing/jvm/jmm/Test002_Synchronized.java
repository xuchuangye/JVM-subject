package com.mashibing.jvm.jmm;

/**
 * 测试synchronized在字节码层面的实现
 * @author xcy
 * @date 2023/3/18 - 14:48
 */
public class Test002_Synchronized {
	public synchronized void method() {

	}

	public void test() {
		synchronized (this) {

		}
	}

	public static void main(String[] args) {

	}
}
