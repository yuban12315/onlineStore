package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserCtrl {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

}
