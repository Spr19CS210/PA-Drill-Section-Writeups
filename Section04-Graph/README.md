# Section04-Graph (Status: Posted 9/27/18) 

## Introduction 
Today we will be reading and processing a matrix market file (.mtx)
to output a graph to a dot file and print the string to
standard out. This will be helpful for starting PA5.

## Setup

Accept the Github classroom assignment for Section 4
[https://classroom.github.com/a/bELgAqrR].

Then do the following:

Click on the green "Clone or download" button on the right of the web page and copy the provided URL.

Import your Section 4 repository into Eclipse.

Open Eclipse
File —> Import —> Git —> Projects from Git, Next, Clone URI, Next, paste in repository URL from github
Next, Select the master branch, Next, make the local destination /home/username/eclipse-workspace/Section4-Graph-yourgithubid.
Next, Import existing Eclipse projects, Next, Finish.
Now you are ready to start coding.

## The Assignment
Overview: Implement the .mtx file processing functionality in Section4Main to 
make a directed graph and output the textual and visual representation.
You will submit your java code to Gradescope.

### Part One - Decomposition 
After importing the section, your section leader will walk the class through the 
decomposition of DGraph and Trip. Before they begin their lecture, take a few
minutes to look over both files and read the usage instructions to familiarize
yourself. Try to answer questions #1-#3 from part 3.

### Part Two - Implementation 
Complete the TODOs in Section4Main. See https://math.nist.gov/MatrixMarket/formats.html
for a description of the .mtx format. You CAN write similar code to the following code
to read in the .mtx format. http://docs.roguewave.com/imsl/java/5.0.1/api/com/imsl/math/SparseMatrixEx2.html.

### Part Three - Practice
1. What Trip method can be used to check if a trip can visit all of its
cities? i.e. the trip contains all the nodes in a graph.

2. What Trip method can be used to check which cities are left to visit?

3. How is each city represented in Trip?

4. Francine is a world class traveler and she wants to visit three cities
in three days with a possible fourth city: 1 New York, USA; 2 Paris, France;
3 Tokyo, Japan; 4 Madrid, Spain.

   Francine is booking this trip with your startup. Create a new java file
called FrancinesTrip.java and play around with it to make this trip possible.

   1. Construct a trip with the number of cities Francine wants to visit.
   2. Choose New York as her first city.
   3. Choose Tokyo as her next city.
   4. Choose Madrid as her third city.
   5. Print out the trip so far. It should look like the following
   ```
   visitOrder = [1, 3, 4], citiesLeft = [2]
   ```
   6. Francine just called and wants to visit Madrid last. Unchoose this city.
   7. Make a list of the cities left to visit and print it out. You should get
   ```
   [2, 4]
   ```
   8. Choose Paris.
   9. Choose Madrid
   10. Print out the trip. You should get
   ```
   visitOrder = [1, 3, 2, 4], citiesLeft = []
   ```
   Try playing around with Trip.java more and construct a DGraph to test the
   tripCost method.

5. Using the recursive backtracking algorithm provided in the writeup for PA5,
walk through the algorithm using the example input file and paper. Draw the
graph with the directed edges and weights. What are the possible visit orders
using the BACKTRACK command? Draw the graphs.
