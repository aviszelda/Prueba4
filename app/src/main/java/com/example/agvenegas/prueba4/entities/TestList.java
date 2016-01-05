package com.example.agvenegas.prueba4.entities;

import com.example.agvenegas.prueba4.utils.Constants;

/**
 * Created by agvenegas on 12/28/15.
 */
public class TestList {

    public TestList() {
        this.setName(null);
        this.setAge(null);
        this.setHometown(null);
    }

    public TestList (int imageID, String name, String age, String hometown) {
        super();
        this.setImageID(imageID);
        this.setName(name);
        this.setAge(age);
        this.setHometown(hometown);
    }

    private int imageID;
    public int getImageID() { return imageID; }
    public void setImageID(int value) { this.imageID = value; }

    private String name;
    public String getName() { return name; }
    public void setName(String value) { this.name = (value != null) ? value : Constants.EMPTY_STRING; }

    private String age;
    public String getAge() { return age; }
    public void setAge(String value) { this.age = (value != null) ? value : Constants.EMPTY_STRING; }

    private String hometown;
    public String getHometown() { return hometown; }
    public void setHometown(String value) { this.hometown = (value != null) ? value : Constants.EMPTY_STRING; }
}
