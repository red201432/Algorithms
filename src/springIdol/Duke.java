package springIdol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Duke {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springIdol/spring4.xml");
		Performer performer=(Performer)ctx.getBean("poeticDuke");
		performer.perform();
		Performer performer2=(Performer)ctx.getBean("kenny");
		performer2.perform();
		((Contestant)performer2).receiveAward();
		Thinker thinker=(Thinker)ctx.getBean("thinker");
		thinker.thinkOfSomthing("I am thinging");
	}
}
