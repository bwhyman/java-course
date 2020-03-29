package com.example23.optional;

public class Soundcard {
	private USB usb;
	public Soundcard() {
	}
	public Soundcard(USB usb) {
		this.usb = usb;
	}
	public USB getUsb() {
		return usb;
	}
	public void setUsb(USB usb) {
		this.usb = usb;
	}

}
