package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		String str = "+U+n+c--+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s";
		boolean isPlus = false;
		for(Character c : str.toCharArray()){
			if(c.equals('+')){
				isPlus = true;
			}else if(c.equals('-')){
				System.out.print(stack.pop());
			}else{
				if(isPlus){
					stack.push(c);
					isPlus = false;
				}
			}
		}
		
	}

}
