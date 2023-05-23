package Principal;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpaMapeamentos1.Employee;
import jpaMapeamentos1.Department;
public class OneToOne {
	public static void main(String[] args) throws IOException
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("dbjpa1_1");
	
		EntityManager entitymanager = emfactory.createEntityManager();
	
		entitymanager.getTransaction().begin();
		
		Department department = new Department();
		
		department.setName("Oficina");
		
		entitymanager.persist(department);
	

//		Employee employee4 = new Employee();
//		employee4.setEname("Marcos");
//		employee4.setSalary(6000.0);
//		employee4.setDeg("Youtuber");
//		employee4.setDepartment(department);
		Employee employee5 = new Employee();
		employee5.setEname("Paulo");
		employee5.setSalary(3000.0);
		employee5.setDeg("Mecanico");
		employee5.setDepartment(department);
//		entitymanager.persist(employee4);
		entitymanager.persist(employee5);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	
}
