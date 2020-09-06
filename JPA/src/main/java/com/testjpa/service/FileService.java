package com.testjpa.service;

import com.testjpa.dao.FileInfo;
import com.testjpa.dao.FileInfoResposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    @Autowired
    FileInfoResposition fileInfoResposition;

    public List<FileInfo> findAll(){
        return fileInfoResposition.findAll();
    }

    public void save(List<FileInfo> fileInfoList){
        fileInfoResposition.save(fileInfoList);
        fileInfoResposition.flush();
    }
}
