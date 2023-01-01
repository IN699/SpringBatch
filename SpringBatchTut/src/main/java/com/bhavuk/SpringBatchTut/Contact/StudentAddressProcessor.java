package com.bhavuk.SpringBatchTut.Contact;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.ClassifierCompositeItemProcessor;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

public class StudentAddressProcessor implements ItemProcessor<StudentAddress,StudentAddress> {

	@Override
	public StudentAddress process(StudentAddress item) throws Exception {
		// TODO Auto-generated method stub
//		Logger loggerOne = (Logger) LoggerFactory.getLogger(LoggingController.class);
		
		
		//CompositeItemProcessor<I, O>
//		ClassifierCompositeItemProcessor<I, O> 
		
		if(item.getAddress_type().equals("B"))
		{
			return null;
		}
		
		
		
		return item;
	}

}
