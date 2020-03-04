/**
 * 
 */
package org.iesjacaranda.dwes.restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Melero
 *
 */
@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
    public JavaMailSender emailSender;
 
    public void enviarCorreo(String destinatario) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(destinatario); 
        message.setSubject("Prueba"); 
        message.setText("asdasd");
        emailSender.send(message);

    }

}
