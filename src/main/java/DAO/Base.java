package DAO;

import java.util.List;
import java.util.Map;

public interface Base<T> {
    //添加
    public void insert(T object);
    //根据条件查找
    public T findOne(Map<String, Object> params);
   //查找所有
    public List<T> findAll(Map<String,Object> params);
//    //修改
    public void update(T object);
//    //根据条件删除
    public void remove(Map<String,Object> params);
}
