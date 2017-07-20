import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SmartPhoneList")

public class SmartPhoneList extends HttpServlet {

	/* Console Page Displays all the Consoles and their Information in Game Speed */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = null;
		String CategoryName = request.getParameter("maker");


		/* Checks the Tablets type */

		HashMap<String, SmartPhone> hm = new HashMap<String, SmartPhone>();
		if(CategoryName==null){
			hm.putAll(SaxParserDataStore.smartphones);
			name = "";
		}
		else
		{
		   if(CategoryName.equals("apple"))
		   {
			 for(Map.Entry<String,SmartPhone> entry : SaxParserDataStore.smartphones.entrySet())
			 {
				if(entry.getValue().getRetailer().equals("Apple"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
			 }
				name = "Apple";
		   }
		   else if(CategoryName.equals("samsung"))
		    {
			for(Map.Entry<String,SmartPhone> entry : SaxParserDataStore.smartphones.entrySet())
				{
				 if(entry.getValue().getRetailer().equals("Samsung"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
				 name = "Samsung";
			}
			else if(CategoryName.equals("motorola"))
			{
				for(Map.Entry<String,SmartPhone> entry : SaxParserDataStore.smartphones.entrySet())
				{
				 if(entry.getValue().getRetailer().equals("Motorola"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Motorola";
			}
		}
		
		/* Header, Left Navigation Bar are Printed.

		All the Smartphone and Smartphone information are displayed in the Content Section

		and then Footer is Printed*/

		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>"+name+" SmartPhones</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1; int size= hm.size();
		for(Map.Entry<String, SmartPhone> entry : hm.entrySet())
		{
			
			SmartPhone smartphone = entry.getValue();
			if(i%3==1) pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>"+smartphone.getName()+"</h3>");
			pw.print("<strong>$"+smartphone.getPrice()+"</strong><ul>");
			pw.print("<li id='item'><img src='images/smartphone/"+smartphone.getImage()+"' alt='' /></li>");
			pw.print("<li><form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+smartphone.getName()+"'>"+
					"<input type='hidden' name='type' value='smartphones'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='hidden' name='state' value='new york city'>"+
					"<input type='hidden' name='city' value='New york'>"+
					"<input type='hidden' name='zipcode' value='10008'>"+
					"<input type='hidden' name='onsale' value='yes'>"+
					"<input type='hidden' name='retailername' value='BestDeal'>"+
					"<input type='hidden' name='rebate' value='10%'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form></li>");
			pw.print("<li><form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='"+smartphone.getName()+"'>"+
					"<input type='hidden' name='type' value='smartphones'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='hidden' name='state' value='new york city'>"+
					"<input type='hidden' name='city' value='New York'>"+
					"<input type='hidden' name='zipcode' value='10008'>"+
					"<input type='hidden' name='onsale' value='yes'>"+
					"<input type='hidden' name='retailername' value='BestDeal'>"+
					"<input type='hidden' name='rebate' value='10%'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='WriteReview' class='btnreview'></form></li>");
			pw.print("<li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+smartphone.getName()+"'>"+
					"<input type='hidden' name='type' value='smartphones'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='hidden' name='state' value='new york city'>"+
					"<input type='hidden' name='city' value='New York'>"+
					"<input type='hidden' name='zipcode' value='10008'>"+
					"<input type='hidden' name='onsale' value='yes'>"+
					"<input type='hidden' name='retailername' value='BestDeal'>"+
					"<input type='hidden' name='rebate' value='10%'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='ViewReview' class='btnreview'></form></li>");
			
			pw.print("</ul></div></td>");
			if(i%3==0 || i == size) pw.print("</tr>");
			i++;
		}		
		pw.print("</table></div></div></div>");		
		utility.printHtml("Footer.html");
		
	}
}
