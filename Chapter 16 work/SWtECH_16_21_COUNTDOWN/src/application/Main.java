package application;
	
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends Application {
	private int timeMe;
	private static final String MEDIA_URL = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
	
		Media bell = new Media(MEDIA_URL);
		MediaPlayer ding = new MediaPlayer(bell);
		TextField countdown = new TextField();
		Timeline tick = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
			int seconds = Integer.parseInt(countdown.getText());
			countdown.setText(seconds - 1 + "");
			if(seconds - 1 <= 0 ) {
				stopAnimation();
			}
			playMoosic();
		}));
	 
	@Override
	public void start(Stage stage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			
			//create text object to be counted down
			Text countMe = new Text();
			
			countdown.setOnAction(e -> {
				tick.setCycleCount(Timeline.INDEFINITE);
				tick.play();
	
			});
			root.setTop(countdown);
			countdown.setAlignment(Pos.CENTER);
			root.setCenter(countMe);
			countMe.setFont(Font.font("Papyrus", 50));

			
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stopAnimation() {
		tick.stop();
	}
	
	public void playMoosic() {
		if(tick.getStatus().equals(Animation.Status.STOPPED)) {
			ding.play();
		}
	}
	public static void main(String[] args) {
		launch(args);
		
	}
}
