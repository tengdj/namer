package name;

import java.util.ArrayList;

public class Plate {

	public static void main(String args[]) {
		ArrayList<String> lines = Util.read_file("plate.txt");
		
		
		int min_number = 3;
		String allowed_style[] = {
				"LNNNNL", 
				"LNNNLL",
				"LLNNNL"
				};
		String skipped[] = {"4", "250"};
		String query = "103";
		boolean keep_seq = true;
		for(String s:lines) {
			boolean isallowed = false;
			for(String a:allowed_style) {
				boolean al = true;
				for(int i=0;i<a.length();i++) {
					if(a.charAt(i)=='L'&&(s.charAt(i)>='0'&&s.charAt(i)<='9')) {
						al = false;
						break;
					}
					if(a.charAt(i)=='N'&&(s.charAt(i)<'0'||s.charAt(i)>'9')) {
						al = false;
						break;
					}
				}
				if(al) {
					isallowed = true;
				}
			}
			
			if(!isallowed) {
				continue;
			}
			
			boolean issk = false;
			for(String sk:skipped) {
				if(s.contains(sk)) {
					issk = true;
					break;
				}
			}
			
			if(issk) {
				continue;
			}
			int nc = 0;
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)>='0'&&s.charAt(j)<='9'){
					nc++;
				}
			}
			if(nc<min_number) {
				continue;
			}
			
			if(keep_seq){
				if(s.contains(query)) {
					System.out.println(s);
				}
			}else {
				int cnum = 0;
				for(int i=0;i<query.length();i++) {
					for(int j=0;j<s.length();j++) {
						if(query.charAt(i)==s.charAt(j)) {
							cnum++;
							break;
						}
					}
				}
				if(cnum==query.length()) {
					System.out.println(s);
				}
			}

		}
	}
	
}
