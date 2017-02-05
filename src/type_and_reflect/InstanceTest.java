package type_and_reflect;

public class InstanceTest {

	public static void main(String[] args) {
		MyAbstraceClass abs = new ConciseClass();
		MyAbstraceClass abs2 = new ConciseClass2();
		abs.method();
		abs2.method();
		System.out.println(abs instanceof ConciseClass);
		System.out.println(abs instanceof ConciseClass2);
		System.out.println(abs2 instanceof ConciseClass);
		System.out.println(abs2 instanceof ConciseClass2);

		try {
			Class<?> abs3 = Class.forName("type_and_reflect.ConciseClass");
			ConciseClass concise = ((ConciseClass) abs3.newInstance());
			concise.method();
			/**
			 * class.isInstance是instanceof运算符的动态等效
			 */
			System.out.println(ConciseClass.class.isInstance(abs));// 使用类字面常量
			System.out.println(abs3.isInstance(abs));
			System.out.println(abs3.isInstance(abs2));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ConciseClass extends MyAbstraceClass {

	void method() {
		System.out.println("concise");
	}

}

class ConciseClass2 extends MyAbstraceClass {

	void method() {
		System.out.println("concise 2");
	}

}