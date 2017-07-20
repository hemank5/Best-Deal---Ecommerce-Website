

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * Servlet implementation class ViewReview
 */
@WebServlet(description = "ViewReview", urlPatterns = { "/ViewReview" })
public class ViewReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		Utilities utility = new Utilities(request, pw);
		String productName = request.getParameter("maker");
		ArrayList<Review> arReview = new ArrayList<>();
		
		DBCollection myReviews;
		MongoClient mongo;
		mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("CustomerReviews");
		myReviews= db.getCollection("myReviews");
		
		BasicDBObject query = new BasicDBObject();
		query.put("productName", productName);
		DBCursor dbCursor = myReviews.find(query);
		
		HashMap<String, ArrayList<Review>> hmReview = new HashMap<>();
		hmReview = MongoDBDataStoreUtilities.selectReview();
		
		arReview = hmReview.get(productName);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		
		pw.print("<table border='1'>");
		while (dbCursor.hasNext()){
			BasicDBObject bobj = (BasicDBObject) dbCursor.next();
			pw.print("<tr><td align='center' colspan='2'></td></tr><tr><td>User Id: </td><td>" +
			bobj.getString("userName") + "</td></tr>"
			+ "<tr><td>Rating:</td><td>" + bobj.getString("reviewRating") + "</td></tr>"
			+ "<tr><td>Date:</td><td>" + bobj.getString("reviewDate") + "</td></tr>"
			+ "<tr><td>Review Text:</td><td>" + bobj.getString("reviewText")+"</td><tr>"
			+ "<tr><td>RetailerCity:</td><td>" + bobj.getString("city")+"</td><tr>"
			+ "<tr><td>RetailerState:</td><td>" + bobj.getString("state")+"</td><tr>"
			+ "<tr><td>Zipcode:</td><td>" + bobj.getString("zipcode")+"</td><tr>"
			+ "<tr><td>Onsale</td><td>" + bobj.getString("productonsale")+"</td><tr>"
			+ "<tr><td>Occupation:</td><td>" + bobj.getString("occupation")+"</td><tr>"
			+ "<tr><td>Age:</td><td>" + bobj.getString("age")+"</td><tr>"
			+ "<tr><td>Maker:</td><td>" + bobj.getString("maker")+"</td><tr>"
			+ "<tr><td>ManufacturerRebate:</td><td>" + bobj.getString("productonsale")+"</td><tr>"
			
			
			
					);
		}
		pw.print("</table>");
		//No data found
		if(dbCursor.count() == 0){
			pw.print("<h2>No Data Found</h2>");
		}

		pw.print("</div></div></div>");		
		utility.printHtml("Footer.html");


	}

}
