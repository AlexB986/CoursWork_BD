import DAO.RoleDAO;
import DAO.RoleDAOImpl;
import DAO.UsersDAO;
import DAO.UsersDAOImpl;
import pojo.Role;
import pojo.Users;

import javax.persistence.EntityManager;
import java.util.*;

public class UserDataBase {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("==============DataBase============");

        Users users = new Users();
        Role role = new Role();

        UsersDAO usersDAO = new UsersDAOImpl();
        RoleDAO roleDAO = new RoleDAOImpl();

        while (true) {
            try {
                printMenu();
                int choiceMenu = Integer.parseInt(scanner.nextLine());
                if (choiceMenu == 1) {
                    createUsersPole(usersDAO, roleDAO, users, role, scanner);
                } else if (choiceMenu == 2) {
                    System.out.println("Введите id");
                    int choiceId = scanner.nextInt();
                    Users usersRole = getAllUsersRole(usersDAO, choiceId);
                    System.out.println(usersRole.toString());
                } else if (choiceMenu == 3) {
                    System.out.println("Выбор роли");
                    Collection<?> usersRole = getUsersRole(roleDAO, choicesRole());
                    System.out.println(usersRole);

                } else if (choiceMenu == 4) {
                    System.out.println("Удалить пользователя введите id");
                    int idUsers = scanner.nextInt();
                    deleteUsersUser(usersDAO, users, idUsers);
                } else if (choiceMenu == 5) {
                    System.out.println(" Получить пользователей без ролей");
                    Collection<?> usersNoRole = getAllUsersNoRole();
                } else if (choiceMenu == 6) {
                    System.out.println("Обновить пользователя");
                    updateUsersPole(usersDAO, scanner);
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

    private static void createUsersPole(UsersDAO usersDAO, RoleDAO roleDAO, Users users, Role role, Scanner scanner) {
        System.out.print("+===СОздать пользователя===+\n");

        System.out.println("Имя пльзователя\n");
        String name = scanner.nextLine();

        System.out.println("Login пльзователя\n");
        String login = scanner.nextLine();

        System.out.println("Password пльзователя\n");
        String password = scanner.nextLine();

        System.out.println("Роль пльзователя\n");

        int i = 1;
        for (RoleType element : RoleType.values()) {
            System.out.println(i + " " + element.getRoleType());
            i++;
        }
        RoleType roleType = RoleType.valueOf(scanner.nextInt());
        users = new Users(name, login, password, roleType.ordinal() + 1, new Role(roleType.getValue()));
        usersDAO.createUsers(users);

    }


    //* 2 Получать конкретного пользователя (с его ролями) из БД; */
    private static Users getAllUsersRole(UsersDAO usersDAO, int id) {
        return usersDAO.getUsersById(id);


    }
    //* 3 Получать список пользователей по конкретной роли; */

    private static Collection<?> getUsersRole( RoleDAO roleDAO, int choiceRole) {
        Collection<?> roleCollection = Arrays.asList(
                roleDAO.getRoleById(choiceRole + 1)
        );
        return roleCollection;
    }

    //    * 4 Удалять пользователя в БД; */
    private static void deleteUsersUser(UsersDAO usersDAO, Users users, int id) {
        usersDAO.deleteUsers(id, users);

    }

    //* 5 Получать список пользователей из БД (без ролей); */
    private static Collection<?> getAllUsersNoRole() {

        return null;
    }

    //* 6 Редактировать существующего пользователя в БД. */
    private static void updateUsersPole(UsersDAO usersDAO, Scanner scanner) {
        System.out.println("Id пользователя");
        int idUser = scanner.nextInt();

        System.out.println("Имя пльзователя\n");
        String name1 = scanner.nextLine();
        String name = scanner.nextLine();

        System.out.println("Login пльзователя\n");
        String login = scanner.nextLine();

        System.out.println("Password пльзователя\n");
        String password = scanner.nextLine();

        usersDAO.updateUsers(new Users(idUser, name, login, password, choicesRole() + 1));

    }

    private static int choicesRole() {
        System.out.println("Роль пльзователя\n");

        int i = 1;
        for (RoleType element : RoleType.values()) {
            System.out.println(i + " " + element.getRoleType());
            i++;
        }
        RoleType roleType = RoleType.valueOf(Integer.valueOf(scanner.nextLine()));
        return roleType.ordinal();
    }


//    https://github.com/AlexB986/CoursWork_BD/pull/1
}





