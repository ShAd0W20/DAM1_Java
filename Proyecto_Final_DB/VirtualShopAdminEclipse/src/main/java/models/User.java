package main.java.models;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class User {
	private String dni;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String address;

	private static final String dniChars = "TRWAGMYFPDXBNJZSQVHLCKE";

	public User(String dni, String name, String password, String email, String phone, String address) {
		this.dni = dni;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public User(String dni, String email, String phone, String address) {
		this.dni = dni;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public User(String dni, String password) {
		this.dni = dni;
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static boolean verifyDNI(@NotNull String dni) {

		if (dni.length() != 9) {
			return false;
		}

		String intPartDNI = dni.trim().replaceAll(" ", "").substring(0, 8);
		char ltrDNI = dni.charAt(8);

		if (!intPartDNI.matches("\\d{8}")) {
			return false;
		}

		if (dniChars.charAt(Integer.parseInt(intPartDNI) % 23) != ltrDNI) {
			return false;
		}

		return true;
	}

	public static boolean verifyEmail(@NotNull String email) {
		if (!Pattern.matches("\\S+@\\S+\\.\\S+$", email)) {
			return false;
		}
		return true;
	}

	public static boolean verifyPhone(@NotNull String phone) {
		if (!phone.matches("\\d{9}")) {
			return false;
		}
		return true;
	}
}
