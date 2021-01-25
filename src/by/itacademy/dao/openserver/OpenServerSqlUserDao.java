package by.itacademy.dao.openserver;

import by.itacademy.dao.UserDao;
import by.itacademy.service.User;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpenServerSqlUserDao extends AbstractConnection implements UserDao {

    @Override
    public boolean create(User user) {
        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement
                            ("INSERT INTO users (login, password) VALUES (?,?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getHash());
            statement.execute();
            return true;
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public User read(String login, String password) {
        User user = null;
        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement("SELECT id, login, password FROM users where login=?");
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            int id;
            String name;
            String pass;
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("login");
                pass = rs.getString("password");
                user = new User(id, name, pass);
            }
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public User update(Integer id, User user) {
        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement("UPDATE users SET login=?, password=? WHERE id=?");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getHash());
            statement.setString(3, id.toString());
            statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return user;

    }

    @Override
    public boolean delete(String login, String password) {
        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement("DELETE FROM users WHERE login = ? and password = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            return statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<User> readAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement("SELECT id, login, password FROM users");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                users.add(new User(set.getInt("id"),
                        set.getString("login"),
                        set.getString("password")));
            }
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return users;
    }
}
