package com.headstrong.npi.raas;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSetupUtility {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MailSetupUtility.class);

	static final String FROM = "nishant.kumar5@genpact.com"; // Replace with
																// your "From"
	// address. This address
	// must be verified.
	static final String TO = "nishant.kumar5@genpact.com"; // Replace with a
																// "To"
	// address. If you have
	// not yet requested
	// production access,
	// this address must be
	// verified.

//	static final String BODY = "This email was sent through the Amazon SES SMTP interface.";
	static final String SUBJECT = "RaaS - Email Test";

	// Supply your SMTP credentials below. Note that your SMTP credentials are
	// different from your AWS credentials.
	// Old AKIAJ63B5ENLEQAW4PQQ
	static final String SMTP_USERNAME = "AKIAIEURAP3TSLDJ2PKQ"; // Replace with
	// your SMTP
	// username
	// credential.
	// Old Anm3dBRx7MW9+w/DizDECPDG2U0Doaaxc9oI8d+X23Ph
	static final String SMTP_PASSWORD = "ApAyLSgJ25py7qnzJlCx4VM1jk28/naDBui7VdYm7i+U"; // Replace
																						// with
	// your SMTP
	// password.

	// Amazon SES SMTP host name.
	static final String HOST = "email-smtp.us-east-1.amazonaws.com";

	// Port we will connect to on the Amazon SES SMTP endpoint. We are choosing
	// port 25 because we will use
	// STARTTLS to encrypt the connection.
	static final int PORT = 587;

	public static void sendMail(String to, String from, String subject,
			String inputBoby) {

		// Create a Properties object to contain connection configuration
		// information.
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", PORT);

		// Set properties indicating that we want to use STARTTLS to encrypt the
		// connection.
		// The SMTP session will begin on an unencrypted connection, and then
		// the client
		// will issue a STARTTLS command to upgrade to an encrypted connection.
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");

		// Create a Session object to represent a mail session with the
		// specified properties.
		Session session = Session.getDefaultInstance(props);
		Transport transport = null;
		try {
			// Create a message with the specified information.
			MimeMessage message = new MimeMessage(session);
			Multipart mp = new MimeMultipart();
			MimeBodyPart htmlPart = new MimeBodyPart();
			
			String body = inputBoby;
			htmlPart.setContent(body, "text/html");
			mp.addBodyPart(htmlPart);
			message.setContent(mp);
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);

			// Create a transport.
			transport = session.getTransport();

			// Send the message.

			LOGGER.debug("Attempting to send an email through the Amazon SES SMTP interface...");

			// Connect to Amazon SES using the SMTP username and password you
			// specified above.
			if (transport != null) {

				transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

				// Send the email.
				transport.sendMessage(message, message.getAllRecipients());
				LOGGER.debug("Email sent!");
			} else {
				LOGGER.debug("Email not sent!");
			}

		} catch (Exception ex) {
			LOGGER.error("The email was not sent.", ex);
		} finally {
			// Close and terminate the connection.
			try {
				if (transport != null) {
					transport.close();
				}
			} catch (MessagingException e) {
				LOGGER.error("Could not close mail transport", e);
			}
		}
	}


	

}
