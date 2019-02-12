package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.naming.CommunicationException;

/**
 * 找出小说《我的26岁女房客》中出现的歌名
 * 
 * @date 2018年3月19日 下午6:49:37
 * @author jianxinliu
 */
public class Util {

	static int count = 0;
	static int mode = 0;
	static char[] buff = new char[1024];

	static Set<String> result = new LinkedHashSet<String>(0);
	static String filepath = "../res/res.txt";
	static File file = new File(filepath);

	/**
	 * 读取文件并调用相应的方法
	 */
	static void get() {
		InputStream is = null;
		InputStreamReader isr = null;
		try {
			is = new FileInputStream(file);
			isr = new InputStreamReader(is);
			int count = 0;
			while ((count = isr.read(buff)) != -1) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < buff.length; i++) {
					sb.append(buff[i]);
				}
				searchName(sb.toString());

				// 乐瑶：3372
				// 米彩：8501
				// 简薇：3386
				// 烟:2172
				// 罗本：2188
				// 方圆：2121
				// 向晨：511
				// CC:1787
				// 昭阳：1853
				// count(sb.toString(), "米彩");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (isr != null)
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	/**
	 * 从元文本中统计出目标文本出现的次数
	 * 
	 * @param source 源文本
	 * @param tar    目标文本
	 */
	static void count(String source, String tar) {
		char start = tar.charAt(0);
		for (int i = 0; i < source.length(); i++) {
			if (source.charAt(i) == start) {
				if (tar.length() == 1) {
					count++;
				} else {
					int j = 0, k = i;
					for (; j < tar.length(); k++, j++) {
						try {
							if (source.charAt(k) != tar.charAt(j))
								break;
						} catch (Exception e) {
							continue;
						}
					}
					if (j == tar.length()) {
						count++;
					}
				}
			}
		}
	}

	/**
	 * 找出出现的歌名
	 * 
	 * @param s
	 */
	static void searchName(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int end = 0;
			if (s.charAt(i) == '《') {
				// 处理可能的演唱者
				/*
				 * if(s.charAt(i-1) == '的'){ sb.append(s.substring(i-1-8,i)); sb.append("-"); }
				 */

				// 提取歌名
				for (int j = i; j < s.length(); j++) {
					if (s.charAt(j) == '》') {
						end = j;
						break;
					}
				}
				sb.append(s.substring(i, end + 1));
				result.add(sb.toString());
				sb.delete(0, sb.length());
			}
		}
	}

	/*
	 * static void count(String item){ HashMap<Character, Integer> map = new
	 * HashMap<Character, Integer>(0); for (int i = 0; i < item.length(); i++) { int
	 * count = 0; for (int j = 0; j < item.length(); j++) { if(item.charAt(j) ==
	 * item.charAt(i)){ count++; } } map.put(item.charAt(i),count); count = 0; }
	 * 
	 * }
	 */

	public static void main(String[] args) {
		get();
		Iterator<String> it = result.iterator();
		System.out.println(result.size());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println(count);
	}
}
