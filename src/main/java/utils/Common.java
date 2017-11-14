package utils;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class Common {
    public static String getKey(Map<String,Object> params){
        Object[] array=params.keySet().toArray();
        int length=array.length;
        if(length==0) return null;
        return params.keySet().toArray()[0].toString();
    }

    public static Object sessionGet(HttpSession session,String attr){
        Object result;
        try {
            result=session.getAttribute(attr);
        }catch (Exception e){
            return null;
        }
        return attr;
    }

}
