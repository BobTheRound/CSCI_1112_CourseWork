package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Main extends Application {
	
	
	
	@Override
	public void start(Stage stage) {
		try {
			Group root = new Group();
			BorderPane pane = new BorderPane();
			Pane circlePane = new Pane();
			
			Scene scene = new Scene(root, 200, 200);
			HBox butRow = new HBox(10);
			butRow.setAlignment(Pos.BOTTOM_CENTER);
			
			//construct circle
			Circle circle = new Circle();
			circle.setRadius(50);
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
			circlePane.getChildren().add(circle);
			circle.setCenterX(100);
			circle.setCenterY(100);
			
			
			pane.setCenter(circlePane);
			
			pane.setPrefSize(200, 200);
			
			pane.setBottom(butRow);
			

			Button up = new Button("up");
			Button down = new Button("down");
			Button left = new Button("left");
			Button right = new Button("right");
			
			butRow.getChildren().addAll(up, down, left, right);
			
			root.getChildren().add(pane);
		
			
			up.setOnAction(e -> {
				circle.setCenterY(circle.getCenterY() - 10);
				double y = circle.getCenterY();
				if(y <= 50) {
					circle.setCenterY(100);
				}
			});
			
			down.setOnAction(e -> {
				circle.setCenterY(circle.getCenterY() + 10);
				double y = circle.getCenterY();
				if(y >= 150) {
					circle.setCenterY(100);
				}
			});
			
			left.setOnAction(e -> {
				circle.setCenterX(circle.getCenterX() - 10);
				double x = circle.getCenterX();
				if(x <= 50) {
					circle.setCenterX(100);
				}
			});
			
			right.setOnAction(e -> {
				circle.setCenterX(circle.getCenterX() + 10);
				double x = circle.getCenterX();
				if(x >= 150) {
					circle.setCenterX(100);
				}
			});
			stage.setTitle("Circle Pain.java");
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
