package springIdol;

public class Stage {
	private Stage(){
		
	}
	private static Stage instance;
	public static Stage getInstance() {
		instance=new Stage();
		return instance;
	}
	
}
