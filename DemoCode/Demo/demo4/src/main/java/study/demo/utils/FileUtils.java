package study.demo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FileUtils {
	
	public static JSONObject ListFile(File dir) {
		File[] files = dir.listFiles();

		JSONArray array = new JSONArray();
		for(int i=0;i<files.length;i++) {
			File curFile = files[i];
			
			if(curFile.getName().contains(".git"))continue;
			
			JSONObject curObj;
			if(curFile.isDirectory()) {
				curObj = ListFile(curFile);
			}else {
				curObj = new JSONObject();
				curObj.put("file", curFile.getName());
			}
			array.add(curObj);
		}
		JSONObject rootObj = new JSONObject();
		rootObj.put(dir.getName(), array);
		
		return rootObj;
	}

	public static String ReadFileToString(File file) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
		BufferedReader bufferedReader = new BufferedReader(isr);
		String strLine = "";
		StringBuilder sb = new StringBuilder();
		try {
			while ((strLine = bufferedReader.readLine()) != null) {
				sb.append(strLine+"\n");
			}
		} finally {
			bufferedReader.close();
		}
		return sb.toString();
	}
}
