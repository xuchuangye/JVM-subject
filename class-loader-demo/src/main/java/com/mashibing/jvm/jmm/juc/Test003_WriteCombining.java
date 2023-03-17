package com.mashibing.jvm.jmm.juc;

/**
 * 测试乱序问题之合并写：
 * <p>
 * 在程序里，同时修改6个位置，分成3个位置为一组快，还是6个位置同时写会更快？
 * <p>
 * Write Combine Buffer：位置非常的少，非常的宝贵，只有4个位置
 *
 * @author xcy
 * @date 2023/3/17 - 13:58
 */
public final class Test003_WriteCombining {

	private static final int ITERATIONS = Integer.MAX_VALUE;
	private static final int ITEMS = 1 << 24;
	private static final int MASK = 1;

	private static final byte[] arrayA = new byte[ITEMS];
	private static final byte[] arrayB = new byte[ITEMS];
	private static final byte[] arrayC = new byte[ITEMS];
	private static final byte[] arrayD = new byte[ITEMS];
	private static final byte[] arrayE = new byte[ITEMS];
	private static final byte[] arrayF = new byte[ITEMS];

	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {
			System.out.println(i + "：singleLoop duration (ns) = " + runCaseOne());
			System.out.println(i + "：splitLoop duration (ns) = " + runCaseTwo());
		}
	}

	public static long runCaseOne() {
		long start = System.nanoTime();

		int i = ITERATIONS;
		while (--i != 0) {
			int slot = i & MASK;
			byte b = (byte) i;
			arrayA[slot] = b;
			arrayB[slot] = b;
			arrayC[slot] = b;
			arrayD[slot] = b;
			arrayE[slot] = b;
			arrayF[slot] = b;
		}
		return System.nanoTime() - start;
	}

	/**
	 * 每次写操作都是4个位置，刚好满足合并写的位置数，不需要等待后续写操作的合并，因此效率会更快
	 *
	 * @return
	 */
	public static long runCaseTwo() {
		long start = System.nanoTime();

		int i = ITERATIONS;
		while (--i != 0) {
			int slot = i & MASK;
			byte b = (byte) i;
			arrayA[slot] = b;
			arrayB[slot] = b;
			arrayC[slot] = b;
		}

		i = ITERATIONS;
		while (--i != 0) {
			int slot = i & MASK;
			byte b = (byte) i;
			arrayD[slot] = b;
			arrayE[slot] = b;
			arrayF[slot] = b;
		}
		return System.nanoTime() - start;
	}
}
