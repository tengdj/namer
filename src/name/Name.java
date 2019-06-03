package name;

import java.util.ArrayList;
import java.util.HashSet;

public class Name {
	
	public void query(String q, ArrayList<Phase> phases) {
		System.out.println("query\t"+q);
		HashSet<Character> set=new HashSet<Character>();  
		q = Util.keep_chinese(q);
		for(int i=0;i<q.length();i++) {
			set.add(q.charAt(i));
		}
		int count = 0;
		for(int i=0;i<phases.size();i++) {
			if(phases.get(i).match(set)) {
				count++;
				System.out.print(count+"\t");
				System.out.println(phases.get(i).toString(set));
			}
		}
	}

	public static void main(String args[]) {
		String teng = "ºêÍ¼Ôó»ÁÊé½úÒæ";
		Name n = new Name();
		ArrayList<Phase> phases = new ArrayList<Phase>();
		SishuwujingLoader ssloader = new SishuwujingLoader();
		phases.addAll(ssloader.load("reference/sishuwujing.txt"));
		ChuciLoader ccloader = new ChuciLoader();
		phases.addAll(ccloader.load("reference/chuci.txt"));
		n.query(teng, phases);
	}
	
}
