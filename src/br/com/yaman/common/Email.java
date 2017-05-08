package br.com.yaman.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private Email(String email) {
		this.email = email;
	}

	public String toString() {
		return "Email: " + this.email;
	}

	public static Email of(String email) throws Exception {
		if (isEmail(email)) {
			return new Email(email);
		}
		throw new Exception("Email Inválido");
	}

	public static boolean isEmail(String email) {
		String[] emailArroba = email.split("@");
		String dominioBr = "com.br";
		String dominioCom = "com";

		if (email != null && email.length() > 0) {
					if (emailArroba.length == 2) {
						if (emailArroba[0].length() > 2) {
							if (emailArroba[1].length() > 2) {
								if (emailArroba[1].contains(dominioBr)) {
									return (true);
								} else {
									if (emailArroba[1].contains(dominioCom)) {
										return (true);
									}
								}
							}
						}
					}
				}
		
		return false;
	}

}