package BG.BGJDBC;

import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class StudentDao implements Interf {

	public StudentDao() {
		super();
		// TODO Auto-generated constructor stub
	}




	private NamedParameterJdbcTemplate namedparameterjdbctemplate;
	
	public StudentDao(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		super();
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public NamedParameterJdbcTemplate getNamedparameterjdbctemplate() {
		return namedparameterjdbctemplate;
	}

	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	


	public void save(Student i) {
		
		String sql = "INSERT INTO contact_bhavuk(Last_Name,First_Name,Phone,Email,Title,Designation) 		VALUES(:Last_name,:First_name,:Phone,:Email,:Title,:Designation)";		
		
		Map<String,Object> paramMap=new HashMap<String,Object>();
		
		paramMap.put("Last_name", i.getLast_name());
		paramMap.put("First_name", i.getFirst_name());
		paramMap.put("Phone", i.getPhone());
		paramMap.put("Email", i.getEmail());
		paramMap.put("Title", i.getTitle());
		paramMap.put("Designation", i.getDesignation());
		
		int modifications = namedparameterjdbctemplate.update(sql, paramMap);
		System.out.printf("%d records inserted in DB.%n",modifications);
		
	}

}
	
// Callback------------------------------------------------------------------------------------------------------------------------
//		SqlParameterSource namedParameters=new MapSqlParameterSource("Last_name","Gupta")
//				.addValue("First_name", "Bhavuk")
//				.addValue("Phone", 3432423)
//				.addValue("Email", "abc@gmail.com")
//				.addValue("Title", "Mr.")
//				.addValue("Designation", "skdsjndjs");
	
//		namedparameterjdbctemplate.q(sql, namedParameters);
	
	

/*(sql,m1,new PreparedStatementCallback() {  
			
			public Object doInPreparedStatement(java.sql.PreparedStatement ps)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return  ps.executeUpdate();
			}  
		}); */ 
