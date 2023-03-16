package com.mashibing.jvm.classloader;

/**
 * 测试自定义类加载器的parent如何指定
 * @author xcy
 * @date 2023/3/16 - 10:26
 */
public class Test010_Parent {
	private static final ClassLoader parent = new Test005_CustomClassLoader();

	public static void main(String[] args) {
		System.out.println(new Test005_CustomClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader());
	}

	public static class MyClassLoader extends ClassLoader {

		public MyClassLoader() {
			super(parent);
		}
	}
}
