package name;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;

public class Query {
	PrintStream out = System.out;
	public char target = ' ';
	public HashSet<Character> avoids = new HashSet<Character>();
	public Query(char ch, String avoid_string) {
		target = ch;
		for(char avs:avoid_string.toCharArray()){
			avoids.add(avs);
		}
	}
	public Query() {
	}
	
	public boolean match(String sentense) {
		int len = sentense.length();
		for(int j=0;j<len;j++) {
			char cur = sentense.charAt(j);
			if(cur!=target) {
				continue;
			}
			// this sentence matches the target
			if((j==0||!avoids.contains(sentense.charAt(j-1)))&&
					((j==len-1)||!avoids.contains(sentense.charAt(j+1)))) {
				return true;
			}
		}
		return false;
	}
	
	public String formalize(Phase phase) {
		String p = phase.from+"("+phase.line+")\t("+phase.former+"\t";
		int len = phase.sentense.length();
		for(int j=0;j<len;j++) {
			char cur = phase.sentense.charAt(j);
			if(cur!=target) {
				p += cur;
				continue;
			}
			if((j==0||!avoids.contains(phase.sentense.charAt(j-1)))&&
					((j==len-1)||!avoids.contains(phase.sentense.charAt(j+1)))) {
				p += "["+cur+"]";
			}else {
				p += cur;
			}
		}
		p += "\t"+phase.latter+")";
		return p;
	}
	
	public void setOutput(String path) {
		try {
			out = new PrintStream(new File(path));
		} catch (FileNotFoundException e) {
			out = System.out;
			e.printStackTrace();
		}
	}
	
	public void query(ArrayList<Phase> phases) {
		out.println("query\t"+target);
		int count = 0;
		for(int i=0;i<phases.size();i++) {
			if(match(phases.get(i).sentense)) {
				count++;
				out.print(count+"\t");
				out.println(formalize(phases.get(i)));
			}
		}
	}
	
	public void query(String q, ArrayList<Phase> phases) {
		q = Util.keep_chinese(q);
		for(char ch:q.toCharArray()) {
			this.target = ch;
			query(phases);
		}
	}
}