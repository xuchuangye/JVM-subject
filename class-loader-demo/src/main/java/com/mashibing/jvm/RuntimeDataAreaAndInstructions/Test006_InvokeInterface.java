package com.mashibing.jvm.RuntimeDataAreaAndInstructions;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试invoke interface指令
 * @author xcy
 * @date 2023/3/19 - 11:13
 */
public class Test006_InvokeInterface {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		//通过接口调用的方法指令是invoke interface
		strings.add("hello");

		ArrayList<String> list = new ArrayList<>();
		//不是接口调用的方法指令是invoke virtual
		list.add("hello");
	}
}
