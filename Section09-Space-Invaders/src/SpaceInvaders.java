
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SpaceInvaders extends Application {
	
	private static final int SHIP_SIZE = 50;
	
	private static final int WINDOW_SIZE = 500;
	
	private static final int CYCLES = 450;
	private static final int MILLISECONDS = 5;
	private static final int LASER_VELOCITY = 5;
	private static final int LASER_SIZE = 5;
	private static final Color LASER_COLOR = Color.BLACK;

	public static void main(String [] args) {
		
		launch(args);
	}
	
	public void start(Stage stage) {
		
		// Initialize JavaFX window requirements, including canvas and graphics context
		Group root = new Group();
		Canvas canvas = new Canvas(WINDOW_SIZE, WINDOW_SIZE);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		
		// TODO: Display square on screen
		// TODO: Add event handler to move square on screen
		// TODO: Add event handler to fire lasers
		
		// required to display window on screen
		stage.setScene(new Scene(root));
		stage.show();
		
	}
	
	/**
	 * Class Name: Animation
	 * Purpose: Handle animation events inside of a Timeline animation
	 * class
	 * Parameters: startingX: The starting X coordinate for a laser animation
	 *             context: The graphicsContext to draw on
	 * @author Clarkdale
	 *
	 */
	private class Animation implements EventHandler<ActionEvent> {
		private double xVal;
		private double yVal;
		private GraphicsContext gc;
		
		public Animation(double startingX, GraphicsContext context) {
			this.xVal = startingX;
			this.yVal = WINDOW_SIZE - SHIP_SIZE - LASER_SIZE;
			this.gc = context;
		}
		
		@Override
		/**
		 * Method Name: handle
		 * Purpose: draw laser at a given instance, and increment to next
		 *          animation state
		 * return: none
		 */
		public void handle(ActionEvent e) {
			// set fill color
			this.gc.setFill(LASER_COLOR);
			// If the y-value is greater than zero, then the next laser state can be drawn. 
			// Otherwise, remove the final square from screen so they do not accumulate at 
			// the top. 
			if (yVal > 0) {
				gc.clearRect(this.xVal - LASER_SIZE, this.yVal, LASER_SIZE, LASER_SIZE);
				yVal -= LASER_VELOCITY;
				gc.fillRect(this.xVal - LASER_SIZE, this.yVal, LASER_SIZE, LASER_SIZE);
			} else {
				gc.clearRect(this.xVal - LASER_SIZE, this.yVal, LASER_SIZE, LASER_SIZE);
			}
			
		}
	}
	
	
}
