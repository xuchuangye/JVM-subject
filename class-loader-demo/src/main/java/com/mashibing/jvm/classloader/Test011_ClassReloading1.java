package com.mashibing.jvm.classloader;

/**
 * 测试打破双亲委派机制
 * <p>
 * 没有打破双亲委派机制的原因：没有重写ClassLoader的loadClass()
 *
 * @author xcy
 * @date 2023/3/16 - 10:49
 */
public class Test011_ClassReloading1 {

	public static void main(String[] args) throws ClassNotFoundException {
		Test005_CustomClassLoader classLoader = new Test005_CustomClassLoader();
		Class<?> clazz = classLoader.loadClass("com.mashibing.jvm.classloader.test.Hello");

		classLoader = null;
		System.out.println(clazz.hashCode());

		classLoader = null;
		classLoader = new Test005_CustomClassLoader();

		Class<?> aClass = classLoader.loadClass("com.mashibing.jvm.classloader.test.Hello");
		System.out.println(aClass.hashCode());
		System.out.println(aClass == clazz);
	}
}
