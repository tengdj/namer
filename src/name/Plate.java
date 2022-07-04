package name;

import java.util.ArrayList;

public class Plate {

	public static void main(String args[]) {
		ArrayList<String> lines = Util.read_file("plate.txt");
		System.out.println(lines.size()+" plate numbers are loaded");
		
		
		int min_number = 0;
		ArrayList<String> allowed_style = new ArrayList<String>();
//		allowed_style.add("LNNNNL");
//		allowed_style.add("LNNNLL");
//		allowed_style.add("LLNNNL");
//		allowed_style.add("LLLNNN");
		ArrayList<String> skipped = new ArrayList<String>();
		skipped.add("4");
		skipped.add("250");
		
		ArrayList<String> contained = new ArrayList<String>();
//		contained.add("103");
//		contained.add("127");
//		contained.add("312");
//		contained.add("208");
//		contained.add("315");
		contained.add("BJH");
		boolean keep_seq = false;
		for(String s:lines) {
			
			/* must follow some pattern */
			if(allowed_style.size()>0) {
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
			}
			
			/* skip some pattern */
			if(skipped.size()>0) {
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
			}
			
			/* at least some number of numbers*/
			if(min_number>0) {			
				int nc = 0;
				for(int j=0;j<s.length();j++) {
					if(s.charAt(j)>='0'&&s.charAt(j)<='9'){
						nc++;
					}
				}
				//System.out.println(nc);
				if(nc<min_number) {
					continue;
				}
			}
			
			
			/* must contain the query */
			if(contained.size()>0) {
				boolean valid = false;
				for(String query:contained) {
					if(keep_seq){
						if(s.contains(query)) {
							valid = true;
							break;
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
							valid = true;
							break;
						}
					}
				}
				if(!valid) {
					continue;
				}
			}
			
			System.out.println(s);
		}
		System.out.println("completed");
	}
	
	
}
