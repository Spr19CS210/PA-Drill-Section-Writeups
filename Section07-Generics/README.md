# Section07-Generics (Status: Posted 10/18/18)

## Introduction 
Now that you have practiced using a list with user defined objects,
it's time to further your understanding of generics by working with other
collections. For this section, you will be using HashSets and create a
generic type. This will help with understanding the implementation of
HashMaps for PA7.

## Setup

Accept the Github classroom assignment for Section 7. [https://classroom.github.com/a/ES2PiyhI]

Then do the following:

Click on the green "Clone or download" button on the right of the web page and
copy the provided URL.

Import your section repository into Eclipse.

Open Eclipse
File —> Import —> Git —> Projects from Git, Next, Clone URI, Next, paste in
repository URL from github
Next, Select the master branch, Next, make the local destination
/home/username/eclipse-workspace/Section7-Generics-yourgithubid.
Next, Import existing Eclipse projects, Next, Finish.
Now you are ready to start coding.

## The Assignment
Overview: Practice using generics with user defined types.
Answer the theoretical questions first and then implement Person.java
and MyBag.java.

### Part One
Recall hash-based data structures use hashing to store and retrieve
values and that every class is derived from Object. Some methods will need
to be overridden in order for your HashSet to work correctly.
Take some time to go to the following link and answer the questions.

https://www.geeksforgeeks.org/override-equalsobject-hashcode-method/

1. Which two methods do you need to override for HashSet and HashMap
to work with user defined objects and why?
2. What happens if you have one and not the other?
3. Take a look at Section07.java. Which third method from Object needs to be overridden?

### Part Two
Create a new class named Person and implement the required methods.
You can use the id as the hash code for simplicity, but note that it can
be more efficient by being calculated some other way.

The console should have this output:

```
HashSet with a user defined type, Person:
[Grace Hopper (id=1), Anita Borg (id=2), Alan Turing (id=3)]

The same set after trying to add duplicates:
[Grace Hopper (id=1), Anita Borg (id=2), Alan Turing (id=3)]
```

### Part Three
Create a new class named MyBag and make it generic so it can hold any type.
Remove the two commented lines in Section07.java to run your code.
Start with the field and the constructor, then move on to the methods
that need to be overriden for HashSet. For generic types, you can't use
instanceOf(), you'll have to compare the objects by using getClass().
Again, you can use the object's hash code for simplicity.
If you get stuck, you can work with a neighbor, review the reading assignments,
class notes or code examples from Tuesday's lecture, or ask your section leaders.

The console should have this as the final output:

```
HashSet with a user defined type, Person:
[Grace Hopper (id=1), Anita Borg (id=2), Alan Turing (id=3)]

The same set after trying to add duplicates:
[Grace Hopper (id=1), Anita Borg (id=2), Alan Turing (id=3)]

MyBag as a generic type, using ints:
[100, 200, 300]

MyBag as a generic type, using strings:
[rst, abc, xyz]
```
