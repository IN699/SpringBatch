package com.bhavuk.SpringBatchTut.Address;

import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student,Student> {

	@Override
	public Student process(Student item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}
