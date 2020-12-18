package study.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.demo.utils.FileUtils;

@Controller
@PropertySource("classpath:application.yml")//读取application.yml文件
public class GetController {
	@Value(value = "${rootDir}")
	String dir;
	
	@RequestMapping("/")
	public String index() throws IOException {
		return "/index.html";
	}
	
	@RequestMapping("/listFile")
	@ResponseBody
	public String listFile() throws IOException {
		File file = new File(dir);
		return FileUtils.ListFile(file).toString();
	}
	
	@RequestMapping("/getFile")
	@ResponseBody
	public String getFile(@RequestBody Map<String, Object> map) throws IOException {
		String filePath = dir+map.get("fileName");
		File file = new File(filePath);
		return FileUtils.ReadFileToString(file);
	}

}
