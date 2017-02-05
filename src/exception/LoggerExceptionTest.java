package exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggerExceptionTest {

	public void f() throws LoggerException{
		System.out.println("f()");
		throw new LoggerException();
	}
	public static void main(String[] args) {
		try{
			throw new LoggerException();
			
		}catch(LoggerException e){
			e.printStackTrace();
		}
		try{
			new LoggerExceptionTest().f();
		}catch(LoggerException e){
			e.printStackTrace();
		}
	}

}
class LoggerException extends Exception{
	private static Logger logger = Logger.getLogger("my Logger exception");
	public LoggerException(){
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
//		logger.severe(trace.toString());
	}
}
