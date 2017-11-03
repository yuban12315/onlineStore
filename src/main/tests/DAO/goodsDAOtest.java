package DAO;

import DAO.impl.GoodsDAOImpl;
import Model.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import DAO.impl.GoodsDAOImpl;

public class goodsDAOtest {
    public static void main(String args[]){
        GoodsDAOImpl goodsDAO=new GoodsDAOImpl();
//        Goods goods=new Goods();
//        goods.setName("name");
//        goods.setAssort("123");
//        goods.setDesc("desc");
//        goods.setPicture("http");
//        goods.setPrice(12315);
//        goods.setQuantity(10);
//        GoodsDAOImpl goodsDAO=new GoodsDAOImpl();
//        goodsDAO.insert(goods);

        Map<String,Object> params=new HashMap<String,Object>();
        params.put("name","name");
        List<Goods> goods=goodsDAO.findAll(params);

        for (Goods good : goods) {
            System.out.println(good.getDesc());
            good.setDesc("desc");
            goodsDAO.update(good);
        }

    }


}
