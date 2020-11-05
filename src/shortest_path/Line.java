package shortest_path;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private Station line_start;  //线路起始站
    private Station line_end;   //线路终点站
    private int distance;  //距离
    private Station front_station;  //到达该站的最短路径中的上一站
    private String line_name;   //路线名称
    private int line_change;  //标记从上一站到该站是否有换乘，0为无换乘，1为需换乘
    private List<Station> stations=new ArrayList<Station>();//记录站点
	
	public List<Station> getStations() {
		return stations;
	}
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	public Station getLine_start() {
		return line_start;
	}
	public void setLine_start(Station line_start) {
		this.line_start = line_start;
	}
	public Station getLine_end() {
		return line_end;
	}
	public void setLine_end(Station line_end) {
		this.line_end = line_end;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Station getFront_station() {
		return front_station;
	}
	public void setFront_station(Station front_station) {
		this.front_station = front_station;
	}
	public String getLine_name() {
		return line_name;
	}
	public void setLine_name(String line_name) {
		this.line_name = line_name;
	}
	public int getLine_change() {
		return line_change;
	}
	public void setLine_change(int line_change) {
		this.line_change = line_change;
	}
}
