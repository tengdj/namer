package name;

import java.util.ArrayList;

public class Namer {
	
	public static void main(String args[]) {
		
		ArrayList<Phase> phases = new ArrayList<Phase>();
		SishuwujingLoader ssloader = new SishuwujingLoader();
		phases.addAll(ssloader.load("reference/sishuwujing.txt"));
		ChuciLoader ccloader = new ChuciLoader();
		phases.addAll(ccloader.load("reference/chuci.txt"));
		//ShijiLoader sjloader = new ShijiLoader();
		//phases.addAll(sjloader.load("reference/shiji.txt"));
		Query q = new Query();
		q.query(Util.teng, phases);

		//n.setOutput("out.txt");
//		Query q = new Query('Í¼', "ÉÏÉÐÚ¯Ô»");
//		q.query(phases);		
		
	}
	
}
