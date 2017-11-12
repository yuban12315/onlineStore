package utils;

import java.util.HashMap;
import java.util.Map;

public class Message {
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    private Boolean status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public void print(){
        System.out.println("status:"+status+",msg:"+msg);
    }

    public static Map<String, Object>messageToMap(Message message){
        Map<String, Object>map=new HashMap<String,Object>();
        map.put("status",message.getStatus());
        map.put("msg",message.getMsg());
        return  map;
    }
}
