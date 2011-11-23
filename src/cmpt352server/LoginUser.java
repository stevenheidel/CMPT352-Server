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

public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws IOException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	
    	Entity user;
    	
    	try {
			user = datastore.get(KeyFactory.createKey("User", username));
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return;
		}
    	
    	if (user.getProperty("password").equals(password)) {
    		HttpSession session = req.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("loggedin", false);
            
            resp.sendRedirect("/login_step2.jsp");
    	}
	}
}
