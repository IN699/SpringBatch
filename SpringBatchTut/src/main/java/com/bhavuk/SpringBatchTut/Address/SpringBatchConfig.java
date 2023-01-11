package com.bhavuk.SpringBatchTut.Address;

import java.util.ArrayList;
import java.util.Arrays;

import javax.sql.DataSource;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import antlr.collections.List;
import lombok.AllArgsConstructor;

@EnableBatchProcessing
@Configuration
@AllArgsConstructor
public class SpringBatchConfig {
	
	
	@Autowired
	private DataSource datasource;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	@StepScope
	public FlatFileItemReader<Student> reader()
	{
		FlatFileItemReader<Student> itemReader=new FlatFileItemReader<Student>();
		itemReader.setResource(new FileSystemResource("C:\\Users\\bgupta\\Desktop\\sts\\sts-4.17.0.RELEASE\\STSProjects\\SpringBatchTut\\src\\main\\resources\\Contacts.csv"));
		itemReader.setLinesToSkip(1);
		itemReader.setName("csvReader");
		itemReader.setLineMapper(lineMapper());
		
		
		
		return itemReader;
	}

	public LineMapper<Student> lineMapper() {
		// TODO Auto-generated method stub
		DefaultLineMapper<Student> lineMapper=new DefaultLineMapper<Student>();
		
		DelimitedLineTokenizer  lineTokenizer=new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("lastName","firstName","phone","email","title","designation");
		
		BeanWrapperFieldSetMapper<Student> fieldMapper=new BeanWrapperFieldSetMapper<Student>();
		fieldMapper.setTargetType(Student.class);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldMapper);
		
		
		return lineMapper;
		
	}
	
	@Bean
	@StepScope
	public StudentProcessor processor()
	{
		
		return new StudentProcessor();
		
	}
	public MyCompositeItemWriter myCustomWriter()
	{
		return new MyCompositeItemWriter();
	}
	
	
		
	@Bean
	public Job runJob() throws Exception
	{
		return (Job) jobBuilderFactory.get("importStudent")
								.incrementer(new RunIdIncrementer())
								.flow(step1()).end().build();
		
	}
	
	@Bean
	public Step step1() throws Exception {
		return ((SimpleStepBuilder<Student, Student>) stepBuilderFactory.get("csv-step").<Student, Student>chunk(10)
								 .reader(reader())
								 .allowStartIfComplete(true))
								 .processor(processor())
								 .writer(myCustomWriter())
								 .listener(new StudentStepExecutionListener())
								 .build();	 
	}
	
	

}

//	@Bean
//	@StepScope
//	public JdbcBatchItemWriter<Student> writerJDBC()
//	{
//		JdbcBatchItemWriter<Student> writer=new JdbcBatchItemWriter<Student>();
//		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Student>());
//		writer.setSql("INSERT INTO contact_bhavuk(Last_Name,First_Name,Phone,Email,Title,Designation) VALUES(:lastName,:firstName,:phone,:email,:title,:designation)");
//		writer.setDataSource(this.datasource);
//		return writer;	
//		}

//	@Bean
//	@StepScope
//	public FlatFileItemWriter<Student> writerCSV()
//	{
//		FlatFileItemWriter<Student> writer=new FlatFileItemWriter<Student>();
//		
//		DelimitedLineAggregator<Student> lineAggregator=new DelimitedLineAggregator<Student>();
//		lineAggregator.setDelimiter(",");
//		
//		BeanWrapperFieldExtractor<Student> Reflector=new BeanWrapperFieldExtractor<Student>();
//		Reflector.setNames(new String[]{"lastName","firstName","phone","email","title","designation"});
//		
//		
//		writer.setResource(new FileSystemResource("C:\\Users\\bgupta\\Desktop\\sts\\sts-4.17.0.RELEASE\\STSProjects\\SpringBatchTut\\src\\main\\resources\\ErrorOutput.csv"));
//		writer.setAppendAllowed(true);
//		writer.setLineAggregator(lineAggregator);
////		writer.setHeaderCallback(null);
//		lineAggregator.setFieldExtractor(Reflector);
//		return writer;
//		
//		
//	}


//	@Bean
//	public CompositeItemWriter<Student> compositeItemWriter() throws Exception{
//	    
////	    	java.util.Iterator<Student> it=list.iterator();
////	    Student s1=new Student();
////	    	it.
//	 	 // if(list.contains(list))
////			    {
////			    	
////			    	writer.setDelegates(Arrays.asList(writerJDBC()));
////			    	 return writer;
////			    }
////			    else {
////			    	writer.setDelegates(Arrays.asList(writerCSV()));
////			    	 return writer;
////			    }
//	    
//	    
//		CompositeItemWriter<Student> writer = new CompositeItemWriter<>();
//	    	ArrayList<Student> list=new ArrayList<Student>();
//	    	writer.write(list);
//	    	
////	   
//	    	
//	    	
//	    	
//	    	
//	    	for(Student s1 : list) {
//	    		if(s1.isValid()) {
//			    	writer.setDelegates(Arrays.asList(writerJDBC()));
//			    	 return writer;
//	    		}
//	    		else {
//			    	writer.setDelegates(Arrays.asList(writerCSV()));
//			    	 return writer;
//	    		}
//	    	}
//	    	
//	    
//	    return null;
//	  
//	}