package springIdol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Instrumentalist implements Performer {
	private String song;
	public void  setSong(String song) {
		this.song=song;
	}
	public String  getSong() {
		return song;
	}
	public String screamSong() {
		return song;
	}
	private Instrument instrument;
	//可选的自动装配，可以为null
	@Autowired(required=false)
	@Qualifier("eddie")
	public void setInstrument(Instrument instrument) {
		this.instrument=instrument;
	}
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		instrument.play();
	}
	
}
