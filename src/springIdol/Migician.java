package springIdol;

public class Migician implements MindReader {
	private String thoughts;
	
	@Override
	public void interceptThoughts(String thoughts) {
		// TODO Auto-generated method stub
		System.out.println("Tntercepting volunteer's thoughts");
		this.thoughts=thoughts;
	}

	@Override
	public String getThoughts() {
		// TODO Auto-generated method stub
		return thoughts;
	}

}
