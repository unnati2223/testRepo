package com.tutorialspoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/FORMDEMO";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "unnati@123";
	

   @RequestMapping(method = RequestMethod.GET)public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "hello";
   }
   
 
   @RequestMapping(value="/test", method=RequestMethod.GET)
   @ResponseBody
   public String getAllIssuers(@RequestParam("name") String name, @RequestParam("fathername") String fathername,
		   @RequestParam("paddress") String paddress, @RequestParam("personaladdress") String personaladdress, 
		   @RequestParam("sex") String sex,
		   @RequestParam("City") String City, @RequestParam("Course") String Course, @RequestParam("pincode") String pincode,
		   @RequestParam("emailid") String emailid, @RequestParam("dob") String dob, @RequestParam("mobileno") String mobile){
	   
	   
	   
	   System.out.println("name = " +name);
	   System.out.println("fatherName = " +fathername);
	   System.out.println("paddress = " +paddress);
	   System.out.println("personaladdress = " +personaladdress);
	   System.out.println("sex = " +sex);
	   System.out.println("City = " +City);
	   System.out.println("Course = " +Course);
	   System.out.println("pincode = " +pincode);
   	   System.out.println("dob = " +dob);
	   System.out.println("mobileno = " +mobile);
	   System.out.println("emailid = " +emailid);
	   
	   
	   Connection conn = null;
	   Statement stmt = null;
	   String test="";
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Inserting records into the table...");
	      //stmt = conn.createStatement();
	      
	      //String sql = "INSERT INTO STUDENTS " +
	    //               "VALUES (100, 'Zara', 'Ali', 18)";
	    //  stmt.executeUpdate(sql);
	   
	   
	   
	   test = "your form is submitted successfully";
	  
  
     }catch(SQLException se){
         //Handle errors for JDBC
         se.printStackTrace();
      }catch(Exception e){
         //Handle errors for Class.forName
         e.printStackTrace();
      }finally{
         //finally block used to close resources
         try{
            if(stmt!=null)
               conn.close();
         }catch(SQLException se){
         }// do nothing
         try{
            if(conn!=null)
               conn.close();
         }catch(SQLException se){
            se.printStackTrace();
         }//end finally try
      }//end try
    
	   return test;
	   

   }
}