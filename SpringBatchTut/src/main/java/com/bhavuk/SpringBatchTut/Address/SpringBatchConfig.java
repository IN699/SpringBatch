package com.bhavuk.SpringBatchTut.Address;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

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
	
	public FlatFileItemReader<Student> reader()
	{
		FlatFileItemReader<Student> itemReader=new FlatFileItemReader<Student>();
		itemReader.setResource(new FileSystemResource("src/main/resources/Contacts.csv"));
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
		lineTokenizer.setNames("Last_Name","First_Name","Phone","Email","Title","Designation");
		
		BeanWrapperFieldSetMapper<Student> fieldMapper=new BeanWrapperFieldSetMapper<Student>();
		fieldMapper.setTargetType(Student.class);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldMapper);
		
		
		return lineMapper;
		
	}
	@Bean
	public StudentProcessor processor()
	{
		return new StudentProcessor();
		
	}
	@Bean
	public JdbcBatchItemWriter<Student> writer()
	{
		JdbcBatchItemWriter<Student> writer=new JdbcBatchItemWriter<Student>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Student>());
		writer.setSql("INSERT INTO contact_bhavuk(Last_Name,First_Name,Phone,Email,Title,Designation) VALUES(:Last_name,:First_name,:Phone,:Email,:Title,:Designation)");
		writer.setDataSource(this.datasource);
		return writer;	
		}

	@Bean
	public Job runJob()
	{
		return (Job) jobBuilderFactory.get("importStudent")
								.incrementer(new RunIdIncrementer())
								.flow(step1()).end().build();
		
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("csv-step").<Student, Student>chunk(10)
								 .reader(reader())
								 .processor(processor())
								 .writer(writer())
								 .build();	 
	}
	
	

}