package com.wenzs.jokeintefacetest;

/**
 * Created by Administrator on 2016/6/19.
 */
public class Joke_contentlist {
    private String id;
    private String title;
    private String img;
    private int type;
    private String ct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    @Override
    public String toString() {
        return "Joke_contentlist{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", type=" + type +
                ", ct='" + ct + '\'' +
                '}';
    }
}
