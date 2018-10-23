# Drill07 - Starting to work with JavaFX library

There are some errors Eclipse throws when dealing with some of the JavaFX classes
used in Drill07 (see 
https://stackoverflow.com/questions/22812488/using-javafx-in-jre-8-access-restriction-error
for more info).  To deal with these, download e(fx)clipse.
 * in eclipse, Help —> Install New Software
 * In “Work with” drop down menu select Photon
 * In “filter text” field type “e(fx)clipse"
 * Click the select box next to e(fx)clipse IDE
 * Click next and follow the rest of the instructions from install wizard
 * on bottom right of eclipse IDE, keep track of the installation progress
 * You will need to restart Eclipse for the changes to take effect

## increaseRed

Write a method that takes a color as a parameter and returns a new color. The new 
color should have the red value increased by one and all other values the same as the passed in color. 


## swapGreenBlue

Write a method that takes a color as a parameter and returns a new color. The new 
color should have the same red and opacity values as the passed in color but its green 
and blue values should be swapped.


## setFillColor

Write a method that takes a canvas as a parameter and sets the fill color to be 
used on that canvas (using the GraphicsContext) to be red 255, green 0, blue 0.

## setStrokeColor

Write a method that takes a canvas as a parameter and sets the stroke color to 
be used on that canvas (using the GraphicsContext) to 
be red 0, green 255, blue 0.

## drawOval

Write a method that takes a canvas as a parameter and draws an outline of an 
oval on it. The oval outline should have a color of red 0, green 0, blue 255. 
Its upper left corner should be at (20, 20) and it should be 40 wide and 40 tall. 
