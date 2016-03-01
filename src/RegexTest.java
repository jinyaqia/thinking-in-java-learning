import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	static String data = "121.32.23.43@01-32-5764\n"
			+ "121.52.223.43@01-52-5454\n"
			+ "51.32.3.3@01-32-5657\n"
			+ "121.32.323.43@01-32-5775\n"
			+ "111.32.23.45@01-32-5434\n";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(data);
		String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@"
				+ "(\\d{2}\\-\\d{2}[-]\\d{4})";
		while(scanner.hasNext(pattern)){
			scanner.next(pattern);
			MatchResult match = scanner.match();
			String ip = match.group(1);
			String date = match.group(2);
			System.out.format("threat on %s from %s\n", date,ip);
		}
		
		String text = "@jinya恰 this is 天";
		Pattern p = Pattern.compile("(@[\u4e00-\u9fa5a-zA-Z0-9]+)");
		Matcher matcher = p.matcher(text);
		while(matcher.find()){
			String s = matcher.group(1);
			System.out.println(s);
			s = matcher.replaceFirst("<font color>"+text.substring(matcher.start(),matcher.end())+"</font>");
			System.out.println(s);
		}
		
	}

}
