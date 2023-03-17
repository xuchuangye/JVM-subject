package com.mashibing.jvm.classloader.singleton;

/**
 * 测试单例模式的双重检查
 * <p>
 * 面试题：为什么INSTANCE需要关键字volatile修饰？
 * 因为会出现指令重排序的问题
 * <p>
 * 正常的指令：
 * 0 new #2 <java/lang/Object>
 * 3 dup
 * 4 invokespecial #1 <java/lang/Object.<init> : ()V>
 * 7 astore_1
 * 8 return
 * <p>
 * 错误的指令：
 * 可能astore_1指令先执行，而invokespecial后执行
 * 导致单例模式的双重检查，会出现之后的线程读取到之前线程半初始化的对象，只是读取到了默认值，而没有读取到初始值
 *
 * @author xcy
 * @date 2023/3/16 - 14:34
 */
public class SingletonMode {
	public static void main(String[] args) {
		SingletonMode instance1 = SingletonMode.getInstance();
		SingletonMode instance2 = SingletonMode.getInstance();
		System.out.println(instance1 == instance2);
	}

	private SingletonMode() {

	}

	private static volatile SingletonMode INSTANCE;

	public static SingletonMode getInstance() {
		if (INSTANCE == null) {
			synchronized (SingletonMode.class) {
				if (INSTANCE == null) {
					INSTANCE = new SingletonMode();
				}
			}
		}
		return INSTANCE;
	}
}
