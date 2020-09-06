package com.testjpa.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="taginfo")
public class TagInfo {
    @Id
    private int id;
    private int fileID;
    private String tag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
