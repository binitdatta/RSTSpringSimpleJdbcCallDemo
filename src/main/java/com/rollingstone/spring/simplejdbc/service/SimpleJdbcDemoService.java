package com.rollingstone.spring.simplejdbc.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.rollingstone.spring.simplejdbc.dao.ISimpleJdbcDemoDao;
import com.rollingstone.spring.simplejdbc.domain.Employee;

/**
 * @author Binit Datta
 *
 */
@Service
public class SimpleJdbcDemoService implements ISimpleJdbcDemoService {

	ISimpleJdbcDemoDao simpleJdbcDemoDao;

	public ISimpleJdbcDemoDao getSimpleJdbcDemoDao() {
		return simpleJdbcDemoDao;
	}

	@Autowired
	@Required
	public void setSimpleJdbcDemoDao(ISimpleJdbcDemoDao simpleJdbcDemoDao) {
		this.simpleJdbcDemoDao = simpleJdbcDemoDao;
	}

	@Override
	public String getAppraisalRemarks(long empId) throws IOException,
			SQLException {
		return simpleJdbcDemoDao.getAppraisalRemarks(empId);

	}

	@Override
	public String createAppraisalRemarks(long empId, String remarks)
			throws SQLException {
		return simpleJdbcDemoDao.createAppraisalRemarks(empId, remarks);
	}

	@Override
	public String createEmployee(Employee emp) {
		return simpleJdbcDemoDao.createEmployee(emp);
	}

	@Override
	public String deleteEmployee(Employee emp) {
		return simpleJdbcDemoDao.deleteEmployee(emp);
	}

	@Override
	public String updateEmployee(long empId, Employee emp) {
		return simpleJdbcDemoDao.updateEmployee(empId, emp);
	}

}
