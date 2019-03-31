package serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class Res extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3242909457741935301L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doSomething(req, resp);
		System.out.println("DoPost");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doSomething(req, resp);
		System.out.println("DoGet");
	}

	void doSomething(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Model model = (Model) req.getAttribute("Result");
			resp.getOutputStream().println(model.toString());
			resp.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
