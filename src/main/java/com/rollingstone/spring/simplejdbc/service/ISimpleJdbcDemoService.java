package com.rollingstone.spring.simplejdbc.service;

import java.io.IOException;
import java.sql.SQLException;

import com.rollingstone.spring.simplejdbc.domain.Employee;

/**
 * @author Binit Datta
 *
 */
public interface ISimpleJdbcDemoService {

	String getAppraisalRemarks(long empId) throws IOException, SQLException;

	String createAppraisalRemarks(long empId, String remarks)
			throws SQLException;

	String createEmployee(Employee emp);

	String deleteEmployee(Employee emp);

	String updateEmployee(long empId, Employee emp);

}
