# Section8-Maze-GUI-Input (Posted: 3/29/2019)

## Introduction

Today we will explore receiving input from a graphical user 
interface. We will be adding a TextField and Button to the GUI 
so we can control the movement through the maze using the simple
 commands 'RIGHT', 'LEFT', 'UP' and 'DOWN'.


## Assignment

### Setup
Clone this repository, and add it to your local eclipse workspace. 
This code uses the E19Mazeoutput.java file from 3/21/2019's lecture, 
as well as the PublicTestCases/maze_01.txt, and PublictTestCases/maze_02.txt.
Before starting, run the MazeGUIInput file as a Java Application, to 
make sure that JavaFX is functioning properly. 

If JavaFX is not properly setup, please follow the steps at the following 
link: https://www.concretepage.com/ide/eclipse/how-to-change-eclipse-java-version-for-compiler-and-jre

### Part One - Setup Additional Objects 
You will need to add several class variables. Two ```int```s will
need to be added to represent the coordinates where the triangle
is in the maze and one ```int``` constant will be used to 
represent the number of squares the triangle moves. The default 
of this constant should be 1. We suggest 
you name the coordinates x, y and the constant MOVE to match 
later code that is given to you.

Next, declare the following for your GUI input.
```
    // GUI objects
    Button nextMove;
    GraphicsContext gc;
```
Be sure to import the ```javafx.scene.control```
package. Additionally, you will have to change the 2D char array,
```maze``` from a local variable in start() to be a class variable. 
Do the same for ```GraphicsContext gc```, to ensure you use
and initialize the appropriate gc variable. 


### Part Two - Updating readMaze() and start()
Add code to readMaze() to initialize the x and y coordinates to 
the start location of the triangle, indicated by 'S' from the
input file, PublicTestCases/maze_02.txt. You can add a
```System.out.println()``` to make sure your x and y match the position in the file. 

Now update start() to format the additional elements of the GUI. 
Add the code below to your start method, BEFORE the 
```primaryStage.setScene(new Scene(root));``` line
to initialize and format the new GUI objects.
Again, import the appropriate packages. 

```
        // Text field to take in maze command
        TextField command = new TextField();

        // Border pane will contain canvas for drawing and text area underneath
        BorderPane p = new BorderPane();

        // Input Area + nextMove Button
        Label cmdLabel = new Label("Type Command in TextField");
        HBox hb = new HBox(3);

        // Input + Text Output
        VBox vb = new VBox(2);

        setupNodes(hb, cmdLabel, vb, command);
        nextMove.setOnAction(new CommandHandler(command));

        p.setCenter(canvas);
        p.setBottom(vb);
```

You will notice the methods setupNodes() and the class CommandHandler
are not implemented yet. Copy over the code below to implement
setupNodes(), which will add the TextField, Label, and Button.
You will implement the CommandHandler class in part 4.

```
    /*
     * Sets up the TextField, label, and button to be
     * at the bottom
     */
    private void setupNodes(HBox hb, Label cmd, VBox vb, TextField inputCmd) {

        nextMove = new Button("Simulation Step");

        hb.setSpacing(15);
        hb.getChildren().add(cmd);
        hb.getChildren().add(nextMove);

        vb.getChildren().add(hb);
        vb.getChildren().add(inputCmd);
    }
```

Now you will have to update your code to set up the primaryStage 
to accept ```p``` so the new set up can be displayed. This code
replaces the primaryStage setup from
```new Scene(root)```. To maintain good style, you should 
remove all code referencing the Group root. 

```
        primaryStage.setScene(new Scene(p));

```

### Part Three - Button EventHandler
The TextField takes in the typed user input. We will 
control the movement through the maze using the simple commands 
'RIGHT', 'LEFT', 'UP' and 'DOWN'. However, typing the these 
commands into the TextField and clicking the button will have no
effect unless we implement a EventHandler. For this section, a 
button EventHandler will be used from inside an inner class. Any time 
the button is clicked it will read in the text in TextField and
process it if it is a  valid command. The button EventHandler is a
class method. 

Copy the code below as an inner class. Import the appropriate package
to take an ActionEvent.

```
    class CommandHandler implements EventHandler<ActionEvent> {
    	private TextField command;

    	CommandHandler(TextField command) {
    		this.command = command;
    	}

    	/*
    	 * Button EventHandler to take input command
    	 * when button is clicked.
    	 */
    	@Override
    	public void handle(ActionEvent event) {
    		parseLine(command.getText());

    	}

    }
```

You will implement parseLine() in part 4. This function will be 
used to validate the user input. ```command.getText()``` retrieves the
string of text from the command TextField. 

### Part Four - Additional Functions to Implement Input Response 

Now that the button EventHandler is implemented we need to 
implement two functions. The function, parseLine() will check if
the input is valid by making sure the location to move is not a 
wall and is within the boundaries. The command must be spelled 
correctly, but capitalization should not matter. A line for 
debugging and one example validation check is included below.
You must implement the three other moves: down, left, and right.
You can shorten the commands to U, D, L, R, if you like.
Print "Invalid command" to the console if the input is not a 
valid move. When implementing the other moves, it is easiest to 
think about how they are implemented in terms of the 2D char
array. 

```
    public void parseLine(String line) {
        System.out.println("reading " + line); // Print line for debugging
        if (line.toLowerCase().compareTo("up") == 0 && y - MOVE >= 0
                && maze[y - MOVE][x] != '*') {
            move(y - MOVE, x);
        } 
    }
```

The second function, move() updates the GraphicsContext of the 
maze. We are giving you the function code to redraw the triangle
based on an already validated move. 

```
    /**
     * This function 'erases' the old triangle and redraws
     * it in the next move location to make it appear that
     * the triangle is navigating the maze. int newY and 
     * int newX represent the coordinates of the valid move. 
     */
    public void move(int newY, int newX) {
        gc.clearRect(x * SIZE, y * SIZE, SIZE, SIZE);
        double[] yPoints = new double[] { (double) (newY * SIZE + SIZE),
                (double) SIZE * newY, (double) (SIZE * newY + SIZE) };
        double[] xPoints = new double[] { (double) newX * SIZE,
                (double) (SIZE * newX + (SIZE / 2)),
                (double) (SIZE * newX + SIZE) };
        gc.setFill(Color.BLUE);
        gc.fillPolygon(xPoints, yPoints, TRIANGLE);
        x = newX;
        y = newY;
    }

```

After you are able to navigate through both of the mazes,
show your SL your output to receive credit for this section. 
