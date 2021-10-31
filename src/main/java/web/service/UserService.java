package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> allUser();
    void add(User user);
    void edit(User user);
    User getById(long id);
    void update(long id,User user);
    void remove(long id);
}
