package name;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Util {
	public static String teng = "ºêÍ¼Ôó»ÁÊé½úÒæ";
	public static String symbol = "£¿£»¡££¡£¬?¡¢¡®¡¯¡°¡±£º©p¡¾¡¿{}£¨£©¡·¡¶££*¡ö;#&";
	public static boolean is_chinese(char ch) {
		return ch>=19968&&ch<40869;
	}
	public static boolean is_chinese_symbol(char ch) {
		for(char c:symbol.toCharArray()) {
			if(c==ch) {
				return true;
			}
		}
		return false;
		//return ch=='£¬'||ch=='£º'||ch=='£»'||ch=='£¿'||ch=='¡£'||ch=='¡¾'||ch=='¡¿'||ch=='£¡';
	}
	public static String keep_chinese(String s) {
		String ret = "";
		for(char ch:s.toCharArray()) {
			if(is_chinese_symbol(ch)||is_chinese(ch)) {
				ret += ch;
			}
		}
		return ret;
	}
	//read all the lines in the file
	public static ArrayList<String> read_file(String path){
		ArrayList<String> ret = new ArrayList<String>();
		try {
			File file = new File(path);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				ret.add(line);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public static String read_chinese(String path) {
		ArrayList<String> lines = read_file(path);
		String ret = "";
		for(String line:lines) {
			for(int i=0;i<line.length();i++) {
				if(is_chinese(line.charAt(i))) {
					ret += line.charAt(i);
				}
			}
		}
		return ret;
	}
	
	public static String[] split(String line, String delimiters) {
		StringTokenizer multiTokenizer = new StringTokenizer(line, delimiters);
		ArrayList<String> rets = new ArrayList<String>();
		while (multiTokenizer.hasMoreTokens()){
			rets.add(multiTokenizer.nextToken());
		}
		String ret_string[] = new String[rets.size()];
		for(int i=0;i<rets.size();i++) {
			ret_string[i] = rets.get(i);
		}
		return ret_string;
	}
}
