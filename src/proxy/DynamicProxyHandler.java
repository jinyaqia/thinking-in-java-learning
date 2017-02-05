package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 参考文档
 * http://www.cnblogs.com/machine/archive/2013/02/21/2921345.html#sec-3
 * @author qiaqia
 *
 */
public class DynamicProxyHandler implements InvocationHandler{
	private Object proxied;
	
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy: "+proxy.getClass()+", method "+method.toString()+", args "+args);
		if(args!=null){
			for(Object o:args){
				System.out.println(" "+o);
			}
		}
		return method.invoke(proxied, args);
	}

}
