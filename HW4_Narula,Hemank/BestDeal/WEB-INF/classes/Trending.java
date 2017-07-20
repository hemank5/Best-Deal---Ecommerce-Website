import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

@WebServlet("/Trending")

public class Trending extends HttpServlet {

	/* Trending Page Displays all the Consoles and their Information in Game Speed*/

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		/* Checks the Consoles type whether it is microsft or sony or nintendo then add products to hashmap*/

				

		/* Header, Left Navigation Bar are Printed.

		All the consoles and Console information are dispalyed in the Content Section

		and then Footer is Printed*/
		
		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'> Trending</a>");
		pw.print("</h2><div class='entry'>");
		
		pw.print("<table><tr><h3> Most liked Products </h3></tr>");
		MongoDBDataStoreUtilities.getMostLikedProducts(pw);
		pw.print("</table>");
						
		pw.print("<table><tr><h3> Most Sold Products regardless of rating </h3></tr>");
		MongoDBDataStoreUtilities.getTopProducts(pw);
		pw.print("</table>");
		
		pw.print("<table><tr><h3> Most Liked Products based on Zip code </h3></tr>");
		MongoDBDataStoreUtilities.getZipcodes(pw);
		pw.print("</table>");
		
		pw.print("</table></div></div></div>");	
		utility.printHtml("Footer.html");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}
	}


