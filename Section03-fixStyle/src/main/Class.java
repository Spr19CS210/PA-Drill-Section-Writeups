package main;

public class Class {
	private String dept;
	private String className;
	private int credits;
	private int number;
	private String staff;
	
	public Class(String department, String name, int numCredits, int courseNumber) {
		this.setDepartment(department);
		this.setClassName(name);
		this.setCredits(numCredits);
		this.setNumber(courseNumber);
		this.setStaff("TBD");
	}
	
	public Class(String department, String name, int numCredits, int courseNumber, String faculty) {
		this.setDepartment(department);
		this.setClassName(name);
		this.setCredits(numCredits);
		this.setNumber(courseNumber);
		this.setStaff(faculty);
	}

	public String getDepartment() {
		return dept;
	}

	public void setDepartment(String dept) {
		this.dept = dept;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public boolean equals(Class other) {
		// if another class has the same dept and course number, they are the same.
		// Return true, otherwise return false
		if (other.getDepartment().equals(this.dept) && other.getNumber() == this.number) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		String output = "";
		output += this.dept;
		output += " " + this.number + ": ";
		output += this.className + " | ";
		output += "Credits: " + this.credits;
		return output;
	}
}
