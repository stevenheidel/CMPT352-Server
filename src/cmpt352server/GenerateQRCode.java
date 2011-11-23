package cmpt352server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class GenerateQRCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SecureRandom random = new SecureRandom();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws IOException {
		// generate random code
		String code = new BigInteger(130, random).toString(32);
		
		// store code in session and in database with timestamp
		HttpSession session = req.getSession(true);
		session.setAttribute("code", code);
		
		String username = (String) session.getAttribute("username");
		Date time = new Date();
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity token = new Entity("Token", code);
		token.setProperty("username", username);
		token.setProperty("time", time);
		token.setProperty("used", false);
		
		datastore.put(token);
				
		// chart size
		String chs = "300x300";
		// chart data
		String chl = req.getScheme() + "://" + req.getServerName() + req.getContextPath() + "/api/qrauth/" + code;

		// get the QR code from Google
		URL url = new URL("https://chart.googleapis.com/chart?cht=qr&chs=" + chs + "&chl=" + URLEncoder.encode(chl, "UTF-8"));
		ByteArrayOutputStream bais = new ByteArrayOutputStream();
		InputStream is = null;
		is = url.openStream ();
		
		// convert it to a byte stream
		byte[] byteChunk = new byte[4096]; // Or whatever size you want to read in at a time.
		int n;
		while ( (n = is.read(byteChunk)) > 0 ) {
			bais.write(byteChunk, 0, n);
		}
		
		// output
		bais.writeTo(resp.getOutputStream());
		is.close();
	}
}
