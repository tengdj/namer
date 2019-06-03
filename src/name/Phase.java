package name;

import java.util.HashSet;

public class Phase {
	public String sentense;
	public String former;
	public String latter;
	public String from;
	public int line;
	public Phase() {
		sentense = "";
		former = "нч";
		latter = "нч";
		from = "";
		line = 0;
	}
	public boolean match(HashSet<Character> map) {
		for(int j=0;j<sentense.length();j++) {
			if(map.contains(sentense.charAt(j))) {
				return true;
			}
		}
		return false;
	}
	
	public String toString(HashSet<Character> map) {
		String p = from+"("+line+")\t"+former+"\t";
		for(int j=0;j<sentense.length();j++) {
			char cur = sentense.charAt(j);
			if(map.contains(cur)) {
				p += "["+cur+"]";
			}else {
				p += cur;
			}
		}
		p += "\t"+latter;
		return p;
	}
}
