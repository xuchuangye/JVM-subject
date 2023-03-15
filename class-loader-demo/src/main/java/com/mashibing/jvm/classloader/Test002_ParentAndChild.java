package com.mashibing.jvm.classloader;

/**
 * 测试父加载器
 * @author xcy
 * @date 2023/3/15 - 19:20
 */
public class Test002_ParentAndChild {
	public static void main(String[] args) {
		//AppClassLoader
		System.out.println(Test002_ParentAndChild.class.getClassLoader());
		//BootStrap，也就是null
		System.out.println(Test002_ParentAndChild.class.getClassLoader().getClass().getClassLoader());
		//AppClassLoader的父加载器ExtClassLoader
		System.out.println(Test002_ParentAndChild.class.getClassLoader().getParent());
		//AppClassLoader的父加载器ExtClassLoader的父加载器BootStrap，也就是null
		System.out.println(Test002_ParentAndChild.class.getClassLoader().getParent().getParent());

	}
}
