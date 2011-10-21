package com.cdstore.dbagent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
//import javax.annotation.Resource;
import javax.naming.*;
import javax.sql.*;

//import javax.annotation.Resource;
import com.cdstore.entities.*;
import com.cdstore.shoppingcart.*;





public class DBAgent {
	//@Resource(name="jdbc/cdstore")
	//private DataSource ds;
// 
	
	private ResourceBundle bundle;
	private String inputPath;
	
	public String getInput(){
		return inputPath;
	}
	
	public DBAgent(){
	//	String sConfigFile = "queries.properties";
		
		//InputStream in = DBAgent.class.getClassLoader().getResourceAsStream(sConfigFile);
		//inputPath=DBAgent.class.getClassLoader().getResource("sConfigFile").getPath();
//		if (in == null) {
//			//File not found! (Manage the problem)
//			///System.out.println(DBAgent.class.getClassLoader().getResource("sConfigFile").getPath());
//		}
	//	Properties props = new Properties();
		
//		try {
			//props.load(new FileInputStream("queries.properties"));
			//this.prop=props;
		//	bundle = ResourceBundle.getBundle("queries");
			//System.out.println(bundle.getString("getCategories"));
	//	} catch (Exception e) {
			// TODO Auto-generated catch block

	//		e.printStackTrace();
	//	}
		
	}
	public ArrayList<Category> getCategories() throws SQLException{
		
		Connection conn=null;
		ArrayList<Category> categories=new ArrayList<Category>();
		Category errorCat=new Category();
		
		
		
		errorCat.setCategoryID(0);
		errorCat.setCategoryName("Error");
		try{
		
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/cdstore");
			/**Setup JNDI Loopup
			
			Test Datasource to see if the JNDI loopup was successfull */
			 if (ds != null) {
				 /**Establish connection and check is connection is available */
			        conn = ds.getConnection();
			       if(conn != null)  {
			        Statement stmt=conn.createStatement();
			   		ResultSet rs=stmt.executeQuery("Select * from Category");	
			   		while(rs.next()){
			   			Category category=new Category();
			   			category.setCategoryID(rs.getInt(1));
			   			category.setCategoryName(rs.getString(2));
			   			categories.add(category);
			   			
			   		}
			        }else{
			        	errorCat.setCategoryName("Connection Error");
			        	categories.add(errorCat);
			        	
			        }
			        
			 }else{
				 errorCat.setCategoryName("DataSource Error");
				 categories.add(errorCat);
			 }

		}catch(Exception ex){
			errorCat.setCategoryName("Connection Error " +ex.getMessage());
			categories.add(errorCat);
			ex.printStackTrace();
			
		}
		//CatName="Someting to test";
		return categories;
	}
	
	public ArrayList<CD> getCDList(Integer CategoryID) throws SQLException{
		
		Connection conn=null;
		ArrayList<CD> cds=new ArrayList<CD>();
		/**
		 * Create an Error CD with is returned when there is an error
		 */
		CD errorCD=new CD();
		errorCD.setID(0);
		errorCD.setTitle("Error");
		try{
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/cdstore");
			
			/**Setup JNDI Loopup
			//DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/cdstore");
			Test Datasource to see if the JNDI loopup was successfull 
			*/
			 if (ds != null) {
				 /**Establish connection and check is connection is available */
			        conn = ds.getConnection();
			       if(conn != null)  {
			    	   PreparedStatement pstmt=null;
					
					     /**Select  CDs Based on Category 
					      * */
			    	   pstmt=conn.prepareStatement("getCDList");
			    	   pstmt.setLong(1, CategoryID);
			    	   ResultSet rs=pstmt.executeQuery();
					   while(rs.next()){
			   			CD cd=new CD(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			   			cds.add(cd);
			   			
			   		}
			        }else{
			        	
			        	cds.add(errorCD);
			        }
			        
			 }else{
				 
				 cds.add(errorCD);
			 }

		}catch(Exception ex){
			cds.add(errorCD);
			ex.printStackTrace();
			
		}
		//CatName="Someting to test";
		return cds;
	}
	public CD getCDInfo(Integer cdid) throws SQLException{
		
		Connection conn=null;
		CD cds=new CD();
		
		try{
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/cdstore");
			//Context ctx=new InitialContext();
			/**Setup JNDI Loopup
			//DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/cdstore");
			Test Datasource to see if the JNDI loopup was successfull 
			*/
			 if (ds != null) {
				 /**Establish connection and check is connection is available */
			        conn = ds.getConnection();
			       if(conn != null)  {
			    	   PreparedStatement pstmt=null;
					
					     /**Select  CDs Based on Category 
					      * */
			    	   pstmt=conn.prepareStatement("getCDInfo");
			    	   pstmt.setLong(1, cdid);
			    	   ResultSet rs=pstmt.executeQuery();
					   while(rs.next()){
						   cds=new CD(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			   			
			   			
			   		}
			        }else{
			        	
			        	
			        }
			        
			 }else{
				
			 }

		}catch(Exception ex){			
			ex.printStackTrace();
			
		}
		//CatName="Someting to test";
		return cds;
	}
	public ArrayList<CD> getCDList() throws SQLException{
		
		Connection conn=null;
		ArrayList<CD> cds=new ArrayList<CD>();
		CD errorCD=new CD();
		errorCD.setID(0);
		errorCD.setTitle("Error");
		try{
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/cdstore");
			/**Setup JNDI Loopup
			//DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/cdstore");
			Test Datasource to see if the JNDI loopup was successfull 
			*/
			 if (ds != null) {
				 //Establish connection and check is connection is available
			        conn = ds.getConnection();
			       if(conn != null)  {
			    	   	
					     //Select  CDs Based on Category
			    	   Statement stmt=conn.createStatement();
				   		ResultSet rs=stmt.executeQuery("getallCDs");	
			    	   
					   while(rs.next()){
			   			CD cd=new CD(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			   			cds.add(cd);
			   			//CatName="INSIDE LOOP";
			   		}
			        }else{
			        	
			        }
			        
			 }else{
				 
				 
			 }

		}catch(Exception ex){
			
			ex.printStackTrace();
			
		}
		
		return cds;
	}
	public Account getAccount(String userName,String Password) throws SQLException{
		
		Connection conn=null;
		Account account=new Account();
		try{
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/cdstore");
			/**
			 * Get Account Information Returning the Account if its Right and an username of invalid
			 * in the account if its wrong
			 */
			 if (ds != null) {
				 //Establish connection and check is connection is available
			        conn = ds.getConnection();
			       if(conn != null)  {
			    	   PreparedStatement pstmt=null;
						
					     //Select  CDs Based on Category
			    	   pstmt=conn.prepareStatement("getAccount");
			    	   pstmt.setString(1,userName);
			    	   pstmt.setString(2, Password);
			    	   ResultSet rs=pstmt.executeQuery();
			    	   Address address=new Address();
			    	  
					   while(rs.next()){
			   			account.setUserName(rs.getString(1));
			   			account.setLastName(rs.getString(2));
			   			account.setFirstName(rs.getString(3));
			   			
			   			
			   			address.setAddressID(rs.getInt(4));
			   			address.setStreet(rs.getString(5));
			   			address.setProvince(rs.getString(6));
			   			address.setPostalCode(rs.getString(7));
			   			address.setPhone(rs.getString(8));
			   			address.setCountry(rs.getString(9));
			   			
			   			//CatName="INSIDE LOOP";
			   			
			   		}
					   account.setAddress(address);
			        }else{
			        	//CatName="Connection Failure";
			        	account.setUserName("Invalid");
			        }
			        
			 }else{
				 
				 account.setUserName("Invalid");
			 }

		}catch(Exception ex){
			account.setUserName("Invalid");
			ex.printStackTrace();
			
		}
		return account;
	}
public Account createAccount(Account accountInfo) throws SQLException{
		
		Connection conn=null;
		Account account=new Account();
		try{
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/cdstore");
			/**
			 * Retrieve the Address Part of the Account and Insert into the Address Table and Using the Address ID 
			 * Insert the Account Information
			 * A Transaction is used to ensure atomicity of the operation
			 */
			 if (ds != null) {
				 //Establish connection and check is connection is available
			        conn = ds.getConnection();
			       if(conn != null)  {
			    	   PreparedStatement pstmt=null;
						Address address=accountInfo.getAddress();
					     //Select  CDs Based on Category
			    	   conn.setAutoCommit(false);
			    	   pstmt=conn.prepareStatement("addAccount",Statement.RETURN_GENERATED_KEYS);
			    	   pstmt.setString(1,address.getStreet());
			    	   pstmt.setString(2, address.getProvince());
			    	   pstmt.setString(3, address.getCountry());
			    	   pstmt.setString(4, address.getPostalCode());
			    	   pstmt.setString(5, address.getPhone());
			    	   pstmt.setString(6, address.getCity());
			    	   ResultSet rs=pstmt.getGeneratedKeys();
			    	   
			    	   
			    	   while(rs.next()){
			    		   address.setAddressID(rs.getInt(1));
			    	   }
			    	   account=accountInfo;
			    	   account.setAddress(address);
			    	   pstmt=conn.prepareStatement("addaddress");
			    	   pstmt.setString(1,account.getUserName());
			    	   pstmt.setString(2, account.getLastName());
			    	   pstmt.setString(3, account.getFirstName());
			    	   pstmt.setString(4, account.getPassword());
			    	   pstmt.setInt(5, account.getAddress().getAddressID());
			    	   pstmt.executeUpdate();			    	   
			    	   conn.commit();
					  
			        }else{
			        	//CatName="Connection Failure";
			        	account.setUserName("Invalid");
			        }
			        
			 }else{
				 
				 account.setUserName("Invalid");
			 }

		}catch(Exception ex){
			conn.rollback();
			account.setUserName("Invalid");
			ex.printStackTrace();
			
		}
	
		return account;
	}

public Boolean confirmOrder(Order order) throws SQLException{
	
	/**
	 * Since the shopping cart is a session object all calculations including vat can be performed within
	 * Copy necesary order information from the shopping cart into the order object
	 */
	Connection conn=null;
	Order myorder=new Order();
	myorder=order;
	//myorder.setAmount(order.getAmount());
	OrderDetails[] cartitems=new OrderDetails[myorder.getOrderDetails().length];
	//List<OrderDetails> cartitems=new ArrayList<OrderDetails>();
	cartitems=myorder.getOrderDetails();
	try{
		Context ctx=new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/cdstore");
		//Test Datasource to see if the JNDI loopup was successfull
		 if (ds != null) {
			 //Establish connection and check is connection is available
		        conn = ds.getConnection();
		       if(conn != null)  {
		    	   PreparedStatement pstmt=null;
					
				    /**
				     * Do an atomic insert of each order operation ensure that data is rolled back if there is 
				     * an error
				     */
		    	   conn.setAutoCommit(false);
		    	   pstmt=conn.prepareStatement("addOrder",Statement.RETURN_GENERATED_KEYS);
		    	   pstmt.setString(1,order.getAccount().getUserName());
		    	   pstmt.setDouble(2, order.getAmount());
		    	   pstmt.setString(3, order.getStatus());
		    	   ResultSet rs=pstmt.getGeneratedKeys();
		    	   
		    	   while(rs.next()){
		    		   order.setOrderID(rs.getInt(1));
		    	   }
		    	   for(OrderDetails item:cartitems){
		    		   
			    	   pstmt=conn.prepareStatement("addOrderDetails");
			    	   pstmt.setInt(1,item.getCDID());
			    	   pstmt.setInt(2, order.getOrderID());
			    	   pstmt.setInt(3, item.getQuantity());
			    	   pstmt.setDouble(4, item.getQuantity());
			    	   pstmt.executeUpdate();
		    	   }
		    	   conn.commit();
				  
		        }else{
		        	//CatName="Connection Failure";
		        	return false;
		        }
		        
		 }else{
			 
			 return false;
		 }

	}catch(Exception ex){
		conn.rollback();
		ex.printStackTrace();
		return false;
	}

	return true;
}
//public static void main(String[] args) throws Exception {
//	try{
//	DBAgent myAgent=new DBAgent();
//	//ArrayList<Category> Categories=myAgent.getCategories();
//	System.out.println("Success");
//	}catch(Exception ex)
//	{
//		System.out.println("Error is: " +ex.getMessage());
//	}
//}
}
