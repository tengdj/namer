package name;

import java.util.ArrayList;

public abstract class ScriptureLoader {
	protected String separator =  "£»£¿¡££¡£¬?¡¢¡®¡¯¡°¡±£º";
	ArrayList<Phase> phases = new ArrayList<Phase>();
	protected String former = "ÎÞ";
	public abstract ArrayList<Phase> load(String path) ;
	public void setSeparator(String sep) {
		separator = sep;
	}

}
