# Section-9-Space Invaders (Posted: 4/5/2019)

## Introduction

Today we will be looking farther into event driven programming, 
specifically with mouse events. We will be using MOUSE_CLICKED and 
MOUSE_MOVED events so we can control a small image on screen, and 
trigger animations. 

## Assignment

### Setup
Clone this repository, and add it to your local eclipse workspace.

Before starting, run the SpaceInvaders file as a Java Application to 
ensure that there are no errors, which displays that JavaFX is working
properly. 

If JavaFX is not properly setup, please follow the steps at the following 
link: https://docs.google.com/document/d/1L5t-rKRHQ3jCCd4cyeCdo21D9zBcV3p0U0cqOjG2d2U/edit

### Part One - Creating a a player icon onscreen
For this part of the assignment, you will need to create a player representation on 
the JavaFX screen, which for now can just be a square in the color of your choosing. 
This box should be at the bottom center of the screen. Ideally, this should 
use the SHIP_SIZE global variable to dictate how big the representation is. 

### Part Two - Moving the Player onscreen
Now that you have a basic icon on the bottom of the screen, you will need to implement
a MouseEvent handler that will move the icon left and right based on where the 
user's mouse is onscreen. This will utilize EventHandler interface, specifically using
the MouseEvent type, as well as the cursor's x coordinate value, 
which is passed into the handle method as a double under the default MouseEvent parameter. 
If you use the Eclipse autocomplete to generate required methods while writing
your handler, it will be filled in for you. To update the icon based on this movement, 
you will need to redraw the icon based on the new x value, which can be done by 
clearing the graphics context with the clearRect method, followed by the redrawing
of the icon immediately followed. To track the x value consistently, you may want to consider
using a global positioning value. Once this class is written, add it to the overall canvas
using the setOnMouseMoved method, passing your event handler object in as a parameter. 
This method works the same as addEventHandler, where it assumes the MouseMoved 
action type for you. 

### Part Three - Firing On Click
The player icon should now move fluidly around on the bottom of your screen. 
In addition to this, you will now include an event handler that will trigger
a missile firing animation when the user clicks on screen. The event handler for this
animation is included in the SpaceInvaders.java file for you at the bottom, so you will only
need to implement an event handler for when the user clicks on screen to trigger this animation. 
Write another handler class, which will implement the EventHandler interface of type MouseEvent, 
just as the last class. Inside of this handle method, you will be using a Timeline animation, 
utilizing the following code in your method. 
```
	Timeline t = new Timeline(new KeyFrame(Duration.millis(MILLISECONDS), new Animation(e.getX(), this.gc)));
	t.setCycleCount(CYCLES);
```
Note that there should be one additional line of code in terms of the Timeline for the animation 
to trigger properly. 

Once this handle method is written, add this event handler to your canvas as well, using the 
setOnMouseClicked method, which will assume the event type MouseClicked for you. To test that 
it is working properly, run your program and try clicking anywhere in the JavaFX window. 

### Part Four - Chaning the Player Icon
At this point, there is a rectangle at the bottom of the screen, which fires smaller rectangles
out of the top of it. To make this a bit more exciting, we can use an image in place of the 
rectangle, by creating an Image object. To do this, declare an Image object, passing the 
string ```img/ship.jpg``` as a parameter to the constructor. Now you can replace all of the
fillRect methods you have written with drawImage, which requires an Image object as its first parameter, 
followed by all the same parameters as fillRect. You can use the declared Image object for this 
Image parameter, so long as the variable is in scope. Once you have replaced the fillRect methods
with this, you should have a cool pixelated spaceship in place of your rectangle on screen. 

### Past Section
Now that you have implemented the basis of this game, feel free to explore more functionality, 
such as how the ship would follow the exact positioning of the user's mouse instead of remaining
at the bottom, and how you could implement enemies that fly in from the top of the screen, and so
forth in line with the original game. Feel free to use this section as the basis of a personal
project to learn more about event driven programming in this manner, as well as JavaFX in 
general. 

			