package proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		ISayHello helloWorld = new HelloWorld();
		helloWorld.sayHello();

		ISayHello proxy = (ISayHello) Proxy.newProxyInstance(ISayHello.class.getClassLoader(),
				new Class[] { ISayHello.class }, new DynamicProxyHandler(new HelloWorld()));
		proxy.sayHello();
	}

}
