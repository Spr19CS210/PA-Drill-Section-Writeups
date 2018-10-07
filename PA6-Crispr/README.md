# PA6-Crispr (Initial Posting: Oct 4, 2018, October 7 2:30pm github assignment link and gradescope ready)

## Learning Objectives

The goal of this assignment is to design a class hierarchy to solve a problem, implement that 
hierarchy, use polymorphism, and use multi-dimensional arrays and/or lists.

What is a class hierarchy you ask? Read about it on [Wikipedia](https://en.wikipedia.org/wiki/Class_hierarchy). 
The class diagram you will be submitting will be a simplified version of the UML class diagrams. There 
are many resources on the internet for UML class diagrams. See all the Thursday 10/4 class notes 
for the format expected in this class for PA6.

## Crispr

[Crispr](https://simple.wikipedia.org/wiki/CRISPR) is relatively new and very powerful way of editing 
gene editing. Many, many scientists are currently experimenting with ways to use it to [restore ecosystems]
(https://www.theatlantic.com/science/archive/2017/11/new-zealand-predator-free-2050-rats-gene-drive-ruh-roh/546011/),
[eradicate or minimize diseases](https://www.npr.org/sections/goatsandsoda/2018/09/24/650501045/mosquitoes-genetically-modified-to-crash-species-that-spreads-malaria), 
and solve other real world problems. In most cases they use it to stop a problematic species from being able 
to reproduce. This can have far reaching and sometimes catestrophic affects on the local ecosystem. Therefore, 
before scientists release any creatures with edited genes out into the real world, they run a tremendous amount 
of somputer simulations to try to predict how the altered species will effect the eco system. In this project, 
you will be creating a simple simulation of an ecosystem with one Crispr edited creature included. 

For this assignment, the ecosystem you will be implementing will consist of a number of columns and rows. 
The animals will move around this ecosystem. When they run into one another, depending on the animal type, 
they will either eat or reproduce. Animals with a Crispr gene will stop being able to reproduce in circumstances 
described later on in this specification. Animals must have enough to eat in order to stay alive. Animals are 
divided up into three different categories: mammals, birds, and insects, all of which have unique characteristics.

## Getting Started

The github assignment link is https://classroom.github.com/a/H8ZlVpNI.

## The Assignment

This is a two-week assignment. The class inheritance diagram will be all that is due Wednesday 10/10 at 11:30 pm to 
both Aropa AND Gradescope. We make suggestions as to what to implement the first week and then the second week, but 
you will be responsible for managing your own time. The rest of the assignment is due Wednesday 10/17.

Class inheritance diagram: Create this diagram however you would like (draw it by hand, use software, etc.). 
You need to create a pdf file of it and submit it to Aropa AND Gradescope.

See (https://gradescope.com/help#help-center-item-student-scanning) for some suggestions of how to scan in a 
document with your phone if you plan to produce your pdf by taking a picture of it.

You will be building on PA6 for PA8 and PA9. In PA8 and PA9, you will be encouraged to use the model-view-controller 
pattern. Feel free to look that up ahead of time. You are not required to know it until we cover it though.

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

Note that the commands should be case-insensitive. In other words, "print", "PRINT", and "Print" are all equivalent in the input file. Here is the output for the example:

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
Cheeta       Dove           Horsefly
Giraffe      Shrike         Ant
Zebra
```

For PA6, animals will be represented with ascii characters. Use the lower case version of the first letter of 
the animal name. For "Elephant" use 'e', for "Warbler" use 'w', etc.

## Commands that need to be implemented

See the PublicTestCases/ for more examples. There are examples with CREATE, PRINT, MOVE, EAT, REPRODUCE, and ISALIVE. 

### The CREATE Command
```
EXAMPLE USE: CREATE (0,0) lion female right
```
If the CREATE command is read, it should be followed by coordinates to place the animal, the type 
of animal to be created, the gender of the animal and any other information needed to create that 
animal. Use animal type to create the correct subclass of animal in the simulation at given coordinates. 
The coordinates are given as row and column. Both rows and columns start at 0. Rows go down the screen, 
and columns go across the screen.  Animal specific information:
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
If the MOVE command is read, then each animal should move once. An animal that moves off the side 
of the grid should appear on the other side. The same thing should happen if an animal moves off 
the top or bottom. Animals should be moved starting from the upper left corner, continuing right 
until the end of the first row, then on to the second row left to right, etc. The animals at a square 
should be moved in the order they got there. Animals that are no longer alive should be removed from the ecosystem.

  * If a mammal is created with the right option it alternates between moving right and down. Otherwise, 
    it alternates between moving left and then up. Mammals die of old age after 100 moves, if they haven't 
    eaten in 10 moves and when eaten.
  * A bird moves the number of steps originally passed in on its creation down then, the number right then, 
    the number up and then repeats. Birds die of old age after 50 moves and if they haven't eaten in 10 moves.
  * Insects make either clockwise (if passed in true when created) or counterclockwise squares, walking the same 
    number of steps in each direction until a complete square is made. The initial square should have one step on 
    each side. The number of steps should increase by one each time a square is completed. Insects die of old age 
    after 20 moves and when eaten.
    
### MOVE (x,y)
```
EXAMPLE USE: MOVE (2,3)
```
Move any animals located in the ecosystem at position (x,y) num times. If there is nothing at this position or the position is outside the size of the ecosystem, don't do anything.

### MOVE [type]
```
EXAMPLE USE: MOVE hippo
```
Move only animals of the specified type.

### MOVE [Animal]
```
EXAMPLE USE: MOVE mammal 
```
Move only animals of the specified class num times.

### EAT
For all locations, the first two animals that are at that location should try to eat each other. Only alive animals should remain in your ecosystem.
  * Birds eat insects. If a bird eats an insect that insect is no longer alive.
  * Insects can eat mammals. If an insect eats a mammal the mammal should remain alive. 
  * Mammals can eat other mammals (yes, we know a giraffe eating a lion doesn't make sense, 
    but for simplicity bear with us).  If a mammal eats another mammal, the eaten mammal should no longer be alive. 
    If two mammals run into each other, the first one at the location should always win.  

### EAT (x,y)
```
EXAMPLE USE: EAT (2,3)
```
Any animals at (x,y) should eat. 

### Eat [type]
```
EXAMPLE USE: Eat lion
```
Has all animals of the specified type eat. If there are no animals with that type, do nothing.

### REPRODUCE
For all locations, the first two animals at that location should try to reproduce. In order to reproduce the two animals need to be the same species and opposite genders. If the pair of animals reproduce successfully, create a third animal of that type in that location that is female. 
  * Mammals can each only reproduce 5 times. Baby mammals should be passed `right`.
  * Birds can only reproduce if they are moving down or right. Baby birds should be passed 5.
  * Insects, except mosquitos (as they are our Crispr editted species) always reproduce. Baby insects should be passed true.
  * Mosquitos carry two genes related to reproduction (the last two boolean parameters given when they are 
    created). If these are both true, the mosquito cannot reproduce.  Baby mosquitos should be passed false and 
    a boolean value indicating whether it has editted genes from each parent. If the parent has edited genes 
    the new mosquito should be passed true for that parent.   

### REPRODUCE (x,y)
```
EXAMPLE USE: REPRODUCE (2,3)
```
Animals at location (x,y) should try to reproduce.

### REPRODUCE [type]
```
EXAMPLE USE: REPRODUCE lion
```
All animals of the specified type should try to reproduce. If there are no animals with that type, do nothing.


## Unique Class

Students will design their own animal type and show an example input and output that illustrates it in their 
README.md file. This new animal should be different from mammal, bird, and insect, but still be usable alongside 
them within the ecosystem and work with the commands listed above.


## Error handling

All of the inputs will be correctly formed for this assignment.


## Design Suggestions

We recommend the following:

* An Ecosystem object with a 2D array or list of animal objects. Note that since multiple animals can be in 
  the same location, you may need another level of lists to store all of the animals at each location.
* An Animal class hierarchy of some kind. The design for this is what will be submitted for peer review on 
  Oct 10 at 11:30 am to both Aropa AND Gradescope.
* A Screen object with a 2D array of characters that each animal can print its current representation into. The Screen 
  object can then print everything to standard out. 

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

The class hierarchy diagram in pdf format is due Wednesday 10/10 at 11:30 pm in Gradescope AND Aropa.

For PA6, you are REQUIRED to submit all of your java source files to Gradescope before Wednesday 10/17 
at 11:30 pm. You also need to submit your README.md with example input and output for your unique class.
