package cmpt352server;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;

public class API extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String action = req.getPathInfo();

		// GET to check if authenticated yet
		if (action.equals("/checklogin")) {
			HttpSession session = req.getSession(true);

			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			Entity token;

			try {
				token = datastore.get(KeyFactory.createKey("Token", (String) session.getAttribute("code")));
			} catch (EntityNotFoundException e) {
				e.printStackTrace();
				return;
			}

			resp.getWriter().println(token.getProperty("used"));
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String action = req.getPathInfo();
		
		// POST to authenticate with QR Code App
		if (action.startsWith("/qrauth/")) {			
			String code = action.substring("/qrauth/".length());

			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			Entity token;

			try {
				token = datastore.get(KeyFactory.createKey("Token", code));
			} catch (EntityNotFoundException e) {
				e.printStackTrace();
				return;
			}

			Entity user;

			try {
				user = datastore.get(KeyFactory.createKey("User", (String) token.getProperty("username")));
			} catch (EntityNotFoundException e) {
				e.printStackTrace();
				return;
			}

			String UUID = req.getParameter("UUID");
			String IMEI = req.getParameter("IMEI");
			String PN = req.getParameter("PN");
			String AC = req.getParameter("AC");
						
			if (UUID.equals(user.getProperty("androidUUID")) && IMEI.equals(user.getProperty("androidIMEI")) && PN.equals(user.getProperty("androidPN"))) {
				token.setProperty("used", true);
				datastore.put(token);
			}
		}
	}
}
