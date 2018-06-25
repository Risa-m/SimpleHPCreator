package gallery;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainUI.Graphics;

/**
 * 写真のデータを入力する画面を生成するクラス。
 * @author Risa
 *
 */
public class Gallery {
	TextField tf;
	
	/**
	 * 写真のデータを入力する画面を生成する。
	 * @param primaryStage 画面を表示するStage
	 */
	public Gallery(Stage primaryStage) {
		BorderPane border = new BorderPane();
		GridPane grid = new GridPane();
		VBox vbox = new VBox();
		
		TabPane tabPane = Graphics.getTabPane();

		border.setCenter(vbox);
		
		Button button = new Button("OK");
		Text eventText = new Text("イベント名"); 
		TextField event = new TextField();
		Text yearText = new Text("年度");
		TextField year = new TextField();
		Text text = new Text("対象フォルダへの相対パスを入力してください。");
		Text restext = new Text();
		tf = new TextField();
		
		button.setOnAction(actionEvent ->{
			String name = getText();
			File file = new File(name);
			if(file.exists()) {
				new JsonCreator(name);
				new GalleryHTML(name, event.getText(), "galleryheader.txt", "galleryfooter.txt", Integer.parseInt(year.getText()));
				restext.setText("\"image.json\",\"index.html\"を作成しました。");
			}else {
				restext.setText("ファイルが見つかりません。");
			}
		});
		
		vbox.getChildren().add(tabPane);
		vbox.getChildren().add(grid);

		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(0, 25, 25, 10));
		grid.setVgap(10);
		grid.add(eventText, 0, 1);
		grid.add(event, 1, 1);
		grid.add(yearText, 0, 2);
		grid.add(year, 1, 2);
		grid.add(text, 0, 3);
		grid.add(tf, 0, 4);
		grid.add(button, 0, 5);
		grid.add(restext, 0, 6);
		
		Scene scene = new Scene(border,600,600);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * @return テキストフィールド
	 */
	public TextField getTextField() {
		return tf;
	}
	
	/**
	 * テキストフィールドに入力された内容を取得する。
	 * @return テキストフィールドに入力された内容（写真の保存されたフォルダへの相対パス）
	 */
	public String getText() {
		return tf.getText();
	}

}
