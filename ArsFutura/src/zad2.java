import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class zad2 {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("/home/jakov/Documents/drugiars"));
			String line = reader.readLine();
			while (line != null) {
				
				String odvojeni []= line.split(" ");
				
				map.put(odvojeni[0], 0);
				
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedReader citaj;
		try {
			citaj = new BufferedReader(new FileReader("/home/jakov/Documents/drugiars"));
			String line = citaj.readLine();
			while (line != null) {
				
				String odvojeni []= line.split(" ");
				String s1 = odvojeni[0];
				String operacija = odvojeni[1];
				
				int uvjet1 = map.get(odvojeni[4]);
				int uvjet2 = Integer.parseInt(odvojeni[6]);
				
				int broj = Integer.parseInt(odvojeni[2]);
				
				if(odvojeni[5].equals(">")) {
					if(uvjet1 > uvjet2) {
						if(operacija.equals("dec")) {
							dec(s1, broj, map);
						}else if(operacija.equals("inc")) {
							inc(s1, broj, map);
						}
					}
				}
				if(odvojeni[5].equals(">=")) {
					if(uvjet1 >= uvjet2) {
						if(operacija.equals("dec")) {
							dec(s1, broj, map);
						}else if(operacija.equals("inc")) {
							inc(s1, broj, map);
						}
					}
				}
				if(odvojeni[5].equals("<")) {
					if(uvjet1 < uvjet2) {
						if(operacija.equals("dec")) {
							dec(s1, broj, map);
						}else if(operacija.equals("inc")) {
							inc(s1, broj, map);
						}
					}
				}
				if(odvojeni[5].equals("<=")) {
					if(uvjet1 <= uvjet2) {
						if(operacija.equals("dec")) {
							dec(s1, broj, map);
						}else if(operacija.equals("inc")) {
							inc(s1, broj, map);
						}
					}
				}
				if(odvojeni[5].equals("==")) {
					if(uvjet1 == uvjet2) {
						if(operacija.equals("dec")) {
							dec(s1, broj, map);
						}else if(operacija.equals("inc")) {
							inc(s1, broj, map);
						}
					}
				}
				if(odvojeni[5].equals("!=")) {
					if(uvjet1 != uvjet2) {
						if(operacija.equals("dec")) {
							dec(s1, broj, map);
						}else if(operacija.equals("inc")) {
							inc(s1, broj, map);
						}
					}
				}
				
				// read next line
				line = citaj.readLine();
			}
			citaj.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int max = 0;
		for (String key : map.keySet()) {
			if(map.get(key) > max) {
				max = map.get(key);
			}
		}
		System.out.println(max);
	}
	
	public static void inc(String a, int broj, Map map) {
		int brojcek = (int) map.get(a);
		map.put(a, broj + brojcek);
	}
	
	public static void dec(String a, int broj, Map map) {
		int brojcek = (int) map.get(a);
		map.put(a, brojcek - broj);
	}
	
}
