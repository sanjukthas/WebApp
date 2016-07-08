

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bhpost;
import model.DbBullhorn;
import model.UserHelp;
import model.Bhuser;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		UserHelp.isValidUser(email, password);
		HttpSession session = request.getSession();
		Bhuser user = null;
		
		if (UserHelp.isValidUser(email, password))
		{
			
			request.setAttribute("message", email);
			 List<Bhpost> posts = null;
			 posts = DbBullhorn.postsofUser(email);
			
				request.setAttribute("posts", posts);
				
					
	    }
		else{
			System.out.println("Incorrect");
		}
		
		
		user = UserHelp.getUserByEmail(email);
		session.setAttribute("user", user);
			int size = 30;
			String gravatarURL = UserHelp.getGravatarURL(email, size);
			System.out.println(gravatarURL);
			session.setAttribute("gravatarURL", gravatarURL);
			 String nextURL = "Home.jsp";
		
		
		request.getRequestDispatcher(nextURL).forward(request,response);		
		
	}

}
