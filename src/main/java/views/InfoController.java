package views;

import buss.Main;
import domain.BusVO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class InfoController extends MasterController {
	@FXML
	private Pane pane;
	
//	@FXML
//	private Label lblName;
	
	@FXML
	private Label locationNo1;
	
	@FXML
	private Label locationNo2;
	
	@FXML
	private Label predictTime1;
	
	@FXML
	private Label predictTime2;
	
	public void infoView(BusVO data) {
		locationNo1.setText("첫 번째 버스 전 정류소 : " + data.getLocationNo1() + " 정거장 전");
		locationNo2.setText("두 번째 버스 전 정류소 : " + data.getLocationNo2() + " 정거장 전");
		predictTime1.setText("첫 번째 버스 남은 시간 : " + data.getPredictTime1() + " 분 전");
		predictTime2.setText("두 번째 버스 남은 시간 : " + data.getPredictTime2() + " 분 전");
		System.out.println(data);
		//data.getPlateNo2()
	}
	
	public void cancel() {
		Main.app.slideOut(getRoot());
	}
}
