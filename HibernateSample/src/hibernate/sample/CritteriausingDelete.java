package hibernate.sample;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
public class CritteriausingDelete 
{

	Session session = null;
	public static void main(String[] args)
	{
		
		/*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
        session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();
        
        Long employeeId=42L;
        Criteria criteria=session.createCriteria(Employee.class);
        criteria.add(Expression.eq("id",employeeId));
        List list=criteria.list();
        for(Iterator it = list.iterator();it.hasNext();)
        {
         Employee employee=(Employee) it.next();	
         System.out.println("Employee id:"+employee.getId());
         System.out.println("Employee name:"+employee.getEmployeeName());*/
         like();
        }
	 public static void like()
	 {
		    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = null;
	        session = sessionFactory.openSession();
	        Transaction tran = session.beginTransaction();
	        Criteria criteria=session.createCriteria(Employee.class);
	        criteria.add(Restrictions.like("employeeName","G%"));
	        List list=criteria.list();
	        for(Iterator it = list.iterator();it.hasNext();)
	        {
	         Employee employee=(Employee) it.next();	
	         System.out.println("Employee id:"+employee.getId());
	         System.out.println("Employee name:"+employee.getEmployeeName());
	         
	        }
	  }
	 
}
