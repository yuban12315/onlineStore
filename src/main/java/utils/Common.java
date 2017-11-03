package utils;

import java.util.Map;

public class Common {
    public static String getKey(Map<String,Object> params){
        Object[] array=params.keySet().toArray();
        int length=array.length;
        if(length==0) return null;
        return params.keySet().toArray()[0].toString();
    }
}
