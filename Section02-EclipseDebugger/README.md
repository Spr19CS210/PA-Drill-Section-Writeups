# Section02-Eclipse-Debugger-Introduction  (DRAFT: still being edited)

## Introduction 
The goal of today's section is to learn about Eclipse's built in debugging features.
Debugging software supplements the critical thinking process that occurs when finding 
and correcting errors in code. There are many helpful aspects of the debugger, including 
being able to pause your program at different steps in order to see the value of all 
stored variables and being able to move step by step through your code utilizing 
breakpoints. 

## Assignment

### Read about Key Features 
Start the section by reading Eclipse's brief introduction to Debugging the Eclipse IDE 
for Java Developers by following the link below. Only read the first section of the article; 
stop when you see "Advanced Tools to Debug Complex Scenarios". 

https://www.eclipse.org/community/eclipse_newsletter/2017/june/article1.php

### Setup
Copy the following code into a new project on Eclipse. 

```
import java.util.ArrayList;
import java.util.List;
/*
 * Author: Dr. Strout 
 * 
 * Prints out an arrangement of the given dice that adds up to the desired sum.
 */
public class Section02Main {
	public static void main(String[] args) {
		System.out.println(diceRollSum(2, 7,new ArrayList<Integer>()));
	}

	public static int sum(List<Integer> nums) {
		int sum=0;
		for (int n : nums) {
			sum += n;
		}
		return sum;
	}
	
	public static String diceRollSum(int N, int X, List<Integer> sofar) {
		if (sofar.size()==N){
			if (sum(sofar)==X) {   // evaluate this leaf
				return sofar.toString();
			} else { return null; }
		} 
		for (int i=1; i<=6; i++) {   // all possible local decisions 
			sofar.add(i);  // make local decision
			String answer = diceRollSum(N, X, sofar);
			if (answer!=null) {return answer; }        
			sofar.remove(sofar.size()-1);     // undo local decision
		}
		return null;
	}

}


```

### Review Process
You will be stepping through problem 9 from the midterm. This problem is a recursive dice rolling 
combination and summation problem. As you step through this problem, you will be answering a series 
of questions that you will need to show your SL the correct answers to. 

1. Take the steps from the article to launch the debugging process. Make sure that the Debug and 
Variables windows are open as you will need them to answer the next few questions.  If you do not 
see them, go to Window show view and find them. 

2. Place a breakpoint on line 16 and 29 and run the program. Move through a few steps of the program 
by clicking on the Resume button (yellow bar and green triangle) and the variety of Step Into, Step Over 
and Step Return buttons inorder to become familiar with their functionality. Explore the functionality 
by moving breakpoints and seeing the effects. 
```
	How can you tell what line is being executed? 
	
	What is the purpose of the Step Into button how does the Step Into button differ from the Resume button?
```	
3. You are able to find the values of the variables in the Variables window. By stepping through 
the program and seeing which variables are present at each step, answer the following questions. 
```
	What variables are visible when you are in the sum method? 
	
	What variables are visible in the diceRollSum methods? 
```
4. From the debug window, terminate and relaunch the debugging process. 
```
	What are the values of N, X, sofar and i?  
```
5. Step through to the first call to sum. 
```
	What are the values of nums, sum and n? 
```
Concluding questions:

	What does the N parameter represent?

	What does the X parameter represent?
	
	What does sofar represent? 
	
	Consider the method call diceRollSum(3, 6, new ArrayList<Integer>()). Which sum combination will be returned? 
