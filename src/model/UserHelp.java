package model;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserHelp {

	public static Bhuser getUserByEmail(String Email) {
		EntityManager em= DBUtil.getEmFactory().createEntityManager();
		String qString ="Select u from Bhuser u "
				+ "where u.useremail= :useremail";
		TypedQuery<Bhuser> q =em.createQuery(qString,Bhuser.class);
		q.setParameter("useremail", Email);
		Bhuser User =null;		
		try{
			User = q.getSingleResult();
		}catch(NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
			
		}

		return User;
	
	}
	public static boolean isValidUser(String email,String password){
		EntityManager em= DBUtil.getEmFactory().createEntityManager();
		String qString ="Select count(b.bhuserid) from Bhuser b "
				+ " where b.useremail= :useremail"
				+ " and b.userpassword=:userpass";
		TypedQuery<Long> q =em.createQuery(qString,Long.class);
		boolean result =false;
		q.setParameter("useremail", email);
		q.setParameter("userpass", password);
		try{
			Long UserId = q.getSingleResult();
			if (UserId >0)
			{
				result=true;
			}
		}catch(NoResultException e){
			result=false;;
		}finally{
			em.close();
			
		}
          return result;
	
	}
	public static String gettablelist(ArrayList<Bhuser> userlist, int columnCount)
	{
		StringBuilder tablelist = new StringBuilder();
		
		tablelist.append("<table>");
		tablelist.append("<tr>");
		tablelist.append("<thead><tr><th>SLNO</th><th>Email</th><th>Username</th>"
    +"<th>Password</th></tr></thead>");
		for (int i=1; i<=columnCount; i++){
			tablelist.append("<th>");
			}
		tablelist.append("</tr>");
			for(Bhuser users:userlist){
				for (int i=1; i<=columnCount; i++){
					tablelist.append("<td>");
					tablelist.append(users.getBhuserid());
					tablelist.append(users.getUseremail());
					tablelist.append(users.getUsername());
					tablelist.append(users.getUserpassword());
					tablelist.append("</td>");
				}
				tablelist.append("</tr>");
			}
			tablelist.append("<table>");
			//System.out.println(tablelist.toString());
			return tablelist.toString();
		}
public static String getGravatarURL(String useremail, int size){
		
		return ("https://www.gravatar.com/avatar/" +MD5Util.md5Hex(useremail) +"?s=" +size);
	}
}