package com.bhavuk.SpringBatchTut.Address;

import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student,Student> {

	@Override
	public Student process(Student item) throws Exception {
		if(item.getFirst_name().equals("")||item.getLast_name().equals("")||item.getPhone()==0)
		{
			return null;
		}
		
		if(item.getPhone()>10)
		{
			return null;
		}
		
		
		return item;
	}

}
