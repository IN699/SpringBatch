package com.bhavuk.SpringBatchTut.Address;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StudentStepExecutionListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println(stepExecution.getSummary());	
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		

		System.out.println(stepExecution.getSummary());
		System.out.println();
		return null;
	}

}
