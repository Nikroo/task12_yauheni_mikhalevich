package by.itacademy.service;
import by.itacademy.dao.UserDao;
import by.itacademy.dao.openserver.OpenServerSqlUserDao;

import java.util.List;

public class UserService {
    private UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public boolean addUser(User user){ return dao.create(user);}

    public boolean removeUser(User user){
        return dao.delete(user.getLogin(), user.getPassword());
    }

    public User selectUser(String login, String password){
        return dao.read(login, password);
    }

    public User updateUser(Integer id, User user){ return dao.update(id, user);}

    public List<User> readAll(){return dao.readAll();}




}
