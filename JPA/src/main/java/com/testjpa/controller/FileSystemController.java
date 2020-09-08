package com.testjpa.controller;

import com.testjpa.service.FileService;
import com.testjpa.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileSystemController {
    @Autowired
    FileService fileService;

    @RequestMapping(path = "/addFile",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void save(@RequestBody String requestBody){
        fileService.save(requestBody);
    }
}
