package com.qrmor;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;


public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SecureRandom random = new SecureRandom();

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity user;
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");

		String code = new BigInteger(32, random).toString();

		try {
			user = datastore.get(KeyFactory.createKey("User", username));
			return;
		} catch (EntityNotFoundException e) {}
		
		user = new Entity("User", username);
		user.setProperty("username", username);
		user.setProperty("password", password);
		user.setProperty("androidPN", phone);

		user.setProperty("textCode", code);
		
		datastore.put(user);

		// send text message
		try {
			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, null);

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("***REMOVED***", "qrmor.com register"));
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(phone + "@sms.sasktel.com", phone));
			msg.setSubject("QRMOR Registration");
			msg.setText(code);
			Transport.send(msg);
		} catch (AddressException e) {
			e.printStackTrace();
			return;
		} catch (MessagingException e) {
			e.printStackTrace();
			return;
		}

		resp.sendRedirect("/register_step2.jsp");
	}
}
