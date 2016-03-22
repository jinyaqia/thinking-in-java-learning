import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruthGenerate {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Truth truth = new Truth();

		System.out.println("input number of question");
		truth.qNum = input.nextInt();

		System.out.println("input operation");
		truth.operation = input.next();

		int len = (int) Math.pow(2, truth.qNum);
		for (int i = 0; i < len; i++) {
			String tmp = Integer.toBinaryString(i);
			int dif = truth.qNum - tmp.length();
			String str = "";
			for (int j = 0; j < dif; j++) {
				str += "0";
			}
			truth.ans.add(str + tmp);
		}
		char[] cs = truth.operation.toCharArray();
		
		for (int k = 0;k<truth.ans.size();k++) {
			String rowStr = truth.ans.get(k);
			char ans = rowStr.charAt(0);
			for (int j = 1; j < rowStr.length(); j++) {
				char tc = rowStr.charAt(j);
				switch (cs[j-1]) {
				case '&':
					ans = (char) (ans & tc);
					break;
				case '|':
					ans = (char) (ans | tc);
					break;
				case '^':
					ans = (char) (ans ^ tc);
					break;
				default:
				}
			}
			truth.ans.set(k,rowStr+ans);
		}
		truth.print();
	}
}

class Truth {
	public int qNum;
	public String operation;
	public ArrayList<String> ans = new ArrayList<String>();
	void print(){
		for (String str : ans) {
			System.out.println(str);
		}
	}
}