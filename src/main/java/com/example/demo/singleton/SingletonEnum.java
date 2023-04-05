package com.example.demo.singleton;

/*public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){ // #3
        if(instance == null){		//если объект еще не создан
            instance = new Singleton();	//создать новый объект
        }
        return instance;		// вернуть ранее созданный объект
    }
}*/
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

