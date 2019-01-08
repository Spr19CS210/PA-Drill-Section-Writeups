# CS 210 Drill Writeups

credits: Russ Lewis wrote most of the original drills for 127A&B in CloudCoder, 
         Michelle Strout converted some into a github and gradescope organization,
         Michelle Strout and Allison Obourn developed drills to support the PAs in 210

This file is online at github 
https://github.com/Spr19CS210/PA-Drill-Section-Writeups/tree/master/Drills

## Drills for Spring 2019

Computer Science is the art of solving problems with computers.  The main mechanism
we use to solve problems with a computer is programming.  This semester, you will be 
learning and practicing the skill of programming in Java.  For the last couple of 
decades, Java has been the first or second most popular programming language 
(https://fossbytes.com/most-popular-programming-languages/).

Programming is a skill that like all other skills require practice to learn and improve.  
In CS 210 this Spring 2019, you will be doing programming drills that are due on Wednesdays.
These drills provide you an opportunity to learn and practice the basic syntax and semantics
of Java and how to use Java to solve and test solutions for the kinds of problems
that will appear in the larger programming assignments.

*IMPORTANT:* The drills are meant to take less than one hour to 
complete each week.  If you get stuck, then post a question on piazza.
You can post a question anonymously to your classmates
or privately to the to CS 210 instructor and section leaders.

### Getting Started with Drills

Let's start by having you create your own private drill repository on github,
which you will be using all semester.  No one but you and the CS 210 staff
can see the code in your private drill repository.

 * (ONE TIME SETUP) Each student will create their own drill code repository by 
   accepting the drill assignment at https://classroom.github.com/a/3EVlyjtr.
   The github account you use must have your netid@email.arizona.edu email
   address associated with it for you to accept assignments in github for CS 210.
   ALL of your drills should be committed and pushed to your drill github repository to 
   enable the CS 210 staff to help you with any questions or issues you are 
   having over piazza or email.
   
 * (ONE TIME SETUP) In Eclipse, import the drill repository.
   In Eclipse: File --> Import --> Git,Projects from Git, Next, Clone URI, Provide the
   link of the github repository that was created for you, and then click Finish.
   See the tutorial about this provided on Piazza if you have more questions.


### Running a Drill within Eclipse

In the src/edu/uacs210spr2019/drill##/ directories, there will be
a Drill##.java file (and later other files) that you will be editing.
   
Give it a try!  There is a src/edu/uacs210spr2019/drill00/ 
subdirectory with the files Drill00TestClass.java and Drill00.java.
   
     * In the Eclipse Package Explorer, right click on the 
       Drill00TestClass.java and click Run As --> JUnit Test.  
       All of the test cases should work with no Failures.
       
     * Go to Gradescope and submit the Drill00.java file to
       the Drill00 Assignment.  Note that the autograder is running
       the same tests that are in Drill00TestClass.java and it
       will tell you your grade for drill00.  Drill00 has already been
       implemented for you so we can illustrate how drills work.


### Doing Drill01 through Drill09

Doing a drill consists of (1) downloading the files for the drill,
(2) adding those files to your drill repository, (3) writing code
to solve one drill problem at a time, (3) committing and pushing your code
frequently (everytime you run it for example), (4) testing each drill problem
solution in Eclipse using JUnit, and (4) submitting the solution
to the appropriate drill assignment in Gradescope.

#### (1) Downloading the files for the drill

For each drill assignment, there is a src/edu/uacs210spr2019/drill##/
subdirectory in your drill github repository.  Your drill github repository
was initially copied from the drills public repository
https://github.com/UACS210spr2019/Drills-Public.  The repository starts
with at least the files for drill00 and drill01.

As the semester progresses, we will be posting the Drill##TestClass.java, 
Drill##.java, and any other needed files in the drills public repository.
You can download the file to your machine and place it in the appropriate
drill##/ subdirectory in your Eclipse Drill project.  Make sure to do a
Team --> Commit and Push on those new files.

#### (2) Submitting Drills via Gradescope

Log in to your Gradescope account and find the Drill## assignment for CS 210
and click on submit.  Drag the files you need to submit (i.e., Drill##.java)
from the eclipse package browser to the Gradescope submission window or
navigate through the Gradescope file finder.  Click Upload and you should see
your grade for the drill in 5-10 seconds.


#### (3) Recommendations

Work on implementing one method at a time.  For the drills, you will be 
given simple Java methods and (and later classes) to implement.  A method is 
a small block of code that takes some inputs and returns an output - a lot 
like a function from Python.  Your job is to write a small amount of Java 
code (usually <10 lines) that will produce the correct result for any valid
inputs.

Submit to gradescope as many times as you would like.  Gradescope
will autograde your drill and tell you your grade for each drill.
Each drill will indicate at the top of the drill##-README.md file
exactly what file(s) need to be submitted to gradescope for that
drill.  There are no hidden test cases for drills.  You can test
all of your drill method implementations in Eclipse before uploading
your file(s) to Gradescope.  Feel free to submit partially done drills
to check on your progress (and provide yourself at least some partial
credit if you forget to finish the drill).

### Now go read drill00-README.md and get started learning and practicing Java!
