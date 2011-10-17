package controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Category;
import entity.Cds;

/**
 * Servlet implementation class ControllerServellet
 */
public class ControllerServellet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private String surcharge;
    /**
     * @see HttpServlet#HttpServlet()
     */
	 @Override
	    public void init(ServletConfig servletConfig) throws ServletException {

	        super.init(servletConfig);

	        // initialize servlet with configuration information
	       // surcharge = servletConfig.getServletContext().getInitParameter("deliverySurcharge");
	        
	        // store category list in servlet context
	      //  getServletContext().setAttribute("categories",categoryFacade.findAll() );
	    }
	
    public ControllerServellet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPath=request.getServletPath();
        HttpSession session = request.getSession();
        Category selectedCategory;
        Collection<Cds> categoryProducts;
		//if category page is requested
		if(userPath.equals("/cds")){
			//TODO: Implement category request
		}
		//if cart page is requested
		else if(userPath.equals("/viewCart")){
			//TODO: Implement cart page request
			userPath="/cart";
		}
		//if checkout page is requested
		else if(userPath.equals("/checkout")){
			//TODO: Implement checkout page request
		}// if user switches language
		
		
		String url="/WEB-INF/view"+userPath+".jsp";
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
		//if addToCart action is called
		if(userPath.equals("/addToCart")){
			//TODO: Implement add product to cart action
		}
		//if UpdateCart Action is Called
		else if(userPath.equals("/updateCart")){
			//TODO: Implement update Cart Action
		}
		//if purchase action is called
		else if(userPath.equals("/purchase")){
			//TOD: Implement purchase action
			userPath="/loginpage";
		}else if(userPath.equals("/login")){
			userPath="/confirmation";
		}
		//use Request Dispatcher to foward request internally
		String url="/WEB-INF/view"+userPath+".jsp";
		try{
			request.getRequestDispatcher(url).forward(request, response);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
