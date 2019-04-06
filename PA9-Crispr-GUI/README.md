# PA9-Crispr
NOTE: This assignment is due THURSDAY April 11th at 11:30PM. This is because
you will be demoing your project to your section leaders in section.

## Learning Objectives

The goal of this assignment is to improve on basic JavaFX knowledge by adding
event-driven GUI programming to the PA8-Crispr program.

## The Assignment

For PA9, you will be adding events to the GUI representation of PA8. This means
there will be no input file to read from. Instead of reading the input file
from the command line arguments, you will read in the number of rows and columns
of the ecosystem from the command line.  Then along with the ecosystem visualization
you will create a TextField where a user can input an ecosystem simulation command
(e.g., move, reproduce (2,3) eat, ...) and then click on a simulate
button to show the results of that command.

Another interesting aspect of PA9 is that you will be continuing to refine
the ecosystem simulation code.  Some of your code will change and some of the
code from PA8 and PA6 should be removed in PA9.


## What needs to be removed

**File reading:** Since we are no longer reading commands in from a file,
all code that is used to read in from a file is no longer needed.  You will
still need to parse commands however.

**Delay Code:** In the previous assignment a delay was needed to show the output
for every command, for this assignment this is no longer needed since we are running
one command at a time via a graphical user interface.

## What needs to be added

**User input:** Since we will not be reading from a file, we are going to need some way
to read in commands from the user.  We recommend a TextArea and a button to cause
the execution of the command in that TextArea.  Feel free to try different approaches.

**Event Handlers:** To use the information that the user provides your code must have
at least one Event Handler. This should grab the information from the user and do something with
it whenever a specified event occurs. (clicking of a button or pressing enter on keyboard)

## What needs to be changed

**Command line arguments:** Instead of reading in a filename from the command line, you will
be reading in both the number of rows and number of columns of the ecosystem.

## Steps for completing this assignment

 1. Accept the github assignment for PA9, [https://classroom.github.com/a/ateEspXb].  
    Import your PA9 github repository into Eclipse as usual.
 
 2. Play around with the given PA9 starter code that does something with the 
    text a user puts into a text field.
 
 3. Make sure your PA8 code works.
 
 4. If it does, then copy your PA8 code into the Eclipse project.
 
 5. Implement the the functionality provided in this write up for PA9.
 
 6. Test your code with various inputs to make sure that it works correctly.
 
 7. Create a demo video that shows commands being entered and simulated.


## Resources

The provided code uses some new GUI input concepts such as event handling.
Here are some references and also refer to the reading assignments about
event handling.

  * Text Field, https://docs.oracle.com/javafx/2/ui_controls/text-field.htm

## General requirements

This assignment is different from other assignments you've had so far 
in that you are given a lot more freedom to design your output the way 
you want. You can try to mimic what was done in the video and get the 
credit for it, but however you choose to receive graphical input for your
ecosystem, the following general requirements must be met:

* A user should be able to type in a command or select options and submit it via the GUI. This means that there
  should be somewhere to insert text and some way to submit that text. Both of these must be
  **intuitive**, that means that the user must understand where they should insert commands
  and how to submit said command by only looking at the GUI. 

* As in PA8, each animal must be **one-of-a-kind**, meaning they must be distinguishable 
  from any other kind of animal and the background. In the example video, this is 
  done by using a different color for each animal against a brown background. 
  You do not have to do it this way, for example, you can choose to use an 
  image for each animal instead of a colored tile.

* As in PA8, each command must be **visually noticeable**. This means that when 
  'MOVE' is called for example, it should be visually obvious that every 
  animal moved by 1.

* As in PA8, there must be a command log that displays commands as they are being executed. 
  In the example video, this is done in a TextArea at the bottom of the ecosystem.
  


## Grading Criteria

Half of the PA9 grade will be a working GUI.  You will be demonstrating your
GUI to your SL during the Friday/Monday sections after the due date.  Your demonstration
must be less than 5 minutes and show all of the above listed criteria.

The working GUI must also be demonstrated with code and a demo video.  
Submit your PA9 code and demo video (MOV or MP4 format) to gradescope.

The other half of the PA9 grade will be your code decomposition and code clarity.

* Points will be taken off for copy, pasted, and edited code that
  should have been encapsulated in a method.
  
* Should carefully select data structures that implement the required 
  functionality.

* Your program should contain 10 or less java files. All of the Java files should be <350 lines 
  of code.  The usage instructions in the file header do not count towards the <350 line limit.
  

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

Remember, we will be grading the code that you submitted for PA6 again. Therefore, you must fix any
errors (with decomposition in code clarity) that were pointed out in your PA6 grading or receive further deductions.
You will not be counted off for minor functional errors that still exist from PA6. An example of this would be if you
failed a few private test cases but your program still works well overall. If you had serious issues with PA6 and your
program does not work for simple inputs, then you will be marked off since it will be impossible to assess your GUI.


## Submission

For this assignment, you are **REQUIRED** to submit all of the following files
to Gradescope before Thursday April 11th at 11:30pm. 
  * All the Java source files needed to run your program.
  * Your netid-demo.MOV file with your demo video.
  * If you are trying for the up to 10 extra credit points for going
    above and beyond, then let your SL know during your demo and summarize 
    what you did extra in a README.md file that you submit to Gradescope.

Write your own code. We will be using a tool that finds similar code.

It is recommended that when talking with others about the assignment, do not write
anything down.
