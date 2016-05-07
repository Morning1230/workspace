package training.classloadertest.test2;


public class NewworkClassLoaderTest {

	public static void main(String[] args) {
		try {
			String userDir = System.getProperty("user.dir");
			System.out.println(userDir);
			//测试加载网络中的class文件
			//String rootUrl = "http://localhost:8080/httpweb/classes";
			//String rootUrl = userDir;
			String className = "adc.classloadertest.test2.NetClassLoaderSimple";
			String rootUrl = "file:/Users/apple/work/tmp";
			
			NetworkClassLoader ncl1 = new NetworkClassLoader(rootUrl);
			NetworkClassLoader ncl2 = new NetworkClassLoader(rootUrl);
			Class<?> clazz1 = ncl1.loadClass(className);
			Class<?> clazz2 = ncl2.loadClass(className);
			
			
			System.out.println(String.format("clazz1.getClassLoader() = %s", clazz1.getClassLoader()));  
			System.out.println(String.format("clazz2.getClassLoader() = %s", clazz2.getClassLoader())); 
			
			Object obj1 = clazz1.newInstance();
			Object obj2 = clazz2.newInstance();
			clazz1.getMethod("setNetClassLoaderSimple", Object.class).invoke(obj1, obj2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
