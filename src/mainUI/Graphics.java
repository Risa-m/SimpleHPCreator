package mainUI;

import gallery.Gallery;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * �����̉�ʂ���Ăяo�����\���̂���Pane�����B
 * 
 * @author Risa
 *
 */
public class Graphics {
	private static TabPane tabPane;
	/**
	 * 
	 */
	public Graphics() {
		
	}
	/**
	 * ������ʂ�؂�ւ�����^�u������Pane
	 * @param primaryStage �^�u��\������Stage
	 * 
	 */
	public void createTabPane(Stage primaryStage) {
		tabPane = new TabPane();
		Tab tab1 = new Tab("��������(�c�̐�)");
		Tab tab2 = new Tab("��������(�l��)");
		Tab tab3 = new Tab("�ʐ^��");
		Tab tab4 = new Tab("�g��������");
		tab1.setClosable(false);
		tab2.setClosable(false);
		tab3.setClosable(false);
		tab4.setClosable(false);
		tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
		tabPane.getSelectionModel().selectedItemProperty().addListener((obs, ot, nt) -> {
/*			System.out.println(tabPane.getTabs().get(1));
			System.out.println(ot);
			System.out.println(nt);
*/            if(tabPane.getTabs().get(0).equals(nt)) {
        		new Scores(primaryStage);
            }else if(tabPane.getTabs().get(1).equals(nt)) {
            	new Scorei(primaryStage);
            }else if(tabPane.getTabs().get(2).equals(nt)) {
        		new Gallery(primaryStage);
            }else {
            	new About(primaryStage);
            }
        });
	}
	
	/**
	 * �������ꂽTabPane��Ԃ��܂��B
	 * @return �������ꂽTabPane
	 */
	public static TabPane getTabPane() {
		return tabPane;
	}
	
}
