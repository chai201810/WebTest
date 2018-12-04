package com.dy.AutoTest.web.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class Scanner {
	/**
	 * 从包package中获取所有的Class
	 *
	 * @param packageName
	 * @return
	 */
	public Set<Class<?>> getClasses(String path, String packageName) throws Exception {

		// 第一个class类的集合
		Set<Class<?>> classes = new HashSet<>();
		// 是否循环迭代
		boolean recursive = true;

		try {
			URL url = new URL(path);
			// 得到协议的名称
			String protocol = url.getProtocol();
			// 如果是以文件的形式保存在服务器上
			if ("file".equals(protocol)) {
				// 获取包的物理路径
				String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
				findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return classes;
	}

	public void getTests(String path, String packageName) throws Exception {
		Set<Class<?>> clsList = getClasses(path, packageName);
		if (clsList != null && clsList.size() > 0) {
			for (Class<?> cls : clsList) {

				Method[] methods = cls.getMethods();

				for (Method m : methods) {
					Test annotationTest = m.getAnnotation(Test.class);
					if (annotationTest != null) {

						System.out.println("类名：" + cls.toString());
						System.out.println("方法名：" + m.toString());
						System.out.println("用例描述：" + annotationTest.description());

						for (String depend : annotationTest.dependsOnMethods()) {
							System.out.println("用例依赖：" + depend);
						}
					}
				}

			}
		}

	}

	/**
	 * 以文件的形式来获取包下的所有Class
	 *
	 * @param packageName
	 * @param packagePath
	 * @param recursive
	 * @param classes
	 */
	public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive,
			Set<Class<?>> classes) {

		// 获取此包的目录 建立一个File
		File dir = new File(packagePath);
		// 如果不存在或者 也不是目录就直接返回
		if (!dir.exists() || !dir.isDirectory()) {
			// log.warn("用户定义包名 " + packageName + " 下没有任何文件");
			return;
		}
		// 如果存在 就获取包下的所有文件 包括目录
		File[] dirfiles = dir.listFiles(new FileFilter() {
			// 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
			public boolean accept(File file) {
				return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});
		// 循环所有文件
		for (File file : dirfiles) {
			// 如果是目录 则继续扫描
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive,
						classes);
			} else {
				// 如果是java类文件 去掉后面的.class 只留下类名
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					// 经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
					classes.add(
							Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));

					findClassesByFile(packageName, packagePath, classes);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private static void findClassesByFile(String pkgName, String pkgPath, Set<Class<?>> classes) {
		File dir = new File(pkgPath);
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}
		// 过滤获取目录，or class文件
		File[] dirfiles = dir.listFiles(pathname -> pathname.isDirectory() || pathname.getName().endsWith("class"));
		if (dirfiles == null || dirfiles.length == 0) {
			return;
		}
		String className;
		Class clz;
		for (File f : dirfiles) {
			if (f.isDirectory()) {
				findClassesByFile(pkgName + "." + f.getName(), pkgPath + "/" + f.getName(), classes);
				continue;
			} 
			// 获取类名，干掉 ".class" 后缀
			className = f.getName();
			className = className.substring(0, className.length() - 6);
			// 加载类
			clz = loadClass(pkgName + "." + className);
			if (clz != null) {
				classes.add(clz);
			}
		}
	}

	private static Class<?> loadClass(String fullClzName) {
		try {
			return Thread.currentThread().getContextClassLoader().loadClass(fullClzName);
		} catch (ClassNotFoundException e) {
			System.out.printf("load class error! clz: {}, e:{}", fullClzName, e);
		}
		return null;
	}

	public static void main(String[] args) throws Exception {

		URL path = new Scanner().getClass().getClassLoader().getResource("");
        System.out.println(path);
		
		String packageName = "com.dy.AutoTest.OnlineCashier.TestCases.accountmanage";
		String packagePath = packageName.replaceAll("\\.","/");
		
		System.out.println(packagePath);
		
		new Scanner().getTests(path + "/" + packagePath, packageName);

	}
}
