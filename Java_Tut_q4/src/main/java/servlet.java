

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet
 */
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String item1=request.getParameter("item1");
		String item2=request.getParameter("item2");
		String item3=request.getParameter("item3");
		String item4=request.getParameter("item4");
		String e[]= {item1,item2,item3,item4};
		
		int price=0;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","Forti");
			System.out.println("Connected With the database successfully");
			Statement cur=conn.createStatement();
			for (String i:e) {
				if(i!=null) {
					ResultSet rs=cur.executeQuery(String.format("select price from price where item='%s'",i));
					rs.next();
					price+=Integer.parseInt(rs.getString(1));
				}
			}
			/*RequestDispatcher view=request.getRequestDispatcher("SignUp.html");
			view.forward(request, response);*/
			
			/*response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.print("<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Shopping Cart</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<center>\r\n"
					+ "	<font color=\"blue\" size=\"6\">Shopping Cart</font><br><br>\r\n"
					+ "	<form method=\"get\" action=\"servlet\">      \r\n"
					+ "              <input type=\"checkbox\" id=\"item1\" name=\"item1\" value=\"item1\"/>    \r\n"
					+ "                  <label>item1 (/-50)</label> <br>\r\n"
					+ "              <input type=\"checkbox\" id=\"item2\" name=\"item2\" value=\"item2\"/>    \r\n"
					+ "                 <label>item2 (/-100)</label> <br>    \r\n"
					+ "              <input type=\"checkbox\" id=\"item3\" name=\"item3\" value=\"item3\"/>    \r\n"
					+ "                 <label>item3 (/-70)</label> <br>  \r\n"
					+ "         	  <input type=\"checkbox\" id=\"item4\" name=\"item4\" value=\"item4\"/>    \r\n"
					+ "                 <label>item4 (/-110)</label> <br> \r\n"
					+ "              <input type=\"Submit\" value=\"Add to Cart\"/>\r\n"
					+ "</form>\r\n"
					+ "\r\n"
					+ price+"\r\n"
					+ "</body>\r\n"
					+ "</html>");*/
			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Shopping Cart</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<center>\r\n"
				+ "	<font color=\"blue\" size=\"6\">Shopping Cart</font><br><br>\r\n"
				+ "	<form method=\"get\" action=\"servlet\">      \r\n"
				+ "              <input type=\"checkbox\" id=\"item1\" name=\"item1\" value=\"item1\"/>    \r\n"
				+ "                  <label>item1 (/-50)</label> <br>\r\n"
				+ "              <input type=\"checkbox\" id=\"item2\" name=\"item2\" value=\"item2\"/>    \r\n"
				+ "                 <label>item2 (/-100)</label> <br>    \r\n"
				+ "              <input type=\"checkbox\" id=\"item3\" name=\"item3\" value=\"item3\"/>    \r\n"
				+ "                 <label>item3 (/-70)</label> <br>  \r\n"
				+ "         	  <input type=\"checkbox\" id=\"item4\" name=\"item4\" value=\"item4\"/>    \r\n"
				+ "                 <label>item4 (/-110)</label> <br> \r\n"
				+ "              <input type=\"Submit\" value=\"Add to Cart\"/>\r\n"
				+ "</form>\r\n"
				+ "\r\n"
				+ "Your bill is = "+price+"\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

}
