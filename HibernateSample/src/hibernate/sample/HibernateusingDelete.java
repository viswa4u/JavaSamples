package hibernate.sample;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateusingDelete 
{
public void delete()
  {
	Session session = null;
	try
	{
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
  	session = sessionFactory.openSession();
	Transaction tran = session.beginTransaction();
	Employee employee = new Employee();
	Long employeeId=39L;
	String hql="delete from Employee employee  where id =:employeeId";
	Query query = session.createQuery(hql);
	query.setParameter("employeeId",employeeId);
	int row = query.executeUpdate();
	if (row == 0)
	{
	   System.out.println("Doesn't deleted any row!");
	}
	 else
	    {
	        System.out.println("Deleted Row: " + row);
	     }
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		System.out.println("error");
	}
	finally
	{
		if(session != null)
		{
			session.flush();
			System.out.println("After Flush is called");
			session.close();
			System.out.println("After close is called");
		}
	}
  }
}
	  

