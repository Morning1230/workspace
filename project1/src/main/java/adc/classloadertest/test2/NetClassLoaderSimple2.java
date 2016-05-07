package adc.classloadertest.test2;

public class NetClassLoaderSimple2 {
	
	@SuppressWarnings("unused")
	private NetClassLoaderSimple2 instance;

	public void setNetClassLoaderSimple(Object obj) {
		System.out.println(obj.getClass());
		this.instance = (NetClassLoaderSimple2)obj;
	}
}