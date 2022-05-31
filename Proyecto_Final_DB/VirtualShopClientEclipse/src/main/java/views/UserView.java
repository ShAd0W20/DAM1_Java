package main.java.views;

import main.java.DAO.UserDAO;
import main.java.models.User;
import main.java.utils.ConsoleHelper;

public class UserView {

	public static void registerUser() {
		String dni = ConsoleHelper.readString("Introduce tu DNI: ");

		while (!User.verifyDNI(dni)) {
			dni = ConsoleHelper.readString("Introduce tu DNI: ");
		}

		String name = ConsoleHelper.readString("Introduce tu nombre: ");
		String password = ConsoleHelper.readString("Introduce tu contraseña: ");
		String email = ConsoleHelper.readString("Introduce tu email: ");

		while (!User.verifyEmail(email)) {
			email = ConsoleHelper.readString("Introduce tu email: ");
		}

		String phone = ConsoleHelper.readString("Introduce tu telefono: ");

		while (!User.verifyPhone(phone)) {
			phone = ConsoleHelper.readString("Introduce tu telefono: ");
		}

		String address = ConsoleHelper.readString("Introduce tu direccion: ");

		boolean isRegistered = new UserDAO().register(new User(dni, name, password, email, phone, address));

		if (isRegistered) {
			ConsoleHelper.readString("\n[+] Te has registrado correctamente \n\nPulse enter para volver al menu");
		} else {
			ConsoleHelper.readString(
					"\n[!] Ha habido algun problema, intentelo mas tarde \n\nPulse enter para volver al menu");
		}

	}

	public static void modifyUserInfo() {
		int opt = ConsoleHelper.readInteger("Que desea modificar? \n[1] Email \n[2] Telefono \n[3] Direccion");

		switch (opt) {
		case 1 -> modifyUserEmail();
		case 2 -> modifyUserPhone();
		case 3 -> modifyUserAddress();
		case 4 -> modifyUserPassword();
		}

		ConsoleHelper.readString("\n[+] Pulse enter para volver al menu");

	}

	public static void deleteUser() {
		String dni = ConsoleHelper.readString("Introduce el dni del cliente a eliminar: ");
		String password = ConsoleHelper.readString("Introduce la contraseña: ");

		boolean deleted = new UserDAO().deleteUser(new User(dni, password));

		if (deleted) {
			ConsoleHelper.readString("Usuario eliminado correctamente \nPulse enter para volver al menu");
		} else {
			ConsoleHelper.readString("Usuario no encontrado \nPulse enter para volver al menu");
		}
	}

	private static void modifyUserEmail() {
		String dni = ConsoleHelper.readString("Introduce el dni: ");

		while (!User.verifyDNI(dni)) {
			dni = ConsoleHelper.readString("Introduce el dni: ");
		}

		String email = ConsoleHelper.readString("Introduce el nuevo email: ");

		while (!User.verifyEmail(email)) {
			email = ConsoleHelper.readString("Introduce el nuevo email: ");
		}

		boolean modified = new UserDAO().updateEmail(new User(dni, email, "", ""));

		if (modified) {
			System.out.println("Correo modificado correctamente");
		} else {
			System.out.println("Usuario no encontrado");
		}

	}

	private static void modifyUserPhone() {
		String dni = ConsoleHelper.readString("Introduce el dni: ");

		while (!User.verifyDNI(dni)) {
			dni = ConsoleHelper.readString("Introduce el dni: ");
		}

		String phone = ConsoleHelper.readString("Introduce el nuevo telefono: ");

		while (!User.verifyPhone(phone)) {
			phone = ConsoleHelper.readString("Introduce el nuevo telefono: ");
		}

		boolean modified = new UserDAO().updatePhone(new User(dni, "", phone, ""));

		if (modified) {
			ConsoleHelper.readString("Telefono modificado correctamente \nPulse enter para volver al menu");
		} else {
			ConsoleHelper.readString("Usuario no encontrado \nPulse enter para volver al menu");
		}
	}

	private static void modifyUserAddress() {
		String dni = ConsoleHelper.readString("Introduce el dni: ");

		while (!User.verifyDNI(dni)) {
			dni = ConsoleHelper.readString("Introduce el dni: ");
		}

		String address = ConsoleHelper.readString("Introduce la nueva direccion: ");

		boolean modified = new UserDAO().updateAddress(new User(dni, "", "", address));

		if (modified) {
			ConsoleHelper.readString("Direccion modificada correctamente \nPulse enter para volver al menu");
		} else {
			ConsoleHelper.readString("Usuario no encontrado \nPulse enter para volver al menu");
		}
	}

	private static void modifyUserPassword() {
		String dni = ConsoleHelper.readString("Introduce el dni: ");

		while (!User.verifyDNI(dni)) {
			dni = ConsoleHelper.readString("Introduce el dni: ");
		}

		String password = ConsoleHelper.readString("Introduce la nueva contraseña: ");

		boolean modified = new UserDAO().updatePassword(new User(dni, password));

		if (modified) {
			ConsoleHelper.readString("Contraseña modificada correctamente \nPulse enter para volver al menu");
		} else {
			ConsoleHelper.readString("Usuario no encontrado \nPulse enter para volver al menu");
		}
	}

}
