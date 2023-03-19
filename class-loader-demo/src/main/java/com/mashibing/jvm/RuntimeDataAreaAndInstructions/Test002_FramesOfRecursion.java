package com.mashibing.jvm.RuntimeDataAreaAndInstructions;

/**
 * 测试方法递归的栈帧以及栈的执行过程
 *
 * @author xcy
 * @date 2023/3/19 - 10:35
 */
public class Test002_FramesOfRecursion {
	public static void main(String[] args) {
		Test002_FramesOfRecursion test002_framesOfRecursion = new Test002_FramesOfRecursion();

		int i = test002_framesOfRecursion.method(3);
	}

	private int method(int num) {
		if (num == 1) {
			return 1;
		}
		return num * method(num - 1);
	}
}
