package hibernate.sample;

import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class HibernateusingInsert
{
	public  void insert()
	{
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tran = session.beginTransaction();
			Employee employee = new Employee();

			employee.setEmployeeCode("instage14");
			employee.setEmployeeName("visu");
			employee.setEmployeeDepartment("IT");
			employee.setEmployeeDOJ(new Date(10/10/2009));

			session.saveOrUpdate(employee);
			tran.commit();
		} catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("error");
		} 
		finally {
			if (session != null) {
				session.flush();
				System.out.println("After Flush is called");
				session.close();
				System.out.println("After close is called");
			}
		}
	}

}
