package domain;

public class BusVO {
	private String flag; // 운행정보 PASS와 RUN이 운행중
	private String locationNo1; // 첫번째 버스의 전정류소
	private String locationNo2; // 두번째 버스의 전정류소
	private String plateNo1; // 첫번째 버스 번호
	private String plateNo2; // 두번째 버스 번호
	private String predictTime1; // 첫번째 예상시간
	private String predictTime2; // 두번째 예상시간


	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getLocationNo1() {
		return locationNo1;
	}

	public void setLocationNo1(String locationNo1) {
		this.locationNo1 = locationNo1;
	}

	public String getLocationNo2() {
		return locationNo2;
	}

	public void setLocationNo2(String locationNo2) {
		this.locationNo2 = locationNo2;
	}

	public String getPlateNo1() {
		return plateNo1;
	}

	public void setPlateNo1(String plateNo1) {
		this.plateNo1 = plateNo1;
	}

	public String getPlateNo2() {
		return plateNo2;
	}

	public void setPlateNo2(String plateNo2) {
		this.plateNo2 = plateNo2;
	}

	public String getPredictTime1() {
		return predictTime1;
	}

	public void setPredictTime1(String predictTime1) {
		this.predictTime1 = predictTime1;
	}

	public String getPredictTime2() {
		return predictTime2;
	}

	public void setPredictTime2(String predictTime2) {
		this.predictTime2 = predictTime2;
	}

	@Override
	public String toString() {
		return "첫 번째 버스 번호 : " + plateNo1 + "두 번째 버스 번호 : " + plateNo2;
	}

}
