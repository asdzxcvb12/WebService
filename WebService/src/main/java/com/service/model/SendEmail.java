package com.service.model;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public String send(String getEmail, String getCode) {
		String result = null;
		
		String from = "asdzxcvb12@naver.com";
		String to = getEmail;
		String code = getCode;
		String subject = "confirm E-mail code... by Code Storage";
		String content = "Enter the code : " + code;
		
		Properties p = new Properties();
		 
		p.put("mail.smtp.host","smtp.naver.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		// SMTP ������ �����ϱ� ���� ������
		 
		try{
		    Authenticator auth = new SMTPAuthenticatior();
		    Session ses = Session.getInstance(p, auth);
		    
		    ses.setDebug(true);
		     
		    MimeMessage msg = new MimeMessage(ses); // ������ ������ ���� ��ü
		    msg.setSubject(subject); // ����
		     
		    Address fromAddr = new InternetAddress(from);
		    msg.setFrom(fromAddr); // ������ ���
		     
		    Address toAddr = new InternetAddress(to);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // �޴� ���
		     
		    msg.setContent(content, "text/html;charset=UTF-8"); // ����� ���ڵ�
		     
		    Transport.send(msg); // ����
		} catch(Exception e){
			result = "fail";
		    e.printStackTrace();
		    // ���� �߻��� �ڷ� ���ư�����
		}
		 
		result = "success";
		
		return result;
	}
}
