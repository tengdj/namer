package name;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Util {
	public static boolean is_chinese(char ch) {
		return ch>=19968&&ch<40869;
	}
	public static boolean is_chinese_delimiter(char ch) {
		return ch=='��'||ch=='��'||ch=='��'||ch=='��';
	}
	public static boolean is_chinese_symbol(char ch) {
		return ch=='��'||ch=='��'||ch=='��'||ch=='��'||ch=='��'||ch=='��'||ch=='��'||ch=='��';
	}
	public static String keep_chinese(String s) {
		String ret = "";
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(is_chinese_symbol(ch)||is_chinese(ch)) {
				ret += s.charAt(i);
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
}
