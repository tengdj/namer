package name;

import java.util.ArrayList;

public class Namer {
	
	public static void main(String args[]) {
//		
//		ArrayList<Phase> phases = new ArrayList<Phase>();
//		SishuwujingLoader ssloader = new SishuwujingLoader();
//		phases.addAll(ssloader.load("reference/sishuwujing.txt"));
//		ChuciLoader ccloader = new ChuciLoader();
//		phases.addAll(ccloader.load("reference/chuci.txt"));
//		ShijiLoader sjloader = new ShijiLoader();
//		phases.addAll(sjloader.load("reference/shiji.txt"));
//		GlobalLoader zjtjloader = new GlobalLoader("����ͨ��");
//		phases.addAll(zjtjloader.load("reference/zizhitongjian.txt"));
//		GlobalLoader tsloader = new GlobalLoader("ȫ��ʫ");
//		phases.addAll(tsloader.load("reference/tangshi.txt"));
//		GlobalLoader scloader = new GlobalLoader("ȫ�δ�");
//		phases.addAll(scloader.load("reference/songci.txt"));
//		Query q = new Query();
//		//q.turntowuxing();
//		//q.setOutput("C:\\Users\\admin\\Desktop\\name.txt");
//		//q.sethuo();
//		//q.setShui();
//		//q.setJin();
//		//q.setTu();
//		//q.setMu();
//		//q.addTarget("����");
//		q.addTarget("�ѻ�");
//		q.query(phases);
//
////		Query q = new Query('��', "����گԻ");
////		q.query(phases);	
		
		for(int i=1;i<100000;i++) {
			double v = i*0.86243549292146;
			if(v-(int)v<0.0001) {
				System.out.println(i+" "+v);
			}
		}
	}
	
}
