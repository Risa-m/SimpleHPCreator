package mainUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * �g��������
 * @author Risa
 *
 */
public class About {
	/**
	 * �g��������
	 * @param primaryStage ��ʂ�\������Stage
	 */
	public About(Stage primaryStage) {
		VBox root = new VBox();
		TabPane tabPane = Graphics.getTabPane();
		VBox texts = new VBox();
		Text text = new Text("�g��������");
		Text t1 = new Text("�������ʁi�c�̐�j\n���W�I�{�^���Œj�qor���q��I����eight/five���؂�ւ��܂��B\n"
				+ "�N�����͔����̔��p�����œ��́i���ꂪ�t�@�C�����ɂȂ�܂��B�j����ȊO���ƃG���[�ɂȂ�܂��B\n"
				+ "���͗�j 2018�N3��1���̎�����20180301\n"
				+ "�ΐ�Z�́A�������K�������ʂ́����ɑ������镔���ł��B\n"
				+ "�����i�c���Ɩ��O�̊Ԃ͑S�p�󔒁j �w�N �_�� ���l���͔��p�󔒂������̓n�C�t��\"-\"�ŋ�؂��Ă��������B\n"
				+ "���͗�j\n�@�����@���Y 2 250-310-560\n�@�����@���Y 1 200-300-500 �I�[�v��"
				+ "���͂���������΁AOK�{�^���������ƁA\"�������݂܂����B\"�ƕ\������܂��B");
		Text t2 = new Text("�������ʁi�l��j");
		Text t3 = new Text("�ʐ^��\n�N�x��4�����p�����œ��͂��Ă��������B\n"
				+ "�ʐ^�͈�̃t�H���_�ɂ܂Ƃ߂āA���̃t�H���_�ւ̑��΃p�X����͂���ƁA\"index.html\"��\"images.json\"�t�@�C����\n"
				+ "�Ώۃt�H���_���ɐ�������܂��B������܂Ƃ߂ăA�b�v���[�h���܂��B");
		root.getChildren().add(tabPane);
		root.getChildren().add(texts);
		texts.setSpacing(10);
		texts.getChildren().addAll(text, t1, t2, t3);
		texts.setPadding(new Insets(20, 25, 10, 25));
		
		Scene scene = new Scene(root,600,600);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
