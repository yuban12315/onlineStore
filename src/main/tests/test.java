import Model.Goods;
import Model.User;
import utils.Common;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String args[]){
        Goods goods=new Goods();
        goods.setName("d");
        System.out.println(goods.getName());
        System.out.println(goods.getPrice());
        System.out.println(goods.getDesc());
    }
}
