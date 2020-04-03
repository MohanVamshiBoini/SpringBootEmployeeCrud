package com.cap.anurag.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cap.anurag.entities.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		Query q = entityManager.createQuery("select e from Employee e");
		List<Employee> l = q.getResultList();
		return l;
	}

	@Override
	public Employee getEmployeeById(Integer id) throws RecordNotFoundException {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public Employee update(Employee entity) throws RecordNotFoundException {
		Employee employee = entityManager.find(Employee.class, entity.getId());
		employee.setName(entity.getName());
        employee.setSalary(entity.getSalary());
		return entityManager.merge(employee);
	}

	@Override
	public Employee create(Employee entity) throws RecordNotFoundException {
		return entityManager.merge(entity);

	}

	@Override
	public void deleteEmployeeById(Integer id) throws RecordNotFoundException {
		Employee employee = entityManager.find(Employee.class, id);

		entityManager.remove(entityManager.merge(employee));

	}
}
