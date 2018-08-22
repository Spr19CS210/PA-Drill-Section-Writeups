# Section1-Scanner (status: posted 8/22/18)

The goal for this section is to write a program that reads a filename from the
console and then prints out all of the lines from the file to the console.


## Introduction 
Today's section will be an introduction to reading input in Java, which will prepare
you for PA1 by familiarizing you with the Java Scanner class. The Scanner class is a simple text scanner for 
parsing primitive data types and strings. Input can be read from the console using System.in or from a file by
using a File object. Below are examples of reading a number from the console using Java and Python. Recall that 
classes have to be instantiated to create an object. In Java, this is done by using the new operator. Then, just 
like in Python, methods can be called on it, such as the nextInt() method below.

| Java                                    | Python                                  | 
|-----------------------------------------|-----------------------------------------|
| Scanner sc = new Scanner(System.in);    | n = input("Enter a number\n")           |
| System.out.println("Enter a number");   |                                         |
| int n = sc.nextInt();                   |                                         |

Here is a link to Java's API that describes the Scanner class and how 
to use its built in constructors and methods: 
https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html

The Java API is a great resource for better understanding the language and
we encourage you to utilize this resource as you are learning about Java this
semester. Additionally, we encourage paired programming during section, so 
please work through the section activity with a student sitting next to you.
In section you can share code.  For programming assignments you cannot.

## Setup
Here is the URL for accepting the github classroom assignment
for Section 1, [FIXME].

Next, go to your section1 repository on github, and then clone and import 
the Section 1 gitrepo into Eclipse.
  * Click on the green "Clone or download" button on the right of the web page 
    and copy the provided URL.

  * Import your Section 1 repository into Eclipse.
    * open Eclipse 
    * File —> Import —> Git —> Projects from Git, Next, Clone URI, Next, paste in repository URL from github
    * Next, Select the master branch, Next, make the local destination 
      /home/username/eclipse-workspace/Section1-yourgithubid.
    * Next, Import existing Eclipse projects, Next, Finish.

Now you are ready to get started coding. 


## The Assignment
Overview: Given a filename from stdin, open the file specified and print out each line.

### Step Zero 
Copy the code below into main and run it to make sure it compiles and prints. 


```
        System.out.println("Welcome to Section 1!");
```

Then commit and push your changes to github. Here is a reminder of the steps:
Right click on Section1Main.java --> Team --> Commit, move unstaged files 
that you want to commit into staged changes, put in a commit message, and 
then click commit and push.

### Step One - Read in the filename
Similar to PA1 you will be reading in a file from the console. Begin by 
initializing a Scanner object as demonstrated in the example above, specifying 
System.in as the input stream. Then use the object to call next(), which will 
return the file name as a String. You can check that this was done successfully 
by printing out the file name.

### Step Two - Open the file and print each line
Take a moment to open PublicTestCases/inputPA1writeup.in from the Package Explorer 
in Eclipse. This is the example input from the PA1 specification. Have your program
open this file, iterate through the content and print each line. You'll need to 
initialize a new Scanner object for the file.

See the reminders below for methods relating to Scanner.

### Reminders
* System.out.println() is your friend
* new Scanner(System.in)
  * next()
* new Scanner(new File(fileName))
  * hasNextLine()
  * nextLine()
  * close()

### Experimentation now that you have done Section assignment
Here is example code demonstrating how Scanner is used with doubles. It assigns each 
number to a double type from a file, "numbers".  Give it a try!

```
public static void main(String[] args) {
    String fileName = "numbers";
  
    try {
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNextDouble()) {
            double n = input.nextDouble());
        }
        input.close();
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    }
}
```
