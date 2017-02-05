package type_and_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {

	private static Pattern p = Pattern.compile("\\w+\\.|final|native");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int lines = 0;
		try {
			//获取类
			Class<?> c = Class.forName("type_and_reflect.MyAbstraceClass");
			//获取类方法
			Method[] methods = c.getMethods();
			//获取构造函数
			Constructor<?>[] ctors = c.getConstructors();
			
			for (Method method : methods) {
				
				System.out.println(p.matcher(method.toString()).replaceAll(""));
				System.out.println(method);
				System.out.println();
			}
			for (Constructor<?> cotr : ctors)
				System.out.println(cotr);
			lines = methods.length + ctors.length;
		} catch (ClassNotFoundException e) {
			System.out.println("No such class" + e);
		}
	}
}
