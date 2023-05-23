package Principal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpaMapeamentos2.Employee;
import jpaMapeamentos2.Department;
public class ManyToMany {
	public static void main(String[] args)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("dbjpan_n");
	
		EntityManager entitymanager = emfactory.createEntityManager();
	
		entitymanager.getTransaction().begin();
		
		Department department = new Department("Empresário",null);
		Department department2 = new Department("Programador",null);
		Department department3 = new Department("Saúde",null);
		
		entitymanager.persist(department);
		entitymanager.persist(department2);
		entitymanager.persist(department3);
	
		List<Department> departmentSet1 = new ArrayList();
		departmentSet1.add(department);
		
		List<Department> departmentSet2 = new ArrayList();
		departmentSet2.add(department2);
		
		List<Department> departmentSet3 = new ArrayList();
		departmentSet3.add(department3);
		
		

//		Employee employee1 = new Employee();
//		employee1.setEname("Carlos");
//		employee1.setSalary(8000.0);
//		employee1.setDeg("Lojista");
//		employee1.setDepartmentSet(departmentSet1);
//		
//		Employee employee2 = new Employee();
//		employee2.setEname("Rhuan");
//		employee2.setSalary(10000.0);
//		employee2.setDeg("Dev Junior");
//		employee2.setDepartmentSet(departmentSet2);
//
//		Employee employee3 = new Employee();
//		employee3.setEname("Marcos");
//		employee3.setSalary(11000.0);
//		employee3.setDeg("Médico");
//		employee3.setDepartmentSet(departmentSet3);
		
		Employee employee4 = new Employee();
		employee4.setEname("Marcos");
		employee4.setSalary(11000.0);
		employee4.setDeg("Médico");
		employee4.setDepartmentSet(departmentSet3);
		
		
		
//		entitymanager.persist(employee1);
//		entitymanager.persist(employee2);
//		entitymanager.persist(employee3);
		entitymanager.persist(employee4);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	
}
