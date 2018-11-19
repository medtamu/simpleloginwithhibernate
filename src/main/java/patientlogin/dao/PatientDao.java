package patientlogin.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.sql.DataSource;
import patientlogin.Patient;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
//import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.common.hash.Hashing;

public class PatientDao implements ipatientdao {

  static SessionFactory factory ;
  
  
  public SessionFactory sfactory() {
	  Configuration cfg = new Configuration();
	  
	  cfg.configure("hibernate.cfg.xml");
	  StandardServiceRegistryBuilder sreg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
      
       factory = cfg.buildSessionFactory(sreg.build());
	  
	  return factory;
  }
  
	public boolean  authenticatePatient(Patient patient) throws Exception{
		boolean userExists = false;
		 String hashedpass = Hashing.sha256()
       		  .hashString(patient.getPassword(), StandardCharsets.UTF_8)
       		  .toString();
        
        System.out.println("opening session ...");
               Session ss = sfactory().openSession();
      Transaction tx = null;
     
   
      try {
         tx = ss.beginTransaction();
        
         Query query = ss.createQuery("from Patient where username = :username and password = :password");
         query.setParameter("username", patient.getUsername());
         query.setParameter("password", hashedpass);
         
         List patientlist = query.list();
         
    if(!patientlist.isEmpty()) {

userExists = true;
}
         
  

         tx.commit();
      } catch (HibernateException e) {
    	
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         ss.close(); 
      }
      
      System.out.println("dao response: "+ userExists);
      return userExists;
   }


        public boolean registerPatient(Patient patient) {
         boolean success = false ;
         
        
         
         String hashedpass = Hashing.sha256()
        		  .hashString(patient.getPassword(), StandardCharsets.UTF_8)
        		  .toString();
         
         System.out.println("opening session....");
         Session ss = sfactory().openSession();
           Transaction tx = null;
         
     try 
     {
    	 tx = ss.beginTransaction();
    	 
    	Query query = ss.createSQLQuery("insert into Patient (username, password, firstname, lastname, email, address, phone, ssn, dob) values (?,?,?,?,?,?,?,?,?)");
    	 query.setParameter(0, patient.getUsername());
    	 query.setParameter(1, hashedpass);
    	 query.setParameter(2, patient.getFirstname());
    	 query.setParameter(3, patient.getLastname());
    	 query.setParameter(4, patient.getEmail());
    	 query.setParameter(5, patient.getAddress());
    	 query.setParameter(6, patient.getPhone());
    	 query.setParameter(7, patient.getSsn());
    	 query.setParameter(8, patient.getDob());
     
          int insert = query.executeUpdate();
    
          if(insert != 0) {
        	  success = true ;
        	  
          }
     tx.commit();
     
     }
         
     catch (HibernateException e) {
   	    if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     } finally {
    	 //success = true;
        ss.close(); 
     }
     
     System.out.println("dao response:" + success);

        	 
        	 
         
         
         
        return success;
       }


}
