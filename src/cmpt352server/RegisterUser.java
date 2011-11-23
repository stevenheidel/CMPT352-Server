package cmpt352server;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;


public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// private static final Logger log = Logger.getLogger(RegisterUser.class.getName());

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    	
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	
    	Entity user = new Entity("User", username);
    	user.setProperty("username", username);
    	user.setProperty("password", password);
    	
    	user.setProperty("androidUUID", req.getParameter("androidUUID"));
    	user.setProperty("androidIMEI", req.getParameter("androidIMEI"));
    	user.setProperty("androidPhone", req.getParameter("androidPhone"));
    	
    	datastore.put(user);
    }
}
