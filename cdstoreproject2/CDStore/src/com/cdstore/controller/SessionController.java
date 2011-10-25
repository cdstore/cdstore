package com.cdstore.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cdstore.beans.*;
import com.cdstore.entities.*;
import com.cdstore.shoppingcart.*;
/**
 * 
 * @author Dan
 *
 */
public class SessionController extends HttpServlet {

	private String propertyFile = "/navigation.properties";
	String selectedCategory="All CDS";
	private Properties props = new Properties();
	private static final long serialVersionUID = 1L;
//	private String surcharge;
    /**
     * @see HttpServlet#HttpServlet()
     */
	String tax="";
	/**
	 * At Servlet Initializaiton load the properties files which contains the exact file name of the JSP pages
	 */
	 @Override
	 public void init(ServletConfig servletConfig) throws ServletException {

	        super.init(servletConfig);
	        
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
	         CDStoreBean bean=new CDStoreBean();
	         
	         getServletContext().setAttribute("categories",bean.getCategoryList());
	        tax = servletConfig.getServletContext().getInitParameter("tax");
	        
	    }
	
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */	
	public SessionController(){
		super();
		
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
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPath=request.getServletPath();
        HttpSession session = request.getSession();
        

		ShoppingCart shopBean = (ShoppingCart)session.getAttribute("cart"); 
		/**
		 * This directs you to the main CDs page
		 */
		if(userPath.equals("/viewCategory")){
			String categoryId = request.getQueryString();
			Integer CatID=Integer.parseInt(categoryId);
			CDStoreBean bean=new CDStoreBean();
			if(CatID<0)
			{
				selectedCategory="All CDs";
				 
		         CD[] cds=bean.getCDList();
		         session.setAttribute("CDS", cds);
			}else{
				// CDStoreBean bean=new CDStoreBean();
				Category[] cats=bean.getCategoryList();
				for(Category cat:cats){
					if(cat.getCategoryID()==Integer.parseInt(categoryId)){
						selectedCategory=cat.getCategoryName();
					}
				}
				//CDStoreBean bean=new CDStoreBean();
		         CD[] cds=bean.getCDList(Integer.parseInt(categoryId));
		         session.setAttribute("CDS", cds);
			}
			session.setAttribute("selectedCategory", selectedCategory);
			userPath=props.getProperty("viewCDStore");
		}
		
		/**
		 * IF ADD ITEM TO SHOPPING CART
		 */
		else if(userPath.equals("/addToCart")){
			//TODO: Implement cart page request
			
			String cdid = request.getQueryString();

			
			// check if already have a shopping cart
			if (shopBean==null){
				
				shopBean = new ShoppingCart();
				
				session.setAttribute("cart", shopBean);
			}
			
			CDStoreBean cdBean = new CDStoreBean(); 
			
			//returns CD object via service
			CD cdItem = cdBean.getCDInfo(new Integer (cdid));
				
			shopBean.addItem(cdItem);
			List<ShoppingCartItem> tst=shopBean.getItems();
			
			//session.setAttribute("shopBean", arg1)
			userPath= props.getProperty("viewCart");
		}
		/**
		 * VIEW/CLEAR SHOPPING CART ACTION
		 */
		else if(userPath.equals("/viewCart")){
			 String clear = request.getParameter("clear");

	            if ((clear != null) && clear.equals("true")) {

	                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
	                cart.clear();
	            }

	            userPath =props.getProperty("viewCart");

		}
		/**
		 * IMPLEMENT CHECK OUT PROCESS
		 */
		else if(userPath.equals("/checkout")){
			
			ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
			Account account=(Account)session.getAttribute("account");
			/**
             * Calulate the Tax
             */
            cart.setTax(tax);
			/**
             * calculate total
             */
            cart.calculateTotal(tax);
            
            OrderBean orderBean=new OrderBean();
            orderBean.setAccount(account);
            orderBean.createOrder(cart);
            session.setAttribute("order", orderBean.getOrder());
            userPath=props.getProperty("viewCheckout");
            
            // forward to checkout page and switch to a secure channel
		}/**
		 * ORDER CANCELLATION
		 */
		else if(userPath.equals("/cancelOrder")){
			OrderBean oBean=new OrderBean();
		
			//Clear Order Session Object
			session.removeAttribute("order");
			
			//Clear Shopping Cart Session Object
			ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
			shopBean.clear();
			userPath=props.getProperty("viewCDStore");
		}
		/**
		 * CREATE USER ACCOUNT - JUST NAVIGATE TO CREATEACCOUNT PAGE
		 */
		else if(userPath.equals("/createAccountPage")){
			userPath=props.getProperty("createAccount");
		}
		/**
		 * CONTROL THE LOG OUT ACTION
		 */
		else if(userPath.equals("/logout")){
			session.invalidate();
			userPath=props.getProperty("index");
		}
		
		/**
		 * RETURN TO THE CD STORE HOME PAGE
		 */
		else if(userPath.equals("/home")){
			userPath=props.getProperty("index");
		}
		
		String url;
		url=userPath;
		try{
			request.getRequestDispatcher(url).forward(request, response);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPath=request.getServletPath();
		HttpSession session = request.getSession();
		ShoppingCart shopBean = (ShoppingCart)session.getAttribute("cart"); 
		/**
		 * LOGIN ACTION
		 * 
		 */
		if(userPath.equals("/loginAction")){
					
			String userName=request.getParameter("userName");
			String pwd=request.getParameter("userPassword");
			session.setAttribute("selectedCategory", "All CDS");
			OrderBean account=new OrderBean();
			session.removeAttribute("createSuccess");
	        Account userAccount = new Account();
	        /**
	         *  CHECK USER CREDENTIALS FROM WEBSERVICE - INVALID USERNAME IS RETURNED IF CREDENTIALS ARE NOT CORRECT
	         */
	        		userPath=props.getProperty("loginFailed");
	        		userAccount=account.getAccount(userName, pwd);
	        		if(userAccount.getUserName()==null){	        			
	        			userPath=props.getProperty("loginFailed");
	        			session.setAttribute("loginerror","Please check your username and password!"+userName+""+pwd+" "+userAccount.getUserName());
	        		}else{
	        			session.setAttribute("account", userAccount);
	        			session.setAttribute("loginerror","");
	        			userPath=props.getProperty("viewCDStore");
	        			CDStoreBean bean=new CDStoreBean();
	        			CD[] cds=bean.getCDList();
	        			session.setAttribute("CDS", cds);
	        		}
	        
			
			
		    //TODO: Implement add product to cart action
		}
		/**
		 * UPDATE QUANITTIES OF SHOPPING CART ITEMS
		 */
		else if(userPath.equals("/updateQuantity")){
			 // get input from request
           String cdid = request.getParameter("itemIndex");
           String quantity = request.getParameter("newQuantity");

           CDStoreBean cdBean = new CDStoreBean(); 
           CD cdItem = cdBean.getCDInfo(Integer.parseInt(cdid));

			//returns CD object via service
           if(request.getParameter("update")!=null){
			           shopBean.update(cdItem, quantity);
           }else if(request.getParameter("delete")!=null){
        	   shopBean.update(cdItem, "0");
           }
           userPath = props.getProperty("viewCart");
		}
		/**
		 * CONFIRM ORDER PROCESS
		 */
		else if(userPath.equals("/confirmOrder")){
			int processedOrders = 0;
			/**
			 * CHECK IF NUMBER OF HITS IS LESS THAN 5
			 */
			Boolean orderStatus=false;
			if (session.getAttribute("processedOrders")==null){
				session.setAttribute("processedOrders", 1);				
			}
			processedOrders = (Integer)session.getAttribute("processedOrders");
			Order mOrder=(Order)session.getAttribute("order");
			OrderBean oBean=new OrderBean();
			/**
			 * VALIDATE NUMBER OF ORDER PROCESS REQUESTS
			 */
			if((processedOrders % 5) == 0){
				
				orderStatus=oBean.confirmOrder(mOrder,"error", "error");
				session.setAttribute("orderMsg","ORDER FAILED!!! <br/>Every fifth request is refused!!!");
				
			} else {
						
			    String ccNumber = request.getParameter("ccNumber");
				String secCode = request.getParameter("secCode");
				
				//confirm successful order
				orderStatus = oBean.confirmOrder(mOrder,ccNumber, secCode);
				if(orderStatus==true){
				session.setAttribute("orderMsg","Order Successfully Completed"); 
				}else{
					session.setAttribute("orderMsg","Credit Card Authorization Failed.");
				}
				//delete order from bean
				Order order = (Order)session.getAttribute("order");
				order = null;
				
				//clear shopping cart
				
				shopBean.clear();
				
				
			}
			
			processedOrders++;
			session.setAttribute("processedOrders", processedOrders);
			
			userPath=props.getProperty("viewResultPage");
		}
		/**
		 * CREATE ACCOUNT FOR PERSISTING ACCOUNT INFORMATION
		 */
		else if(userPath.equals("/createAccount")){
			 	String username = request.getParameter("userName");
				String password = request.getParameter("userPassword");
				String verifyPassword = request.getParameter("verifyPassword");
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String street = request.getParameter("street");
				String city = request.getParameter("city");
				String province = request.getParameter("province");
				String postalcode = request.getParameter("postalcode");
				String country = request.getParameter("country");
				String phonenumber = request.getParameter("phonenumber");
				
				if ( username != null && username.length() > 0  
					 && password != null && password.length() > 0
					 && verifyPassword != null && verifyPassword.length() > 0
					 && firstName != null && firstName.length() > 0
					 && password.equals(verifyPassword)		 
					) {
			    	
			    	OrderBean oBean = new OrderBean();
			    	
			    	Account account = new Account();
			    	Address address = new Address();
			    	
			    	account.setUserName(username);
			    	account.setPassword(password);
			    	account.setFirstName(firstName);
			    	account.setLastName(lastName);
			    	address.setStreet(street);
			    	address.setCity(city);
			    	address.setProvince(province);
			    	address.setPostalCode(postalcode);
			    	address.setCountry(country);
			    	address.setPhone(phonenumber);
			    	
			    	account.setAddress(address);
			    	
			    	Account serviceAccount = oBean.createAccount(account);
			    	/**
			    	 * IF ACCOUNT ALREADY EXIST INVALID USERNAME IS RETURNED
			    	 */
			    	if (!serviceAccount.getAddress().equals("Invalid") && serviceAccount.getAddress()!=null ) {
			    		// have account in DB
				    	session.setAttribute("oBean", oBean);   	
				    	session.removeAttribute("loginerror");
				    	session.removeAttribute("createerror");
				    	selectedCategory="All CDs";
				    	CDStoreBean bean=new CDStoreBean();
				    	//load CDs into the CD Session to allow browsing of CDs
				        CD[] cds=bean.getCDList();
				        session.setAttribute("CDS", cds);
				        session.setAttribute("selectedCategory", selectedCategory);
				        //Set the account new account information into the account session to track the user
				    	session.setAttribute("account", account);
				    	//Set this session to separate login from successful account creation since they both takes to to the cdstore.jsp page
				    	session.setAttribute("createSuccess", true);
				    	userPath=props.getProperty("loginSuccess");
			    	} else{
			    		session.setAttribute("errorMessage", "Sorry Username already exist please use a different Username");
			    		session.setAttribute("createerror", true);
					    userPath=props.getProperty("createAccount");
			    	}
			    }else{
			        
			    //redirects before this if has account
			    	session.setAttribute("errorMessage", "Account creation error! Please check your value");
			    	session.setAttribute("createerror", true);
			    userPath=props.getProperty("createAccount");
			    }
		}
		//use Request Dispatcher to foward request internally
		String url="";
		
		 url=userPath;
		try{
			request.getRequestDispatcher(url).forward(request, response);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
