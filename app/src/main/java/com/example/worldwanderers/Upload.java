package com.example.worldwanderers;

public class Upload {
    private String name;
    private String imageUri;
    private String location;
    private String date;
    private String tag;


    public Upload(String name, String imageUrl, String location,String date, String tag) {
        if (name.trim().equals("")) {name="No name";}
        this.name = name;
        if (location.trim().equals("")){location="No location";}
        this.location = location;
        this.imageUri = imageUrl;
        if (tag.trim().equals("")){tag="No tag";}
        this.tag = tag;
        if (date.trim().equals("")){date="No date";}
        this.date = date;




    }

    public String getName() {
        return name;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}

