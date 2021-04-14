package beans;

import java.util.Map.Entry;

public class Makers {
	
	private String maker;
	private Long timesBuyed;
	
	public Makers() {}
	
	public Makers(String maker, Long timesBuyed) {
		this.maker = maker;
		this.timesBuyed = timesBuyed;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Long getTimesBuyed() {
		return timesBuyed;
	}

	public void setTimesBuyed(Long timesBuyed) {
		this.timesBuyed = timesBuyed;
	}
	
	public static Makers statisticToMaker(Entry<String, Long> m) {
		return new Makers(m.getKey(), m.getValue());
	}

	@Override
	public String toString() {
		return "Makers [maker=" + maker + ", timesBuyed=" + timesBuyed + "]";
	}
	
	

}
