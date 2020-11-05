package shortest_path;

import java.util.ArrayList;
import java.util.List;

public class Station {
	private String station_name;  //站点名
    private List<String> station_line=new ArrayList<String>();  //所在线路（换乘站有多条）
    private List<Station> near_stations=new ArrayList<Station>();  //与之相邻的站点
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public List<String> getStation_line() {
		return station_line;
	}
	public void setStation_line(List<String> station_line) {
		this.station_line = station_line;
	}
	public List<Station> getNear_stations() {
		return near_stations;
	}
	public void setNear_stations(List<Station> near_stations) {
		this.near_stations = near_stations;
	}
	
}
