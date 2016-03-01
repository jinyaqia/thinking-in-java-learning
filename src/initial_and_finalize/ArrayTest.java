package initial_and_finalize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
	private static Random random = new Random();
	static final int INT_1 = random.nextInt(299);
	final int a ;
	{ a = 3;}
	public static void main(String[] args) {
		int [] intArray = {1,2,3,};
		System.out.println(Arrays.toString(intArray));
		ArrayList<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("a","b","c","c"));
		String abc = "abcdefghi";
		list.addAll(3, Arrays.asList("f","g"));
		System.out.println(list.toString());
	}

}
