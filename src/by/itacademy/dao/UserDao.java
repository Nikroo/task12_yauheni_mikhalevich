package by.itacademy.dao;

import by.itacademy.service.User;

import java.util.List;

public interface UserDao {
   boolean create(User user);
   User read(String login, String pass);
   User update(Integer id, User user);
   boolean delete(String login, String pass);
   List<User> readAll();
}
