package com.cdstore.dbagent;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
//import javax.annotation.Resource;
import javax.naming.*;
import javax.sql.*;

//import javax.annotation.Resource;
import com.cdstore.entities.*;





public class DBAgent {
	//@Resource(name="jdbc/cdstore")
	//private DataSource ds;
// 
	
	private String inputPath;
	private String propertyFile = "/queries.properties";
	
	private Properties props = new Properties();
	
	public String getInput(){
		return inputPath;
	}
	/**
	 * Default Constructor for the CD Class
	 */
	public DBAgent(){

 		InputStream in = getClass().getResourceAsStream(propertyFile);
		
		if (in == null) {
			//File not found! (Manage the problem)
			System.out.println(propertyFile + "not found!");
		}
		
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This Function Returns of the CD Categories
	 * @return ArrayList of Categories
	 * @throws SQLException
	 */
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
			   		ResultSet rs=stmt.executeQuery(props.getProperty("getCategories"));	
			   		while(rs.next()){
			   			Category category=new Category();
			   			category.setCategoryID(rs.getInt(1));
			   			category.setCategoryName(rs.getString(2));
			   			categories.add(category);
			   			
			   		}
			   		rs.close();
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
			
		}finally{
			if(conn!=null)
				conn.close();
		}
		//CatName="Someting to test";
		return categories;
	}
	
	/**
	 * This function returns and array list of CD of object
	 * @param CategoryID
	 * @return Array List of CD Objects
	 * @throws SQLException
	 */
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
			    	   pstmt=conn.prepareStatement(props.getProperty("getCDList"));
			    	   pstmt.setInt(1, CategoryID);
			    	   ResultSet rs=pstmt.executeQuery();
					   while(rs.next()){
			   			CD cd=new CD(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			   			cds.add(cd);
			   			
			   		}
					   rs.close();
			        }else{
			        	
			        	cds.add(errorCD);
			        }
			        
			 }else{
				 
				 cds.add(errorCD);
			 }

		}catch(Exception ex){
			cds.add(errorCD);
			ex.printStackTrace();
			
		}finally{
			if(conn!=null)
				conn.close();
		}
		//CatName="Someting to test";
		return cds;
	}
	/**
	 * This Function Returns of the information about a single CD based on the cdid
	 * @param cdid
	 * @return Returns CD Information Details
	 * @throws SQLException
	 */
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
			    	   pstmt=conn.prepareStatement(props.getProperty("getCDInfo"));
			    	   pstmt.setLong(1, cdid);
			    	   ResultSet rs=pstmt.executeQuery();
					   while(rs.next()){
						   cds=new CD(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			   			
			   			
			   		}
					   rs.close();
			        }else{
			        	
			        	
			        }
			        
			 }else{
				
			 }

		}catch(Exception ex){			
			ex.printStackTrace();
			
		}finally{
			if(conn!=null)
				conn.close();
		}
		//CatName="Someting to test";
		return cds;
	}
	/**
	 * This Function Retrieves all CDs in the DB into an ArrayList of CD objects
	 * @return ArrayList of CD objects
	 * @throws SQLException
	 */
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
				   		ResultSet rs=stmt.executeQuery(props.getProperty("getallCDs") );	
			    	   
					   while(rs.next()){
			   			CD cd=new CD(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			   			cds.add(cd);
			   			//CatName="INSIDE LOOP";
			   		}
					   rs.close();
			        }else{
			        	
			        }
			        
			 }else{
				 
				 
			 }

		}catch(Exception ex){
			
			ex.printStackTrace();
			
		}finally{
			if(conn!=null)
				conn.close();
		}
		
		return cds;
	}
	
	/**
	 * This Function all information about an Account based on a username and password into an Account object
	 * @param userName
	 * @param Password
	 * @return Account
	 * @throws SQLException
	 */
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
			    	   pstmt=conn.prepareStatement(props.getProperty("getAccount"));
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
			   			address.setCity(rs.getString(10));
			   			//CatName="INSIDE LOOP";
			   		 account.setAddress(address);
			   		}
					  
					   rs.close();
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
			
		}finally{
			if(conn!=null)
				conn.close();
		}
		return account;
	}
	/**
	 * Creates a New Account based on Account information supplied and returns the information into an account object
	 * @param accountInfo
	 * @return Account
	 * @throws SQLException
	 */
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
			    	   pstmt=conn.prepareStatement(props.getProperty("addAccount"),Statement.RETURN_GENERATED_KEYS);
			    	   pstmt.setString(1,address.getStreet());
			    	   pstmt.setString(2, address.getProvince());
			    	   pstmt.setString(3, address.getCountry());
			    	   pstmt.setString(4, address.getPostalCode());
			    	   pstmt.setString(5, address.getPhone());
			    	   pstmt.setString(6, address.getCity());
			    	   pstmt.execute();
			    	   ResultSet rs=pstmt.getGeneratedKeys();
			    	   
			    	   int i=1;
			    	   while(rs.next()){
			    		   i=rs.getInt(1);
			    		  
			    	   }
			    	   address.setAddressID(i);
			    	   account=accountInfo;
			    	   account.setAddress(address);
			    	   pstmt=conn.prepareStatement(props.getProperty( "addaddress"));
			    	   pstmt.setString(1,account.getUserName());
			    	   pstmt.setString(2, account.getLastName());
			    	   pstmt.setString(3, account.getFirstName());
			    	   pstmt.setString(4, account.getPassword());
			    	   pstmt.setInt(5, account.getAddress().getAddressID());
			    	   pstmt.execute();			    	   
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
			
		}finally{
			if(conn!=null)
				conn.close();
		}
	
		return account;
	}
	/**
	 * Saves/persists the order information into DB and return true if success otherwise returns false
	 * @param order
	 * @return Boolean
	 * @throws SQLException
	 */
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
		    	   pstmt=conn.prepareStatement(props.getProperty("addOrder"),Statement.RETURN_GENERATED_KEYS);
		    	   pstmt.setString(1,order.getAccount().getUserName());
		    	   pstmt.setDouble(2, order.getAmount());
		    	   pstmt.setString(3, order.getStatus());
		    	   pstmt.execute();
		    	   ResultSet rs=pstmt.getGeneratedKeys();
		    	   
		    	   while(rs.next()){
		    		   order.setOrderID(rs.getInt(1));
		    	   }
		    	   for(OrderDetails item:cartitems){
		    		   
			    	   pstmt=conn.prepareStatement(props.getProperty( "addOrderDetails"));
			    	   pstmt.setInt(1,item.getCDID());
			    	   pstmt.setInt(2, order.getOrderID());
			    	   pstmt.setInt(3, item.getQuantity());
			    	   pstmt.setDouble(4, item.getPrice());
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
		return false;
		//ex.printStackTrace();
		
	}finally{
		if(conn!=null)
			conn.close();
	}

	return true;
}

public String confirmOrderT(Order order) throws SQLException{
	
	/**
	 * Since the shopping cart is a session object all calculations including vat can be performed within
	 * Copy necesary order information from the shopping cart into the order object
	 */
	Connection conn=null;
	Order myorder=new Order();
	myorder=order;
	//myorder.setAmount(order.getAmount());
	//OrderDetails[] cartitems=new OrderDetails[myorder.getOrderDetails().length];
	//List<OrderDetails> cartitems=new ArrayList<OrderDetails>();
	String ret="Start.....";
	OrderDetails[] cartitems=myorder.getOrderDetails();
	ret+="Cart Item Count"+cartitems.length;
	
	try{
		Context ctx=new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/cdstore");
		//Test Datasource to see if the JNDI loopup was successfull
		 if (ds != null) {
			 ret+="- Establish DataSource";
			 //Establish connection and check is connection is available
		        conn = ds.getConnection();
		       if(conn != null)  {
		    	   //PreparedStatement pstmt=null;
					ret+="Connection Established";
				    /**
				     * Do an atomic insert of each order operation ensure that data is rolled back if there is 
				     * an error
				     */
		    	   conn.setAutoCommit(false);
		    	   PreparedStatement pstmt=conn.prepareStatement(props.getProperty("addOrder"),Statement.RETURN_GENERATED_KEYS);
		    	   pstmt.setString(1,order.getAccount().getUserName());
		    	   /**
		    	    * INSERT ORDER WITH OUT COMMITING
		    	    */
		    	   ret+=order.getAccount().getUserName();
		    	   Double amt=order.getAmount();
		    	   pstmt.setDouble(2, amt);
		    	   ret+=amt.toString();
		    	   pstmt.setString(3, order.getStatus());
		    	   ret+=order.getStatus()+"-";
		    	   pstmt.execute();
		    	   ResultSet rs=pstmt.getGeneratedKeys();
		    	   ret+="- Generate Key Succeed";
		    	   
		    	   /**
		    	    * RETRIEVE THE ORDER ID
		    	    */
		    	  int id=1;
		    	   while(rs.next()){
		    		  // order.setOrderID(rs.geString(1));
		    		   id=rs.getInt(1);
		    		   ret+=rs.getString(1)+"-";
		    	   }
		    	   order.setOrderID(id);
		    	   Integer tcount=rs.getRow();
		    	   ret+=" Row Count:"+tcount.toString() + cartitems.length;
		    	   //conn.rollback();
		    	   /**
		    	    * INSERT THE ORDER DETAILS
		    	    */
		    	   for(OrderDetails item:cartitems){
		    		   
			    	   pstmt=conn.prepareStatement(props.getProperty( "addOrderDetails"));
			    	   ret+=" CD ID" +item.getCDID().toString();
			    	   		
			    	   pstmt.setInt(1,item.getCDID());
			    	   ret+=item.getCDID().toString()+"-";
			    	   pstmt.setInt(2, order.getOrderID());
			    	   
			    	   pstmt.setInt(3, item.getQuantity());
			    	   pstmt.setDouble(4, item.getPrice());
			    	  ret+=item.getPrice().toString();
		    	   pstmt.execute();
		    	   }
		    	   /**
		    	    * FINALLY COMMIT TRANSACTION
		    	    */
		    	   conn.commit();
				  
		        }else{
		        	//CatName="Connection Failure";
		        	return "false Unable to Establish Connection";
		        }
		        
		 }else{
			 
			 return "false Datasource not correct";
		 }

	}catch(Exception ex){
		conn.rollback();
		return "false"+ex.getMessage()+ret;
		//ex.printStackTrace();
		
	}finally{
		if(conn!=null)
			conn.close();
	}

	return "true EVEY THING OK" + ret;
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
