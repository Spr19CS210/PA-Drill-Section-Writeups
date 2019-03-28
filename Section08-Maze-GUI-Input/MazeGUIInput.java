
/**
 * E19MazeOutput reads a file in that is hard coded and
 * turns that file's character representation of a maze
 * into a drawing on a JavaFX canvas.
 * 
 * Adapted from the Section 10 code from CS210 Fall 2018.
 * 
 */
import java.io.File;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MazeGUIInput extends Application {
    // 25 x 25 pixel square
    final int SIZE = 50;
    // Points needed to draw a triangle
    final int TRIANGLE = 3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Process the input file and store it in a 2D array of characters
        char[][] maze = readMaze("PublicTestCases/maze_02.txt");
        primaryStage.setTitle("A-maze-ing!");

        Group root = new Group();
        // Canvas to scale to the size of the input file
        Canvas canvas = new Canvas(maze[0].length * SIZE, maze.length * SIZE);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        initScreenMaze(gc, maze);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /*
     * Iterates over the 2D array maze and draws the shape that corresponds
     * to the character.
     */
    public void initScreenMaze(GraphicsContext gc, char[][] maze) {
        // default is yellow because it is a corn maze
        gc.setFill(Color.YELLOW);

        // Two arrays that correspond to the points of the triangle to be drawn
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {

                // * fill in as yellow because it is a corn wall
                if (maze[i][j] == '*') {
                    gc.fillRect(j * SIZE, i * SIZE, SIZE, SIZE);

                } else if (maze[i][j] == 'S') { // Color blue for start position
                                                // in maze
                    gc.setFill(Color.BLUE);
                    double[] yPoints = new double[] {
                            (double) (i * SIZE + SIZE), (double) SIZE * i,
                            (double) (SIZE * i + SIZE) };
                    double[] xPoints = new double[] { (double) j * SIZE,
                            (double) (SIZE * j + (SIZE / 2)),
                            (double) (SIZE * j + SIZE) };
                    // Could just pass arrays straight into fillPolygon
                    gc.fillPolygon(xPoints, yPoints, TRIANGLE);
                    gc.setFill(Color.YELLOW); // Set color back to yellow

                } else if (maze[i][j] == 'E') { // Color square green for end
                    gc.setFill(Color.GREEN);
                    gc.fillRect(j * SIZE, i * SIZE, SIZE, SIZE);
                    gc.setFill(Color.YELLOW); // Set color back to yellow
                }

            }
        }

    }

    /*
     * readMaze accepts a string argument that is the file name
     * Process the file and place its contents in the 2D character
     * array Maze. This 2D array is returned so that another function
     * can handle drawing on the Canvas.
     */
    public char[][] readMaze(String filename) {
        char[][] maze = null;

        try {
            Scanner in = new Scanner(new File(filename));
            int width = in.nextInt(), height = in.nextInt();
            in.nextLine();

            // Initialize array to match input file
            maze = new char[height][width];

            // Fill array with input characters
            for (int i = 0; i < height; i++) {
                int j = 0;
                String s = in.nextLine();
                for (char c : s.toCharArray()) {
                    maze[i][j++] = c;
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return maze;
    }

}