package com.mashibing.jvm.agent;

import java.lang.instrument.Instrumentation;

/**
 * 测试对象的大小
 * <p>
 * agent代理是如何装载到JVM上：
 * 1.创建ObjectSizeAgent
 * 2.打包
 *
 * @author xcy
 * @date 2023/3/18 - 16:02
 */
public class ObjectSizeAgent {
	/**
	 * 对字节码进行调试，整理
	 */
	private static Instrumentation instrumentation;

	/**
	 * 方法名和参数固定
	 *
	 * @param agentArgs
	 * @param _instrumentation
	 */
	public static void premain(String agentArgs, Instrumentation _instrumentation) {
		instrumentation = _instrumentation;
	}

	public static long sizeOf(Object o) {
		return instrumentation.getObjectSize(o);
	}
}
