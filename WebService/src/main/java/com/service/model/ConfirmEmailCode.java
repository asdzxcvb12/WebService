package com.service.model;

import java.util.Random;

public class ConfirmEmailCode {
	public String getEmailCode() {
		Random ran = new Random();
		
		String[] eng = {"a","b","c","d","e","f","g","h","i","j","k","l","n","m","o","p","q","r","s","t","u","v","w","x","y","z"};
		String[] sep = {"!","@","#","$","%","^","&","*","+","-"};
		
		String mkCode = "";
			for(int j=0; j<5; j++) {
				int eng_sep = ran.nextInt(9);
				if(eng_sep < 3) mkCode += (eng[ran.nextInt(eng.length)]);
				else if(eng_sep >= 3 && eng_sep < 6) mkCode += (sep[ran.nextInt(sep.length)]);
				else mkCode += (eng[ran.nextInt(eng.length)].toUpperCase());
			}
			
		return mkCode;
	}
}
