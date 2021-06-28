package name;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;

public class Query {

	boolean withcontext = false;
	public HashSet<Character> jin = new HashSet<Character>();
	public HashSet<Character> mu = new HashSet<Character>();
	public HashSet<Character> shui = new HashSet<Character>();
	public HashSet<Character> huo = new HashSet<Character>();
	public HashSet<Character> tu = new HashSet<Character>();
	public HashSet<Character> avoids = new HashSet<Character>();
	
	boolean hasjin = false;
	boolean hasmu = false;
	boolean hasshui = false;
	boolean hashuo = false;
	boolean hastu = false;
	
	public void setContext() {
		withcontext = true;
	}
	
	public void setJin() {
		hasjin = true;
	}
	public void setMu() {
		hasmu = true;
	}	
	public void setShui() {
		hasshui = true;
	}	
	public void sethuo() {
		hashuo = true;
	}
	public void setTu() {
		hastu = true;
	}
	public void addTarget(String q) {
		q = Util.keep_chinese(q);
		//out.println("query\t"+q);
		HashSet<Character> t = new HashSet<Character>();
		for(char v:q.toCharArray()) {
			t.add(v);
			alltarget.add(v);
		}
		target.add(t);
	}
	
	public void avoid(String avoid_string) {
		for(char avs:avoid_string.toCharArray()){
			avoids.add(avs);
		}
	}

	PrintStream out = System.out;
	ArrayList<HashSet<Character>> target = new ArrayList<HashSet<Character>>();
	HashSet<Character> alltarget = new HashSet<Character>();
	private void init() {
		String tmp = Util.read_chinese("pianpang/jin.txt");
		for(char v:tmp.toCharArray()) {
			jin.add(v);
		}
		tmp = Util.read_chinese("pianpang/mu.txt");
		for(char v:tmp.toCharArray()) {
			mu.add(v);
		}
		tmp = Util.read_chinese("pianpang/shui.txt");
		for(char v:tmp.toCharArray()) {
			shui.add(v);
		}
		tmp = Util.read_chinese("pianpang/huo.txt");
		for(char v:tmp.toCharArray()) {
			huo.add(v);
		}
		tmp = Util.read_chinese("pianpang/tu.txt");
		for(char v:tmp.toCharArray()) {
			tu.add(v);
		}
	}
	void turntowuxing() {
		jin.clear();
		mu.clear();
		shui.clear();
		huo.clear();
		tu.clear();
		String tmp = Util.read_chinese("wuxing/jin.txt");
		for(char v:tmp.toCharArray()) {
			jin.add(v);
		}
		tmp = Util.read_chinese("wuxing/mu.txt");
		for(char v:tmp.toCharArray()) {
			mu.add(v);
		}
		tmp = Util.read_chinese("wuxing/shui.txt");
		for(char v:tmp.toCharArray()) {
			shui.add(v);
		}
		tmp = Util.read_chinese("wuxing/huo.txt");
		for(char v:tmp.toCharArray()) {
			huo.add(v);
		}
		tmp = Util.read_chinese("wuxing/tu.txt");
		for(char v:tmp.toCharArray()) {
			tu.add(v);
		}
	}
	public Query() {
		init();
	}
	
	public boolean match(String sentense) {
		
		boolean matched = false;
		for(HashSet<Character> t:target) {
			boolean allfound = true;
			for(char ch:t) {
				boolean found = false;
				for(char cur:sentense.toCharArray()) {
					if(ch==cur) {
						found = true;
						break;
					}
				}
				if(!found) {
					allfound = false;
					break;
				}
			}
			if(allfound) {
				matched = true;
			}
			if(matched) {
				break;
			}
		}
		if(target.size()>0&&!matched) {
			return false;
		}
		
		if(hasjin) {
			boolean found = false;
			for(char cur:sentense.toCharArray()) {
				if(jin.contains(cur)) {
					found = true;
					break;
				}
			}
			if(!found) {
				return false;
			}
		}
		if(hasmu) {
			boolean found = false;
			for(char cur:sentense.toCharArray()) {
				if(mu.contains(cur)) {
					found = true;
					break;
				}
			}
			if(!found) {
				return false;
			}
		}
		if(hasshui) {
			boolean found = false;
			for(char cur:sentense.toCharArray()) {
				if(shui.contains(cur)) {
					found = true;
					break;
				}
			}
			if(!found) {
				return false;
			}
		}
		if(hashuo) {
			boolean found = false;
			for(char cur:sentense.toCharArray()) {
				if(huo.contains(cur)) {
					found = true;
					break;
				}
			}
			if(!found) {
				return false;
			}
		}
		if(hastu) {
			boolean found = false;
			for(char cur:sentense.toCharArray()) {
				if(tu.contains(cur)) {
					found = true;
					break;
				}
			}
			if(!found) {
				return false;
			}
		}
		return true;
	}
	
	public String formalize(Phase phase) {
		String p = phase.from+"("+phase.line+")\t";
		if(withcontext) {
			p += "("+phase.former+"\t";
		}
		int len = phase.sentense.length();
		for(int j=0;j<len;j++) {
			char cur = phase.sentense.charAt(j);			
			if(alltarget.contains(cur)) {
				if((j==0||!avoids.contains(phase.sentense.charAt(j-1)))&&
						((j==len-1)||!avoids.contains(phase.sentense.charAt(j+1)))) {
					p += "["+cur+"]";
				}else {
					p += cur;
				}
			}else if(hasjin&&jin.contains(cur)) {
				p += "[j"+cur+"j]";
			}else if(hasmu&&mu.contains(cur)) {
				p += "[m"+cur+"m]";
			}else if(hasshui&&shui.contains(cur)) {
				p += "[s"+cur+"s]";
			}else if(hashuo&&huo.contains(cur)) {
				p += "[h"+cur+"h]";
			}else if(hastu&&tu.contains(cur)) {
				p += "[t"+cur+"t]";
			}else {	
				p += cur;
			}
		}
		if(withcontext) {
			p += "\t"+phase.latter+")";
		}
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
		int count = 0;
		for(int i=0;i<phases.size();i++) {
			if(match(phases.get(i).sentense)) {
				count++;
				out.print(count+"\t");
				out.println(formalize(phases.get(i)));
			}
		}
	}
}
