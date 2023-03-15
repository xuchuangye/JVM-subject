package com.mashibing.jvm.classloader;

/**
 * 测试如何自定义类加载器
 *
 * @author xcy
 * @date 2023/3/15 - 19:52
 */
public class Test004_ClassLoaderByHand {
	public static void main(String[] args) throws ClassNotFoundException {
		//1.先判断是否已经加载过了，如果已经加载过了，直接返回，如果没有，则先去父加载器中查找，父加载器中也是如此
		/*
			protected Class<?> loadClass(String name, boolean resolve)
			    throws ClassNotFoundException
			{
			    synchronized (getClassLoadingLock(name)) {
			        // First, check if the class has already been loaded
			        Class<?> c = findLoadedClass(name);
			        if (c == null) {
			            long t0 = System.nanoTime();
			            try {
			                if (parent != null) {
			                    c = parent.loadClass(name, false);
			                } else {
                    c = findBootstrapClassOrNull(name);
		 */
		//2.如果一级一级往上找，都没有找到，那么只能自己去加载，调用findClass()
		/*
			if (c == null) {
			    // If still not found, then invoke findClass in order
			    // to find the class.
			    long t1 = System.nanoTime();
			    c = findClass(name);
			    // this is the defining class loader; record the stats
			    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
			    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
			    sun.misc.PerfCounter.getFindClasses().increment();
			}
		 */
		//3.所以自定义类加载器，只需要重写findClass()
		/*
			protected Class<?> findClass(String name) throws ClassNotFoundException {
			    throw new ClassNotFoundException(name);
			}
		 */
		Class<?> clazz = Test004_ClassLoaderByHand.class.getClassLoader().loadClass("com.mashibing.jvm.classloader.Test004_ClassLoaderByHand");
		System.out.println(clazz.getName());
	}
}
