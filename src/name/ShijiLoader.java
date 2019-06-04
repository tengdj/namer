package name;

import java.util.ArrayList;

public class ShijiLoader extends ScriptureLoader {
	

	@Override
	public ArrayList<Phase> load(String path) {
		ArrayList<String> lines = Util.read_file(path);
		String cur_from = "";
		for(int line_count=0;line_count<lines.size();line_count++){
			String line = lines.get(line_count);
		
			//title
			if(line.length()>1 && !line.startsWith(" ") && !line.startsWith("\t")) {
				cur_from = "史记："+line;
				former = "无";
				continue;
			}
			String ph[] = Util.split(line, separator);
			for(String p:ph) {
				if(!former.equals("无")&&phases.size()>0) {
					//former's latter one is this one
					phases.get(phases.size()-1).latter = p;
				}
				Phase phase = new Phase();
				phase.former = former;
				phase.sentense = p;
				phase.from = cur_from;
				phase.line = line_count;
				phases.add(phase);
				former = p;
			}
		}
		return phases;
	}
	
}
