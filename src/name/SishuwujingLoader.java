package name;

import java.util.ArrayList;

public class SishuwujingLoader extends ScriptureLoader {
	int start[] = {15,221,3342,8559,9072,9892,10831,12221,12781};
	String book_names[]= {"大学","孟子","论语","中庸","春秋","礼记","周易","尚书","诗经"};
	public enum book{
		DAXUE,MENGZI,LUNYU,ZHONGYONG,
		CHUNQIU,LIJI,ZHOUYI,SHANGSHU,SHIJING
	};
	String judge_sishuwujing(int line_num) {
		assert line_num>0;
		for(int i=8;i>=0;i--) {
			if(line_num>start[i]) {
				return book_names[i];
			}
		}
		return book_names[0];
	}
	@Override
	public ArrayList<Phase> load(String path) {
		former = "无";
		boolean in_yuanwen = false;
		ArrayList<String> lines = Util.read_file(path);
		int line_count = 0;
		for(String line:lines) {
			line_count++;
			line = Util.keep_chinese(line);
			if(line.length()==0) {
				continue;
			}
			if(line.charAt(0)=='【') {
				if(line.equals("【原文】")) {
					in_yuanwen = true;
					continue;
				}else{
					in_yuanwen = false;
					former = "无";
				}
			}
			if(in_yuanwen) {
				String ph[] = line.split("[；？。！]");
				for(String p:ph) {
					if(!former.equals("无")&&phases.size()>0) {
						//former's latter one is this one
						phases.get(phases.size()-1).latter = p;
					}
					Phase phase = new Phase();
					phase.former = former;
					phase.sentense = p;
					phase.from = judge_sishuwujing(line_count);
					phase.line = line_count;
					phases.add(phase);
					former = p;
				}
				//System.out.println(cur);
			}	
		}
		return phases;
	}
}
