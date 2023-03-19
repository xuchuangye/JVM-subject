package com.mashibing.jvm.jmm;

/**
 * 通过JClassLib工具查看字节码
 * 测试Frame栈帧中：Local Variable Table局部变量表以及Operand Stack操作数堆栈的流程
 * @author xcy
 * @date 2023/3/18 - 21:05
 */
public class Test004_IPlusPlus {
	public static void main(String[] args) {
		int i = 8;
		//  0 bipush 8 将8符号扩展成int类型，推送到操作数堆栈中
		//  2 istore_1 将8从操作数堆栈中弹出，对局部变量表中索引为1的数进行赋值
		//  3 iload_1 再将i=8推送到操作数堆栈中
		//  4 iinc 1 by 1 将局部变量表中索引为1的数进行递增
		//  7 istore_1 再将i=8推送到操作数堆栈中，所以局部变量i的值为8
		//  8 getstatic #2 <java/lang/System.out : Ljava/io/PrintStream;>
		// 11 iload_1
		// 12 invokevirtual #3 <java/io/PrintStream.println : (I)V>
		// 15 return
		//i = i++;


		//  0 bipush 8 将8符号扩展为int类型，推送到操作数堆栈中
		//  2 istore_1 将8从操作数堆栈中弹出，对局部变量表中索引为1的数进行赋值
		//  3 iinc 1 by 1 将局部变量表中索引为1的数进行递增，此时索引为1的i值为9
		//  6 iload_1 再将索引为1的i值推送到操作数堆栈中
		//  7 istore_1 再将索引为1的i值从操作数堆栈中弹出，所以局部变量i的值为9
		//  8 getstatic #2 <java/lang/System.out : Ljava/io/PrintStream;>
		// 11 iload_1
		// 12 invokevirtual #3 <java/io/PrintStream.println : (I)V>
		// 15 return
		i = ++i;
		System.out.println(i);
	}
}
