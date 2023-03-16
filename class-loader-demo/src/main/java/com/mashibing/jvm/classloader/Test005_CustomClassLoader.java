package com.mashibing.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author xcy
 * @date 2023/3/15 - 20:32
 */
public class Test005_CustomClassLoader extends ClassLoader {
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		Test005_CustomClassLoader classLoader = new Test005_CustomClassLoader();
		Class<?> clazz = classLoader.loadClass("com.mashibing.jvm.classloader.Test005_CustomClassLoader");
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
		     ByteArrayOutputStream baos = new ByteArrayOutputStream();){

			int b = 0;
			while ((b = fis.read()) != 0) {
				baos.write(b);
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
}
