package ttlock.demo.lock.model;

import android.util.Log;

import java.util.ArrayList;

public class KeyListObj {
    int total;
    int pages;
    int pageNo;
    int pageSize;

    ArrayList<KeyObj> list;

    public ArrayList<KeyObj> getList() {
        Log.d("KeyListObj", "getList: " + list);
        return list;
    }

}
