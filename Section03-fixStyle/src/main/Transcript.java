package main;

import java.util.HashMap;
import java.util.Map;

public class Transcript {
	// bonus style: use map interface here as well
	private Map<Class, Character> complete;
	private double gpa;
	
	public Transcript() {
		setComplete(new HashMap<>());
		setGpa(0.0);
	}
	
	public void addClass(Class course, char grade) {
		// add class to transcript
		complete.put(course, grade);
		char currGrade;
		int gpaVal;
		int total = 0;
		gpa = 0;
		// parse over every class including new one, and recalculate GPA
		for (Class key : complete.keySet()) {
			currGrade = complete.get(key);
			switch (currGrade) {
				case 'A':
					gpaVal = 4;
					break;
				case 'B':
					gpaVal = 3;
					break;
				case 'C':
					gpaVal = 2;
					break;
				case 'D':
					gpaVal = 1;
					break;
				default:
					gpaVal = 0;
			}
			
			gpa += gpaVal;
			total += key.getCredits();
		}
		// final division
		gpa /= total;
	}

	public Map<Class, Character> getComplete() {
		return complete;
	}

	public void setComplete(Map<Class, Character> complete) {
		this.complete = complete;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public String toString() {
		String output = "";
		// add course information to output string
		for (Class course : this.complete.keySet()) {
			output += course.toString() + " | Grade: ";
			output += this.complete.get(course);
			output += "\n";
		}
		
		// add final gpa to output string
		output += "\n";
		output += "Overall GPA: ";
		output += this.gpa + "\n";
		return output;
	}
}
