package buss;

import java.util.List;
import java.util.Scanner;

import api.APILoader;
import domain.BusVO;
import domain.StationVO;

public class MainApp {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		APILoader loader = new APILoader();
		loader.initData(); // 정류소 데이터 읽어오기
		
		System.out.println("정류소 이름을 입력하세요");
		String name = in.nextLine();
		
		List<StationVO> findList = loader.findStation(name);
		
		System.out.println("찾은 정류장은 다음과 같습니다.");
		
		for(StationVO station : findList) {
			System.out.println(station);
		}
		
		System.out.println("찾은 정류장중 검색할 아이디를 입력하세요");
		String stationCode = in.nextLine();
		
		List<BusVO> bList = loader.getBusInfo(stationCode);
		
		for(BusVO bus : bList) {
			System.out.println(bus);
		}
		
	}
}
