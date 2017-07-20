import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TelevisionList")

public class TelevisionList extends HttpServlet {

	/* Trending Page Displays all the Tablets and their Information in Best Deal */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

	/* Checks the Television type */

		String name = null;
		String CategoryName = request.getParameter("maker");
		HashMap<String, Television> hm = new HashMap<String, Television>();

		if (CategoryName == null)	
		{
			hm.putAll(SaxParserDataStore.televisions);
			name = "";
		} 
		else 
		{
			if(CategoryName.equals("samsung")) 
			{	
				for(Map.Entry<String,Television> entry : SaxParserDataStore.televisions.entrySet())
				{
				  if(entry.getValue().getRetailer().equals("Samsung"))
				  {
					 hm.put(entry.getValue().getId(),entry.getValue());
				  }
				}
				name ="Samsung";
			} 
			else if (CategoryName.equals("sony"))
			{
				for(Map.Entry<String,Television> entry : SaxParserDataStore.televisions.entrySet())
				{
				  if(entry.getValue().getRetailer().equals("Sony"))
				  {
					 hm.put(entry.getValue().getId(),entry.getValue());
				  }
				}
				name = "Sony";
			} 
			else if (CategoryName.equals("toshiba")) 
			{
				for(Map.Entry<String,Television> entry : SaxParserDataStore.televisions.entrySet())
				{
				  if(entry.getValue().getRetailer().equals("Toshiba"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}	
				name = "Toshiba";
			}
	    }

		/* Header, Left Navigation Bar are Printed.

		All the television and tablet information are displayed in the Content Section

		and then Footer is Printed*/

		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>" + name + " Televisions</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1;
		int size = hm.size();
		for (Map.Entry<String, Television> entry : hm.entrySet()) {
			Television Television = entry.getValue();
			if (i % 3 == 1)
				pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>" + Television.getName() + "</h3>");
			pw.print("<strong>" + Television.getPrice() + "$</strong><ul>");
			pw.print("<li id='item'><img src='images/television/"
					+ Television.getImage() + "' alt='' /></li>");
			pw.print("<li><form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+Television.getName()+"'>"+
					"<input type='hidden' name='type' value='televisions'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='hidden' name='state' value='Texas'>"+
					"<input type='hidden' name='city' value='Dallas'>"+
					"<input type='hidden' name='zipcode' value='75001'>"+
					"<input type='hidden' name='onsale' value='yes'>"+
					"<input type='hidden' name='retailername' value='BestDeal'>"+
					"<input type='hidden' name='rebate' value='10%'>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form></li>");
			pw.print("<li><form method='post' action='WriteReview'>"+
					"<input type='hidden' name='name' value='"+Television.getName()+"'>"+
					"<input type='hidden' name='type' value='televisions'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='hidden' name='state' value='Texas'>"+
					"<input type='hidden' name='city' value='Dallas'>"+
					"<input type='hidden' name='zipcode' value='75001'>"+
					"<input type='hidden' name='onsale' value='yes'>"+
					"<input type='hidden' name='retailername' value='BestDeal'>"+
					"<input type='hidden' name='rebate' value='10%'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='WriteReview' class='btnreview'></form></li>");
			pw.print("<li><form method='post' action='ViewReview'>"+
				    "<input type='hidden' name='name' value='"+Television.getName()+"'>"+
					"<input type='hidden' name='type' value='televisions'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='hidden' name='state' value='Texas'>"+
					"<input type='hidden' name='city' value='Dallas'>"+
					"<input type='hidden' name='zipcode' value='75001'>"+
					"<input type='hidden' name='onsale' value='yes'>"+
					"<input type='hidden' name='retailername' value='BestDeal'>"+
					"<input type='hidden' name='rebate' value='10%'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='ViewReview' class='btnreview'></form></li>");
			
			pw.print("</ul></div></td>");
			if (i % 3 == 0 || i == size)
				pw.print("</tr>");
			i++;
		}
		pw.print("</table></div></div></div>");
		utility.printHtml("Footer.html");
	}
}
