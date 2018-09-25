# Section04-Graph (Status: Draft 9/24/18) 

## Introduction 
Today we will be reading and processing a matrix market file (.mtx)
in order to output a graph to a dot file and print the string to
standard out. This will be helpful for starting PA5.

## Setup

Accept the Github classroom assignment for Section 4.

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
yourself.

### Part Two - Implementation 
Complete the TODOs in Section4Main. See https://math.nist.gov/MatrixMarket/formats.html
for a description of the .mtx format. You CAN write similar code to the following code
to read in the .mtx format. http://docs.roguewave.com/imsl/java/5.0.1/api/com/imsl/math/SparseMatrixEx2.html.
