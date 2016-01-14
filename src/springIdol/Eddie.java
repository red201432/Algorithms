package springIdol;

import org.springframework.stereotype.Component;

@Component
public class Eddie implements Instrument {
	 public Eddie() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("this is Eddie");
	}

}
