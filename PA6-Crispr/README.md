# PA6-Crispr

## Learning Objectives

The goal of this assignment is to design a class hierarchy to solve a problem, implement that 
hierarchy, use polymorphism, and use multi-dimensional arrays and/or lists.

What is a class hierarchy you ask? Read about it on [Wikipedia](https://en.wikipedia.org/wiki/Class_hierarchy). 
The class diagram you will be submitting will be a simplified version of the UML class diagrams. There 
are many resources on the internet for UML class diagrams. We expect your class diagram to, at a minimum
contain all of the classes involved in the project, which classes inherit from other classes, and what
methods and fields are contained in each class.

## Crispr

[Crispr](https://simple.wikipedia.org/wiki/CRISPR) is relatively new and very powerful way of editing 
gene editing. Many, many scientists are currently experimenting with ways to use it to [restore ecosystems]
(https://www.theatlantic.com/science/archive/2017/11/new-zealand-predator-free-2050-rats-gene-drive-ruh-roh/546011/),
[eradicate or minimize diseases](https://www.npr.org/sections/goatsandsoda/2018/09/24/650501045/mosquitoes-genetically-modified-to-crash-species-that-spreads-malaria), 
and solve other real world problems. In most cases they use it to stop a problematic species from being able 
to reproduce. This can have far reaching and sometimes catestrophic effects on the local ecosystem. Therefore, 
before scientists release any creatures with edited genes out into the real world, they run a tremendous amount 
of computer simulations to try to predict how the altered species will affect the eco system. In this project, 
you will be creating a simple simulation of an ecosystem with one Crispr edited creature included. 

For this assignment, the ecosystem you will be implementing will consist of a number of columns and rows. 
The animals will move around this ecosystem. When they run into one another, depending on the animal type, 
they will either eat or reproduce. Animals with a Crispr gene will stop being able to reproduce in
circumstances later on in this specification. Animals must have enough to eat in order to stay
alive. Animals are divided up into three different categories: mammals, birds, and insects, all of which
have unique characteristics.

However for PA6, you will not be implementing the eat command. You are also NOT responsible for tracking
whether an animal is alive or not. PA8 and PA9 both build off of PA6. We will add these other parts in
the later assignments.

## Getting Started

The github assignment link is https://classroom.github.com/a/fSoJkatG.
Please note that the gradescope assignment has not been released yet.

## The Assignment

This is a three-week assignment (counting spring break). The class inheritance diagram will be all that is due
Friday March 1 at 11:30 pm to Gradescope. We make suggestions as to what to implement after receiving your class
hierarchy diagram. While you are responsible for managing your own time, I have added a list of milestones later
in this writeup. The assignment is due Friday, March 15 at 11:30 pm.

Class inheritance diagram: Create this diagram however you would like (draw it by hand, use software, etc.). 
You need to create a pdf file of it and submit it to Gradescope.

See (https://gradescope.com/help#help-center-item-student-scanning) for some suggestions of how to scan in a 
document with your phone if you plan to produce your pdf by taking a picture of it. I personally use an app
called Genius Scan which has always worked well for me, but past performance is no guarantee of future results.

Your main program, which must be named `PA6Main.java`, will need to accept the name of an input file on the command 
line. The input file will contain all of the simulation initialization settings and the commands to simulate. Here 
is an example input file.

```
rows: 5
cols: 5

CREATE (1,1) lion female right
PRINT
MOVE
print
```

Note that the commands should be case-insensitive. In other words, "print", "PRINT", and "Print" are all equivalent
in the input file. Here is the output for the example:

```
> PRINT
.....
.l...
.....
.....
.....

> MOVE

> PRINT
.....
..l..
.....
.....
.....
```

The output should be printed to standard out. See PublicTestCases/ for more input and output examples.

The following are the types of specific animals that can be created:

```
MAMMALS      BIRDS          INSECTS
-------      -----          ----------
Elephant     Thrush         Mosquito
Rhinoceros   Owl            Bee
Lion         Warbler        Fly
Giraffe      Shrike         Ant
Zebra
```

For PA6, animals will be represented with ascii characters. Use the lower case version of the first letter of 
the animal name. For "Elephant" use 'e', for "Warbler" use 'w', etc.

## Commands that need to be implemented

See the PublicTestCases/ for more examples. There are examples with CREATE, PRINT, MOVE, and REPRODUCE. 

### The CREATE Command
```
EXAMPLE USE: CREATE (0,0) lion female right
```
If the CREATE command is read, it should be followed by coordinates to place the animal, the type 
of animal to be created, the gender of the animal and any other information needed to create that 
animal. Use animal type to create the correct subclass of animal in the simulation at the given coordinates. 
The coordinates are given as row and column. Both rows and columns start at 0. Rows go down the screen, 
and columns go across the screen.

POTENTIAL ISSUE (there are a lot of subtle points in this assignment that I want to warn you about explicitly,
for the remainder of this writeup I will label it with "POTENTIAL ISSUE"): the coordinates are given as
(row, column). Note that this is the opposite of an (X,Y) coordinate grid. i.e. if I was passed (1,4) as (row, column)
this would correspond to (4,1) as (X,Y). Please draw this out on a sheet of paper and go through an example to 
ensure your understanding.

Animal specific information:
 * Mammals need a direction (left or right), 
 * Birds need a number, 
 * Insects need true or false,
 * Mosquitos need three true or false values 

### The PRINT Command
```
EXAMPLE USE: PRINT
```
If the PRINT command is read, then the entire ecosystem, including living animals, should be 
printed to standard out. If more than one animal occupies a location, just print the first one. 

### The MOVE Command
```
EXAMPLE USE: MOVE
```
If the MOVE command is read, then *each animal should move once*. 

POTENTIAL ISSUE: Below examples talk about animals moving multiple steps. i.e. a bird moves the number of steps
originally passed in on its creation down, then right, then up, then repeats. However each time MOVE is called,
every animal moves only 1 step, no matter what. So even if a bird needs to move three steps down, each time MOVE
is called, it will move only one step down. Go through the example test cases to make sure you understand
how animals are supposed to move before coding the MOVE method.

An animal that moves off the side of the grid should appear on the other side. The same thing should happen if
an animal moves off the top or bottom. It is recommended you complete "off-grid" movement only after ensuring your
MOVE command works for normal cases. Animals should be moved starting from the upper left corner, continuing right 
until the end of the first row, then on to the second row left to right, etc. The animals at a square 
should be moved in the order they got there.

  * If a mammal is created with the right option it alternates between moving right and down, starting with down. Otherwise, 
    it alternates between moving left and up, starting with up.
  * A bird moves the number of steps originally passed in on its creation down then, the number right then, 
    the number up and then repeats.
  * Insects make either clockwise (if passed in true when created) or counterclockwise squares, walking the same 
    number of steps in each direction until a complete square is made. Both start by walking left. The initial square should
    have one step on each side. The number of steps should increase by one each time a square is completed. This movement
		is the most complicated one. Implement move for mammals first, then birds, then insects.
    
### MOVE (row,column)
```
EXAMPLE USE: MOVE (2,3)
```
Move any animals located in the ecosystem at position (row ,column). If there is nothing at this position or the position is outside the size of the ecosystem, don't do anything.

### MOVE [type]
```
EXAMPLE USE: MOVE hippo
```
Move only animals of the specified type.

### MOVE [Animal]
```
EXAMPLE USE: MOVE mammal 
```
Move only animals of the specified class.

### REPRODUCE
For all locations, the first two animals at that location should try to reproduce. In order to reproduce the
two animals need to be the same species and opposite genders. If the pair of animals reproduce successfully,
create a third animal of that type in that location that is female. 
  * Mammals can each only reproduce 5 times. Baby mammals should be passed `right`.
  * Birds can always reproduce. Baby birds should be passed 5.
  * Insects, except mosquitos (as they are our Crispr editted species) always reproduce. Baby insects should be passed false.
  * Mosquitos carry two genes related to reproduction (the last two boolean parameters given when they are 
    created). If these are both true, the mosquito cannot reproduce.  Baby mosquitos should be passed false and 
    a boolean value indicating whether it has edited genes from each parent. If the parent has edited genes 
    the new mosquito should be passed true for that parent.  In other words, the value of the first boolean 
    (which describes the direction the mosquito moves) is false. The second value comes from the first parent. 
    The third value comes from the second parent. i.e. Each mosquito has two genes. If either one is modified
		then it will pass on true to its child to indicate that the child receives a modified gene from its parent.

### REPRODUCE (row, column)
```
EXAMPLE USE: REPRODUCE (2,3)
```
Animals at location (row, column) should try to reproduce.

### REPRODUCE [type]
```
EXAMPLE USE: REPRODUCE lion
```
All animals of the specified type should try to reproduce. If there are no animals with that type, do nothing.

## Error handling

All of the inputs will be correctly formed for this assignment.

## Design Suggestions

We recommend the following:

* An Ecosystem object with a 2D list of lists of animal objects. Note that since multiple animals can be in 
  the same location, you will need a level of lists to store all of the animals at each location.
* An Animal class hierarchy of some kind. The design for this is what will be submitted for review on 
  Mar 1 at 11:30 pm to Gradescope.

## Milestones

While we do not require you to follow this objective list, we highly recommend you tackle the tasks in this order.
There will also be test cases you can use to see if you are on the right track for each milestone.

1 Read the writeup at least one time through, taking notes on a separate piece of paper on the important aspects.


2 Think and draw your Animal class hierarchy. The design for this is what will be submitted for review on 
  Mar 1 at 11:30 pm to Gradescope. This may take multiple iterations. Think about a class hierarchy that makes sense
	and reduces code duplication.

3 Write your PA6Main.java file which reads in a file of commands and calls the appropriate classes. This file should
	not be overly long or complex. Instead of calling the methods you have not written yet, put in "dummy" print statements.
	For example if REPRODUCE [type] is called, just have PA6Main.java print out "REPRODUCE lion called".

4	Write your Ecosystem.java file which will keep track of your grid of animals. Presumably, this file will hold the
	functionality for the PRINT command. Write this print command and test that it prints off empty grids of the correct
	size.

5	Go through multiple test cases in the PublicTestCases folder. Make sure that you understand why the output performs
	as it does. If you don't understand, post on piazza. While we hope this is not the case, It is also possible that
	there are some errors in the test case outputs. Many of the test cases were created new to be able to test smaller
	parts of the assignment.

6	Write the barebones skeleton of your Animal classes. At the very least you should be able to create each animal type.

7	Write the necessary code for CREATE. You should now be testing your code with every incremental change. With CREATE,
	you can now look at the different test cases we have provided to ensure you are placing animals correctly after having
	been created.

8	MOVE: specifically MOVE for mammals, then for birds, then for insects. After MOVE for each animal type, compare your
	output to the test cases we have provided that moves those specific animal types. Catching bugs earlier rather than
	later will make your life much easier. Also we recommend that you implement the general MOVE, before moving on to the
	specific types like MOVE (row, column) and MOVE [type], and MOVE [animal]. It is imperative to your success that you test
	each successive change as you write your code.

9	Reproduce: follow a similar pattern as you did for the MOVE command in step 7.

10	Tie together any loose ends. This should include a full review of your code to see if you can simplify anything. It
	is recommended that you commit and push before reviewing/changing your code in case you break anything.

## Grading Criteria

Half of the PA6 grade will be correctness.  For this assignment, there will be some private test cases on 
Gradescope used for grading.

The other half of the PA6 grade will be decomposition, code clarity and your class hierarchy diagram

### Decomposition

* Points will be taken off for copy, pasted, and edited code that
  should have been encapsulated in a method.
  
* Should carefully select data structures that implement the required 
  functionality.

* Your program should contain 10 or less java files. All of the Java files should be <350 lines of code.

* Each method should be less than 30 lines.  This INCLUDES
  comments, but not the method header.  It is easier to read a 
  function if it can all fit on one screen.

* Make things as simple as possible.
  * Don't use lambda functions or other features in non-standard ways.
  * Reduce the amount of conditional nesting as much as possible.

* Declare collection variables using interface types.

* Your code should be decomposed well. main should be a good summary of 
  your program and no method should be overly long or trivial. Your methods 
  should not be chained. Do NOT have main just call one method that does everything.

 * Redundancy is a grading focus; some tasks are similar in behavior or based off 
   of other tasks. You should avoid repeated logic as much as possible.

Code Clarity
* YOU should be able to read, understand, and explain your own code
  to someone else a couple days after you wrote it.
  * No magic numbers
  * No methods written to just get the test cases to work

* There needs to be a balance between no comments in the body of the
  methods and a comment for every line in the program.  Either extreme
  will result in points off.

* The file header should include instructions on how someone would
  use this program.  To use the program, one would need to know the
  input file format.

* Use meaningful variable names.  Loop iterators can
  be simple (i for integers, s for strings, n for numbers, etc.).

 * We will be modeling some of the issues we are seeing with code.

 * We will ask permission to show clear code examples.


The coding style in terms of spacing, etc. should be done automatically every time you 
save in Eclipse. As long as you stick with those defaults, the syntax style should 
be fine. At workplaces the style requirements can be extensive. In this class, we have 
the following requirements:
 1. No lines should be longer than 80 characters line.
 2. Do not mix tabs and spaces. Use spaces consistently.
 3. The left curly brace should start on the same line as the loop or conditional.

## Submission

Write your own code. We will be using a tool that finds overly similar code. We recommend that when 
talking with others about the assignment, do not write anything down.

The class hierarchy diagram in pdf format is due Friday 03/01 at 11:30 pm in Gradescope.

For PA6, you are REQUIRED to submit all of your java source files to Gradescope before Friday 03/15
at 11:30 pm. Since this is a longer assignment we highly recommend you commit and push after completing
each milestone.
