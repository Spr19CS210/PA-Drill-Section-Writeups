# Drill00 (posted July 2018, due Friday August 24th at 11:30pm)

In this drill all of the problems have already been solved for you.  See
README.md for how to get started with Drill00 and how to submit it.
Here is a description of the problems that we recommend you read as you
are reading the code in Drill00.java.  The material in these drill
writeups can be asked about in reading quizzes or in 

## addOne

Description:
Return the given parameter incremented by one.

Welcome to Java!  Note that the addOne() function is in the Drill00.java file.
Here are some notes about what is going on in the file:
 * The top of the file declares what package the Drill00 class is in.
   The package name has to match the path of subdirectories where the file is located.
 
 * `public class Drill00 { ... }` is a class declaration.  Unlike in Python,
   in Java, each function has to be defined within a class.
   
 * The declaration of the addOne() function starts with the keyword `static`.
   The static keyword indicates that the function is NOT an instance method.  IOW
   it does not expect to be called on a class instance.  We will start the course out
   with assignments that only involve static methods and then move on to instance methods.
   See the syllabus on piazza if you would like to see a schedule of the topics being covered.


## max

This drill provides experience with conditional flow using if-else statements.

Description:
Return the larger of the two parameters.


## sum2

As addOne illustrates, the basic arithmetic operations are almost the
same as in Python.  See [FIXME] for all of the Java operators and
their order of evaluation (precedence).

Description: 
Calculate the sum of 2 numbers

Pseudocode:
```
sum2(a,b):
    return a+b
```

## range1

This method returns a boolean, which is one of the built in types in Java.
Booleans in Java can have the value of true or false.  The implementation
of range1 also uses the boolean and operation.

Description: 
Return true if the input value is between 10 and 20, inclusive.

("Inclusive" means to include the two edge values. So return true if the
 value is 10, or 20, or anything in-between.)

Inputs: 
num - The input value

Output: 
true or false; true if the input is between 10 and 20, inclusive.

Pseudocode:
```
range1(num):
    if (10 <= num <= 20)
        return true
    else
        return false
```

Hint: 
The syntax 
```
    10 <= num <= 20
```
is illegal in Java! Instead, you must perform two different comparisons, 
and combine them with a logical operator.

Author: Russell Lewis


## absDiff

Description: 
Return the absolute difference between two inputs. That is, if a is larger 
than b, return a-b; if b is larger than a, then return b-a; if they are equal, 
then return 0.

Inputs: 
a - The first number 
b - The second number

Output: 
The absolute difference.

Hint: 
If you structure your code as series of if() statements, then it will not compile - 
because Java will notice that there is a path where you never return from the method.

Instead, use if()/else statements.

Author: Russell Lewis
