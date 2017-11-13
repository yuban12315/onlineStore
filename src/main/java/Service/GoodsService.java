package Service;

import DAO.impl.GoodsDAOImpl;
import DAO.impl.UserDAOImpl;
import Model.Goods;
import Model.User;
import utils.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsService {
    private GoodsDAOImpl goodsDAO;
    private UserDAOImpl userDAO;

    public GoodsService() {
        goodsDAO = new GoodsDAOImpl();
        userDAO = new UserDAOImpl();
    }

    /*
    * type:按商品分类返回数据，根据int量page分页返回*/
    public ArrayList<Goods> getGoodsList(String type, int page) {
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("type",type);
        map.put("page",page);
        return goodsDAO.findAll(map);
    }

    public Goods getGoodDetail(int id){
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("id",id);
        return goodsDAO.findOne(map);
    }

    //创建商品
    public Message createGood(Goods goods) {
        Message message = new Message();
        goods.setId(goodsDAO.getCount() + 1);//id设置为已有量加一
        if (!this.checkData(goods)) {
            message.setStatus(false);
            message.setMsg("未通过结构验证");
            return message;
        }
        goodsDAO.insert(goods);
        message.setStatus(true);
        message.setMsg("创建商品：（" + goods.getName() + "）成功");
        return message;
    }

    //修改商品
    public Message updateGood(Goods goods, String owner) {
        Message message = new Message();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", goods.getName());

        Goods _goods = goodsDAO.findOne(params);
        if (_goods == null) {
            message.setMsg("商品不存在");
            message.setStatus(false);
            return message;
        }
        if (goods.getId() != _goods.getId()) {
            message.setStatus(false);
            message.setMsg("id字段不能修改");
            return message;
        }
        goodsDAO.update(goods);


        message.setStatus(true);
        message.setMsg("修改商品成功");
        return message;
    }

    //检查数据
    private boolean checkData(Goods goods) {
        if (goods.getName() == null) {
            return false;
        }
        if (goods.getPrice() == 0) {
            return false;
        }
        if (goods.getDesc() == null) {
            return false;
        }
        if (goods.getAssort() == null) {
            return false;
        }
        if (goods.getPicture() == null) {
            return false;
        }
        if (goods.getQuantity() == 0) {
            return false;
        }
        if (goods.getOwner() == null) {
            return false;
        }

        return true;
    }

    //获取商品的主人名字(username唯一)
    public String getGoodsOwner(Goods goods) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", goods.getId());
        Goods goods1 = goodsDAO.findOne(params);
        return goods1.getOwner();
    }

}
