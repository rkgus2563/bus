package api;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import domain.BusVO;
import domain.StationVO;

public class APILoader {
	private List<StationVO> stationList = new ArrayList<>();
	
	public void initData() {
		String url = "https://openapi.gg.go.kr/BusStation?KEY=f985b2f4740f452098a1298ac4d75710&pSize=1000&SIGUN_CD=";
		try {
			for(int i = 1; i <=2; i++) {
				loadList(url + "41130&pIndex=" + i);
			}
			for(int i = 1; i <=2; i++) {
				loadList(url + "41610&pIndex=" + i);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BusVO> getBusInfo(String stationId) {
		String url = "http://openapi.gbis.go.kr/ws/rest/busarrivalservice/station";
		url += "?serviceKey=eUiETQ%2Bl3ZgVs7V1CEJ041DbFO6nugcHguOOZI6oHt7%2BVVI15lrYXZ7L35H%2B4I9JnuNmkjMDDGFEwSR0nmLW5A%3D%3D";
		url += "&stationId=" + stationId;

		
		List<BusVO> bList = new ArrayList<BusVO>();
		
		try {
			Document doc = Jsoup.connect(url).get();
			System.out.println(doc.text());
			Elements busList = doc.select("busArrivalList");
			
			for(Element bus : busList) {
				BusVO temp = new BusVO();
				temp.setFlag(bus.selectFirst("flag").text());
				temp.setLocationNo1(bus.selectFirst("locationNo1").text());
				temp.setLocationNo2(bus.selectFirst("locationNo2").text());
				temp.setPlateNo1(bus.selectFirst("plateNo1").text());
				temp.setPlateNo2(bus.selectFirst("plateNo2").text());
				temp.setPredictTime1(bus.selectFirst("predictTime1").text());
				temp.setPredictTime2(bus.selectFirst("predictTime2").text());
				bList.add(temp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bList;
	}
	
	private void loadList(String url) throws Exception{
		Document doc = Jsoup.connect(url).get();
		Elements list = doc.select("row");
		for(Element station : list) {
			String name = station.selectFirst("STATION_NM_INFO").text();
			String code = station.selectFirst("STATION_ID").text();
			
			StationVO temp = new StationVO();
			temp.setName(name);
			temp.setCode(code);
			stationList.add(temp);
		}
	}
	
	public List<StationVO> findStation(String name){
		List<StationVO> findList = new ArrayList<>();
		
		for(StationVO station : stationList) {
			if(station.getName().contains(name)) {
				findList.add(station);
			}
		}
		
		return findList;
	}
}
