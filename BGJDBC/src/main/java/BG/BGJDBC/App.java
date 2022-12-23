package BG.BGJDBC;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class App 
{
    public static void main( String[] args )
    {
    	
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
        StudentDao sd=(StudentDao) ctx.getBean("jdbc");        
        Student s=new Student("Gupta","Bhavuk",12334341,"jdodge@example.com","Mr.","SVP of Sales");
        sd.save(s);
        
	    Resource res = new FileSystemResource("C:\\Users\\bgupta\\Desktop\\Assignments\\Assignment 2\\Spring-Batch\\Spring-Batch");
	    FlatFileItemReader<Student> itemReader=new FlatFileItemReader<Student>();
	    itemReader.setResource(res);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
//	    itemReader.setLineMapper(lineMapper);
	    itemReader.toString();
//        
        
        
        
//		try {
//			Scanner sc = new Scanner(new File("C:\\Users\\bgupta\\Desktop\\Assignments\\Assignment 2\\Spring-Batch\\Spring-Batch\\Contacts.csv"));
//			sc.useDelimiter(",");
//			while(sc.hasNext())
//		    {
//		    	System.out.println(sc.next());
//		    }
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    
	    
        ((AbstractApplicationContext) ctx).close();
        
        
        
        																																			
       
       
    }
}
