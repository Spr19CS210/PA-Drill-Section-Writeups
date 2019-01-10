# PA1-Gradenator (Status: posted 1/09/19, due 1/18/19 at 11:30pm)

The goals for PA1 are to get started with Java and figure out how to 
calculate your current CS 210 grade.

## Input File

When your program starts it should prompt the user for an input file. 

Each line of the input file should be in the following format:
```
  <number> <number> ...; <string with no semicolons>; <number>% 
```
  
Specifically one or more numbers in the inclusive range 0 to 100 [0,100] 
separated by one or more spaces, a semicolon,  a string with any characters 
except a semicolon, a semicolon, and a number in the inclusive range 0 to 100 
[0,100] followed by a percent sign. The Java `Scanner` class with its `nextLine()` 
method can handle whatever line ending your file system uses. 

Example input (see the syllabus for percentages for your grade in this course):
```
  80; final; 20%
  90 60 80; programming assignments; 25%
```

An overall grade will be calculated by averaging the grades listed at the beginning
of each line (e.g. avg(90 60 80) ==> 76.67) and then computing a total grade
based on the percentages indicated on each line (e.g. (0.20)80 + (0.25)76.67
==> 35.17, where (0.20)80 is another way to write 0.20 times 80).  
Note that if the input percentages do not add up 100%, then the
total grade will not be out of 100%. In the example above the best possible
grade would be 20% + 25% ==> 45%.

The output will be the average grade per line and a total line. Example
output:
```
  final; 20.0%; avg=80.0
  programming assignments; 25.0%; avg=76.6
  TOTAL = 35.1% out of 45.0%
```
Numbers representing discreet values should be stored as `int`s. Numbers representing 
continuous values should be stored as `double`s. 

Values of type `double` are printed with many digits after the decimal place by default 
but this does not look very good and causes grading problems due to round-off differences.
Therefore, to print a smaller number of digits we will be using `System.out.format`.

Example: 
```
System.out.format("%.1f is pi", 3.141);
```

The above line will output the following:
```
3.1 is pi
```
You should use the exact syntax above to round all output to one digit after the decimal. 
If you want to print a percent sign in a `System.out.format` statement you will need to escape it.
You can escape it by writing two percentage signs in a row `%%`. 

Error checking:
Your PA1 program can assume that all grading input follows the format described. Any input that 
does not follow the input format can result in undefined behavior.

## Getting Started

1. Use the assignment URL https://classroom.github.com/a/r1nCUNE\_ to set 
up a github repository.  And then click on that repository in your 
web browser (pa1-gradenator-yourgithubid).

2. Click on the green "Clone or download" button on the right of the web page
and copy the provided URL.  It should look like 
(https://github.com/Spr19CS210/pa1-gradenator-yourgithubid...).

3. Import your PA1 repository into Eclipse.
    1. Open up Eclipse on a lab machine or your machine (if you are working on
       your own machine, you will need to install Eclipse).

    2. File —> Import —> Git —> Projects from Git, Next, Clone URI, Next,
       paste in repository URL from github

    3. Next, select the master branch, next, make the local destination 
       /home/username/eclipse-workspace/pa1-gradenator-yourgithubid.  
       This is where the local git repository will be placed.

    4. Next, Import existing Eclipse projects, Next, Finish.

    5. Test that it runs.  Right click on the `PA1Main.java` file, Run As, 
       Java Application.

4. Edit, commit, and push a small change to the program.
    1. Put the code `System.out.println("Hello");` into the main method.
    
    2. Run the program and see that "Hello" is printed to the Eclipse Console.
    
    3. Right click on `PA1Main.java` --> Team --> Commit, move unstaged files
       that you want to commit into staged changes, put in a commit message,
       and then click "commit and push".

5. Submit your program for autograding to Gradescope as many times as you would like.
   Half of the points for each programming assignment for PA1-PA7 are autograded.
   Submit to Gradescope by logging into gradescope and then submitting the PA1Main.java
   file by dragging the file to the submit upload window.


## Testing your program

If your program cannot compile and run, then you should feel very
uncomfortable.  Experienced programmers write a little bit of new functionality
and then quickly compile and run it.  When you ask CS 210 staff questions
about your program, we will want to see that it compiles and runs.  Comment
out new stuff you have added until it compiles and runs.  Show us what compiles 
and runs, and then add the one small piece that breaks it.

There are two main advantages to frequent "commits and pushes" to github:
 * The CS210 staff can look at your code remotely to help you with questions.
 * If you FORGET to turn in your assignment, we will turn in the code from
   github that was the version at the time of the deadline.  It will cost you
   15 out of 100 points, but that is better than a zero for the whole assignment.

We recommend you do a commit every time you add a small piece and your
program compiles and run.  We also recommend you submit your code to Gradescope
(which automatically runs test cases whenever you submit) at least once 
a day to see where you stand with the grading script and the public
test cases.

`System.out.println` is your friend.  It can help you figure out what 
the value of variables are at various points in your program.


## More than one revision

The first time we write a piece of a program, it is really a draft.
We want to get the syntax right and figure out the functionality.
After that, we need to fix our initial comments so they clarify
what the code is doing.  Help your future self and others who
will be reading your code.  Plan on rewriting pieces of your
program multiple times to produce a professional and clear program.


## Decomposition Ideas

Here are some Java classes and methods that might be helpful when
working on this assignment.  We recommend you lookup online examples 
of how to use these and what their parameters and return values are:
* `System.out.println()`
* `new File("PublicTestCases/inputReal1.in")`
* `new Scanner(System.in)`
  * `hasNextLine()`
  * `nextLine()`
  * `close()`
* `String`
  * `substring()`
  * `indexOf()`
  * `trim()`
  * `split()`
* Iterating over an array of strings,
  https://www.guru99.com/foreach-loop-java.html


## Grading Criteria

Half of the PA1 grade will be correctness.  For this assignment, if your
program works for all of the test cases in `PublicTestCases/`, then you will
earn all of the correctness points.  Any time you submit to gradescope, it will
tell you how many of the 50 points you have earned.

The other half of the PA1 grade will be your decomposition and code clarity.

Decomposition
* Should just use `static` methods in the single `PA1Main` class.

* Use a single file.  This should be a small program (<200 lines).

* Each `static` method should be less than 30 lines.

* Make things as simple as possible.
  * Avoid nested loops.
  * Avoid nesting conditionals.
  * Avoid too many levels of user-defined methods calling other
  user-defined methods.


Code Clarity
* YOU should be able to read, understand, and explain your own code
a couple days after you wrote it.

* The file header should include instructions on how someone would
use this program.

* Use meaningful variable names.
You should avoid single letter variable names.

* The clearest code examples will be anonymously shown in class.

* The most obfuscated code examples will be anonymously shown in class
with suggestions for improvement.


The coding style in terms of spacing, etc. should be done automatically
every time you save in Eclipse.  As long as you stick with those defaults,
the syntax style should be fine.

Write your own code.  We will be using a tool that finds overly similar code.
Do not look at other students' code.  Do not let other students look at your code 
or talk in detail about how to solve this programming project. 
