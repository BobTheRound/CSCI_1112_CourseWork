package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	
	private String stahp = new String("STOP");
	
	public double setWidth(double wide) {
		return wide;
	}
	
	public double setHeight(double high) {
		return high;
	}
	
	public void setFill(Color fill) {
		

	}
	
	public void setStroke(Color paint) {
		
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root, 800, 800);
			Stage stage = new Stage();	
			
			Text text = new Text();
			text.setText(stahp);
			text.setX(300);
			text.setY(400);
			text.setFont(Font.font(80));
			text.setFill(Color.WHITE);
			
			Polygon polygon = new Polygon();
			polygon.setFill(Color.RED);
			polygon.setStroke(Color.BLACK);
			
			ObservableList<Double> list = polygon.getPoints();
			
			double centerX = setWidth(800.0) / 2, centerY = setHeight(800.0) / 2;
			double radius = Math.min(setWidth(800.0), setHeight(800.0)) * 0.4;

			// s represents the number of sides of the shape
			// Make sure to update this number when necessary
			int s = 8;
			// Add points to the polygon list
			for (int i = 0; i < s; i++) {
				list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
				list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
			}
			
			root.getChildren().clear();
			root.getChildren().add(polygon); 
			root.getChildren().add(text);
			stage.setTitle("Very Special Stop Sign");
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
//pie