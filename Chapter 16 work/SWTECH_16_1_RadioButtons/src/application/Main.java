package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {

	
	@Override
	public void start(Stage stage) {
		try {
			BorderPane root = new BorderPane();

			Scene scene = new Scene(root, 400, 400);

			//create text object
			Text text = new Text(50, 50, "I can't drink this Java!");
			text.setFont(new Font(20));
//			root.getChildren().add(text);
			root.setCenter(text);
			
			Pane textPane = new Pane();
			textPane.getChildren().add(text);
			textPane.setStyle("-fx-border-color: black");
			root.setCenter(textPane);
			
			//create left/right buttons
			HBox butRow = new HBox(12);
			root.setBottom(butRow);
			butRow.setAlignment(Pos.CENTER);
			butRow.setStyle("-fx-border-width: 1px; -fx-border-color: black");

			Button butLeft = new Button("<==");
			Button butRight = new Button("==>");
			
			//import functionality for l/r
			butLeft.setOnAction(e -> {
				double x;
				 text.setX(text.getX() - 10);
				 x = text.getX();
				 if (x <= 0) {
					 text.setX(100);
				 }
				 });
			butRight.setOnAction(e -> {
				double x;
				 text.setX(text.getX() + 10);
				 x = text.getX();
				 if (x >= 200) {
					 text.setX(100);
				 }
				 });
			
			//create HBox for radial buttons
			HBox radButRow = new HBox(20);
			root.setTop(radButRow);
			radButRow.setAlignment(Pos.CENTER);
			radButRow.setStyle("-fx-border-width: 1px; -fx-border-color: black");
			radButRow.setPadding(new Insets(12, 12, 12, 12));
					
			//create radio buttons
			RadioButton black = new RadioButton("black");
			RadioButton green = new RadioButton("green");
			RadioButton red = new RadioButton("red");
			RadioButton blue = new RadioButton("blue");
			RadioButton coffee = new RadioButton("coffee");
			
			//create toggle group
			ToggleGroup radButs = new ToggleGroup();
			black.setToggleGroup(radButs);
			green.setToggleGroup(radButs);
			red.setToggleGroup(radButs);
			blue.setToggleGroup(radButs);
			coffee.setToggleGroup(radButs);
			
			//make colors work
			black.setOnAction(e ->{
				if (black.isSelected()) {
					text.setFill(Color.BLACK);
				}
			});
			
			green.setOnAction(e ->{
				if (green.isSelected()) {
					text.setFill(Color.GREEN);
				}
			});
			
			red.setOnAction(e ->{
				if (red.isSelected()) {
					text.setFill(Color.RED);
				}
			});
			
			blue.setOnAction(e ->{
				if (blue.isSelected()) {
					text.setFill(Color.BLUE);
				}
			});
			
			coffee.setOnAction(e ->{
				if (coffee.isSelected()) {
					text.setFill(Color.SADDLEBROWN);
				}
			});
			radButRow.getChildren().addAll(black, green, red, blue, coffee);		
			butRow.getChildren().addAll(butLeft, butRight);
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
