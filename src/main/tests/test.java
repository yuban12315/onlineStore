import Model.Goods;
import Model.User;
import utils.Common;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String args[]) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("page",0);
        map.put("type","all");
        System.out.println(map.keySet().toArray()[0].toString());
        System.out.println(map.keySet().toArray()[1].toString());
    }
}
