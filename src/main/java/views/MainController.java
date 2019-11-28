package views;

import buss.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController extends MasterController {
	@FXML
	private Button bt1;
	
	@FXML
	private TextField txtId;
	
	@FXML
	private ChoiceBox chcId;
	
	@FXML
	private AnchorPane mainPane;
	
	public void InPage() {
		Main.app.slideOut(mainPane);
	}
}
