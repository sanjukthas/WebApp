
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bhpost;
import model.Bhuser;
import model.DbBullhorn;
import model.DbUser;
import model.UserHelp;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUser() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String userMotto = request.getParameter("userMotto");
		HttpSession session = request.getSession();
		Bhuser au = new Bhuser();
		au.setUsername(userName);
		au.setUseremail(userEmail);
		au.setUserpassword(userPassword);
		au.setMotto(userMotto);
		DbUser.insert(au);
		session.setAttribute("user", au);
		int size = 30;
		String gravatarURL = UserHelp.getGravatarURL(au.getUseremail(), size);
		System.out.println(gravatarURL);
		session.setAttribute("gravatarURL", gravatarURL);
		request.setAttribute("message", au.getUseremail());
		List<Bhpost> posts = null;
		posts = DbBullhorn.postsofUser(userEmail);
		request.setAttribute("posts", posts);
		String nextURL = "/Home.jsp";
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
