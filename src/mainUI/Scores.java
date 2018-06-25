package mainUI;

import java.util.ArrayList;

import construction.DataSet;
import construction.HTMLCreator;
import construction.Member;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * �������ʁi�c�̐�j����͂����ʂ𐶐�����B
 * @author Risa
 *
 */
public class Scores {
	/**
	 * �������ʁi�c�̐�j����͂����ʂ𐶐�����B
	 * @param primaryStage ��ʂ�\������Stage
	 */
	public Scores(Stage primaryStage) {
		VBox vbox = new VBox();
		GridPane grid = new GridPane();
		TabPane tabPane = Graphics.getTabPane();

		Button okbutton = new Button("OK");
		TextField tf1 = new TextField("2018");
		TextField tf2 = new TextField("��w");
		TextField tf3 = new TextField("�����W");
		TextArea ta1 = new TextArea();
		TextArea ta2 = new TextArea();
		Text text = new Text();

		RadioButton rb1 = new RadioButton("�j�q");
		RadioButton rb2 = new RadioButton("���q");
		final ToggleGroup group = new ToggleGroup();
		rb1.setToggleGroup(group);
		rb1.setSelected(true);
		rb2.setToggleGroup(group);
		rb1.setUserData("boys");
		rb2.setUserData("girls");
		HBox rbs = new HBox();
		rbs.getChildren().addAll(rb1, rb2);
		group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) ->{
			if(group.getSelectedToggle() != null) {
				if(group.getSelectedToggle().getUserData().equals("boys")) {
					DataSet.setBoys();
				}else if(group.getSelectedToggle().getUserData().equals("girls")) {
					DataSet.setGirls();
				}
			}
		});
		
		Pane pf1 = setPane("�N����", tf1);
		Pane pf2 = setPane("�ΐ�Z", tf2);
		Pane pf3 = setPane("�ꏊ", tf3);
		Pane pa1 = setPane("�����@�w�N�@�_���@���l��\n", ta1);
		Pane pa2 = setPane("�����@�w�N�@�_���@���l��\n(����Z)", ta2);
		 
			
		vbox.getChildren().add(tabPane);
		vbox.getChildren().add(grid);
//		vbox.setPadding(new Insets(10,10,10,10));
//		vbox.setSpacing(10);
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(0, 25, 25, 10));
		grid.setVgap(5);
		grid.add(rbs, 0, 1);
		grid.add(pf1, 0, 2);
		grid.add(pf2, 0, 3);
		grid.add(pf3, 0, 4);
		grid.add(pa1, 0, 5);
		grid.add(pa2, 0, 6);
		grid.add(okbutton, 0, 7);
		grid.add(text, 0, 8);
		
		okbutton.setOnAction(actionEvent ->{
			boolean check = true;
			String str1 = tf1.getText();// date
			String str2 = tf2.getText();// opponent
			String str3 = tf3.getText();// place
			String str4 = ta1.getText();// member1
			String str5 = ta2.getText();// member2
			ArrayList<Member> list1 = new ArrayList<>();
			ArrayList<Member> list2 = new ArrayList<>();
			String[] strs1 = str4.split("\r\n|[\n\r\u2028\u2029\u0085]");
			String[] strs2 = str5.split("\r\n|[\n\r\u2028\u2029\u0085]");
			try {
				for (int i = 0; i < strs1.length; i++) {
					String[] splits = strs1[i].split(" |-");
					Member members = new Member(splits[0], 
							splits[1], splits[2],
							splits[3], splits[4], (splits.length>5)?splits[5]:"");
					list1.add(members);
				}
				for (int i = 0; i < strs2.length; i++) {
					String[] splits = strs2[i].split(" |-");
					Member members = new Member(splits[0], 
							splits[1], splits[2],
							splits[3], splits[4], (splits.length>5)?splits[5]:"");
					list2.add(members);
				}
				DataSet dataset = new DataSet(/*str1, str2, str3, list1, list2*/);
				if(!str1.isEmpty()) {
					if(!dataset.setDate(str1)) {
						check = false;
						text.setText("�N������8���̔��p��������͂��Ă��������B");
					}
				}
				else {
					check = false;
					text.setText("���t����͂��Ă��������B");
				}
				if(!str2.isEmpty())dataset.setOpponent(str2);
				else {
					check = false;
					text.setText("�ΐ�Z����͂��Ă��������B");
				}
				if(!str3.isEmpty())dataset.setPlace(str3);
				else {
					check = false;
					text.setText("�ꏊ����͂��Ă��������B");
				}
				dataset.setMembers(list1);
				dataset.setOpponentMembers(list2);
				HTMLCreator creator = new HTMLCreator("header.txt", "footer.txt", dataset);
				if(creator.create()&&check) {
					text.setText("�������݂܂����B");
				}else {
//					text.setText("�t�@�C�������݂��܂���B");
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				text.setText("�������ʂ͎����A�w�N�A�_�����󔒂ŋ�؂��Ă��������B");
			}
		});
		Scene scene = new Scene(vbox,600,600);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	/**
	 * �e�L�X�g�ƃe�L�X�g�t�B�[���h�����ɕ��ׂ�Pane�𐶐�����B
	 * @param str �\������e�L�X�g
	 * @param tf �ݒu����e�L�X�g�t�B�[���h
	 * @return �����тɂ���Pane
	 */
	public Pane setPane(String str, TextField tf) {
		HBox hbox = new HBox();
		Text text = new Text(str);
		
		hbox.getChildren().add(text);
		hbox.getChildren().add(tf);

		hbox.setSpacing(20);
		return hbox; 
	}
	/**
	 * �e�L�X�g�ƃe�L�X�g�G���A�����ɕ��ׂ�Pane�𐶐�����B
	 * @param str �\������e�L�X�g
	 * @param ta �ݒu����e�L�X�g�G���A
	 * @return �����тɂ���Pane
	 */
	public Pane setPane(String str, TextArea ta) {
		HBox hbox = new HBox();
		Text text = new Text(str);
		
		hbox.getChildren().add(text);
		hbox.getChildren().add(ta);
		hbox.setSpacing(20);
		
		return hbox; 
	}
}
