import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")

/*
 * Home class uses the printHtml Function of Utilities class and prints the
 * Header,LeftNavigationBar, Content,Footer of Best Deal Application.
 * 
 */

public class Home extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3455985009740567509L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String searchId = request.getParameter("searchId");

		if (searchId != null && action != null) {

			StringBuffer sb = new StringBuffer();
			boolean namesAdded = false;
			if (action.equals("complete")) {
				if (!searchId.equals("")) {
					AjaxUtility a = new AjaxUtility();
					try {
						sb = a.readdata(searchId);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if (sb != null || !sb.equals("")) {
						namesAdded = true;
					}
					if (namesAdded) {
						response.setContentType("text/xml");
						response.getWriter().write("<products>" + sb.toString() + "</products>");
					}
				}
			}
			
			if (action.equals("lookup")) {
				// Lookup
			}

		} else {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();

			Utilities utility = new Utilities(request, pw);
			utility.printHtml("Header.html");
			utility.printHtml("LeftNavigationBar.html");
			utility.printHtml("Content.html");
			utility.printHtml("Footer.html");
		}

	}

}
