package mainapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validations {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String cpValids = "Palamos-17230,Palafrugell-17200,La Bisbal-17100,Calonge-17350,Platja d'Aro-17250,Sant Feli de Guixols-17220,Suka-33333";
		String dni = "", naix = "", nom = "", adreca = "", cp = "", poblacio = "", matricula = "", telefon = "", email = "";
		LocalDate date = LocalDate.of(2022, 1, 1);
		
		System.out.println("Inserte su DNI");
		dni = input.nextLine();
		while(!validarDNI(dni)) {
			System.out.println("Inserte su DNI");
			dni = input.nextLine();
		}
		
		System.out.println("Inserte su nombre");
		nom = input.nextLine();
		
		System.out.println("Inserte su fecha de nacimiento formato: DD/MM/YY");
		naix = input.nextLine();
		while(!validarDataNaixement(naix)) {
			System.out.println("Inserte su fecha de nacimiento formato: DD/MM/YY");
			naix = input.nextLine();
		}
		
		if(validarDataNaixement(naix)) {
			date = LocalDate.parse(naix, DateTimeFormatter.ofPattern("d/M/y"));
		}

		System.out.println("Inserte su direccion");
		adreca = input.nextLine();
		
		System.out.println("Inserte su CP");
		cp = input.nextLine();
		while(!validarCodiPostal(cp, cpValids)) {
			System.out.println("Inserte su CP");
			cp = input.nextLine();
		}
		
		poblacio = poblacio(cp, cpValids);
		
		System.out.println("Inserte su matricula");
		matricula = input.nextLine();
		while(!validarMatricula(matricula)) {
			System.out.println("Inserte su matricula");
			matricula = input.nextLine();
		}
		
		System.out.println("Inserte su telefono");
		telefon = input.nextLine();
		while(!validarTelefon(telefon)) {
			System.out.println("Inserte su telefono");
			telefon = input.nextLine();
		}
		
		System.out.println("Inserte su email");
		email = input.nextLine();
		while(!validarEmail(email)) {
			System.out.println("Inserte su email");
			email = input.nextLine();
		}
		
		System.out.println(dni + " " + nom +  " " + date.toString() + " " + adreca + " " + cp + " " + poblacio + " " + matricula + " " + telefon + " " + email);
		input.close();
	}

	public static boolean validarDNI(String studentID) {
		String dniChars = "TRWAGMYFPDXBNJZSQVHLCKE";
		
		if (studentID.length() != 9) {
			return false;
		}
		
		String intPartDNI = studentID.trim().replaceAll(" ", "").substring(0, 8);
		char ltrDNI = studentID.charAt(8);
		
		if (intPartDNI.matches("[0-9]{8}") == false) {
			return false;
		}
		
		int valNumDNI = Integer.parseInt(intPartDNI) % 23;

		if (dniChars.charAt(valNumDNI) != ltrDNI) {
			return false;
		}
		
		return true;
	}
	
	public static boolean validarEmail(String email) {
		if(!Pattern.matches("\\S+@\\S+\\.\\S+$", email)) {
			return false;
		}
		return true;
	}
	
	public static boolean validarDataNaixement(String data) {
		try {
			LocalDate.parse(data, DateTimeFormatter.ofPattern("d/M/y"));
		} catch (DateTimeParseException e) {
			return false;
		}
		
		return true;
	}
	
	public static String poblacio(String cp, String cpValids) {
		if(cp.matches("[0-9]{5}")) {
			for(String s: cpValids.split(",")) {
				if(cp.equals(s.replaceAll("[^0-9]", ""))) {
					return s.replaceAll("[^a-zA-Z]", " ");
				}
			}
		}
		return "";
	}
	
	
	public static boolean validarCodiPostal(String cp, String cpValids) {
		if(cp.matches("[0-9]{5}")) {
			for(String s: cpValids.split(",")) {
				if(cp.equals(s.replaceAll("[^0-9]", ""))) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean validarMatricula(String matricula) {
		if(!matricula.matches("[1-9]{4}[A-Z]{3}")) {
			return false;
		}
		return true;
	}
	
	public static boolean validarTelefon(String telef) {
		if(!telef.matches("[0-9]{9}")) {
			return false;
		}
		return true;
	}

}
