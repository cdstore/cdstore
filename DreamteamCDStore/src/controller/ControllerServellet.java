package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServellet
 */
public class ControllerServellet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServellet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPath=request.getServletPath();
		
		//if category page is requested
		if(userPath.equals("/category")){
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
		else if(userPath.equals("/chooseLanguage")){
			//TODO: Implement language request
		}
		
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
