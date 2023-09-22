package application;
	
import javafx.application.Application;
import javafx.beans.binding.IntegerBinding;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


public class Main extends Application {
	
	protected int i = 0;
	
	public int setI(int i) {
		 this.i += 1;
		return this.i;
	}
	
	public int addTick(int i) {
		this.i += 1;
		return this.i;		
	}
	
	public int subTick(int i) {
		if(this.i < 0) {
			this.i = -1;
			return this.i;
		}else {
			this.i -= 1;
			return this.i;
		}
	}
	

	@Override
	public void start(Stage primaryStage) {
		try {
			TriforcePane pane = new TriforcePane();
			Button buttPlus = new Button("+");
			Button buttMinus = new Button("-");
		
			buttPlus.setOnMousePressed(e ->
				pane.setOrder(addTick(this.i)));
			
			buttMinus.setOnMousePressed(e ->
				pane.setOrder(subTick(this.i)));
			
			HBox hBox = new HBox(10);
			hBox.getChildren().addAll(buttPlus, buttMinus);
			hBox.setAlignment(Pos.CENTER);
			
			BorderPane borderPane= new BorderPane();
			borderPane.setCenter(pane);
			borderPane.setBottom(hBox);
			
			Scene scene = new Scene(borderPane, 800, 800);
			primaryStage.setTitle("Fractal Triforce");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			pane.widthProperty().addListener(ov -> pane.paint());
			pane.heightProperty().addListener(ov -> pane.paint());
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

 class TriforcePane extends Pane {
	protected int order = 0;
	
	
	public void setOrder(int order) {
		this.order = order;
		paint();
		
	}
	
	TriforcePane(){
		
	}
	
	protected void paint() {
		Point2D p1 = new Point2D(getWidth() / 2, 10);
		Point2D p2 = new Point2D(10, getHeight() - 10);
		Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
		
		this.getChildren().clear();
		
		displayTriangles(order, p1, p2, p3);
	}
	
	private void displayTriangles(int order, Point2D p1, Point2D p2, Point2D p3) {
		if(order == 0) {
			Polygon triangle = new Polygon();
			triangle.getPoints().addAll(p1.getX(), p1.getY(),
					p2.getX(), p2.getY(), p3.getX(), p3.getY());
			triangle.setStroke(Color.GOLD);
			triangle.setFill(Color.YELLOW);
			
			this.getChildren().add(triangle);
		}else {
			Point2D p12 = p1.midpoint(p2);
			Point2D p23 = p2.midpoint(p3);
			Point2D p31 = p3.midpoint(p1);
			
			
			displayTriangles(order - 1, p1, p12, p31);
			displayTriangles(order - 1, p12, p2, p23);
			displayTriangles(order - 1, p31, p23, p3);
		}
	}
}