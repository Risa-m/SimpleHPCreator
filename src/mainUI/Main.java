package mainUI;

import gallery.Gallery;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * �A�v���P�[�V�����̊�ՂƂȂ�N���X
 * @author Risa
 * 
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		HBox hbox = new HBox();
		Graphics g = new Graphics();
		g.createTabPane(primaryStage);
		htmlCreate(primaryStage);
	}
	
	public void gallery(Stage primaryStage) {
		new Gallery(primaryStage);
	}
	
	public void htmlCreate(Stage primaryStage) {
		new Scores(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}