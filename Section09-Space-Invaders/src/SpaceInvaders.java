
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
	// private double axis = 250.0;
	
	private static final int WINDOW_SIZE = 500;
	
	private static final int CYCLES = 450;
	private static final int MILLISECONDS = 5;

	public static void main(String [] args) {
		
		launch(args);
	}
	
	public void start(Stage stage) {
		
		
		Group root = new Group();
		Canvas canvas = new Canvas(WINDOW_SIZE, WINDOW_SIZE);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		
		// Image ship = new Image("img/ship.jpg");
		
		// gc.drawImage(ship, axis - (SHIP_SIZE / 2), WINDOW_SIZE - SHIP_SIZE, SHIP_SIZE, SHIP_SIZE);
		// canvas.setOnMouseMoved(new MovePlayer(ship, gc));
		// canvas.setOnMouseClicked(new Fire(gc));
		
		stage.setScene(new Scene(root));
		stage.show();
		
	}
	
	/*
	private class MovePlayer implements EventHandler<MouseEvent> {
		private Image toDraw;
		private GraphicsContext gc;
		
		public MovePlayer(Image in, GraphicsContext context) {
			this.toDraw = in;
			this.gc = context;
		}
		
		@Override
		public void handle(MouseEvent e) {
			axis = e.getX();
			gc.clearRect(0, WINDOW_SIZE - SHIP_SIZE, WINDOW_SIZE, SHIP_SIZE);
			gc.drawImage(toDraw, axis - (SHIP_SIZE / 2), WINDOW_SIZE - SHIP_SIZE, SHIP_SIZE, SHIP_SIZE);
		}
		
	}
	*/
	
	/*
	private class Fire implements EventHandler<MouseEvent> {
		private GraphicsContext gc;
		
		public Fire(GraphicsContext context) {
			this.gc = context;
		}
		
		@Override
		public void handle(MouseEvent e) {
			Timeline t = new Timeline(new KeyFrame(Duration.millis(MILLISECONDS), new Animation(e.getX(), this.gc)));
			t.setCycleCount(CYCLES);
			t.play();
		}
		
	}
	*/
	
	private class Animation implements EventHandler<ActionEvent> {
		private double xVal;
		private double yVal;
		private GraphicsContext gc;
		
		public Animation(double startingX, GraphicsContext context) {
			this.xVal = startingX;
			this.yVal = 445;
			this.gc = context;
		}
		
		@Override
		public void handle(ActionEvent arg0) {
			this.gc.setFill(Color.BLACK);
			if (yVal > 0) {
				gc.clearRect(this.xVal - 5, this.yVal, 5, 5);
				yVal -= 5;
				gc.fillRect(this.xVal - 5, this.yVal, 5, 5);
			} else {
				gc.clearRect(this.xVal - 5, this.yVal, 5, 5);
			}
			
		}
	}
	
	
}
