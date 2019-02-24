package mainUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 使い方メモ
 * @author Risa
 *
 */
public class About {
	/**
	 * 使い方メモ
	 * @param primaryStage 画面を表示するStage
	 */
	public About(Stage primaryStage) {
		VBox root = new VBox();
		TabPane tabPane = Graphics.getTabPane();
		VBox texts = new VBox();
		Text text = new Text("使い方メモ");
		Text t1 = new Text("試合結果（団体戦）\nラジオボタンで男子or女子を選択→eight/fiveが切り替わります。\n"
				+ "年月日は八桁の半角数字で入力（これがファイル名になります。）これ以外だとエラーになります。\n"
				+ "入力例） 2018年3月1日の試合→20180301\n"
				+ "対戦校は、○○練習試合結果の○○に相当する部分です。\n"
				+ "氏名（苗字と名前の間は全角空白） 学年 点数 備考等は半角空白もしくはハイフン\"-\"で区切ってください。\n"
				+ "入力例）\n　佐藤　太郎 2 250-310-560\n　佐藤　次郎 1 200-300-500 オープン"
				+ "入力が正しければ、OKボタンを押すと、\"書き込みました。\"と表示されます。");
		Text t2 = new Text("試合結果（個人戦）");
		Text t3 = new Text("写真館\n年度は4桁半角数字で入力してください。\n"
				+ "写真は一つのフォルダにまとめて、そのフォルダへの相対パスを入力すると、\"index.html\"と\"images.json\"ファイルが\n"
				+ "対象フォルダ内に生成されます。これをまとめてアップロードします。");
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
