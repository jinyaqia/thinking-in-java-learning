package collection;

import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		for(Map.Entry entry : System.getenv().entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

}
