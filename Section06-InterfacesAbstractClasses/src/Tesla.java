
public class Tesla {
	private int speed;
	private int gasCapacity;
	private int currentGas;
	private boolean insanityMode;
	
	public Tesla() {
		this.speed = 0;
		this.setGasCapacity(0);
		this.setCurrentGas(0);
		this.setInsanityMode(false);
	}

	public int getGasCapacity() {
		return gasCapacity;
	}

	public void setGasCapacity(int gasCapacity) {
		this.gasCapacity = gasCapacity;
	}

	public int getCurrentGas() {
		return currentGas;
	}

	public void setCurrentGas(int currentGas) {
		this.currentGas = currentGas;
	}

	public boolean isInsanityMode() {
		return insanityMode;
	}

	public void setInsanityMode(boolean insanityMode) {
		this.insanityMode = insanityMode;
	}
	
	public void applyBrakes(int decrement) {
		int slow = this.speed - decrement;
		if (slow < 0) {
			this.speed = 0;
		} else {
			this.speed = slow;
		}
	}
	
	public void accelerate(int increment) {
		if (this.insanityMode) {
			this.speed += (2 * increment);
		} else {
			this.speed += increment;
		}
	}
	
	public void printState() {
		System.out.println("Speed: " + this.speed); 
	}
}
