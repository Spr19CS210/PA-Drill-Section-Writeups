# Drill04

This drill has you doing 5 tasks that are relevant for PA4. The file
setup for this drill is slightly more complicated than previous drill
setups. Initially set this drill up like any other: go to piazza->resources.
Download the drill04 code. Create a new package for your drill folder. Add
these files to that new package. This is all documented in the link "Starting a 
new drill" on piazza->general resources. You can now do all of the drills except
for getLexeme. For getLexeme, you also need to copy the PACKAGE bool_exp from
PA4. Luckily this shouldn't be too difficult. You can click on it in your package
explorer in eclipse, copy it, then click on the 'src' folder in your drills project
and paste it there. Get an early start! Then if you have any troubles you can go to
those Monday office hours which are usually ghost towns!  

Implement the following methods in Drill04.java.

Some of the descriptions for these drills aren't too detailed...
Part of the goal of this drill is to get used to working with multiple classes
and multiple files. To start, look at Drill04TestClass.java to see how we are 
testing you. Then read through the classes you need to use in order to understand
them.

## splitWrapper

Separate fields by commas. Have empty strings if there is nothing between
commas or after last comma and end of line.
This will require reading documentation on split.

## enum2string

This can be implemented with one, short line of code!
Read some documentation about enumerated types to figure out how
to get a string for a Java enumerated type.

## getLexeme

Return the string representation for the given token in
the given string.  Use the Lexer that we provide for PA4.
Copy the bool_exp/\* files into your Drills src/ subdirectory.

## sumTree

Return the sum of all the data on the given tree.

## createConfigStr

Create a configuration string like what is needed for PA4 based on
given map.  See Drill04TestClass.java for the format of the expected output.

