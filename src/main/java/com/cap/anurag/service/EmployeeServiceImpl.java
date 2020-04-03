package com.cap.anurag.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.anurag.dao.EmployeeDao;
import com.cap.anurag.entities.Employee;

@Service//@Component
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
    private EmployeeDao dao;

	public EmployeeDao getDao() {
		return dao;
	}

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return dao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeById(id);
	}

	@Override
	public Employee create(Employee employee) {
		// TODO Auto-generated method stub
		return dao.create(employee);
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		dao.deleteEmployeeById(id);
		
	}

	@Override
	public Employee update(Employee employee) {
		return dao.update(employee);
	}

}
