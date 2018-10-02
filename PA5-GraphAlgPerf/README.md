# PA5-GraphAlgPerf (Posted: Sept 24, 6pm)

PA5 is about applying three different approaches to solving a well-known
and generally useful graph problem, the Traveling Salesperson Problem (TSP).

## Learning Objectives

The goal of this assignment is to practice the following
algorithm patterns, data structures, and decomposition approaches.

* Algorithmic patterns: recursive backtracking and heuristic

* Data structure: graphs

* Decomposition: using provided classes other than the Java libraries

* Performance analysis of different graph algorithm variants.


## Traveling Salesperson Problem (TSP)

The Traveling Salesperson Problem asks what is the shortest trip
through a sequence of locations and back to the beginning while
only visiting each location once.  The distances between locations
are the input to the problem and can be represented as weights on 
edges in a graph.

TSP is an example of an NP-Complete problem.  There are a significant
number of NP-Complete problems that can all be converted to each other
[https://en.wikipedia.org/wiki/List_of_NP-complete_problems].  Some
example problems that are especially like TSP include:
 * vehicle routing,
 * circuit design, and
 * robot navigation.


## The Assignment

In this assignment you will be implementing the traveling salesperson
problem using three different ways: recursive backtracking, heuristic, 
and your own approach.

To use the program, someone will need to put the following arguments
into the Eclipse arguments tab:
    PathTo/infile.mtx [HEURISTIC,BACKTRACK,MINE,TIME]

The input files are in the same format as the matrix market format used by
the SuiteSparse Matrix Collection (https://sparse.tamu.edu/about). 
See https://math.nist.gov/MatrixMarket/formats.html for a description of the .mtx
format.  You CAN write similar code to the following code to read in the .mtx format.
http://docs.roguewave.com/imsl/java/5.0.1/api/com/imsl/math/SparseMatrixEx2.html.
Reading .mtx files will be covered in Section 4.  Here is an example input file:
```
%%MatrixMarket matrix coordinate real general
3 3 6
1 2 1.0
2 1 2.0
1 3 3.0
3 1 4.0
2 3 5.0
3 2 6.0
```

Example output to standard out is provided in the PublicTestCases/
for HEURISTIC and BACKTRACK.  Here is the output for the above input
file and the HEURISTIC command:
```
cost = 10.0, visitOrder = [1, 2, 3]
```
You will be running your own algorithm with the MINE command.  
The output for TIME is shown below.

You CAN use the code provided and/or written in Section 4
to read in files, store a graph, and output
a graph to a dot file in your PA5.  The output to a dot
file might help debugging.

### Recursive Backtracking

Will make the decisions starting with node 1 and continuing through the
nodes in order.  Everytime a node is chosen, that choice
will be checked before recursing to do some pruning.  We cannot stop
at the first node we find, because it is possible that other nodes
will cost less.

```
  create a trip
  choose city 1 first
  call enumerate on the trip
    
  enumerate( graph data structure, current trip so far,  
             min trip previously found)
        
      if all nodes are in trip then
          process the current trip:
              does it have less cost than min trip?
              if so then modify min trip previously found (hint: copyOtherIntoSelf())
          return
      
      if trip so far has less cost than the min trip previously found
          for each city x of the cities left
              choose x next
              enumerate( graph data structure, updated trip,
                         min trip previously found )
              unchoose x
```

### Heuristic

```
    create a trip
    choose city 1 first, call it the current city
    
    for k=2 to num_nodes inclusive
    
        for each neighbor of node the current city (use getNeighbors method)
            
            find the neighbor that is available AND the closest to the current city
                        
        choose the closest city that is available for the trip
        AND call that closest city the current city
        
        
```

### Your own approach

You will also implement the command MINE that executes your own 
faster algorithm for performing the traveling salesperson problem.
The code you submit should be able to execute the MINE command.

For your own approach you can choose to do one of the following:
  * improve upon the recursive backtracking approach by putting in more pruning
    and then show this is faster than the suggested recursive backtracking approach
  * improve upon the heuristic approach while not resorting to a trivial solution
    like just listing all of the nodes in order

## Timing all of the approaches

Using code similar to the following, you will have a TIME command that 
times all of the algorithms.
```
        long startTime = System.nanoTime();
        trip = heuristic(graph);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("heuristic: cost = " + trip.tripCost(graph) + ", "
                + duration + " milliseconds");
```
The output for the TIME command will look as follows:
```
heuristic: cost = 935.3299999999999, 0 milliseconds
mine: cost = 935.3299999999999, 0 milliseconds
backtrack: cost = 835.8799999999999, 5 milliseconds
```
None of the grading test cases call TIME, because each time you run
the program even on the same input and on the same machine
there will be some time variance.  Because of that you will probably
want to run the timings about 5 times before drawing any conclusions.

INSTEAD, you will be running the TIME command on your machine for
the big11.mtx input.  It takes around a minute for the
recursive backtracking algorithm on a 3 year old Mac.


## Error handling

All of the inputs will be correctly formed for this assignment.


## Notes and Suggestions

* The github assignment link is at [https://classroom.github.com/a/Wsrk6QQI].
Go to that link to accept the github assignment and get your own private repository for PA5. 
  
* The node ids should go from 1 to the number of nodes inclusive,
  because the sparse matrix market file format (.mtx) stores node
  ids starting at 1 instead of 0.
  
* We are providing a Trip class that keeps track of a Trip.  Read
  its usage instructions.

* In Section 4 this week and in the initial code, we provide a graph data 
  structure called DGraph.  Read its usage instructions for how to use
  handy methods such as the one that returns the neighbors for a node.
  
* In Section 4 this week, we will help you write the code to read in .mtx
  files and output a dot file.


## Grading Criteria

Half of the PA5 grade will be correctness for the HEURISTIC and BACKTRACK
commands.  For this assignment, there will be some private test cases on 
Gradescope used for grading.

The other half of the PA5 grade will be broken up as follows:
  * 20 your decomposition and code clarity
  * 10 timing results in the README.md file along with some discussion of
    why the algorithms have the relative performance they do.  Why is
    HEURISTIC faster than BACKTRACK?  How does your MINE algorithm perform?
    (One or two paragraphs at the most.)
  * 10 TIME implementation
  * 10 MINE algorithm that does something different than given algorithms

Decomposition

* Points will be taken off for copy, pasted, and edited code that
  should have been encapsulated in a method EXCEPT for in the 
  timing code.
  
* Should carefully select data structures that implement the required 
  functionality.

* All of the Java files should be <250 lines of code.

* Each method should be less than 30 lines.  This INCLUDES
  comments, but not the method header.  It is easier to read a 
  function if it can all fit on one screen.

* Make things as simple as possible.
  * Only use one Scanner instance.
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

Files that need to be submitted to Gradescope:
  * The PA5Main.java file
  * README.md with the results of timing experiments that compare your
    improved algorithm to the required algorithms for the input file big11.mtx
    and describes why the algorithms have relative performance differences
 

