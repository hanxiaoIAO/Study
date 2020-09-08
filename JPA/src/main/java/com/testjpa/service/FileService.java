package com.testjpa.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.testjpa.dao.FileInfo;
import com.testjpa.dao.FileInfoResposition;
import com.testjpa.dao.TagInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    @Autowired
    FileInfoResposition fileInfoResposition;

    public List<FileInfo> findAll(){
        return fileInfoResposition.findAll();
    }

    public void save(String dataStr){
        JSONArray jsonArray = (JSONArray) JSON.parse(dataStr);
        List<FileInfo> fileInfoList = new ArrayList<>();
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            FileInfo fileInfo  = new FileInfo();
            fileInfo.setFilename(jsonObject.getString("name"));
            fileInfo.setPath(jsonObject.getString("path"));
            fileInfo.setType(jsonObject.getString("type"));
            String tagStr = jsonObject.getString("tag");
            if(tagStr!=null){
                String[] tags = tagStr.split(",");
                List<TagInfo> tagInfoList = new ArrayList<>();
                for(String tag:tags){
                    TagInfo tagInfo = new TagInfo();
                    tagInfo.setFile(fileInfo);
                    tagInfo.setTag(tag);
                    tagInfoList.add(tagInfo);
                }
                fileInfo.setTagList(tagInfoList);
            }
            fileInfoList.add(fileInfo);
        }
        fileInfoResposition.save(fileInfoList);
//        fileInfoResposition.flush();
    }

    public void save(List<FileInfo> fileInfoList){
        fileInfoResposition.save(fileInfoList);
        fileInfoResposition.flush();
    }
}
