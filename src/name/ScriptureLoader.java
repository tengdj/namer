package name;

import java.util.ArrayList;

public abstract class ScriptureLoader {
	ArrayList<Phase> phases = new ArrayList<Phase>();
	protected String former = "нч";
	public abstract ArrayList<Phase> load(String path) ;

}
