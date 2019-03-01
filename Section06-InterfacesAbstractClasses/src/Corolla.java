
public class Corolla {
	private int speed;
	private int gasCapacity;
	private int currentGas;
	
	public Corolla(int gasCapacity) {
		this.speed = 0;
		this.setGasCapacity(gasCapacity);
		this.setCurrentGas(gasCapacity);
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
		if (slow < 0) {
			this.speed = 0;
		} else {
			this.speed = slow;
		}
	}
	
	public void accelerate(int increment) {
		if (this.speed % 2 == 0) {
			this.currentGas--;
		}
		
		if (this.currentGas > 0) {
			this.speed += increment;
		}
	}
	
	public void printState() {
		System.out.println("Speed: " + this.speed); 
	}
}
