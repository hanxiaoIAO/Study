package com.testjpa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.testjpa.dao.FileInfo;
import com.testjpa.service.FileService;
import com.testjpa.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FileSystemController {
    @Autowired
    FileService fileService;

    @RequestMapping(path = "/addFile",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void save(@RequestBody String requestBody){
        fileService.save(requestBody);
    }

    @RequestMapping(path = "/findFile",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String find(){
        List<FileInfo> fileInfoList = fileService.findAll();
        JSONArray jsonArray = new JSONArray();
        for(FileInfo fileInfo:fileInfoList){
            JSONObject obj = new JSONObject();
            obj.put("id",fileInfo.getId());
            obj.put("name",fileInfo.getFilename());
            obj.put("tag",fileInfo.getTagStr());

            jsonArray.add(obj);
        }
        return jsonArray.toJSONString();
    }
}
