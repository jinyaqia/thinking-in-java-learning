package initial_and_finalize;

/**
 * 
 * 初始化时，static 在构造函数执行前执行初始化
 *
 */
public class Cup {

	public static void main(String[] args) {
		new Cups();
	}
	static Cup1 cup1 = new Cup1(111);
}
class Cup1{
	Cup1(int a){
		System.out.println("cup1"+a);
	}
}
class Cups{
	static Cup1 cup1;
	static Cup1 cup2;
	static{
		cup1 = new Cup1(1);
		cup2 = new Cup1(1);
	}
	Cups(){
		System.out.println("cups");
	}
	
}