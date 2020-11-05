package shortest_path;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import com.xupppp.sub.model.Line;
import com.xupppp.sub.util.DataBuilder;

import mode.Station;
import subway.Line;

public class subway {
	public static void main(String[] args) throws IOException {
		public static LinkedHashSet<List<Station>> lineSet = new LinkedHashSet<List<Station>>();   //线路集合
		System.out.print("请输入地铁路线文档路径：");
		//D:\programming\java file\eclipse-wokespace\shortest_path\src\地铁线路信息.txt
		Scanner path=new Scanner(System.in);
		File file=new File(path.nextLine());//读取地铁路线文件
		if(!file.exists()) throw new FileNotFoundException("文件路径有误");
		Line lines=new Line();
		Station stations=new Station();
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//规定字符集以免出现乱码
        String content="";
        content=br.readLine();
        int linenum=Integer.parseInt(content);
        for(int i=0;i<linenum;i++) {  //循环往lineSet中添加line
        	content=br.readLine();
        	List<Station> line=new ArrayList<Station>();
        	String[] splits=content.split(" "); 
        	String linename=splits[0];
        	for(int j=1;j<splits.length;j++) {  //循环往line中添加station
        		int flag=0;
        		for(List<Station> l:lineSet) {  //处理换乘站
        			for(int k=0;k<l.size();k++) {
        				if(l.get(k).getName().equals(splits[j])) {  
        					List<String> newline=l.get(k).getLine();
        					newline.add(linename);
        					l.get(k).setLine(newline);
        					line.add(l.get(k));
        					flag=1;
        					break;
        				}
        			}
        			if(flag==1)
        				break;
        		}
        		if(j==splits.length-1&&splits[j].equals(splits[1])) {  //处理环线
        			line.get(0).getLinkStations().add(line.get(line.size()-1));
        			line.get(line.size()-1).getLinkStations().add(line.get(0));
        			flag=1;
        		}
        		if(flag==0)
        			line.add(new Station(splits[j],linename));
        	}
        	for(int j=0;j<line.size();j++) {  //初始化每个车站相邻的车站
        		List<Station> newlinkStations=line.get(j).getLinkStations();
        		if(j==0) {
        			newlinkStations.add(line.get(j+1));
        			line.get(j).setNear_stations(newlinkStations);
        		}
        		else if(j==line.size()-1) {
        			newlinkStations.add(line.get(j-1));
        			line.get(j).setNear_stations(newlinkStations);
        		}
        		else {
        			newlinkStations.add(line.get(j+1));
        			newlinkStations.add(line.get(j-1));
        			line.get(j).setNear_stations(newlinkStations);
        		}
        	}
        	lineSet.add(line); 
        }
        br.close();
        System.out.print("选择要查询的类别 1、查询线路2、查询最短路径");
        int choice=path.nextInt();
        if(choice==1) {
        	sysytem.out.print("请输入要查询的路线");
        	String line_name=path.next();
        	int flag=1;
            for(Line line:lines) {
                if(line.getLine_name().equals(line_name))
                    {
                		System.out.print(lines.getStations().toString());//根据所存的数组直接输出
                        flag=0;
                        break;
                    }
            }
            if(flag==1) {
                System.out.print("线路名输入有误");
            }
        }
        else if(choice==2)
        System.out.print("请输入起始站：");
        String start_stationt_station_name=path.next();
        System.out.print("请输入终点站：");
        String line_end_station_name=path.next();
        Station start_stationt_station = new Station();
        Station line_end_station = new Station();
        for(Station station:stations) {
            if(station.getStation_name().equals(start_stationt_station_name)) {
                start_stationt_station=station;
            }
            if(station.getStation_name().equals(line_end_station_name))
                line_end_station=station;
        }
        ArrayList<Station> shortestPath=new ArrayList<Station>();
        showPath(line_end_station,shortestPath);
        String changeLine=getSameLine(shortestPath.get(0),shortestPath.get(1));
        for(int i=0;i<shortestPath.size();i++) {
            if(i>=2) {
                if(!getSameLine(shortestPath.get(i),shortestPath.get(i-1)).equals(changeLine)) {
                    changeLine=getSameLine(shortestPath.get(i),shortestPath.get(i-1));
                    System.out.println("------->换乘"+changeLine);
                }
            }
            System.out.println(shortestPath.get(i).getStation_name());
        }
        }
        else {
            System.out.print("输入有误,请重试");
        }
	public static Dijkstra(Station start_station, Station end_station) {  //dijkstra算法计算最短路径
		private static List<Station> analysisList = new ArrayList<>();        //已经分析过的站点
		private static HashMap<Station,Line> LineMap = new HashMap<>();  //结果集
		private static Station getNextStation() {    //获取下一个需要分析的站点
	        int dist=999999;
	        Station rets = null;
	        Set<Station> stations = LineMap.keySet();
	        for (Station station : stations) {
	            if (analysisList.contains(station)) {
	                continue;
	            }
	            Line Line = LineMap.get(station);
	            if (Line.getDistance() < dist) {
	                dist = Line.getDistance();
	                rets = Line.getline_end();
	            }
	        }
		for(List<Station> l:DataBuilder.lineSet) {  //构造结果集
		for(int k=0;k<l.size();k++) {
            Line Line = new Line();
            Line.setstart_station(start_station);
            Line.setline_end(l.get(k));
            Line.setDistance(999999);
            Line.setLine_change(0);
            LineMap.put(l.get(k), Line);
		}
	}
	for(Station s:start_station.getLinkStations()) {  //初始化结果集
		LineMap.get(s).setDistance(1);
		LineMap.get(s).setPassStations(start_station);
		List<String> samelines=getSameLine(start_station.getLine(),s.getLine());
		LineMap.get(s).setLine(samelines.get(0));
	}
	LineMap.get(start_station).setDistance(0);
	analysisList.add(start_station);
    Station nextstation = getNextStation(); 		//计算下一个需要分析的站点
    while(nextstation!=null) {  //循环计算每一个站点的最短路径
    	for(Station s:nextstation.getnear_stations()) {
    		if(LineMap.get(nextstation).getDistance()+1<LineMap.get(s).getDistance()) {  //更新最短路径
    			LineMap.get(s).setDistance(LineMap.get(nextstation).getDistance()+1);
    			LineMap.get(s).setPassStations(nextstation);
    			List<String> samelines=getSameLine(nextstation.getLine(),s.getLine());
    			if(!samelines.contains(LineMap.get(nextstation).getLine())) {  //需要换乘
    				LineMap.get(s).setLine(samelines.get(0));
    				LineMap.get(s).setLinechange(1);
    			}
    			else {
    				LineMap.get(s).setLine(LineMap.get(nextstation).getLine());
    			}
    		}
    	}
    	analysisList.add(nextstation); 
    	nextstation = getNextStation();
    } 
    int flag=1;
	for (List<Station> l:DataBuilder.lineSet) {
		flag=1;
		for(Station s :l) {
			if(!s.getLine().contains(linename))
				flag=0;
		}
		if(flag==1)
			return l;
	}	
	return null;
}
    return LineMap.get(line_end);
}
	
}

