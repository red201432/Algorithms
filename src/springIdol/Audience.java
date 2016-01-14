package springIdol;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
	public void takeSeats(){
		System.out.println("The Audience is taking their seats.");
	}
	
	public  void  turnOffCellPhone() {
		System.out.println("The Audience is turning off their cellphones");
	}
	
	public void applaud() {
		System.out.println("Clap clap clap clap");
	}
	
	public void demandRefund() {
		System.out.println("Boo ,we want our money back.");
	}
	
	public  void  watchPerformance(ProceedingJoinPoint joinPoint) {
		try {
			System.out.println("The Audience is taking their seats.");
			System.out.println("The Audience is turning off their cellphones");
			long start=System.currentTimeMillis();
			joinPoint.proceed();
			long end=System.currentTimeMillis();
			System.out.println("Clap clap clap clap");
			
			System.out.println("The Performance took "+ (end-start) + " milliseconds!");
			
		} catch (Throwable t) {
			System.out.println("Boo ,we want our money back.");
		}
	}
}
