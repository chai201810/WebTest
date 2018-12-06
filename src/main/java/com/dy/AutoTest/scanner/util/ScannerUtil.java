package com.dy.AutoTest.scanner.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import com.dy.AutoTest.scanner.bean.ClassScanDto;
import com.dy.AutoTest.scanner.bean.MethodScanDto;

public class ScannerUtil {

	public List<ClassScanDto> getTests(String path, String packageName) throws Exception {
		List<ClassScanDto> scanList = new ArrayList<ClassScanDto>();
		
		Set<Class<?>> clsList = getClasses(path, packageName);
		if (clsList != null && clsList.size() > 0) {
			for (Class<?> cls : clsList) {
				
				ClassScanDto dto = new ClassScanDto();
				dto.setFilePath(path);
				dto.setPackageName(packageName);
				dto.setClassName(cls.toString());
				
				List<MethodScanDto> methodList = new ArrayList<MethodScanDto>();
				dto.setMethodList(methodList);
				
				Method[] methods = cls.getMethods();

				for (Method m : methods) {
					Test annotationTest = m.getAnnotation(Test.class);
					if (annotationTest != null) {
						MethodScanDto methodDto = new MethodScanDto();

						methodDto.setMethodName(m.toString());
						methodDto.setMemo(annotationTest.description());
						
						StringBuilder depends = new StringBuilder();
						for (String depend : annotationTest.dependsOnMethods()) {
							depends.append(depend).append(",");
						}
						
						methodDto.setDepends(depends.toString());
						methodList.add(methodDto);
					}
				}
				scanList.add(dto);
			}
		}

		return scanList;
	}

	private Set<Class<?>> getClasses(String path, String packageName) throws Exception {
		Set<Class<?>> classes = new HashSet<>();
		// 是否循环迭代
		boolean recursive = true;

		try {
			URL url = new URL(path);
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

	private static void findAndAddClassesInPackageByFile(String packageName, String packagePath,
			final boolean recursive, Set<Class<?>> classes) {

		File dir = new File(packagePath);

		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}

		File[] dirfiles = dir.listFiles(new FileFilter() {
			// 自定义过滤规则：支持递归的目录或者以.class结尾的文件
			public boolean accept(File file) {
				return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});

		for (File file : dirfiles) {

			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive,
						classes);
			} else {
				// 去掉文件后缀名.class，只留下类名
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					// classLoader比forName的load干净，无需调用static方法
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
		// 自定义过滤规则：目录或者以.class结尾的文件
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
			// 获取类名
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

}
