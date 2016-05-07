package training.classloadertest.test1;

import java.net.URL;

public class TestClassLoader1 {
	public static void main(String[] args){
		testParentLoader();
		testLoader1();
	}
	
	public static void testLoader1(){
		System.out.println("-------------------------sun.boot.class.path");
		System.out.println(System.getProperty("sun.boot.class.path").replace(":", "\n"));
		System.out.println("\n-------------------------getBootstrapClassPath");
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].toExternalForm());
		}
	}
	
	public static void testParentLoader(){
		System.out.println("//第一行结果说明：ClassLoaderTest的类加载器是AppClassLoader。");
		System.out.println("//第二行结果说明：AppClassLoader的类加器是ExtClassLoader，即parent=ExtClassLoader。");
		System.out.println("//第三行结果说明：ExtClassLoader的类加器是Bootstrap ClassLoader，因为Bootstrap ClassLoader不是一个普通的Java类，所以ExtClassLoader的parent=null，所以第三行的打印结果为null就是这个原因。");
		ClassLoader loader = TestClassLoader1.class.getClassLoader();	//获得加载ClassLoaderTest.class这个类的类加载器
		while(loader != null) {
			System.out.println(loader);
			loader = loader.getParent();	//获得父类加载器的引用
		}
		System.out.println(loader);
	}
}
