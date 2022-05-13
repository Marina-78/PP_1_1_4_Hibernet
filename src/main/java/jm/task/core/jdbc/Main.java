package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl user = new UserServiceImpl();
        user.createUsersTable();

        user.saveUser("Ivan", "Ivanov", (byte) 20);
        user.saveUser("Petr", "Petrov", (byte) 25);
        user.saveUser("Stepan", "Stepanov", (byte) 31);
        user.saveUser("Anton", "Antonov", (byte) 38);

        for (User us : user.getAllUsers()) {
            System.out.println("User с именем – " + us.getName() + " добавлен в базу данных");

        }
        System.out.print(user.getAllUsers());

        user.cleanUsersTable();
        user.dropUsersTable();
    }
}

