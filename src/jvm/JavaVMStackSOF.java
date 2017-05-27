package jvm;

public class JavaVMStackSOF {
	private int stackLength=1;
	public void statkLeak(){
		stackLength++;
		statkLeak();
	}
	public static void  main(String[] args) {
		JavaVMStackSOF oom=new JavaVMStackSOF();
		try{
			oom.statkLeak();
		}catch(Throwable e){
			System.out.println("Stack Length : "+oom.stackLength);
			throw e;
		}
	}
}
