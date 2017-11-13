package DAO;

import Model.User;

public interface userDAO extends Base<User> {
    public int getCount();
}
