package application;
	
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Main extends Application {

	public double setWidth(double wide) {
		return wide;
	}
	
	public double setHeight(double high) {
		return high;
	}
	
	
	@Override
	public void start(Stage stage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 800, 800);

			//create pentagon
			Polygon pentaPath = new Polygon();
			pentaPath.setFill(Color.SIENNA);
			pentaPath.setStroke(Color.AZURE);
			ObservableList<Double> list = pentaPath.getPoints();
			
			double centerX = setWidth(400.0) / 2, centerY = setHeight(400.0) / 2;
			double radius = Math.min(setWidth(400.0), setHeight(400.0)) * 0.4;
			int s = 5;
			for (int i = 0; i < s; i++) {
				list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
				list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
			}
			
			//create square to ride along the edge of pentagon
			//(nerds are squares, that's the dad joke.)
			Rectangle nerd = new Rectangle(0, 10, 20, 40);
			nerd.setFill(Color.LIGHTGREEN);
			nerd.setStroke(Color.NAVY);

			//place pentagon and square on same pane
			root.getChildren().add(pentaPath); 
			root.getChildren().add(nerd);
			
			//create travel path
			PathTransition runNerd = new PathTransition();
			runNerd.setDuration(Duration.millis(10000));
			runNerd.setPath(pentaPath);
			runNerd.setNode(nerd);
			runNerd.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);			
			runNerd.setCycleCount(Timeline.INDEFINITE);
			runNerd.setAutoReverse(true);
			runNerd.play();
			
			FadeTransition camoNerd = new FadeTransition(Duration.millis(500), nerd);	
			camoNerd.setFromValue(1.0);
			camoNerd.setToValue(0.001);
			camoNerd.setCycleCount(Timeline.INDEFINITE);
			camoNerd.setAutoReverse(true);
			camoNerd.play();
			
			root.setOnMousePressed(e -> {
				if(runNerd.getStatus() == PathTransition.Status.PAUSED) {
					runNerd.play();
					camoNerd.play();
				} else {
					runNerd.pause();
					camoNerd.pause();
				}
			});
		
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
