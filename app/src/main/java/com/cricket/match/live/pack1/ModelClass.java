package com.cricket.match.live.pack1;

public class ModelClass {

   String name;
    String imagelink;
    String age;
    String address;




    public ModelClass(String imagelink, String name, String address, String age) {
        this.imagelink = imagelink;
        this.name = name;
        this.address = address;
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
}