package DAO;

import DAO.impl.UserDAOImpl;
import Model.User;
import utils.Message;

public class userDAOtest {
    public static void main(String args[]){
        UserDAOImpl userDAO=new UserDAOImpl();
        User user=new User();
        user.setUsername("admin");
        user.setPassword("123456");
        System.out.println(userDAO.getCount());
    }
}
