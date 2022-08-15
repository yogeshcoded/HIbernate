package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.util.HBUtil;

public class CompanyDAOImpl implements ICompanyDAO {

	@Override
	public void saveDataUsingParent() {
		// session object
		Session sec=HBUtil.getSession();
		Transaction tx=null;
		try(sec){
			tx=sec.beginTransaction();
			//create parent object 
			Department dept=new Department();
			dept.setDeptName("IT"); dept.setDeptHead("Scott");
			//create child object 
			Employee emp1=new Employee();
			emp1.setEmpName("Raja"); emp1.setEmpSalary(42000);
			Employee emp2=new Employee();
			emp2.setEmpName("Bujji"); emp2.setEmpSalary(78000);
			
			//set child to parent
			dept.setEmployees(Set.of(emp1,emp2));
			//set parent to child
			emp1.setDept(dept);emp2.setDept(dept);
			
			sec.save(dept);
			tx.commit();
			System.out.println("Record is save");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null&&tx.getRollbackOnly()&&tx.getStatus()!=null) {
				tx.rollback();
				System.out.println("Record not save");
			}//if
		}//catch
	}//method(-,-)

	//======================================  saveDataUsingChild  ================
	@Override
	public void saveDataUsingChild() {
		// session object
		Session sec=HBUtil.getSession();
		Transaction tx=null;
		try(sec){
			tx=sec.beginTransaction();
			//create parent object 
			Department dept=new Department();
			dept.setDeptName("Account"); dept.setDeptHead("Scott");
			//create child object 
			Employee emp1=new Employee();
			emp1.setEmpName("Mahesh"); emp1.setEmpSalary(42000);
			Employee emp2=new Employee();
			emp2.setEmpName("Paresh"); emp2.setEmpSalary(78000);
			
			//set child to parent
			dept.setEmployees(Set.of(emp1,emp2));
			//set parent to child
			emp1.setDept(dept);emp2.setDept(dept);
			//save parent data object using child object
			sec.save(emp1); sec.save(emp2);
			tx.commit();
			System.out.println("Record is save");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null&&tx.getRollbackOnly()&&tx.getStatus()!=null) {
				tx.rollback();
				System.out.println("Record not save");
			}//if
		}//catch
		
	}//method(-,-)
	
	//======================================   load Data Using Parent  ================
	@Override
	public void loadDataUsingParent() {
		// Session
		Session sec =HBUtil.getSession();
		try(sec){
		//load parent object with child
		Query query=sec.createQuery("from Department");
		List<Department> list=query.getResultList();
		list.forEach(dept->{
			System.out.println("Parent:: "+dept);
			Set<Employee> childs=dept.getEmployees();
			/*	childs.forEach(emp->{
					System.out.println("Child:: "+emp);
				});*/
					});
		
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			}//load(--)
	
	
	//======================================   load Data Using Child  ================
	@Override
	public void loadDataUsingChild() {
		// Session
		Session sec=HBUtil.getSession();
		try(sec){
			//load parent object with child
			Query query=sec.createQuery("from Employee");
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println("Child:: "+emp);
					Department dept=emp.getDept();
					System.out.println("Parent:: "+dept);
						});
			
			}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
				}//load(--)
	
}//class
