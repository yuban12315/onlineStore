package Service;

import DAO.impl.UserDAOImpl;
import Model.User;
import utils.Message;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private UserDAOImpl userDAO;

    public UserService() {
        userDAO = new UserDAOImpl();
    }

    //创建用户|注册
    public Message createOne(User object) {
        Message message = new Message();
        Map<String, Object> params = new HashMap<String, Object>();
        if(!this.checkData(object)){
            message.setStatus(false);
            message.setMsg("未通过结构验证");
            return message;
        }
        params.put("username", object.getUsername());
        User _find = userDAO.findOne(params);
        if (_find != null) {
            message.setStatus(false);
            message.setMsg("用户名已被使用！");
            return message;
        }
        userDAO.insert(object);
        message.setStatus(true);
        message.setMsg("注册成功");
        return message;
    }

    //用户登录
    public Message login(User object) {
        Message message = new Message();
        Map<String, Object> params = new HashMap<String, Object>();
        if(!this.checkData(object)){
            message.setStatus(false);
            message.setMsg("未通过结构验证");
            return message;
        }
        params.put("username", object.getUsername());
        User _find = userDAO.findOne(params);
        if (_find == null) {
            message.setStatus(false);
            message.setMsg("用户不存在");
            return message;
        }
        if (!_find.getPassword().equals(object.getPassword())) {
            message.setStatus(false);
            message.setMsg("密码错误");
            return message;
        }
        message.setStatus(true);
        message.setMsg("登录成功");

        return message;
    }

    //检查数据
     private boolean checkData(User user) {
        if (user.getUsername() == null)
            return false;
        if (user.getPassword() == null)
            return false;
        return true;
    }
}
