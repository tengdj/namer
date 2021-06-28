package name;

import java.util.ArrayList;

public class Namer {
	
	public static void main(String args[]) {
		
		ArrayList<Phase> phases = new ArrayList<Phase>();
		SishuwujingLoader ssloader = new SishuwujingLoader();
		phases.addAll(ssloader.load("reference/sishuwujing.txt"));
		ChuciLoader ccloader = new ChuciLoader();
		phases.addAll(ccloader.load("reference/chuci.txt"));
//		ShijiLoader sjloader = new ShijiLoader();
//		phases.addAll(sjloader.load("reference/shiji.txt"));
//		GlobalLoader zjtjloader = new GlobalLoader("资治通鉴");
//		phases.addAll(zjtjloader.load("reference/zizhitongjian.txt"));
		GlobalLoader tsloader = new GlobalLoader("全唐诗");
		phases.addAll(tsloader.load("reference/tangshi.txt"));
		GlobalLoader scloader = new GlobalLoader("全宋词");
		phases.addAll(scloader.load("reference/songci.txt"));
		Query q = new Query();
		//q.setOutput("C:\\Users\\admin\\Desktop\\name.txt");
		q.query("国生", phases);

//
//		Query q = new Query('书', "上尚诏曰");
//		q.query(phases);		
	}
	
}
