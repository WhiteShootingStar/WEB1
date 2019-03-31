package serv;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ADD")
public class Site extends HttpServlet {

	private static final long serialVersionUID = -2985168944872397161L;
	final Logic logic = new Logic();

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
		
	}

	void process(HttpServletRequest req, HttpServletResponse resp) {
		final String pat = "^[0-9]{1,7}$";
		Pattern p = Pattern.compile(pat);
		String first = req.getParameter("NUMBER1");
		String second = req.getParameter("NUMBER2");
		Matcher m1 = p.matcher(first);
		Matcher m2 = p.matcher(second);
		int firstNumber = 0;
		int secondNumber = 0;

		if (m1.matches()) {
			firstNumber = Integer.parseInt(first);
		}
		if (m2.matches()) {
			secondNumber = Integer.parseInt(second);
		}
		Model model = logic.makeModel(firstNumber, secondNumber);
		req.setAttribute("Result", model);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/result");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
