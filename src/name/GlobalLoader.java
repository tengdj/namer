package name;

import java.util.ArrayList;

public class GlobalLoader extends ScriptureLoader {
	String book_name = "";
	public GlobalLoader(String name) {
		book_name = name;
	}
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

			String ph[] = Util.split(line, separator);
			for(String p:ph) {
				if(!former.equals("нч")&&phases.size()>0) {
					//former's latter one is this one
					phases.get(phases.size()-1).latter = p;
				}
				Phase phase = new Phase();
				phase.former = former;
				phase.sentense = p;
				phase.from = book_name;
				phase.line = line_count;
				phases.add(phase);
				former = p;
			}
		}
		return this.phases;
	}
}
