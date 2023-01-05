package com.bhavuk.SpringBatchTut.Address;

import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student,Student> {

	@Override
	public Student process(Student item) throws Exception {
		
		long num=0;
		
		if(item.getFirstName().equals("")||item.getLastName().equals("") || item.getPhone().equals("") || item.getPhone().length()>10)
		{
			item.setValid(false);
			//return item;
			
			return item;
		}
		
	
//		try {
//			
//			num=Long.parseLong(item.getPhone());
//			item.setValid(true);
//			//return item;
//		}
//		catch(NumberFormatException e)
//		{
//			item.setValid(false);
//		}
		
		return item;
		
		
	}

}
