/**
 * 
 */
package org.iesjacaranda.dwes.restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author manu
 *
 */
public class EmailServiceImpl implements EmailService {
	
	@Autowired
    public JavaMailSender emailSender;
 
    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo("manuelpruebasmb@gmail.com"); 
        message.setSubject("Prueba"); 
        message.setText("asdasd");
        emailSender.send(message);

    }
}
