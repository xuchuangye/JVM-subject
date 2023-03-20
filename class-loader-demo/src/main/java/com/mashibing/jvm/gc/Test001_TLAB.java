package com.mashibing.jvm.gc;

/**
 * -XX:-DoEscapeAnalysis      不使用逃逸分析
 * -XX:-EliminateAllocations  不使用标量替换
 * -XX:-UseTLAB               不使用TLAB
 * -Xlog:c5_gc*  线程专有对象分配
 * <p>
 * 为什么使用逃逸分析、标量替换以及TLAB？
 * 1.因为栈上分配肯定比堆上分配效率快很多
 * 2.栈上分配，从栈上弹出不需要垃圾回收的介入
 *
 * @author xcy
 * @date 2023/3/19 - 15:48
 */
public class Test001_TLAB {
	//User u;
	class User {
		int id;
		String name;

		public User(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}

	void alloc(int i) {
		new User(i, "name " + i);
	}

	public static void main(String[] args) {
		Test001_TLAB t = new Test001_TLAB();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000_0000; i++) t.alloc(i);
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		//for(;;);
	}
}
