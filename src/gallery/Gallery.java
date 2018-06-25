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
 * �ʐ^�̃f�[�^����͂����ʂ𐶐�����N���X�B
 * @author Risa
 *
 */
public class Gallery {
	TextField tf;
	
	/**
	 * �ʐ^�̃f�[�^����͂����ʂ𐶐�����B
	 * @param primaryStage ��ʂ�\������Stage
	 */
	public Gallery(Stage primaryStage) {
		BorderPane border = new BorderPane();
		GridPane grid = new GridPane();
		VBox vbox = new VBox();
		
		TabPane tabPane = Graphics.getTabPane();

		border.setCenter(vbox);
		
		Button button = new Button("OK");
		Text eventText = new Text("�C�x���g��"); 
		TextField event = new TextField();
		Text yearText = new Text("�N�x");
		TextField year = new TextField();
		Text text = new Text("�Ώۃt�H���_�ւ̑��΃p�X����͂��Ă��������B");
		Text restext = new Text();
		tf = new TextField();
		
		button.setOnAction(actionEvent ->{
			String name = getText();
			File file = new File(name);
			if(file.exists()) {
				new JsonCreator(name);
				new GalleryHTML(name, event.getText(), "galleryheader.txt", "galleryfooter.txt", Integer.parseInt(year.getText()));
				restext.setText("\"image.json\",\"index.html\"���쐬���܂����B");
			}else {
				restext.setText("�t�@�C����������܂���B");
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
	 * @return �e�L�X�g�t�B�[���h
	 */
	public TextField getTextField() {
		return tf;
	}
	
	/**
	 * �e�L�X�g�t�B�[���h�ɓ��͂��ꂽ���e���擾����B
	 * @return �e�L�X�g�t�B�[���h�ɓ��͂��ꂽ���e�i�ʐ^�̕ۑ����ꂽ�t�H���_�ւ̑��΃p�X�j
	 */
	public String getText() {
		return tf.getText();
	}

}
