package com.bhavuk.SpringBatchTut.Contact;

import org.springframework.batch.item.ItemProcessor;

public class StudentAddressProcessor implements ItemProcessor<StudentAddress,StudentAddress> {

	@Override
	public StudentAddress process(StudentAddress item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}
