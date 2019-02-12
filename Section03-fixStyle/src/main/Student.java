package main;

import java.util.ArrayList;
import java.util.List;

public class Student {
	// Style 1: camel casing in the student class
	private String firstName;
	private String lastName;
	private int idNumber;
	// style 2: using list interface
	private List<Class> enrolled;
	private Transcript transcript;
	// style 3: using private instead of public instance variables
	
	public Student(String first, String last, int id) {
		this.setFirstName(first);
		this.setLastName(last);
		this.setIdNumber(id);
		this.setEnrolled(new ArrayList<>());
		this.setTranscript(new Transcript());
	}
	
	// style 4: using meta overloading with different arguments
	public Student(String first, String last, int id, Transcript transfer) {
		this.setFirstName(first);
		this.setLastName(last);
		this.setIdNumber(id);
		this.setEnrolled(new ArrayList<>());
		this.setTranscript(transfer);
	}
	
	// style 5: using internal methods to handle logic
	public void addClass(Class in) {
		// add class to list
		this.enrolled.add(in);
	}
	
	public void dropClass(Class in) {
		// parse over all courses, and delete the one that is the same
		// in the list
		for (int i = 0; i < enrolled.size(); i++) {
			if (enrolled.get(i).equals(in)) {
				enrolled.remove(i);
			}
		}
	}

	// style 1: getters and setters for accessing variables
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public List<Class> getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(List<Class> courses) {
		this.enrolled = courses;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	
	public String toString() {
		return this.firstName + this.lastName;
	}
}
