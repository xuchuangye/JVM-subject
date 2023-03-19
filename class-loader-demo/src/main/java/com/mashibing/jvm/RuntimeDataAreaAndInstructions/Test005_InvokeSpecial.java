package com.mashibing.jvm.RuntimeDataAreaAndInstructions;

/**
 * 测试invoke special指令
 *
 * @author xcy
 * @date 2023/3/19 - 11:05
 */
public class Test005_InvokeSpecial {
	public static void main(String[] args) {
		Test005_InvokeSpecial test005_invokeSpecial = new Test005_InvokeSpecial();
		test005_invokeSpecial.method();
		test005_invokeSpecial.special();
	}

	/**
	 * final修饰的方法是invoke virtual指令
	 */
	public final void method() {

	}

	/**
	 * 私有方法、构造方法是invoke spacial指令
	 */
	private void special() {

	}
}
