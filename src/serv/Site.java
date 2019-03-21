package serv;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.BindingType;
@WebServlet("/ADD")
public class Site extends HttpServlet {

	
	private static final long serialVersionUID = -2985168944872397161L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
		System.out.println("doPost");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
		System.out.println("DoGet");
	}
	
	void process(HttpServletRequest req, HttpServletResponse resp) {
		final String pat ="^[0-9]{1,7}$";
		Pattern p = Pattern.compile(pat);
		String first =req.getParameter("NUMBER1");
		String second = req.getParameter("NUMBER2");
		Matcher m1 =p.matcher(first);
		Matcher m2 = p.matcher(second);
		try {
			if(m1.matches() && m2.matches()) {
				resp.getOutputStream().println(Integer.parseInt(first ) + Integer.parseInt(second));
			}
			else resp.getOutputStream().println("Bad input");
				
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
