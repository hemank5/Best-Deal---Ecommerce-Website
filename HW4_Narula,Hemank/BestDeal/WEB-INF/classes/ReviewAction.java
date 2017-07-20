import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReviewAction
 */
@WebServlet(description = "ReviewAction", urlPatterns = { "/ReviewAction" })
public class ReviewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//String rating;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		rating = request.getParameter("rating");
*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		Utilities utility = new Utilities(request, pw);
		String productName = request.getParameter("name");
		String productType = request.getParameter("type");
		String rating = request.getParameter("rating");
		String date = request.getParameter("date");
		String review = request.getParameter("reviewtext");
		String zipcode = request.getParameter("zipcode");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String age = request.getParameter("age");
		String occupation = request.getParameter("occupation");
		String maker = request.getParameter("maker");
		String gender = request.getParameter("gender");
		String rebate = request.getParameter("rebate");
		String retailername = request.getParameter("retailername");
		String onsale = request.getParameter("onsale");
		
		System.out.println("Inside ReviewAction zipcode: "+zipcode);
		//doGet(request, response);
		utility.storeReview(productName,zipcode, productType, rating, date, review,state,city,age,occupation,
				maker,gender,rebate,retailername,onsale);
		
		/*System.out.println(productName);
		System.out.println(productType);
		System.out.println(productMaker);
		System.out.println(rating);
		System.out.println(date);
		System.out.println(review);*/


		/* From the HttpServletRequest variable name,type,maker information are obtained.*/

		
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.println("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.println("<a style='font-size: 24px;'>Review Form</a>");
		pw.println("</h2><div class='entry'>");

		pw.print("<h4>Review for "+productName+" stored. Thank you!</h4>");
		utility.printHtml("Footer.html");


	}

}
