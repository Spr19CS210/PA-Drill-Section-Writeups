package edu.spr19cs210.section07;
/*
 * MyGeneric is a generic type.
 * 
 */

public class MyGeneric<E> {
	E obj;
	
	public MyGeneric(E other) {
		obj = other;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		} else if (other == null || other.getClass() != this.getClass()){
			return false;
		} else {
			MyGeneric<E> generic = (MyGeneric<E>) other;
			return obj.equals(generic.obj);
		}
	}
	
	//Use the object's hashCode
	public int hashCode() {
		return obj.hashCode();
	}
	
	//Use the object's toString
	public String toString() {
		return obj.toString();
	}
	
}
