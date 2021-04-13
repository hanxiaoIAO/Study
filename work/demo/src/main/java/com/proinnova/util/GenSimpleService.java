package com.proinnova.util;

public class GenSimpleService {
	
	public static void genJavaFrame(String name) throws Throwable {
		genDao(name);
		genDaoXML(name);
		genService(name);
	}

	private static void genDaoXML(String name) throws Throwable {
		String captureName = StringUtils.captureName(name);
		StringBuilder sb = new StringBuilder();
		
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
		sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n");
		sb.append("\t\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
		
		sb.append("<mapper namespace=\"com.proinnova.dao.").append(captureName).append("Mapper\">\n");
		sb.append("</mapper>");
		
		//生成文件
		String path = System.getProperty("user.dir")+"/src/main/java/com/proinnova/dao/"+captureName+"Mapper.xml";
		FileUtils.WriteToFile(sb.toString(), path);
	}

	private static void genDao(String name) throws Throwable {
		String captureName = StringUtils.captureName(name);
		StringBuilder sb = new StringBuilder();
		
		sb.append("package com.proinnova.dao;\n");
		sb.append("\n");
		
		sb.append("import org.springframework.stereotype.Repository;\n");
		sb.append("\n");
		
		sb.append("@Repository\n");
		sb.append("public interface ").append(captureName).append("Mapper {");
		sb.append("\n");
		sb.append("}");
		
		//生成文件
		String path = System.getProperty("user.dir")+"/src/main/java/com/proinnova/dao/"+captureName+"Mapper.java";
		FileUtils.WriteToFile(sb.toString(), path);		
	}

	private static void genService(String name) throws Throwable {
		String captureName = StringUtils.captureName(name);
		StringBuilder sb = new StringBuilder();
		
		sb.append("package com.proinnova.service;\n");
		sb.append("\n");
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.springframework.stereotype.Service;\n");
		sb.append("\n");
		sb.append("import com.proinnova.dao.").append(captureName).append("Mapper;\n");
		sb.append("\n");
		
		sb.append("@Service\n");
		sb.append("public class ").append(captureName).append("Service {\n");
		sb.append("\n");
		sb.append("\t").append("@Autowired\n");
		sb.append("\t").append("private ").append(captureName).append("Mapper ").append(name).append("Mapper;\n");
		sb.append("\n");
		sb.append("}");
		
		//生成文件
		String path = System.getProperty("user.dir")+"/src/main/java/com/proinnova/service/"+captureName+"Service.java";
		FileUtils.WriteToFile(sb.toString(), path);
	}
	
	public static void main(String args[]) throws Throwable {
		genJavaFrame("role");
	}

}
