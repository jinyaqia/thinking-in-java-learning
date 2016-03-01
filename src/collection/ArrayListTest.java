package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		ReverArrayList<String> list = new ReverArrayList(Arrays.asList("hello world this is".split(" ")));
		for(String str: list){
			System.out.print(str);
		}
		System.out.println();
		for(String str: list.reversed()){
			System.out.print(str);
		}
	}

	
}
class ReverArrayList<T> extends ArrayList<T>{
	
	public ReverArrayList(Collection<T> c){
		super(c);
	}
	public Iterable<T> reversed(){
		return new Iterable<T>(){

			@Override
			public Iterator<T> iterator() {
				
				return new Iterator<T>(){
					int current = size() - 1;
					@Override
					public boolean hasNext() {
						return current >-1;
					}

					@Override
					public T next() {
						return get(current--);
					}
				};
			}
			
		};
	}
}