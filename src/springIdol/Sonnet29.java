package springIdol;

public class Sonnet29 implements Poem {
	private static String[] Lines= {
		"月 02, 2016 3:07:31 下午 org.springframew",
		"ork.context.support.ClassPathXmlApplicationContext prepareRefresh",
		"Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@3fa77460: startup",
		"Loading XML bean definitions from class path resource [springIdol/spring4.xml]"
	};
	@Override
	public void recite() {
		// TODO Auto-generated method stub
		for(int i=0;i<Lines.length;i++){
			System.out.println(Lines[i]);
		}
	}
	public Sonnet29() {
		
	}
	
}
