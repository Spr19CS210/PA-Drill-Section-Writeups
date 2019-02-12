package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UAccess {
	public static void main(String[] args) {

		// Collections of students and classes to keep track of data

		// style 6: using map interface
		Map<String, Student> students = new HashMap<>();
		Map<String, Class> classes = initClasses();

		// initialize the number of students in the system
		int idCounter = students.keySet().size();

		// create scanner and get initial input
		Scanner input = new Scanner(System.in);

		System.out.print("Hello, welcome to UAccess! What is your name(first last)? ");

		// SOLUTION TO BUG
		String name = input.nextLine();

		// init initial student
		Student current;

		// if student exists, use the one stored, if not, create a new student and
		// store
		if (students.containsKey(name)) {
			current = students.get(name);
		} else {
			current = createStudent(name, idCounter);
			idCounter++;
			students.put(name, current);
		}

		parseInput(input, classes, current);

		// Style 7: close scanner
		input.close();

		System.out.println("Logged out of UAuth Successfully");
	}
	
	public static Student createStudent(String name, int id) {
		String [] firstLast = name.split("\\s+");
		Student output = new Student(firstLast[0], firstLast[1], id);
		return output;
	}

	public static void printKey() {
		System.out.println("Input Key");
		System.out.println("'courses': List Courses");
		System.out.println("'transcript': show transcript");
		System.out.println("'add': add a course");
		System.out.println("'drop': drop a course");
		System.out.println("'exit': exit program");
		System.out.print("\nWhat would you like to do next? ");
	}

	public static Map<String, Class> initClasses() {
		Map<String, Class> classes = new HashMap<>();

		// creation and storing of cs courses
		Class cs110 = new Class("CSC", "Intro to Computer Programming 1", 4, 110, "Ben Dicken");
		Class cs120 = new Class("CSC", "Intro to Computer Programming 2", 4, 120, "Janalee O'bagy");
		Class cs210 = new Class("CSC", "Software Development", 4, 210, "Tyler Conklin");

		classes.put("CSC " + cs110.getNumber(), cs110);
		classes.put("CSC " + cs120.getNumber(), cs120);
		classes.put("CSC " + cs210.getNumber(), cs210);

		return classes;
	}

	public static void parseInput(Scanner input, Map<String, Class> classes, Student current) {
		// init decision
		String decision = "";
		while (!decision.equals("exit")) {

			// output of decision options
			printKey();

			// get next decision
			decision = input.nextLine().toLowerCase();

			// if/else statement to select which option was selected
			if (decision.equals("courses")) {
				// output courses
				printCourses(classes);
			} else if (decision.equals("transcript")) {
				System.out.println(current.getTranscript().toString());

				// style 5: using internal methods to handle logic
			} else if (decision.equals("add")) {
				// add classes if it exists in the system
				System.out.print("Which class? ");
				String val = input.nextLine();

				addClass(classes, val, current);
			} else if (decision.equals("drop")) {
				// remove class from student's courses
				System.out.print("Which class? ");
				String val = input.nextLine();

				dropClass(classes, val, current);
			} else if (!decision.equals("exit")) {
				System.out.println("Unrecognized Command.");
			}
		}
	}

	public static void printCourses(Map<String, Class> in) {
		for (String key : in.keySet()) {
			System.out.println(in.get(key).toString());
		}
	}

	public static void addClass(Map<String, Class> classes, String val, Student current) {
		if (classes.containsKey(val)) {
			current.addClass(classes.get(val));
			System.out.println("Successful");
		} else {
			System.out.println("Course not available");
		}
	}

	public static void dropClass(Map<String, Class> classes, String val, Student current) {
		Class takeOff = classes.get(val);
		current.dropClass(takeOff);
	}
}
