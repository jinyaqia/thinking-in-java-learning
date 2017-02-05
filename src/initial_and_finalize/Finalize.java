package initial_and_finalize;

public class Finalize {

	public static void main(String[] args) {
		try {
			Book book = new Book();
			book = null;
			System.gc();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class Book {
	String str;

	{
		str = "hahaha";
	}

	boolean isUseLess = false;

	Book() {
		System.out.println("construct");
	}

	public void setUseLess(boolean b) {
		isUseLess = b;
	}

	@Override
	protected void finalize() throws Throwable {
		if (!isUseLess) {
			System.out.println("can't error");
			throw new Throwable("book is useful and can't be finalized");
		} else {
			System.out.println("can be finalized");
		}
		super.finalize();
	}
}