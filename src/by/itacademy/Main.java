package by.itacademy;


import by.itacademy.service.User;
import by.itacademy.service.UserService;

public class Main {
    public static void main(String[] args) {

        UserService service = new UserService();

        System.out.println(service.addUser(new User("Vania@mail.ru", "1111")));
        System.out.println(service.addUser(new User("Vania@mail.ru", "1111")));
        service.addUser(new User("Vania5050@mail.ru", "0258"));
        service.addUser(new User("Egor123@yahoo.com", "13698"));
        service.addUser(new User("Sveta777@mail.ru", "qwerty123"));

        service.removeUser(new User("Egor123@yahoo.com", "13698"));
        service.removeUser(new User("Sveta777@mail.ru", "qwerty123"));

        User user = service.selectUser("Vania@mail.ru", "1111");

        service.updateUser(user.getId(), new User("Anna@yandex.ru", "1988"));


        for (User element:service.readAll()) {
            System.out.println(element);
        }

    }
}
