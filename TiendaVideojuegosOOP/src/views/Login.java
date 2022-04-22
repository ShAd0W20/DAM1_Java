package views;

import utils.ConsoleHelper;

public class Login {
	public static boolean doLogin(final String masterPassword) {
		String password = ConsoleHelper.readString("Introduce la contraseña: ");
		
		if(password.equals(masterPassword)) {
			return true;
		}
		
		return false;		
	}
}
