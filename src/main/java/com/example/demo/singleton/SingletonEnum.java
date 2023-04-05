package com.example.demo.singleton;


/*public class EnumSingletom {
    public static void main(String[] args) {
        SingletonEnum se = SingletonEnum.INSTANCE;
        ArrayList<String> result = se.getDbDataField();
                System.out.println(result);
    }
}*/

import com.example.demo.entity.Plane;

import java.util.ArrayList;
import java.util.List;

public enum SingletonEnum {
    INSTANCE;
    private List<Plane> planeList = null;
    private void loadData() {
        planeList = new ArrayList<>();
        /*planeList.add("load data from DB once");*/
    }
    public List<Plane> getDbDataField() {
        if(planeList == null) {
            loadData();
        }
        return planeList;
    }
}

