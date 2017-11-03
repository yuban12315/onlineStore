import Model.User;
import utils.Common;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String args[]){
            Map <String,Object>params=new HashMap<String,Object>();
            //params.put("name","2");
        //System.out.println(Common.getKey(params));
        User user1=new User();
        user1.setUsername("11");
        User user2=new User();
        user2.setPassword("22");
        System.out.println(user1.equals(user1));
        System.out.println(user1.equals(user2));

    }
}
