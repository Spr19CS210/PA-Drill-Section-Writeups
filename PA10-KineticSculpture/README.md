# PA10-KineticSculpture

Writeup for the Kinetic sculpture assignment.

## Learning Objectives

This assignment is a synthesis of many of the concepts that we have
covered this semester in class.
 * graphs
 * GUI input and output and event-driven programming
 * inheritance
 * reading input from a file
 * removing redundancy and other code clarity improvements

For PA10 you will be designing a kinetic sculpture simulation.  Look
up "kinetic sculpture" on the internet for a plethora of pictures.
The PA10hardCodedDemo.java starter code hardcodes an example 
kinetic sculpture with four sculpture nodes (input, thing1, thing2, 
and sink) connected with four edges.

Below indicates the minimal requirements for the assignment.
In addition you can design as many other kinds of sculpture nodes as you
would like for up to 10 points of extra credit on PA10.  Note that the 
rules of physics do not need to be followed: circles can change colors, 
they can disappear, new circles can be generated, etc.  We look
forward to seeing your creativity!

## The Assignment

This is a two-week assignment.
* For the first week, put together a class hierarchy diagram with ALL the 
  classes you plan to have and their fields and interface. 
  You can change the plan later, BUT your plan needs
  to have enough in there to do the minimum requirements of the assignment.
  You won't have to submit the diagram until the final due date, but we
	strongly recommend you make significant progress on this assignment
	during the first week.
  
* The whole assignment will need to be completed by the end of the second
  week with a demo video, Java source code, and an in-person demonstration
  of the GUI with your section leader during section. In section, you will
	be demoing the code you submitted on THURSDAY April 25th.


For the assignment, you will need to do the following:
 * Using some form of graphical input (TextField, ...) to have the user
   provide an input file name.
      
 * Read in an input file where the sculpture nodes and how the
   nodes should be connected are specified (hint: graph data structure).
   You can assume the input is correctly formed.
   Here is the input file for the hardcoded example in the PA10
   starter code.
```
delay: 1
input: RED, BLUE
0: input, (12,12)
1: passthrough, (70,25)
2: passthrough, (60,200)
3: sink, (200,150)
0 -> 1
0 -> 2
1 -> 3
2 -> 3
```
    Any number of colors can be specified in a list after the "input:" label.
    You need to at least handle the following colors: RED, BLUE, YELLOW, GREEN.
    There will only be one delay specified.  Any number of
    sculpture nodes and edges between nodes may be specified.
    Sculpture nodes do not need to be connected to any other nodes.
    
  * Graphically layout the sculpture nodes with their top left corner being
    at the specified coordinates.  For the three required sculpture nodes
    (source, passthrough, and sink), the input ports are on the left
    of the sculpture nodes and the output ports are on the right of the node.
    When two sculpture nodes are connected, the line representing the connection
    should go from the middle of the right side of the first node to 
    the middle of the left side of the second node.
    You can set the width and height of the nodes as you wish.
    Run the provided PA10hardCodedDemp start code for an example.
    
  * Create a class hierarchy for kinetic sculpture nodes.
    Required nodes include:
    
    * An input node that each processing step will take
      a circle off the input list and put it on the input nodes's 
      output port.
      
    * A passthrough node that for each processing step takes
      a circle from its input port and moves it to its output port.
      
    * A sink node that each processing step takes all of the
      input circles, removes them from the input port, and prints
      their color to standard out.
       
     
  * Note that there will need to be a processing step that iterates
    over all nodes and has them process their input port.
    After that, there will need to be a separate pass over all
    of the edges that connect nodes.
      
  * The provided starter code has a significant amount of code
    redundancy, some magic numbers, and is only hardcoded for one example.
    Do NOT submit the starter code.  Your code will need to be significantly
    cleaner.
      
  * Your demonstration will need to be done using the provided
    sculpture.in.  You can append more sculpture nodes of different
    types to that file to make your kinetic sculpture
    program unique and to garner up to 10 extra credit points.
    If you do that, submit a mySculpture.in file to Gradescope.
      

## Getting Started

 0. Start NOW!    

 1. Accept the github assignment for PA10, [https://classroom.github.com/a/0riTiUPi].
    Import your PA10 github repository into Eclipse as usual.
 
 2. Run the PA10hardcoded.java and see what it does.
 
 3. Develop a design for PA10.  What classes will you have with
    what fields and what methods?
    
 4. Write your program using any code/ideas generated in class
    and code provided in the repository to help get you started.
 
 5. Make a video of running sculpture.in through your program.
 
 6. Demonstrate your program in your section on Friday April 26th
  or Monday April 29th.

## Suggestions

 * Work on a Sculpture object that can read itself
   in from a file first.
  
 * Then work on displaying the Sculpture object using the
   provided JavaFXView functionality.
    
 * Do the execution of the sculpture last.  The execution
   of the sculpture is where there are marbles flowing
   through the sculpture.

 * Odds and Ends
 
   * Setting the width of a TextField.
   ```
    TextField filename_field = new TextField();
    filename_field.setPrefWidth(200);
   ```
   
   * There will only be one input node specified in any of the provided input files.
   

## Grading Criteria

Half of the PA10 grade will be correctness (30 points) and the class hierarchy diagram (20 points).
For this assignment, correctness is the GUI input and output, which you will illustrate in a demo video
AND in an inperson demo to your SL.  You should also expect that we 
will run your program with additional input files besides the ones provided.
The class hierarchy diagram should follow the format used in PA6 and contain enough
functionality for completing the assignment.

The other half of the PA10 grade will be your decomposition and code clarity.

Decomposition

* Points will be taken off for copy, pasted, and edited code that
  should have been encapsulated in a method.

* **This program should use fewer than 10 .java files.**
  Each of these files should be (<225 lines).  Do NOT include
  PA10hardCodedDemo.java.

* Each method should be less than 30 lines.  This INCLUDES
  comments, but not the method header.  It is easier to read a 
  function if it can all fit on one screen.
  

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

For this assignment, you are **REQUIRED** to submit all of the following files:
  * by Thursday April 25th 11:30pm to Gradescope.
    * a class hierarchy diagram with all the classes, their interfaces, and
      any inheritance relationships
    * All the Java source files needed to run your program.  Do NOT include
      PA10hardCodedDemo.java.
    * mySculpture.in, start with the provided one, but feel free to ADD to it to
      show off for extra credit
    * mySculpture.mov, or other video format that can be run on multiple platforms.
      The video should be around 30 seconds long.
  
To create the video, you can use a program to record your screen as you run 
your program (see PA8 writeup), or you can simply record your screen with your smartphone or tablet. 
Do note however that the video you submit must be of good enough quality for 
the SL's to clearly see you enter the input filename and see your sculpture execute.

Write your own code. We will be using a tool that finds similar code.

It is recommended that when talking with others about the assignment, do not write
anything down.
