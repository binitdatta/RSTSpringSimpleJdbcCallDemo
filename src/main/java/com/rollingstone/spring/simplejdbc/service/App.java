package com.rollingstone.spring.simplejdbc.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rollingstone.spring.simplejdbc.dao.IRSTConstrants;
import com.rollingstone.spring.simplejdbc.domain.Employee;

/**
 * @author Binit Datta
 *
 */
public class App {

	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");

		SimpleJdbcDemoService service = context.getBean(
				"simpleJdbcDemoService", SimpleJdbcDemoService.class);

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		Date dateofJoining = formatter.parse(IRSTConstrants.DATE_OF_JOIN);
		Date dateofBirth = formatter.parse(IRSTConstrants.DATE_OF_BIRTH);

		Employee emp = new Employee();

		emp.setEmpId(1000);
		emp.setDob(dateofBirth);
		emp.setDoj(dateofJoining);
		emp.setEmpName("Dave Richardsson");
		emp.setSalary(100000);

		String success = service.createEmployee(emp);

		LOG.info("Calling createEmployee ::: " + success);

		success = service.createAppraisalRemarks(emp.getEmpId(),
				"Very Good Performance");

		LOG.info(" Calling createAppraisalRemarks ::: " + success);

		success = service.getAppraisalRemarks(emp.getEmpId());

		LOG.info("Calling getAppraisalRemarks :::" + success);

		emp.setEmpName("Richardsson Dave");

		success = service.updateEmployee(emp.getEmpId(), emp);

		LOG.info(" Calling updateEmployee :::" + success);

		success = service.deleteEmployee(emp);

		LOG.info(" Calling deleteEmployee ::: " + success);

		context.close();

	}
}