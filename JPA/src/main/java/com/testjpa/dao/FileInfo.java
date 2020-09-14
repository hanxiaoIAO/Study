package com.testjpa.dao;

import javax.persistence.*;
import java.util.List;

@Entity(name="fileinfo")
public class FileInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private String filename;
    private String type;
    private String path;

    public List<TagInfo> getTagList() {
        return tagList;
    }

    public String getTagStr(){
        StringBuilder sb = new StringBuilder();
        for(TagInfo tag:tagList){
            sb.append(" ");
            sb.append("#");
            sb.append(tag.getTag());
        }
        return sb.toString().substring(1);
    }

    public void setTagList(List<TagInfo> tagList) {
        this.tagList = tagList;
    }

    @OneToMany(mappedBy="file",cascade=CascadeType.ALL)
    private List<TagInfo> tagList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
