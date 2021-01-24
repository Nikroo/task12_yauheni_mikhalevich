package by.itacademy.service;
import by.itacademy.dao.UserDao;
import by.itacademy.dao.openserver.OpenServerSqlUserDao;

import java.util.List;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new OpenServerSqlUserDao();
    }

    public boolean addUser(User user){
        return userDao.create(user);
    }

    public boolean removeUser(User user){
        return userDao.delete(user.getLogin(), user.getPassword());
    }

    public User selectUser(String login, String password){
        return userDao.read(login, password);
    }

    public User updateUser(Integer id, User user){
        return userDao.update(id, user);
    }

    public List<User> readAll(){return userDao.readAll();}



}
