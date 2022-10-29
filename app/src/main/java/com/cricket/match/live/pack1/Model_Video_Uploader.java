package com.cricket.match.live.pack1;

public class Model_Video_Uploader {
    String title,vurl;

    public Model_Video_Uploader() {
    }

    public Model_Video_Uploader(String title, String vurl) {
        this.title = title;
        this.vurl = vurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }
}
