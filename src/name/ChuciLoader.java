package name;

import java.util.ArrayList;

public class ChuciLoader extends ScriptureLoader {
	//read from the chuci.txt
	@Override
	public ArrayList<Phase> load(String path) {
		ArrayList<String> lines = Util.read_file(path);
		int line_count = 0;
		for(String line:lines) {
			line_count++;
			line = Util.keep_chinese(line);
			if(line.length()==0) {
				continue;
			}

			String ph[] = line.split("[£»£¿¡££¡]");
			for(String p:ph) {
				if(!former.equals("ÎÞ")&&phases.size()>0) {
					//former's latter one is this one
					phases.get(phases.size()-1).latter = p;
				}
				Phase phase = new Phase();
				phase.former = former;
				phase.sentense = p;
				phase.from = "³þ´Ç";
				phase.line = line_count;
				phases.add(phase);
				former = p;
			}
		}
		return this.phases;
	}
}
