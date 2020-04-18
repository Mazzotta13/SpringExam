package com.alessio.JPA;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;
	private TransactionTemplate transactionTemplate;
	
	public EmployeeService(EmployeeRepository employeeRepository, 
			PlatformTransactionManager transactionManager) {
		this.employeeRepository = employeeRepository;
		this.transactionTemplate = new TransactionTemplate(transactionManager);
	}
	
	@Transactional(value = TxType.MANDATORY)
	public void testTransaction() throws Exception {
		employeeRepository.save(new Employee("15", "test15", "test1@email"));
		throw new Exception("ExceptionTest");
	}
	
	public void testTransaction2() throws Exception {
		transactionTemplate.setTimeout(1000);
		transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
		transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		transactionTemplate.execute(new TransactionCallback<String>() {
			@Override
			public String doInTransaction(TransactionStatus status) {
				employeeRepository.save(new Employee("17", "test17", "test1@email"));
				throw new RuntimeException("ExceptionTest");
			}
		});
	}
}
