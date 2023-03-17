package com.mashibing.jvm.classloader;

import java.io.*;

/**
 * 测试打破双亲委派机制
 *
 * @author xcy
 * @date 2023/3/16 - 10:55
 */
public class Test012_ClassReloading2 {
	private static class MyClassLoader extends ClassLoader {
		@Override
		public Class<?> loadClass(String name) throws ClassNotFoundException {
			//I:\JVM\JVM-subject\class-loader-demo\src\main\java\com\mashibing\jvm\test\Hello
			File file = new File("G:/JVM/" + name.replace(".", "/").concat(".class"));
			if (!file.exists()) {
				return super.loadClass(name);
			}

			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				byte[] bytes = new byte[fileInputStream.available()];
				fileInputStream.read(bytes);

				fileInputStream.close();
				return defineClass(name, bytes, 0, bytes.length);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return super.loadClass(name);
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		MyClassLoader myClassLoader = new MyClassLoader();
		Class<?> aClass = myClassLoader.loadClass("com.mashibing.jvm.classloader.test.Hello");
		System.out.println(aClass.hashCode());

		myClassLoader = new MyClassLoader();
		Class<?> clazz = myClassLoader.loadClass("com.mashibing.jvm.classloader.test.Hello");
		System.out.println(clazz.hashCode());

		System.out.println(aClass == clazz);
	}
}
