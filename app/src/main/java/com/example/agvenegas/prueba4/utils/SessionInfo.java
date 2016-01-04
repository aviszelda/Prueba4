package com.example.agvenegas.prueba4.utils;

import com.example.agvenegas.prueba4.entities.TestList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agvenegas on 12/30/15.
 */
public class SessionInfo {

    private SessionInfo() {
        super();
    }

    public static SessionInfo instance = null;
    public static SessionInfo getInstance() {
        if (SessionInfo.instance == null) { SessionInfo.instance = new SessionInfo(); }
        return SessionInfo.instance;
    }

    public static void endInstance() { SessionInfo.instance = null; }

    private ArrayList<TestList> test_list;
    public ArrayList<TestList> getTestList() { return this.test_list; }
    public void setTestList(ArrayList<TestList> list) {this.test_list = (list != null) ? list : new ArrayList<TestList>(); }

//    private List<TestList> all_name_list;
//    public List<TestList> getAllNameList() { return this.all_name_list; }
//    public void setAllNameList(List<TestList> list) { this.all_name_list = (list != null) ? list : new ArrayList<TestList>(); }
//
//    private List<TestList> all_age_list;
//    public List<TestList> getAllAgeList() { return this.all_age_list; }
//    public void setAllAgeList(List<TestList> list) { this.all_age_list = (list != null) ? list : new ArrayList<TestList>(); }
//
//    private List<TestList> all_hometown_list;
//    public List<TestList> getAllHometownList() { return this.all_hometown_list; }
//    public void setAllHometownList(List<TestList> list) { this.all_hometown_list = (list != null) ? list : new ArrayList<TestList>(); }

}
