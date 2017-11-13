package DAO;

import Model.Goods;

import java.util.ArrayList;
import java.util.Map;


public interface goodsDAO extends Base<Goods>{
    public int getCount();
    //public ArrayList<Goods>findAllByType(Map<String,Object> params);
}
