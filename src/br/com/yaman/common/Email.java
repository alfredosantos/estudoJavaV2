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

	private Email (String email){
		this.email = email;
	}
	
	public String toString(){
		return "Email: " + this.email;
	}
	
	public static Email of (String email) throws Exception{
		if (isEmail(email)){
			return new Email(email);
		}
		throw new Exception("Email Inválido");
	}

    public static boolean isEmail(String email){
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
            	return(true);
            }
        }
        return(false);
    }

}
