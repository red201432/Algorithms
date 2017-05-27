
public class Singleton {
	private static volatile Singleton instance; //声明的属性，可以被JVM虚拟机知道 改属性的值是否改变，让其他的线程知道它的变化
	private  Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static Singleton	getInstance() {
		if(instance == null){ //第一次为空，则检查代码同步
			synchronized (Singleton.class) {
				if(instance == null)
				{
					instance=new Singleton();
				}
			}
		}		
		return instance;
	}
}
