package initial_and_finalize;

public class InnerClass {
	private int tag;
	
	
	public InnerClass(int tag) {
		this.tag = tag;
	}

	public class Inner{
		private int innerInt = 32;
		public InnerClass getOuter(){
			return new InnerClass(33);
		}
	}
	public static void main(String[] args){
		InnerClass in = new InnerClass(32);
		InnerClass.Inner inner = in.new Inner();
		System.out.println(inner.innerInt);
		System.out.println(inner.getOuter().tag);
	}
}
