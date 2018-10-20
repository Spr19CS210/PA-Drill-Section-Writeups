# PA7-HashMapImpl-Key (Status: Posted Oct 13 3pm)


## Learning Objectives

The goal of this assignment is to use two or more data structures
in a coordinated way to solve a problem.

The problem to be solved in this assignment is to implement a 
HashMap. Therefore, an additional learning objective is to 
increase your skill level with HashMaps from just being able 
to use them to understanding how to implement them.

The dictionary abstract data type (ADT) can be used to solve many
programming problems and therefore questions about hash tables 
frequently occur in job interviews.

## The Assignment

You will be redoing PA2-JobSkills with your own HashMap implementation
called MyHashMap.  Here are the key components of this assignment:

  * PA7Test.java with JUnit tests of all the functionality MyHashMap needs to 
    provide to implement PA2.  The tests can be written for HashMap and then 
    edited slightly to be used to test MyHashMap instead.  Implementing them
    first will help the development of MyHashMap be more test driven.

  * MyHashMap.java with an implementation of a generic, MyHashMap class.
    Your hashmap should only have 8 buckets.

  * PA7Main.java with an edited version of PA2Main.java that...
    * uses MyHashMap instead of the HashMap provided in java.util

    * provides a DEBUG command that outputs the printTable() information
      about conflicts in a table that maps flight codes to integers

    * has been improved based on PA2 code clarity and decomposition feedback
      and follows the more stringent grading criteria specified below
      
    * does some error checking on the input file and skips bad lines


## Getting Started

Here is the github assignment link: [https://classroom.github.com/a/-paUcHnY]

Recommended approach for iteratively implementing the below.  At each of these
steps we recommend you submit to gradescope what you have running even if you are
not passing all of the test cases yet.

1. Write unit tests for hashmap usage from PA2 including some required test cases.
   First just use the Java HashMap data structure in the test cases.

2. Implement a NON-generic MyHashMap that has String as the key type and Integer
   as the value type.
   * Copy in the given hash function
   * Consider which data structures to use to implement the hash table
   * Assume a perfect hash initially (will lose some data when keys conflict)
   * Implement chaining
   
3. Use the NON-generic MyHashMap in your copy of PA2 everywhere possible.

4. As was done in Tuesday 10/16/18 class, change the non-generic MyHashMap
   into a generic MyHashMap.
   
5. Modify your PA2 copy to use the generic MyHashMap and only that.  Take
   out all HashMap and HashSet usage.
   
6. Have this new version of PA2 skip lines that don't have enough fields and 
   refactor the code to get rid of redundant code.


## JUnit implementation

The PA7Test.java file should contain unit tests for all of the HashMap
functionality your PA2 program uses.  We strongly recommend you write
the tests for HashMap first.  They should all pass.  Then replace HashMap
with MyHashMap and you can test MyHashMap as you implement it.

For grading, we will look for unit test cases for at least the following:
  * put
  * get
  * containsKey
  * keySet

## Hash Map Implementation

A hash table is a data structure that offers quick O(1) operations such 
as inserting data and searching for data. You have used a form of a 
hash table when using the HashMap class in Java. However, in this 
assignment you will implement your own version of a hash map.

### Hash Map Background
First, you should read up on what a hash table is. 
[Wikipedia](https://en.wikipedia.org/wiki/Hash_table) is a good place to start.

At its heart a hash table (hash map) is an array that works together 
with a function, known as a hash function, that takes a key and returns 
an index into that array. We usually call the entries in the array 
buckets.  This is because when more than one key maps to the same
array location (or bucket), there needs to be some organization for keeping
all those key,value pairs there and being able to find them.

A critical part of writing a good
hash map implementation is writing a good (and appropriate) hash function. 
It should spread out values evenly based on different input values 
and needs to always produce the same value if the same element is given to it.

In general, there are multiple ways to implement a hash map. Here are three:
  * A linked list that contains a linked list for each bucket (2d linked list)
  * An array that contains an array for each bucket (a 2d array)
  * An array that contains a linked list for each bucket

However, since you are implementing a generic hash table in Java
and generics are problematic in arrays 
(https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html),
we recommend you use an ArrayList of linked lists.  Those linked
lists can be LinkedLists, ArrayLists, or your own linked list implementation
where the key,value pairs link to each other.


Your hash table implementation should be called MyHashMap.

### A Generic MyHashMap class

You will create a class called MyHashMap that maps keys to values.
To enable the construction and use of MyHashMap for any provided
key and value types, you will implement it as a generic class.

This is done by declaring MyHashMap with type parameters.
```
    class MyHashMap<K,V> {
        ...
    } 
```
Throughout the rest of the class definition, the capital letter 'K' will
be used to declare variables of the key type, and the capital letter 'V'
will be used to declare variables of the value type.

See https://docs.oracle.com/javase/tutorial/java/generics/types.html
for more information.

### The Hash Function

For this assignment, you will be implementing your own MyHashMap class using the 
following hash function.
		
  1. Find the hash code of that object (look into the hashCode method)
  2. Mod it by the number of buckets  
  3. Then take its absolute value.

Here is the code for the hash function.  You can use this code directly
in your implementation:
```
	private int hash(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % numBuckets;
		return Math.abs(index);
	}
```

### Handling collisions

This hash map will use chaining to handle the collisions of elements.
Your hash map should only have 8 buckets!  Collisions will happen.
We will be covering this in class.

*PUT the (key,value) pairs at the FRONT of the list in the bucket.*



## Error checking

You **WILL** need to error check the input file. This involves checking to 
see if a line in the input file is valid. If it is not a valid
line, skip it. You know a line is invalid if there isn't the correct
number of fields in it. For this dataset, there should always be 7 fields in a record.
Ignore records that do not have 7 fields.

## The DEBUG command

The program should be able to accept the DEBUG command on the command line after
the input file name.  That output should show how all of the airport codes
in the input file map into indices in the hash table.

The DEBUG command should cause the creation of a MyHashMap with the
keys being all of the airport codes in the input file.
The goal is to see how many hash conflicts occur.  After filing the
MyHashMap, the program should call the printTable() method on MyHashMap.
The printTable() method should output how many conflicts occur at
each bucket and list the keys in that bucket.

Here is an example input file: 
```
Company,Title,Category,Location,Responsibilities,Minimum Qualifications,Preferred Qualifications
Google,TitleA,CategoryX,Tel Aviv,Everything and the rest, BS, MS
Google,TitleB,CategoryX,Tel Aviv,Everything and the rest, BS, MS
Google,TitleB,CategoryY,Houston,Everything and the rest, BS, MS
Google,TitleC,CategoryX,Jonesboro,Everything and the rest, BS, MS 
```

Here is the output of the program when given this input file and
the DEBUG command.
```
DEBUG output for MyTable
-------------------------------------
Index 0: (0 conflicts), []
Index 1: (0 conflicts), []
Index 2: (0 conflicts), []
Index 3: (0 conflicts), []
Index 4: (0 conflicts), []
Index 5: (0 conflicts), [CategoryY, ]
Index 6: (0 conflicts), [CategoryX, ]
Index 7: (0 conflicts), []
Total # of conflicts: 0
```



## **EXTRA CREDIT**
If you provide a better hash function than the one listed above, 
meaning that you have fewer collisions (and/or a better distribution)
on the full job skills database than 
the provided hash function, you will be able to receive 5 points of 
extra credit on PA7.  Provide your README.md file with example 
DEBUG output to show that your hash function is better.  Also explain 
why your hash function is better.

## Grading Criteria

Half of the PA7 grade will be correctness.  For this assignment, there
will be some private test cases on Gradescope used for grading.

The other half of the PA7 grade will be your decomposition and code clarity
and the JUnit tests.

Decomposition
* Should carefully select data structures that implement the
  required MyHashMap functionality.  You cannot use the provided
  Java HashMap implementation or HashSet implementation 
  or any other Map or hash table implementation
  written by someone else.

* Points will be taken off for copy, pasted, and edited code that
  should have been encapsulated in a method.

* This program will use two or more source files in addition to the 
  source file for the JUnit tests.  Each of these files should be (<200 lines).

* Each static method should be less than 30 lines.  This INCLUDES
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

* Use meaningful variable names and write them in camelCase.  Loop 
  iterators can be simple (i for integers, s for strings, n for numbers, etc.).

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

Write your own code.  We will be using a tool that finds overly similar code.
I recommend that when talking with others about the assignment, do not write
anything down.


For PA7, you are **REQUIRED** to submit all of your java source files
to Gradescope.

There is NO Aropa submission for PA7.
