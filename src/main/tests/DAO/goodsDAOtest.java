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
        Goods goods=new Goods();
        goods.setName("name2");
        goods.setAssort("1234");
        goods.setDesc("desc");
        goods.setPicture("http");
        goods.setPrice(12315);
        goods.setQuantity(10);
        //GoodsDAOImpl goodsDAO=new GoodsDAOImpl();
        goodsDAO.insert(goods);

       //System.out.println(goodsDAO.getCount());

    }


}
