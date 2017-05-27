package jvm;

/*
 * 在运行下面代码前需要保存当前的工作，因为在windows平台的虚拟机中，线程是映射到系统内核线程上的，运行代码可能会导致系统假死。
 */
public class JavaVMStackOOM {
	
	public static void  main(String[] args) {
		JavaVMStackOOM oom=new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
	private void dontStop(){
		while(true){
			
		}
	}
	public void stackLeakByThread() {
		while(true){
			Thread thread=new Thread(new Runnable() {
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}
	
}
