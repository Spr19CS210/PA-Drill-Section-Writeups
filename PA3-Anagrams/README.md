# PA3-Anagrams Assignment

## Learning Objectives
The goal of this assignment is to practice the following decomposition, algorithm pattern, and data structure approaches.

 - Algorithmic pattern: recursive backtracking

 - Decomposition approach: using a provided class to help simplify the problem

 - Data structure: arrays and collections


## Anagrams

An anagram is a word or phrase made by rearranging the letters of another word or phrase.  For example, 
the words "midterm" and "trimmed" are anagrams.  If you ignore spaces and capitalization and allow 
multiple words, a multi-word phrase can be an anagram of some other word or phrase.  For example, the 
phrases "Clint Eastwood" and "old west action" are anagrams.

In this assignment, you will create a program called `PA3Main.java` that uses a dictionary to find all 
anagram phrases that match a given word or phrase.  To use the program, command line options will
be provided to indicate a dictionary file, phrase with no spaces to find anagrams of, and
a limit on the number of words in the found anagrams (or 0 to indicate no limit).

For the example command line options:
```
dict1.txt barbarabush 0
```
the output of your program should be the following:
```
Phrase to scramble: barbarabush

All words found in barbarabush:
[abash, aura, bar, barb, brush, bus, hub, rub, shrub, sub]

Anagrams for barbarabush:
[abash, bar, rub]
[abash, rub, bar]
[bar, abash, rub]
[bar, rub, abash]
[rub, abash, bar]
[rub, bar, abash]
```

See the .out files in the public test cases for more examples.  The command line options
are encoded in the .out files similar as they were for previous PAs except the extension for the
input files has changed.  For example, the file pa3-dict3-defleppard-0.out indicates
usage of the following command line arguments:
```
dict3.txt defleppard 0
```

## Getting Started

The process for getting started will be very similar to what was done in PA1.

 * Accept the assignment to have a github repository be created for you at https://classroom.github.com/a/4ORNVnVN
 * Import your PA3 repository into Eclipse (see PA1 writeup for details).



## Implementation Details:

Your program should obtain the dictionary file name, phrase, and max number of words in each possible
anagram from the array of strings passed to main.  Your program should read all of the words from the 
dictionary file and use them to generate the required anagrams. You can assume that the dictionary file will 
contain one word per line.  You can also assume the command-line input will be well formed.

You will want to find all possible words that can be found by using subsets of letters from the provided
phrase.  For example, in the phrase `hairbrush` the following words from `dict1.txt` can be found:
```
All words found in hairbrush:
[bar, briar, brush, bus, hub, huh, hush, rub, shrub, sir, sub]
```

You should use recursive backtracking to find and print all anagrams that can be formed using all of the letters 
of the given phrase.  Each phrase should include at most `max` words.  If max=0 then all possible words should be
specified.  Your output should exactly match the provided examples, including order and formatting.  For example, 
if your anagram solver is using 
the dictionary corresponding to `dict1.txt` and a user 
types the phrase `hairbrush`, with a `max` of `0` your program should produce the following output:
```
[bar, huh, sir]
[bar, sir, huh]
[briar, hush]
[huh, bar, sir]
[huh, sir, bar]
[hush, briar]
[sir, bar, huh]
[sir, huh, bar]
```
If your anagram solver is using the dictionary corresponding to `dict1.txt` and the user types the 
phrase `hairbrush` and a `max` of `2`, your program should produce the following output:
```
[briar, hush]
[hush, briar]
```

## Recursive Algorithm:

Generate all anagrams of a phrase using recursive backtracking.  Many backtracking algorithms involve 
examining all combinations of a set of choices.  In this problem, the choices are the words that can 
be formed from the phrase.  A "decision" involves choosing a word for part of the phrase and recursively 
choosing words for the rest of the phrase.  If you find a collection of words that use up all of the 
letters in the phrase, it should be printed as output.

Part of your grade will be based on efficiency.  One way to implement this program would be to consider 
every word in the dictionary as a possible "choice."  However, this would lead to a massive decision 
tree with lots of useless paths and a slow program.  Therefore for full credit, to improve efficiency 
when generating anagrams for a given phrase, you should first find the collection of words contained 
in that phrase and consider only those words as "choices" in your decision tree. You should also 
backtrack immediately once exceeding the `max`.

The following diagram shows a partial decision tree for generating anagrams of the phrase `barbarabush`.  
Notice that some paths of the recursion lead to dead ends.  For example, if the recursion chooses 
`aura` and `barb`, the letters remaining to use are `[bhs]`, and no choice available uses these 
letters, so it is not possible to generate any anagrams beginning with those two choices.  In such 
a case, your code should backtrack and try the next path.

One difference between this algorithm and other backtracking algorithms is that the same word can 
appear more than once in an anagram.  For example, from `barbara bush` you might extract the 
word `bar` twice.

![barbarabush Decision Tree](/decisionTree.png)

## LetterInventory Class:

An important aspect of simplifying the solution to many backtracking problems is the separation 
of recursive code from code that manages low-level details of the problem.  We have seen this in 
several of our backtracking examples, such as 8 queens (recursive code in Queens.java, low-level 
code in Board.java).  You are required to follow a similar strategy in this assignment.  The 
low-level details for anagrams involve keeping track of letters and figuring out when one group 
of letters can be formed from another.  We are providing you a class called `LetterInventory` 
to help with this task.

A `LetterInventory` object represents the count of each letter from A-Z found in a given string 
(ignoring whitespace, capitalization, or non-alphabetic characters).  For example, a `LetterInventory` 
for the string `Hello there` would keep count of 3 Es, 2 Hs, 2 Ls, 1 O, 1 R, and 1 T.  The 
`toString` of this inventory would be `[eeehhllort]`.

You can add and subtract phrases from a `LetterInventory` and ask whether an inventory contains 
a phrase.  For example, adding `hi ho!` to the above inventory would produce `[eeehhhhilloort]`.  
Subtracting `he he he` from this would produce `[hilloort]`.  If we asked whether this inventory 
`.contains("tool")`, the result is `true`.

Constructor/Method | Description
------------ | -------------
`public LetterInventory(String s)` | constructs a letter inventory for the given string
`public void add(LetterInventory li)` `public void add(String s)` | adds the letters of the given string/inventory to this one
`public boolean contains(LetterInventory li)` `public boolean contains(String s)` | returns `true` if this inventory contains all letters at least as many times as they appear in the given string/inventory
`public boolean isEmpty()` | returns `true` if the inventory contains no letters
`public int size()` | returns the total number of letters in the inventory
`public void subtract(LetterInventory li)` `public void subtract(String s)` | removes letters of the given string/inventory from this one; throws `IllegalArgumentException` if not contained
`public String toString()` | string version of inventory, such as `[eehhllort]`


## Development Strategy and Hints:

Your program should produce the anagrams in the same format as in the expected output files.  The easiest way 
to do this is to build up your answer in a list, stack, or other ordered collection.  Then you can 
`println` the collection and it will have the right format.

Several different dictionary files are provided.  We recommend initially using a very small 
dictionary `dict1.txt` to make testing easier.  But once your code works with this dictionary, 
you should test it with larger dictionaries such as the provided `dict2.txt` and `dict3.txt`.  
You can find other larger dictionaries here:

http://www.puzzlers.org/dokuwiki/doku.php?id=solving:wordlists:start

One difficult part of this program is limiting the number of words that can appear in the 
anagrams.  We suggest you do this part last, initially printing all anagrams regardless of 
the number of words.


## Grading Criteria

Half of the PA3 grade will be correctness (50/100).  For this assignment, there will be some 
private test cases. Any time you submit to gradescope, 
it will tell you how many of the 50 correctness points you have earned.

The other half (50/100) of the PA3 grade will be your decomposition and code clarity.

Decomposition
* Should just use `static` methods in the single `PA3Main` class.

* Use a single file.  This should be a small program (<200 lines).
  We do not count any of the comments in the file header toward this 200 lines.

* Each `static` method should be less than 30 lines.  The method header won't be 
  included in the 30 lines.

* Make things as simple as possible.
  * Nested loops and conditionals are ok if they are following provided
    recursive backtracking code example templates.  Make an effort
    to simplify conditionals as much as possible and explain them
    clearly in comments.
  * Avoid too many levels of user-defined methods calling other
  user-defined methods.

* Declare collection variables using interface types.

* Your code should be decomposed well. `main` should be a good summary of your program and no method 
should be overly long or trivial. Your methods should not be chained.  Do NOT have main just
call one method that does everything.

* Part of your grade will come from appropriately utilizing recursive backtracking to implement 
your algorithm as described previously.  We will grade on the elegance of your recursive 
algorithm; do not create special cases in your recursive code if they are not necessary or 
repeat cases already handled.

* Redundancy is a grading focus; some tasks are 
similar in behavior or based off of other tasks.  You should avoid repeated logic as much as possible.

Code Clarity
* YOU should be able to read, understand, and explain your own code
a couple days after you wrote it.

* The file header should include instructions on how someone would
use this program and what typical inputs would look like.

* Use meaningful variable names.  Loop iterators can
be simple (`i` for integers, `s` for strings, `n` for numbers, etc.).
Otherwise you should avoid single letter variable names. Name Variables in camelCase.

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

As with PA1 and PA2, for PA3 you are required to submit your `PA3Main.java` file to Gradescope.
