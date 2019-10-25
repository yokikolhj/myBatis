package com.shirly.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author shirly
* @version 2019年7月17日 下午4:10:48
* 类说明
*/
public class setTest {

	public static void main(String[] args) throws FileNotFoundException {
//		Set<String> eles = new HashSet<>();
////		File file = new File("‪C:/tt.txt");
//		Scanner in = new Scanner(System.in);
//		while (in.hasNext()) {
//			String word = in.next();
//			eles.add(word);
//		}
//		System.out.println(eles);
		
		int count = 0;
        File f = new File("‪c:/tt.txt");
        String s = "";
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            while ((s=br.readLine())!=null) {
            	sb.append(s+'\n');
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");
        Matcher m = p.matcher(sb.toString());
        while (m.find()) {
            System.out.println(m.group());
            count++;
        }
        System.out.println("总共"+count+"个单词");
	}
}

