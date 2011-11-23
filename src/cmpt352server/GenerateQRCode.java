package cmpt352server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GenerateQRCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// private static final Logger log = Logger.getLogger(RegisterUser.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws IOException {
		// get username
		HttpSession session = req.getSession(true);
		String code = (String) session.getAttribute("username");
		
		// chart size
		String chs = "300x300";
		// chart data
		String chl = code;

		// get the qr code from Google
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
