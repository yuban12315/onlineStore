package Controller;

import DAO.impl.UserDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Message;

import java.util.Map;

@Controller
@RequestMapping(value = "/goods")
public class GoodsCtrl {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> test(){
        UserDAOImpl userDAO=new UserDAOImpl();
        Message message=new Message();
        message.setStatus(false);
        int count=userDAO.getCount()+1;
        System.out.println(count);
        message.setMsg(""+userDAO.getCount());
        return Message.messageToMap(message);
    }
}
