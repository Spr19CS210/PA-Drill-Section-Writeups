
public class F150 {
	private int speed;
	private int gasCapacity;
	private int currentGas;
	
	public F150(int amountGas) {
		this.speed = 0;
		this.setGasCapacity(amountGas);
		this.setCurrentGas(amountGas);
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
	
	public void applyBrakes(int decrement) {
		int slow = this.speed - decrement;
		if (this.currentGas > 0) {
			this.currentGas -= 1;
		}
		if (slow < 0) {
			this.speed = 0;
		} else {
			this.speed = slow;
		}
	}
	
	public void accelerate(int increment) {
		if (this.currentGas > 0) {
			this.currentGas--;
			this.speed += increment;
		}
	}
	
	public void printState() {
		System.out.println("Speed: " + this.speed); 
	}
}
