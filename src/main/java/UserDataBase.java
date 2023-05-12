import DAO.RoleDAO;
import DAO.RoleDAOImpl;
import DAO.UsersDAO;
import DAO.UsersDAOImpl;
import pojo.Role;
import pojo.Users;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class UserDataBase {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("==============DataBase============");

        UsersDAO usersDAO = new UsersDAOImpl();
        RoleDAO roleDAO = new RoleDAOImpl();

        while (true) {
            try {
                printMenu();
                int i = scanner.nextInt();
                if (i == 1) {
                    Users users = createUsersPole();
                    usersDAO.createUsers(users);

                } else if (i == 2) {
                    Collection<Users> usersRole = getAllUsersRole();
                } else if (i == 3) {
                    Collection<Users> usersRole = getUsersRole();
                } else if (i == 4) {
                    int idUsers = scanner.nextInt();
                    deleteUsersPole(idUsers);
                } else if (i == 5) {
                    Collection<Users> usersNoRole = getAllUsersNoRole();
                } else if (i == 6) {
                    updateUsersPole();
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ВВОД НЕ КОРРЕКТЕН");
                scanner.nextLine();
            }

        }
    }

    private static void printMenu() {
        System.out.println("1 - Добавлять нового пользователя с ролями в БД;");
        System.out.println("2 - Получать конкретного пользователя (с его ролями) из БД;");
        System.out.println("3 - Получать список пользователей по конкретной роли;");
        System.out.println("4 - Удалять пользователя в БД;");
        System.out.println("5 - Получать список пользователей из БД (без ролей);");
        System.out.println("6 - Редактировать существующего пользователя в БД.");

    }

    //* 1 Добавлять нового пользователя с ролями в БД; */

    private static Users createUsersPole() {
        System.out.println("+===СОздать пользователя===+\n");

        System.out.println("Имя пльзователя\n");
        String name = scanner.nextLine();

        System.out.println("Login пльзователя\n");
        String login = scanner.toString();

        System.out.println("Password пльзователя\n");
        String password = scanner.toString();

        System.out.println("Роль пльзователя\n");
        int i = 1;
        for (RoleType element : RoleType.values()) {
            System.out.println(element.getRoleType());
            i++;
        }
        RoleType roleType = RoleType.valueOf(Integer.valueOf(scanner.nextLine()));
        Users users = new Users(name, login, password, roleType.ordinal());
        return users;
//        System.out.println(name+""+login+""+password);

    }


    //* 2 Получать конкретного пользователя (с его ролями) из БД; */
    private static Collection<Users> getAllUsersRole() {
        return null;
    }
    //* 3 Получать список пользователей по конкретной роли; */

    private static Collection<Users> getUsersRole() {
        return null;
    }

    //* 4 Удалять пользователя в БД; */
    private static void deleteUsersPole(int id) {

    }

    //* 5 Получать список пользователей из БД (без ролей); */
    private static Collection<Users> getAllUsersNoRole() {
        return null;
    }

    //* 6 Редактировать существующего пользователя в БД. */
    private static void updateUsersPole() {

    }
}





