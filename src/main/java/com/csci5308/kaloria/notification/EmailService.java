package com.csci5308.kaloria.notification;

import org.springframework.stereotype.Service;

import com.csci5308.kaloria.utilities.Constants;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class EmailService implements ICommunicationService, Constants {

	@Override
	public void send(IMessage email) {
		sendEmail(email);
	}

	private void sendEmail(IMessage email) {
		final Properties configurationProperties = configureEmailServer();
		final Session session = getSession(configurationProperties);
		final Message message = createMimeMessage(session, email);
		sendEmail(message);
	}

	private Properties configureEmailServer() {
		Properties properties = System.getProperties();

		try (InputStream resourceStream = EmailService.class.getResourceAsStream(EMAIL_CONFIG_FILE_PATH)) {
			properties.load(resourceStream);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return properties;
	}

	private Session getSession(Properties properties) {
		return Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				final String username = System.getProperty("mail.username");
				final String password = System.getProperty("mail.password");
				return new PasswordAuthentication(username, password);
			}
		});
	}

	private Message createMimeMessage(Session session, IMessage email) {
		Message message = new MimeMessage(session);
		;

		try {
			message.setContent(email.getBody(), "text/html; charset=utf-8");
			message.addRecipients(Message.RecipientType.TO,
					InternetAddress.parse(String.join(",", email.getRecipients())));
			message.setSubject(email.getSubject());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return message;
	}

	private void sendEmail(Message message) {
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			System.out.println(e.getMessage());
		}
	}
}
