package com.proinnova.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenEntity {
	
	private static String entityName = "cashflowSendLogEntity";
	private static String excelPath = "C:\\Users\\hanxu\\Desktop\\test.xlsx";
	
	private static int fieldKeyIndex = 0;
	private static int messageIndex = 1;
	private static int typeIndex = 2;
	
	public static void main(String args[]) throws Throwable {
			FileInputStream fs = new FileInputStream(excelPath);
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fs);
			//读取第一个工作表
			XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
			Map<String,List<String>> map = new HashMap<>();
			Map<String,String> importMap = new HashMap<>();
			int maxRowIndex = sheet.getLastRowNum();
			for (int rowIndex = 1; rowIndex <= maxRowIndex; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);
				String fieldKey = row.getCell(fieldKeyIndex).getStringCellValue();
				String message = row.getCell(messageIndex).getStringCellValue();
				String type = transToFieldType(row.getCell(typeIndex).getStringCellValue());
				List<String> info = new ArrayList<String>();
				info.add(type);
				info.add(message);
				dealImport(importMap,type);
				map.put(fieldKey, info);
			}
			genEntity(entityName,new ArrayList<String>(importMap.values()),map);
			xssfWorkbook.close();
			
			System.out.println("run done");
		}

	//fields	{fieldKey,fieldType}
	public static void genEntity(String entityName,List<String> importList,Map<String,List<String>> fields) throws Throwable {
		StringBuilder sb = new StringBuilder();
		sb.append("package com.proinnova.entity;").append("\n");
		sb.append("\n");
		for(String importClass:importList) {
			sb.append("import ").append(importClass).append(";").append("\n");
		}
		sb.append("\n");
		sb.append("public class ").append(entityName).append(" {").append("\n");
		Iterator<Entry<String, List<String>>> it = fields.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, List<String>> entry = it.next();
			String fieldKey = entry.getKey();
			List<String> info = entry.getValue();
			String fieldType = info.get(0);
			String message = info.get(1);
			if(!org.springframework.util.StringUtils.isEmpty(message)) {
				sb.append("\t/*\n");
				sb.append("\t *").append(message).append("\n");
				sb.append("\t */\n");
			}
			//field
			sb.append("\tprivate ").append(fieldType).append(" ").append(fieldKey).append(";").append("\n");
			sb.append("\n");
			//get
			sb.append("\tpublic ").append(fieldType).append(" get").append(StringUtils.captureName(fieldKey)).append("(){").append("\n");
			sb.append("\t\treturn ").append(fieldKey).append(";\n");
			sb.append("\t}").append("\n");
			sb.append("\n");
			//set
			sb.append("\tpublic void set").append(StringUtils.captureName(fieldKey)).append("(").append(fieldType).append(" ").append(fieldKey).append("){").append("\n");
			sb.append("\t\tthis.").append(fieldKey).append(" = ").append(fieldKey).append(";").append("\n");
			sb.append("\t}").append("\n");
			sb.append("\n");
		}
		
		sb.append("}");
		
		//生成文件
		String path = System.getProperty("user.dir")+"/src/main/java/com/proinnova/entity/"+entityName+".java";
		FileUtils.WriteToFile(sb.toString(), path);
	}
	
	private static void dealImport(Map<String,String> importMap,String type) throws Throwable {
		if(importMap.containsKey(type)) {
			return;
		}
		
		switch(type) {
		case "BigDecimal":
			importMap.put("BigDecimal", "java.math.BigDecimal");
			break;
		case "LocalDateTime":
			importMap.put("LocalDateTime", "java.time.LocalDateTime");
			break;
		default:
			return;
		}
		
	}

	private static String transToFieldType(String type) {
		String fieldType = "Object";
		if(type.toLowerCase().contains("varchar")) {
			fieldType = "String";
		}
		if(type.toLowerCase().contains("decimal")) {
			fieldType = "BigDecimal";
		}
		if(type.toLowerCase().contains("datetime")) {
			fieldType = "LocalDateTime";
		}
		if(type.toLowerCase().contains("int")) {
			fieldType = "Integer";
		}
		
		return fieldType;
	}

}
