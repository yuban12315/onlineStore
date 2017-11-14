package Controller;

import Model.User;
import Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Message;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/user")
public class UserCtrl {

//    @RequestMapping(value = "/hello")
//    @ResponseBody
//    public String hello() {
//        return "hello";
//    }


    //map array to json list success√
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Map<String, Object>> test() {
        ArrayList<Map<String, Object>>list=new ArrayList<>();

        Map<String, Object> map = null;
        map = new HashMap<String, Object>();
        map.put("name", "admin");
        list.add(map);

        list.add(map);
        list.add(map);
        return list;
    }

    /*登录*/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody User user, HttpSession session) {
        Map<String, Object> res = new HashMap<String, Object>();
        UserService userService = new UserService();
        Message message = userService.login(user);
        res = message.toMap();
        if (message.getStatus()) {
            session.setAttribute("logged", true);
            session.setAttribute("username",user.getUsername());
        }

        return res;
    }

    /*注册*/
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(@RequestBody User user,HttpSession session) {
        Map<String, Object> res = new HashMap<String, Object>();

        UserService userService = new UserService();
        Message message = userService.createOne(user);
        res = message.toMap();
        if (message.getStatus()) {
            //注册成功默认登录
            session.setAttribute("logged", true);
        }

        return res;
    }

    @RequestMapping(value = "/logged",method = RequestMethod.GET)
    @ResponseBody
    public boolean getLogged(HttpSession session){
        if(session.getAttribute("logged")==null){
            return false;
        }
        return (boolean)session.getAttribute("logged");
    }

//    @RequestMapping(value = "/buy")
//    public Map<String,Object>
}
