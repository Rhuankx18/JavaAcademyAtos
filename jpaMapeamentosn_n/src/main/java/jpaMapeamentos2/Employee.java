package jpaMapeamentos2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int eid;
	private String ename;
	private double salary;
	private String deg;
	
	@ManyToMany(targetEntity=Department.class)
	@JoinTable(name = "employee_department", 
	joinColumns = @JoinColumn(name = "employee_id"), 
	inverseJoinColumns = @JoinColumn(name = "department_id"))
	
	private List<Department> departmentSet;
	
	
	public Employee() {
		super();
	}
	
	public Employee(int eid, String ename, double salary, String deg, List<Department> departmentSet) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.deg = deg;
		this.departmentSet = departmentSet;
	}


	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}

	public List<Department> getDepartmentSet() {
		return departmentSet;
	}

	public void setDepartmentSet(List<Department> departmentSet) {
		this.departmentSet = departmentSet;
	}
	
	
}
