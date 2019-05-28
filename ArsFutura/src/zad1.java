import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class zad1 {

	public static void main(String[] args) {
		

		Map<String, Integer> map = new LinkedHashMap<>();

		
		for (int i = 0; i < 1000; i++) {
			for(int j = 0; j < 1000; j++) {
				map.put(i+","+j, 0);
			}
		}
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("/home/jakov/Documents/myfile"));
			String line = reader.readLine();
			while (line != null) {
				
				String odvojeni []= line.split(" ");
				
				int x1, y1, x2, y2;
				
				if(odvojeni[0].equals("toggle")) {
					x1 = Integer.parseInt(odvojeni[2]);
					y1 = Integer.parseInt(odvojeni[4]);
					x2 = Integer.parseInt(odvojeni[6]);
					y2 = Integer.parseInt(odvojeni[8]);
					toggle(x1, y1, x2, y2, map);
				}
				if(odvojeni[1].equals("on")) {
					x1 = Integer.parseInt(odvojeni[3]);
					y1 = Integer.parseInt(odvojeni[5]);
					x2 = Integer.parseInt(odvojeni[7]);
					y2 = Integer.parseInt(odvojeni[9]);
					turnOn(x1, y1, x2, y2, map);
				}
				if(odvojeni[1].equals("off")) {
					x1 = Integer.parseInt(odvojeni[3]);
					y1 = Integer.parseInt(odvojeni[5]);
					x2 = Integer.parseInt(odvojeni[7]);
					y2 = Integer.parseInt(odvojeni[9]);
					turnOff(x1, y1, x2, y2, map);
				}
				
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		int brojac = 0;
		for(String key : map.keySet()) {
			if(map.get(key) == 1) {
				brojac++;
			}
		}
		
		
		System.out.println(brojac);
	}
	
	public static void turnOn (int x1, int y1, int x2, int y2, Map map) {
		
		for(int k = x1; k <= x2; k++) {
			for(int h = y1 ; h <= y2 ; h++) {
				on(k, h, map);
			}
		}
	}
	
	public static void turnOff (int x1, int y1, int x2, int y2, Map map) {
		
		for(int k = x1; k <= x2; k++) {
			for(int h = y1 ; h <= y2 ; h++) {
				off(k, h, map);
			}
		}
	}
	
	public static void toggle (int x1, int y1, int x2, int y2, Map map) {
		

		for(int k = x1; k <= x2; k++) {
			for(int h = y1 ; h <= y2 ; h++) {
				toggl(k, h, map);
			}
		}
	}
	
	public static void toggl(int x, int y, Map map) {
		if(map.get(x+","+y).equals(1)) {
			map.put(x+","+y, 0);
		}else if(map.get(x+","+y).equals(0)){
			map.put(x+","+y, 1);
		}
	}
	
	public static void on(int x, int y, Map map) {
		map.put(x+","+y, 1);
	}
	
	public static void off(int x, int y, Map map) {
		map.put(x+","+y, 0);
	}
}
