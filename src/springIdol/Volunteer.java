package springIdol;

public class Volunteer implements Thinker {
	private String thoughts;
	
	@Override
	public void thinkOfSomthing(String thoughts) {
		// TODO Auto-generated method stub
		System.out.println(thoughts);
		this.thoughts=thoughts;
	}
	
	public String  getThoughts() {
		return thoughts;
	}
}
