package com.bhavuk.SpringBatchTut.Address;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class MyCompositeItemWriter implements ItemWriter<Student> {
	private static final Logger LOGGER=LoggerFactory.getLogger(MyCompositeItemWriter.class);
	private ItemWriter<Student> student;
    
    
    
	
	public void write(List<? extends Student> items) throws Exception {
		// TODO Auto-generated method stub
		List<Student> csvStudent=new ArrayList<Student>();
		List<Student> jdbcStudent=new ArrayList<Student>();
		
		for( Student s1:items)
		{
			System.out.println(s1.getFlag());
		}
		
		
		for( Student s1:items)
		{
			if(s1.getFlag()==1)
			{
				jdbcStudent.add(s1);
			}
			else {
				csvStudent.add(s1);
			}
		}
//		System.out.println("this is csv");
//		for( Student s1:csvStudent)
//		{
//			System.out.println(s1.getFirstName());
//		}
//		System.out.println("this is jdbc");
//		for( Student s1:jdbcStudent)
//		{
//			System.out.println(s1.getFirstName());
//		}
		
	}
		
		
	}
	
	
	
	
	

	



//		List<Object> item=new ArrayList<>(x);
//		for(Student s1: items)
//		{
//		item.add(0,s1.getLastName());
//		item.add(1,s1.getFirstName());
//		item.add(2,s1.getPhone());
//		item.add(3,s1.getEmail());
//		item.add(4,s1.getTitle());
//		item.add(5,s1.getDesignation());
//			
//		}
//		items.listIterator();


//		for(int i=0;i<x;i++)
//			{
//				if(item.get(i).equals(""))
//				{
//					item.add(6, false);
//				}
//			}
//		if(item.get(2).toString().length()>10)
//		{
//			item.add(6, false);
//		}
//		
//		for(int i=0;i<x;i++)
//		{
//			if(items.get(i).equals(false))
//			{
//				setDelegates(Arrays.asList(writerCSV()));
//				
//			}
//			else {
//				setDelegates(Arrays.asList(writerJDBC()));
//			}
//		}