package com.mashibing.jvm.RuntimeDataAreaAndInstructions;

import java.util.ArrayList;

/**
 * 测试invoke virtual指令
 *
 * @author xcy
 * @date 2023/3/19 - 11:00
 */
public class Test004_InvokeVirtual {
	public static void main(String[] args) {
		new Test004_InvokeVirtual().method();

		ArrayList<String> stringList = new ArrayList<>();
		//不需要通过接口调用的方法也是invoke virtual指令
		stringList.add("hello");
	}

	/**
	 * 普通方法是invoke virtual指令
	 */
	public void method() {

	}
}
