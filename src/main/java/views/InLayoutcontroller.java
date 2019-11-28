package views;

import java.util.List;

import api.APILoader;
import buss.Main;
import domain.BusVO;
import domain.StationVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class InLayoutcontroller extends MasterController {
	@FXML
	private TextField txtName;
	@FXML
	private ChoiceBox<StationVO> stationChoice;

	private ListView<StationVO> listView;

	ObservableList<StationVO> list;

	ObservableList<BusVO> busList;

	InfoController info;

	@FXML
	private StackPane pane;

	@FXML
	private ListView<BusVO> busView;

	private APILoader loader = new APILoader();

	@FXML
	private void initialize() {
		list = FXCollections.observableArrayList();
		stationChoice.setItems(list);
		busList = FXCollections.observableArrayList();
		busView.setItems(busList);
		loader.initData();
	}

	public void Search() {
		String name = txtName.getText();

		if (name.trim().isEmpty()) {
			System.out.println("정류소 이름을 입력하세요");
			return;
		}
		List<StationVO> sList = loader.findStation(name);

		list.clear();
		for (StationVO station : sList) {
			list.add(station);
		}
	}

	public void viewStatus() {
		StationVO station = stationChoice.getSelectionModel().getSelectedItem();

		if (station == null) {
			System.out.println("정류소를 먼저 검색한 후 선택해주세요");
			return;
		}

		List<BusVO> bList = loader.getBusInfo(station.getCode());
		for (BusVO item : bList) {
			busList.add(item);
		}

	}

	public void find() {
		info = (InfoController) Main.app.controllerMap.get("info");
		BusVO list = busView.getSelectionModel().getSelectedItem();
		if (list == null) {
			System.out.println("선택한 정류소에 버스가 없습니다.");
			return;
		}
		info.infoView(list);
		Main.app.loadPage("info");
		
	}
}
