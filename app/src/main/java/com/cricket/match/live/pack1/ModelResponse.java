package com.cricket.match.live.pack1;

public class ModelResponse {

    String address;
    String age;
    String imagelink;
    String name;

    public ModelResponse() {
    }

    public ModelResponse(String address, String age, String imagelink, String name) {
        this.address = address;
        this.age = age;
        this.imagelink = imagelink;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
