package com.bhavuk.SpringBatchTut.Contact;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;

public class StudentValidator implements Validator<StudentAddress> {

	@Override
	public void validate(StudentAddress value) throws ValidationException {
		// TODO Auto-generated method stub
		
		
		if(value.getAddress_type().equals("B"))
		{
			throw new ValidationException("B Billing is not mandatory");
		}
	}

}
