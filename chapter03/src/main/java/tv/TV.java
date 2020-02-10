package tv;

public class TV {

	private int channel;
	private int volume;
	private boolean power;

	public TV(int channel, int volume, boolean power) {
		super();
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void power(boolean on) {
		power = on;
	}

	public void channel(int channel) {
		if(channel < 1)
			channel = 255;
		else if(channel > 255)
			channel = 1;
		this.channel = channel;
	}

	public void channel(boolean up) {
		channel(channel + (up ? 1 : -1));
	}

	public void volume(int volume) {
		if(volume < 0)
			volume = 100;
		else if(volume > 100)
			volume = 1;
		this.volume = volume;
	
	}

	public void volume(boolean up) {
		volume(volume + (up ? 1 : -1));
	}
	public void status() {
		System.out.println("TV[channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}
}
