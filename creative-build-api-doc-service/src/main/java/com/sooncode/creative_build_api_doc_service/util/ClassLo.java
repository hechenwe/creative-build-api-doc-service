package com.sooncode.creative_build_api_doc_service.util;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Stack;

public class ClassLo {

	
	public static void lo() {
		
		
		try {
		// 设置class文件所在根路径  
		// 例如/usr/java/classes下有一个test.App类，则/usr/java/classes即这个类的根路径，而.class文件的实际位置是/usr/java/classes/test/App.class  
		File clazzPath = new File("D:\\java_source");  
		  
		// 记录加载.class文件的数量  
		int clazzCount = 0;  
		  
		if (clazzPath.exists() && clazzPath.isDirectory()) {  
		    // 获取路径长度  
		    int clazzPathLen = clazzPath.getAbsolutePath().length() + 1;  
		  
		    Stack<File> stack = new Stack<>();  
		    stack.push(clazzPath);  
		  
		    // 遍历类路径  
		    while (stack.isEmpty() == false) {  
		        File path = stack.pop();  
		        File[] classFiles = path.listFiles(new FileFilter() {  
		            public boolean accept(File pathname) {  
		                return pathname.isDirectory() || pathname.getName().endsWith(".class");  
		            }  
		        });  
		        for (File subFile : classFiles) {  
		            if (subFile.isDirectory()) {  
		                stack.push(subFile);  
		            } else {  
		                if (clazzCount++ == 0) {  
		                    Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);  
		                    boolean accessible = method.isAccessible();  
		                    try {  
		                        if (accessible == false) {  
		                            method.setAccessible(true);  
		                        }  
		                        // 设置类加载器  
		                        URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();  
		                        // 将当前类路径加入到类加载器中  
		                        method.invoke(classLoader, clazzPath.toURI().toURL());  
		                    } finally {  
		                        method.setAccessible(accessible);  
		                    }  
		                }  
		                // 文件名称  
		                String className = subFile.getAbsolutePath();  
		                className = className.substring(clazzPathLen, className.length() - 6);  
		                className = className.replace(File.separatorChar, '.');  
		                // 加载Class类  
		                Class.forName(className);  
		                
		            }  
		        }  
		    }  
		}  
		
		}catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	
	 
	
}
