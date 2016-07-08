

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bhpost;
import model.Bhuser;
import model.DBUtil;
import model.DbBullhorn;
import model.UserHelp;
import model.DbUser;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
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
		try {
			Bhpost bhPost = new Bhpost();
			Date postdate = new Date();
			HttpSession session = request.getSession();
			
			
			
			String posttext = request.getParameter("posttext");
			Bhuser user = (Bhuser)session.getAttribute("user");
			
			bhPost.setPostdate(postdate);
			bhPost.setPosttext(posttext);
		
			bhPost.setBhuser(user);
			DbBullhorn.insert(bhPost);
			
				System.out.println("The user id is: " + user.getBhuserid());
				String nextURL = "/NewFeed.jsp";
				List<Bhpost> posts = DbBullhorn.getAllPost();
				System.out.println(posts.get(0));
				request.setAttribute("posts", posts);
				System.out.println(posts.get(0).getBhuser().getGravatorurl());
				request.getRequestDispatcher(nextURL).forward(request,response);
			} catch (NoResultException e){
				e.printStackTrace();
			} catch (NonUniqueResultException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
				
				
	}

}
