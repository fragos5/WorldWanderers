package com.example.worldwanderers;

public class Upload {
    private String name;
    private String imageUrl;
// ToDo: tha mpoun ki alla private pragmata px sintetagmenes tags ktlp

    public Upload() {
        //empty
    }
    public Upload(String name, String imageUrl) {
        if (name.trim().equals("")) {
            name="No name";
        }
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

