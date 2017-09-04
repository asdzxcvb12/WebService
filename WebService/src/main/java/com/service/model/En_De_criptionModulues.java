package com.service.model;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class En_De_criptionModulues {
	private String RSA_WEB_KEY; // private key session
	private static String RSA_INSTANCE = "RSA"; // rsa transformation
	
	
	public En_De_criptionModulues(String RSA_WEB_KEY) {
		this.RSA_WEB_KEY = RSA_WEB_KEY;
	}
	
	//0:id, 1:pw
	public String[] decrypt(HttpServletRequest request, String membership_ID, String membership_PW) throws Exception{
		HttpSession session = request.getSession();
        PrivateKey privateKey = (PrivateKey) session.getAttribute(RSA_WEB_KEY);
        
        membership_ID = decryptRsa(privateKey, membership_ID);
        membership_PW = decryptRsa(privateKey, membership_PW);
		
        session.removeAttribute(RSA_WEB_KEY);
        
        String[] result = {membership_ID, membership_PW};
        
        return result;
	}
	
	/* decrypt code */
	private String decryptRsa(PrivateKey privateKey, String securedValue) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_INSTANCE);
        byte[] encryptedBytes = hexToByteArray(securedValue);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedValue = new String(decryptedBytes, "utf-8");
        return decryptedValue;
    }

	/* change to byte array */
	public static byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() % 2 != 0) { return new byte[] {}; }
 
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            byte value = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
            bytes[(int) Math.floor(i / 2)] = value;
        }
        return bytes;
    }


	/* rsa public, private key generator */
	public void initRSAkey(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		KeyPairGenerator generator;
		try{
			generator = KeyPairGenerator.getInstance(RSA_INSTANCE);
			generator.initialize(1024);
			
			KeyPair keyPair = generator.genKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance(RSA_INSTANCE);
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			
			session.setAttribute(RSA_WEB_KEY, privateKey);
			
			RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			String publicKeyModulus = publicSpec.getModulus().toString(16);
			String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
			
			request.setAttribute("RSAModulus", publicKeyModulus);
			request.setAttribute("RSAExponent", publicKeyExponent);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String[] initRSAkeyLog(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String publicKeyModulus = null;
		String publicKeyExponent = null;
		KeyPairGenerator generator;
		
		try{
			generator = KeyPairGenerator.getInstance(RSA_INSTANCE);
			generator.initialize(1024);
			
			KeyPair keyPair = generator.genKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance(RSA_INSTANCE);
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			
			session.setAttribute(RSA_WEB_KEY, privateKey);
			
			RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			publicKeyModulus = publicSpec.getModulus().toString(16);
			publicKeyExponent = publicSpec.getPublicExponent().toString(16);
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String[] result = {publicKeyModulus, publicKeyExponent};
		return result;
	}
}

