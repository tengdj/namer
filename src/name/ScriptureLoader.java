package name;

import java.util.ArrayList;

public abstract class ScriptureLoader {
	protected String separator =  Util.symbol;
	ArrayList<Phase> phases = new ArrayList<Phase>();
	protected String former = "нч";
	public abstract ArrayList<Phase> load(String path) ;
	public void setSeparator(String sep) {
		separator = sep;
	}

}
