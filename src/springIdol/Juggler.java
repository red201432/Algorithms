package springIdol;

public class Juggler implements Performer{
	private  int  beanBags=3;
	public Juggler() {
		
	}
	public Juggler(int beanBags) {
		this.beanBags=beanBags;
	}
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Juggle " + beanBags + " BeanBags");
	}

}
