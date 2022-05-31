package views;

import DAO.UserDAO;
import models.User;
import utils.ConsoleHelper;

public class UserView {
    public static void viewAllUsers() {
        System.out.printf("%n%n[+] Listado de usuarios registrados%n");
        System.out.printf("%n%-20s %-20s %-20s %-20s %-20s%n", "DNI", "Name", "Email", "Phone", "Address");
        for (User u : new UserDAO().getAllUsers()) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s%n", u.getDni(), u.getName(), u.getEmail(), u.getPhone(), u.getAddress());
        }
    }

    public static void viewUserInfo() {
        String dni = ConsoleHelper.readString("Introduce el dni del usuario: ");

        while (!User.verifyDNI(dni)) {
            dni = ConsoleHelper.readString("Introduce tu DNI: ");
        }

        System.out.println(new UserDAO().getUserInfo(dni));

    }
}
