package com.example.agvenegas.prueba4.utils;

import com.example.agvenegas.prueba4.entities.TestList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agvenegas on 12/30/15.
 */
public class SessionInfo {

    public static int selected_user = -1;

    private SessionInfo() {
        super();
        test_list = new ArrayList<TestList>();
        this.setTestList(null);
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

}
