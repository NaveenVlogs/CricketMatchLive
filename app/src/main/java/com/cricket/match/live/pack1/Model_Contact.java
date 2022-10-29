package com.cricket.match.live.pack1;

public class Model_Contact {

    int image,contact;
    String name;

    public Model_Contact(int image, int contact, String name) {
        this.image = image;
        this.contact = contact;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
