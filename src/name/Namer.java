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
//		GlobalLoader zjtjloader = new GlobalLoader("����ͨ��");
//		phases.addAll(zjtjloader.load("reference/zizhitongjian.txt"));
		GlobalLoader tsloader = new GlobalLoader("ȫ��ʫ");
		phases.addAll(tsloader.load("reference/tangshi.txt"));
		GlobalLoader scloader = new GlobalLoader("ȫ�δ�");
		phases.addAll(scloader.load("reference/songci.txt"));
		Query q = new Query();
		//q.setOutput("C:\\Users\\admin\\Desktop\\name.txt");
		q.query("����", phases);

//
//		Query q = new Query('��', "����گԻ");
//		q.query(phases);		
	}
	
}
