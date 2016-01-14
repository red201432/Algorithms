package springIdol;

import org.springframework.stereotype.Component;

@Component
public class Guitar implements Instrument {

	public Guitar() {
		
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("This is Guitar");
	}

}
