package buss;

import java.util.HashMap;
import java.util.Map;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import views.InLayoutcontroller;
import views.InfoController;
import views.MainController;
import views.MasterController;

public class Main extends Application {
	public static Main app;

	private StackPane mainPage;
	
	private StackPane infoPage = null;

	public Map<String, MasterController> controllerMap = new HashMap<>();
	
	

	@Override
	public void start(Stage primaryStage) {
		app = this;
		try {
			FXMLLoader infoLoader = new FXMLLoader();
			infoLoader.setLocation(getClass().getResource("/views/InfoLayout.fxml"));
			infoPage = infoLoader.load();
			
			FXMLLoader inloader = new FXMLLoader();
			inloader.setLocation(getClass().getResource("/views/InLayout.fxml"));
			mainPage = inloader.load();
			
			InLayoutcontroller ic = inloader.getController();
			ic.setRoot(mainPage);
			controllerMap.put("in", ic);
			
			FXMLLoader mainloader = new FXMLLoader();
			mainloader.setLocation(getClass().getResource("/views/MainLayout.fxml"));
			AnchorPane main = mainloader.load();
			
			MainController mc = mainloader.getController();
			mc.setRoot(main);
			controllerMap.put("main", mc);

			Scene scene = new Scene(mainPage);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			mainPage.getChildren().add(main);
			
			InfoController fc = infoLoader.getController();
			fc.setRoot(infoPage);
			controllerMap.put("info", fc);

			primaryStage.setTitle("bus");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadPage(String name) {
		MasterController c = controllerMap.get(name);
		Pane pane = c.getRoot();
		mainPage.getChildren().add(pane);
		
		pane.setTranslateX(-800);
		pane.setOpacity(0);
		
		Timeline timeline = new Timeline();
		KeyValue toRight = new KeyValue(pane.translateXProperty(), 0);
		KeyValue fadeIn = new KeyValue(pane.opacityProperty(), 1);
		
		KeyFrame frame = new KeyFrame(Duration.millis(500), toRight, fadeIn);
		
		timeline.getKeyFrames().add(frame);
		timeline.play();
	}

	public void slideOut(Pane pane) {
		Timeline timeline = new Timeline();
		KeyValue toRight = new KeyValue(pane.translateXProperty(), 800);
		KeyValue fadeOut = new KeyValue(pane.opacityProperty(), 0);

		KeyFrame frame = new KeyFrame(Duration.millis(500), (e) -> {
			mainPage.getChildren().remove(pane);
		}, toRight, fadeOut);

		timeline.getKeyFrames().add(frame);
		timeline.play();
	}

	public static void main(String[] args) {
		launch(args);
	}

}