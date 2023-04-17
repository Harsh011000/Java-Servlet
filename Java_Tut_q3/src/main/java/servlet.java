

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
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
		String Uname=request.getParameter("Uname");
		String pass=request.getParameter("pass");
		try {
			//Class.forName("com.mysql.jdbc.Driver");
        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","Forti");
			System.out.println("Connected With the database successfully");
			Statement cur=conn.createStatement();
			ResultSet rs=cur.executeQuery("select * from info;");
			int c=0;
			while(rs.next()) {
				if (Uname.equals(rs.getString(1))& pass.equals(rs.getString(2))) {
					RequestDispatcher view=request.getRequestDispatcher("Login Success.html");
					view.forward(request, response);
					++c;
					break;
				}
			}
			if (c==0) {
				RequestDispatcher view=request.getRequestDispatcher("Login Failed.html");
				view.forward(request, response);
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
