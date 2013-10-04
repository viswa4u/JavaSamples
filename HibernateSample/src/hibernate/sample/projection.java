package hibernate.sample;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class projection {
	public static void main(String[] args) 
  {
	  Session session = null;
	  int count=0;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			Employee employee = new Employee();
			Transaction tran = session.beginTransaction();
			Criteria criteria=session.createCriteria(Employee.class);
			criteria.setProjection(Projections.rowCount());
			List result=criteria.list();
			System.out.println("The Total Row is:"+result);
			criteria.setProjection(Projections.distinct(Projections.countDistinct("employeeName")));
			List dist=criteria.list();
			System.out.println("The Distinct Row is"+dist);
		    criteria.setProjection(Projections.avg("id"));
		    List avg=criteria.list();
		    System.out.println("The avg is:"+avg);
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
