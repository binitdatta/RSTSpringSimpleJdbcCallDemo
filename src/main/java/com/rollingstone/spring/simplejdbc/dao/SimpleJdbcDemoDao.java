package com.rollingstone.spring.simplejdbc.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rollingstone.spring.simplejdbc.domain.Employee;

/**
 * @author Binit Datta
 *
 */
@Component
@Transactional
public class SimpleJdbcDemoDao extends JdbcDaoSupport implements
		ISimpleJdbcDemoDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(SimpleJdbcDemoDao.class);

	private String clobToString(Clob clob) {
		Reader reader = null;
		try {
			reader = clob.getCharacterStream();
			BufferedReader buffReader = new BufferedReader(reader);
			String line = null;
			StringBuffer buff = new StringBuffer();
			while ((line = buffReader.readLine()) != null) {
				buff.append(line);
			}
			return buff.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return clob.toString();
	}

	@Override
	public String getAppraisalRemarks(long empId) throws IOException,
			SQLException {
		SimpleJdbcCall simpleCall = new SimpleJdbcCall(getDataSource());

		simpleCall
				.withFunctionName(IRSTConstrants.F_EMP_GET_APPRAISAL_REMARKS)
				.withReturnValue()
				.declareParameters(new SqlParameter("IN_EMP_ID", Types.VARCHAR))
				.declareParameters(
						new SqlOutParameter("RETURN_VALUE", Types.CLOB));

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue(
				"IN_EMP_ID", empId, Types.VARCHAR);

		simpleCall.compile();

		Clob clobRetVal = simpleCall.executeFunction(Clob.class, paramMap);

		return clobToString(clobRetVal);
	}

	@Override
	public String createAppraisalRemarks(long empId, String remarks)
			throws SQLException {
		SimpleJdbcCall simpleCall = new SimpleJdbcCall(getDataSource());

		simpleCall
				.withFunctionName(IRSTConstrants.F_EMP_CREATE_APPRAISAL_REMARKS)
				.withReturnValue()
				.declareParameters(new SqlParameter("IN_EMP_ID", Types.VARCHAR))
				.declareParameters(
						new SqlParameter("IN_APPR_COMMENTS", Types.CLOB));

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue(
				"IN_EMP_ID", empId, Types.VARCHAR).addValue("IN_APPR_COMMENTS",
				remarks, Types.CLOB); 

		simpleCall.compile();

		String retVal = simpleCall.executeFunction(String.class, paramMap);

		return retVal;
	}

	@Override
	public String createEmployee(Employee emp) {
		SimpleJdbcCall simpleCall = new SimpleJdbcCall(getDataSource());

		simpleCall
				.withFunctionName(IRSTConstrants.F_EMP_CREATE_EMPLOYEE)
				.withReturnValue()
				.declareParameters(new SqlParameter("IN_EMP_ID", Types.NUMERIC))
				.declareParameters(
						new SqlParameter("IN_EMP_NAME", Types.VARCHAR))
				.declareParameters(new SqlParameter("IN_EMP_DOB", Types.DATE))
				.declareParameters(new SqlParameter("IN_EMP_DOJ", Types.DATE))
				.declareParameters(new SqlParameter("IN_SALARY", Types.FLOAT));

		SqlParameterSource paramMap = new MapSqlParameterSource()
				.addValue("IN_EMP_ID", emp.getEmpId(), Types.NUMERIC)
				.addValue("IN_EMP_NAME", emp.getEmpName(), Types.VARCHAR)
				.addValue("IN_EMP_DOB", emp.getDob(), Types.DATE)
				.addValue("IN_EMP_DOJ", emp.getDoj(), Types.DATE)
				.addValue("IN_SALARY", emp.getSalary(), Types.FLOAT);

		simpleCall.compile();

		String retVal = simpleCall.executeFunction(String.class, paramMap);

		return retVal;
	}

	@Override
	public String deleteEmployee(Employee emp) {
		SimpleJdbcCall simpleCall = new SimpleJdbcCall(getDataSource());

		simpleCall
				.withFunctionName(IRSTConstrants.F_EMP_DELETE_EMPLOYEE)
				.withReturnValue()
				.declareParameters(new SqlParameter("IN_EMP_ID", Types.VARCHAR));

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue(
				"IN_EMP_ID", emp.getEmpId(), Types.VARCHAR);

		simpleCall.compile();

		String retVal = simpleCall.executeFunction(String.class, paramMap);

		return retVal;
	}

	@Override
	public String updateEmployee(long empId, Employee emp) {
		SimpleJdbcCall simpleCall = new SimpleJdbcCall(getDataSource());

		simpleCall
				.withFunctionName(IRSTConstrants.F_EMP_UPDATE_EMPLOYEE)
				.withReturnValue()
				.declareParameters(new SqlParameter("IN_EMP_ID", Types.NUMERIC))
				.declareParameters(
						new SqlParameter("IN_EMP_NAME", Types.VARCHAR))
				.declareParameters(new SqlParameter("IN_EMP_DOB", Types.DATE))
				.declareParameters(new SqlParameter("IN_EMP_DOJ", Types.DATE))
				.declareParameters(new SqlParameter("IN_SALARY", Types.FLOAT));

		SqlParameterSource paramMap = new MapSqlParameterSource()
				.addValue("IN_EMP_ID", emp.getEmpId(), Types.NUMERIC)
				.addValue("IN_EMP_NAME", emp.getEmpName(), Types.VARCHAR)
				.addValue("IN_EMP_DOB", emp.getDob(), Types.DATE)
				.addValue("IN_EMP_DOJ", emp.getDoj(), Types.DATE)
				.addValue("IN_SALARY", emp.getSalary(), Types.FLOAT);

		simpleCall.compile();

		String retVal = simpleCall.executeFunction(String.class, paramMap);

		return retVal;
	}

}
