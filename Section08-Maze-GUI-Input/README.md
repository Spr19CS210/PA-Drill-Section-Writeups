# Section8-Maze-GUI-Input (Draft: 10/29/18)

## Introduction

Today we will explore receiving input from a graphical user 
interface. We will be adding a TextField and Button to the GUI 
so we can control the movement through the maze using the simple
 commands 'RIGHT', 'LEFT', 'UP' and 'DOWN'.

You will need the E19MazeOutput.java file from last Thursday's 
class to complete this section. You can find it in the code
 examples repository. All of the code to implement your GUI will
  be added here.

## Assignment

### Setup
Download last Thursday's code from class, E19MazeOutput.java.
You can find it in the code examples repository. Rename the file
to MazeGUIInput by right clicking the file and selecting
Refactor > Rename.

### Part One - Setup Additional Objects 
You will need to add several class variables. Two ```int```s will
need to be added to represent the coordinates where the triangle
is in the maze and one ```int``` constant will be used to 
represent the number of squares the triangle moves. I suggest 
you name the coordinates x, y and the constant MOVE to match 
later code that is given to you.

Next, declare the following for your GUI input. Be sure to import
the ```javafx.scene.control```
package. Additionally, you will have to change the 2D char array,
```maze``` from start() to be a class variable. Do the same for
```GraphicsContext gc``` since it is included below. 

```
    // GUI objects
    Button nextMove;
    TextField command;
    GraphicsContext gc;
```

### Part Two - Updating readMaze and start
Add code to readMaze() to initialize the x and y coordinates to 
the start location of the triangle, indicated by 'S' from the
input file, PublicTestCases/maze_02.txt. You can add a
```System.out.println()``` to make sure your x and y match the position in the file. 

Now update start() to format the additional elements of the GUI. 
Add the code below to initialize and format the new GUI objects.
Again, import the appropriate packages. 

```
        // Text field to take in maze command
        command = new TextField();

        // Border pane will contain canvas for drawing and text area underneath
        BorderPane p = new BorderPane();

        // Input Area + nextMove Button
        Label cmd = new Label("Type Command in TextField");
        HBox hb = new HBox(3);

        // Input + Text Output
        VBox vb = new VBox(2);

        setupNodes(hb, cmd, vb);
        setupEventHandlers();

        p.setCenter(canvas);
        p.setBottom(vb);
```

You will notice the methods setupNodes and setupEventHandlers()
are not implemented yet. Copy over the code below to implement
setupNodes(), which will add the TextField, Label, and Button.

```
    /*
     * Sets up the TextField, label, and button to be
     * at the bottom
     */
    private void setupNodes(HBox hb, Label cmd, VBox vb) {

        nextMove = new Button("Simulation Step");

        hb.setSpacing(15);
        hb.getChildren().add(cmd);
        hb.getChildren().add(nextMove);

        vb.getChildren().add(hb);
        vb.getChildren().add(command);
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
button EventHandler will be used. Any time the button is clicked 
it will read in the text in TextField and process it if it is a 
valid command. The button EventHandler is a class method. 

Copy the code below into your code to implement the Button
EventHandler. Import the appropriate package to take an ActionEvent.

```
    /*
     * Button EventHandler to take input command
     * when button is clicked.
     */
    private void setupEventHandlers() {
        nextMove.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                parseLine(command.getText());
            }
        });
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
valid move.

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
