package jvm;

public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOOK=null;
	public void isAlive(){
		System.out.println("yes, i am still alive :)");
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize method executed!!!");
		FinalizeEscapeGC.SAVE_HOOK=this;
	}
	public static void main(String[] args) throws Throwable {
		SAVE_HOOK = new FinalizeEscapeGC();
		
		//对象第一次成功自救
		SAVE_HOOK=null;
		System.gc();
		//因为Finalizer方法优先级很低，暂停0.5秒，等待它
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no , i am dead :(");
		}
		
		//下面代码和上面一样，但自救失败了
		SAVE_HOOK=null;
		System.gc();
		//因为Finalizer方法优先级很低，暂停0.5秒，等待它
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no , i am dead :(");
		}
		
	}
}
