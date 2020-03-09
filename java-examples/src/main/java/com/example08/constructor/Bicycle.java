package com.example08.constructor;

public class Bicycle {
	private int speed;
	private int gear;
	private int cadence;
	private boolean moving;

	public Bicycle() {
	}

	public Bicycle(int gear) {
		this.gear = gear;
	}

	public Bicycle(int gear, int cadence) {
		this.gear = gear;
		this.cadence = cadence;
	}

	public Bicycle(int speed, int gear, int cadence) {
		this.speed = speed;
		this.gear = gear;
		this.cadence = cadence;
	}

	public Bicycle(int speed, int gear, int cadence, boolean moving) {
		this.speed = speed;
		this.gear = gear;
		this.cadence = cadence;
		this.moving = moving;
	}

	public void setCadence(int cadence) {
		this.cadence = cadence;
	}
	public int getCadence() {
		return cadence;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getGear() {
		return gear;
	}
	public void setGear(int gear) {
		this.gear = gear;
	}
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public void applyBrakes(int decrement) {
		Bicycle.this.speed = Bicycle.this.speed - decrement;
	}
	
}
