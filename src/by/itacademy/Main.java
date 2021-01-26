package by.itacademy;


import by.itacademy.service.Hash;
import by.itacademy.service.PasswordHash;
import by.itacademy.service.User;
import by.itacademy.service.UserService;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Main extends Hash {
    public static void main(String[] args) {

        UserService service = new UserService();

        User user0 = new User("Makar@tut.by", "0000");
        service.addUser(user0);
        System.out.println(service.addUser(new User("Vania@mail.ru", "1111")));
        System.out.println(service.addUser(new User("Vania@mail.ru", "1111")));
        user0 = service.selectUser("Makar@tut.by", "0000");
        service.updateUser(user0.getId(), new User("Anna@yandex.ru", "1988"));

        service.addUser(new User("Vania5050@mail.ru", "0258"));
/*        service.addUser(new User("Egor123@yahoo.com", "13698"));
        service.addUser(new User("Sveta777@mail.ru", "qwerty123"));

        service.removeUser(new User("Egor123@yahoo.com", "13698"));
        service.removeUser(new User("Sveta777@mail.ru", "qwerty123"));*/

        User user = service.selectUser("Vania@mail.ru", "1111");
        System.out.println(user);

        System.out.println(user.getPassword() +" "+ user.getPassword());

        System.out.println(validatePassword("1111", user.getPassword()));

        System.out.println();


        for (User element:service.readAll()) {
            System.out.println(element);
        }


    }
}
