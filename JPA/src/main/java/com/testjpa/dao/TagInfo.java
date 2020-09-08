package com.testjpa.dao;

import javax.persistence.*;

@Entity(name="taginfo")
public class TagInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
//    private int fileID;
    private String tag;

    public FileInfo getFile() {
        return file;
    }

    public void setFile(FileInfo file) {
        this.file = file;
    }

    @ManyToOne
    @JoinColumn(name="fildid")
    private FileInfo file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getFileID() {
//        return fileID;
//    }
//
//    public void setFileID(int fileID) {
//        this.fileID = fileID;
//    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
