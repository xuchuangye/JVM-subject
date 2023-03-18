package com.mashibing.jvm.jmm;

import com.mashibing.jvm.agent.ObjectSizeAgent;

/**
 * 测试使用ObjectSize.jar
 * @author xcy
 * @date 2023/3/18 - 16:21
 */
public class Test003_SizeOfAnObject {
	public static void main(String[] args) {
		System.out.println(ObjectSizeAgent.sizeOf(new Object()));
		System.out.println(ObjectSizeAgent.sizeOf(new int[] {}));
		System.out.println(ObjectSizeAgent.sizeOf(new P()));
	}

	//一个Object占多少个字节
	// -XX:+UseCompressedClassPointers：ClassPointer指针默认是压缩的，所以4个字节
	// -XX:+UseCompressedOops: Oops = ordinary object pointers：Oops指针默认是压缩的，所以4个字节
	private static class P {
		//                8 _markword
		//                4 _class pointer
		int id;         //4
		String name;    //4
		int age;        //4

		byte b1;        //1
		byte b2;        //1

		Object o;       //4
		byte b3;        //1

	}

}
