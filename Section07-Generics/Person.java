package edu.spr19cs210.section07;
/* 
 * This example shows how a user defined object is written
 * to be used in a HashSet or HashMap.
 * Equals and hashCode must be overridden in order to retrieve the object. 
 * 
 */

public class Person {

	private int id;
	private String firstName;
	private String lastName;
	
	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// Two people are equal if their names and IDs are equal
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		else if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		else {
			Person person = (Person) o;
			return this.firstName.equals(person.firstName)
					&& this.lastName.equals(person.lastName) 
					&& this.id == person.id;
		}
	}
	
	// Return the id as the hashcode value for simplicity.
	// Note: this can be implemented a different way
	// such as being some calculated value.
	public int hashCode() {
		return id;
	}
	
	public String toString() {
		return firstName + " " + lastName + " (id=" + id + ")";
	}
}
