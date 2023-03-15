package com.mashibing.jvm.classloader;

/**
 * 测试类加载器的级别
 * @author xcy
 * @date 2023/3/15 - 16:43
 */
public class ClassLoaderLevel {
	public static void main(String[] args) {
		//BootStrap类加载器是C++实现的，Java中并没有对应的class，所以是null
		//null，表示最顶层的类加载器BootStrap
		System.out.println(String.class.getClassLoader());
		System.out.println(sun.awt.HKSCS.class.getClassLoader());
		//sun.net.spi.nameservice.dns.DNSNameService.class 位于 ext/目录下的jar包，所以类加载器是ExtClassLoader
		System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
		//自定义类默认都是classpath目录下的，所以类加载器是AppClassLoader
		System.out.println(ClassLoaderLevel.class.getClassLoader());

		//类加载器的加载器
		System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());
		System.out.println(ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());

	}
}