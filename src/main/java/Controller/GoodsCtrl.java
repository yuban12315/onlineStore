package Controller;

import DAO.impl.UserDAOImpl;
import Model.Goods;
import Service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.Common;
import utils.Message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/goods")
public class GoodsCtrl {

    //获取商品列表
    @RequestMapping(value = "/getList/{type}/{page}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Goods> getGoodList(@PathVariable String type, @PathVariable int page) {
        GoodsService goodsService = new GoodsService();
        return goodsService.getGoodsList(type, page);
    }

    //按id获取单个商品
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Goods getGoodsDetail(@PathVariable int id,HttpServletRequest request) {
        GoodsService goodsService = new GoodsService();
        return goodsService.getGoodDetail(id);
    }

    //创建商品
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> create(@RequestBody Goods goods, HttpSession session) {
        Map<String, Object> res = new HashMap<String, Object>();

        if (session.getAttribute("logged")==null||!(boolean)session.getAttribute("logged")) {
            res.put("status", false);
            res.put("msg", "请先登录");
            return res;
        }
        Message message;
        GoodsService goodsService = new GoodsService();
        goods.setOwner(session.getAttribute("username").toString());
        message = goodsService.createGood(goods);
        res = message.toMap();
        return res;
    }

    //修改商品
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object>update(@PathVariable int id,HttpSession session,@RequestBody Goods goods){
        Map<String,Object>res=new HashMap<String, Object>();
        if (session.getAttribute("logged")==null||!(boolean)session.getAttribute("logged")) {
            res.put("status", false);
            res.put("msg", "请先登录");
            return res;
        }
        GoodsService goodsService=new GoodsService();
        String username=session.getAttribute("username").toString();
        String _username=goodsService.getGoodsOwner(goods);
        if(!username.equals(_username)){
            res.put("status",false);
            res.put("msg","error");
            return res;
        }
        Message message=goodsService.updateGood(goods,username);
        res=message.toMap();
        return res;

    }

}
