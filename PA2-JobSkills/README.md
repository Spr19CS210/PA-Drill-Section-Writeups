# PA2-JobSkills (Status: POSTED 8/28/18 11:30 pm)
PA2-JobSkills assignment writeup.

## Learning Objectives

The goal of this assignment is to learn how to use the dictionary abstract 
data type in Java, sorting on lists, and reading parameters in from the
command line (Eclipse has an interface for providing command-line options to
a Java program, see Run As --> Run Configurations --> Arguments).

In Java, a HashMap implements a dictionary.  By the end of the assignment 
you will have practiced using the following operations on a HashMap:
  * insertion,
  * modifying the value for a particular key,
  * iterating over all of the key,value pairs, and
  * the fact that HashMaps do NOT store their key,value pairs in order 
    and how to handle it.

## The Assignment

For this project we will be using job skills data that you could download from 
the following website: 
https://www.kaggle.com/niyamatalmass/google-job-skills.
HOWEVER you do not have to download the file, because we provided it and other
variants of it with the same format in the PublicTestCases/ subdirectory.
In fact we had to do a lot of cleaning of the files, so see the "clean" versions
and note that the test cases only involve those clean versions.  
See ScrubCSVFile.java if you are interested.

Differently from PA1, for PA2 you will be taking an input file name from
the command line. 

The program should have the following usage:
```
    java PA2Main infile_name COMMAND optional
```
In addition to the input file, the second command-line argument will be a 
command to run on the data from your input file. The commands consist of 
CATCOUNT and LOCATIONS.  If an unknown command is provided, the program should
print the message:
```
Invalid Command
```

Each command will be most easily implemented with a HashMap.  Therefore,
your implementation will read in the csv file and be using one
or more HashMaps.

***CATCOUNT*** - This command reads an input file and for each job "Category" 
prints out the category and the number of jobs in that category.

***LOCATIONS <CATEGORY>*** For a given category list the locations that 
have a position in that category open.  Each location will be followed
by a number indicating how many positions in that category are open
in a particular location.
       
## Input and Output
Example input (see Kaggle for more in-depth description):
```
Company,Title,Category,Location,Responsibilities,Minimum Qualifications,Preferred Qualifications
Google,TitleA,CategoryX,Tel Aviv,Everything and the rest, BS, MS
Google,TitleB,CategoryX,Tel Aviv,Everything and the rest, BS, MS
Google,TitleB,CategoryY,Houston,Everything and the rest, BS, MS
Google,TitleC,CategoryX,Jonesboro,Everything and the rest, BS, MS 
```

CATCOUNT Output 
```
CategoryX, 3
CategoryY, 1
```

LOCATIONS CategoryX Output 
```
Jonesboro, 1
Tel Aviv, 2
```

## Getting Started

The process for getting started will be very similar to what was done in PA1.
* Accept the assignment to have a github repository be created for you at
  https://classroom.github.com/a/Hp0NVm-9.
* Import your PA2 repository into Eclipse (see PA1 writeup for details).

## Decomposition Ideas

Class 04 notes have examples of reading from the command line.
Refer to this activity to get started.
CSV files for this assignment, you can assume that splitting on commas
is ok.

Since HashMaps are unordered, special steps must be taken for them to be 
outputted in an ordered format. As shown below, take the set of keys and 
input it into an ArrayList of type String. Then use a Collections sort to 
sort the keys in place.

```
	ArrayList<String> sortedKeys = new ArrayList<String>(mymap.keySet());
	Collections.sort(sortedKeys);
```

## Grading Criteria

Half of the PA2 grade will be correctness.  For this assignment, there will be some 
private test cases. Partial points will be given if just one or two of the commands 
is implemented and works on those test cases.  Any time you submit to gradescope, 
it will tell you how many of the 50 points you have earned.

The other half of the PA2 grade will be your decomposition and code clarity.

Decomposition
* Should just use `static` methods in the single `PA2Main` class.

* Use a single file.  This should be a small program (<200 lines).
  We do not count any of the comments in the file header.

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
use this program and what an input file would look like.

* Use meaningful variable names.  Loop iterators can
be simple (`i` for integers, `s` for strings, `n` for numbers, etc.).
Otherwise you should avoid single letter variable names.

* The clearest code examples will be anonymously shown in class.

* The most obfuscated code examples will be anonymously shown in class
with suggestions for improvement.


The coding style in terms of spacing, etc. should be done automatically
every time you save in Eclipse.  As long as you stick with those defaults,
the syntax style should be fine.

Write your own code.  We will be using a tool that finds overly similar code.
Do not look at other students' code.  Do not let other students look at your code 
or talk in detail about how to solve this programming project. 


## Submission

As with PA1, for PA2 you are required to submit your PA2Main.java file to Gradescope.
