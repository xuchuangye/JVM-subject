package com.mashibing.jvm.classloader;

import java.io.*;

/**
 * 测试加密
 *
 * @author xcy
 * @date 2023/3/15 - 20:32
 */
public class Test006_CustomClassLoaderWithEncription extends ClassLoader {

	private static final int seed = 0B10110110;

	public static void main(String[] args) throws Exception {
		encFIle("com.mashibing.jvm.classloader.Test006_CustomClassLoaderWithEncription");

		Test006_CustomClassLoaderWithEncription classLoader = new Test006_CustomClassLoaderWithEncription();
		Class<?> clazz = classLoader.loadClass("com.mashibing.jvm.classloader.Test006_CustomClassLoaderWithEncription");
		Object instance = clazz.newInstance();

		System.out.println(instance.getClass().getName());
		System.out.println(classLoader.getClass().getClassLoader());
		System.out.println(classLoader.getParent());

		System.out.println(getSystemClassLoader());
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {

		File file = new File("I:/JVM/", name.replace(".", "/").concat(".class"));
		try (FileInputStream fis = new FileInputStream(file);
		     ByteArrayOutputStream baos = new ByteArrayOutputStream();) {

			int b = 0;
			while ((b = fis.read()) != 0) {
				baos.write(b ^ seed);
			}

			byte[] bytes = baos.toByteArray();

			//baos.close();
			//fis.close();

			//将二进制内容转换成class类的对象
			//Exception in thread "main" java.lang.ClassNotFoundException
			return defineClass(name, bytes, 0, bytes.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.findClass(name);
	}

	private static void encFIle(String name) throws Exception {
		File file = new File("I:/JVM/", name.replace(".", "/").concat(".class"));
		FileInputStream fileInputStream = new FileInputStream(file);
		FileOutputStream fileOutputStream = new FileOutputStream(new File("I:/JVM/", name.replaceAll(".", "/").concat("msbclass")));

		int b = 0;

		while ((b = fileInputStream.read()) != -1) {
			fileOutputStream.write(b ^ seed);
		}

		fileOutputStream.close();
		fileInputStream.close();
	}
}
