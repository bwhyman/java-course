package com.example23.optional;

public class Computer {
	private Soundcard soundcard;
	public Computer() {
	}
	public Computer(Soundcard soundcard) {
		this.soundcard = soundcard;
	}
	public Soundcard getSoundcard() {
		return soundcard;
	}
	public void setSoundcard(Soundcard soundcard) {
		this.soundcard = soundcard;
	}

}
