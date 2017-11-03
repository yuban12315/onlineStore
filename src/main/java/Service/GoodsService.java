package Service;

import DAO.impl.GoodsDAOImpl;
import Model.Goods;

import java.util.List;

public class GoodsService {
    private GoodsDAOImpl goodsDAO;

    public GoodsService() {
        goodsDAO = new GoodsDAOImpl();
    }

    public List<Goods> getGoodsList(String type){
        return null;
    }

}
