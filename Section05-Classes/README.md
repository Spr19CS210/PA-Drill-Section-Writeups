# Section05-Classes (Status: Posted 10/4/18) 

## Introduction 
Today we will practice drawing class hierarchy diagrams and writing a
StarScreen class for a provided driver. You will be showing your SL your diagram
and submit a StarScreen.java file to Gradescope.

## Setup

Accept the Github classroom assignment for Section 5. [https://classroom.github.com/a/G-oMEJ5F]

Then do the following:

Click on the green "Clone or download" button on the right of the web page and
copy the provided URL.

Import your section repository into Eclipse.

Open Eclipse
File —> Import —> Git —> Projects from Git, Next, Clone URI, Next, paste in
repository URL from github
Next, Select the master branch, Next, make the local destination
/home/username/eclipse-workspace/Section5-Classes-yourgithubid.
Next, Import existing Eclipse projects, Next, Finish.
Now you are ready to start coding.

## Assignment
Overview: You will practice drawing the class hierarchy diagram on paper
and write a StarScreen class for the driver in order to prepare you for PA6.

### Part One - Hierarchy diagram
Draw the class hierarchy diagram including the fields and methods for the following code.

```
public interface Microwaveable {
	void heat(double sec);
}

public class Lunch {
	
	private List<String> ingredients;
	private String varietyType;
		
	public Lunch(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public Lunch(String varietyType) {
		this.varietyType = varietyType;
	}
	
	public void assemble() {
		for (String ingredient: ingredients) {
			System.out.println("Putting "+ingredient);
		}
	}
	
}

public class HotPocket extends Lunch implements Microwaveable {
	public HotPocket(String flavor) {
		super(flavor);
	}
	public void assemble() {
		System.out.println("Unwrapping my hot pocket.");
	}
	public void heat(double sec) {
		System.out.println("Heating up for "+sec+" seconds.");
	}	
}

public class Salad extends Lunch {
	public Salad(List<String> ingredients) {
		super(ingredients);
	}
}

```

### Part Two - StarScreen

For PA6, it is recommended to have a Screen object with a 2D array of
characters that will print the representation of the animal objects
and their locations. This will give you a visual of where the animals
are on the screen. To prepare for this, create a similar class
called StarScreen. This will be a grid of stars represented by the
character *. Empty indices will be represented with a period.
The provided file, StarScreenDriver.java will use your class
and make StarScreen objects to print the stars on the screen.

Take a look at the driver and try to deduce which methods need to be
implemented inside of StarScreen.  Answer the following questions:

1. What data structure does StarScreen use?
2. What field(s) does StarScreen need?
3. What argument(s) does the constructor have?
4. What are StarScreen's methods and what should they do? 
5. What should the grid be initialized with?

You'll notice that in the driver, there is no call to initialize
the grid with periods. Why do you think that is? What access specifier
is used for this method and where is it called?

When you are ready, make a new java file called StarScreen.java.
Implement the methods for the driver to run successfully to produce
the output below.

```
*..
...

.....
...*.
.....
.....

.........*

**
**

*******
*.....*
*.....*
*.....*
*******

***
***
***
```
