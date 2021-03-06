package Servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import Calculation.Calculator;


@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			//get input values from html form
			double currentWeight = Double.parseDouble(request.getParameter("current_weight"));
			double targetWeight = Double.parseDouble(request.getParameter("target_weight"));
			int activityLevel = Integer.parseInt(request.getParameter("activity_level"));
			int age = Integer.parseInt(request.getParameter("age"));
			int days = Integer.parseInt(request.getParameter("target_days"));
			String gender = request.getParameter("gender");
			double height = Double.parseDouble(request.getParameter("height")) * 12;

			
			

			//instantiate calculator and calculate nutrition message
			Calculator calculator = new Calculator();
			String[] outputMessage = calculator.generateOutput(activityLevel,days,currentWeight,height,targetWeight,age,gender);

			
			//instantiate HttpResponseHelper and send http response back
			HttpResponseHelper helper = new HttpResponseHelper();
			
			
	        if(Integer.parseInt(outputMessage[2]) < Integer.parseInt(outputMessage[3])) {
	        	
	        	//handle corner case 1: daily safe calorie intake < daily calorie loss
	        	helper.showReenterPrompt();
	        	
	        	// return response 
	        	response.sendRedirect("index.html");
	        } else { 
	        	// get response writer
	        	PrintWriter writer = response.getWriter();
	        	
	        	//handle corner case 2: daily calorie intake to lose weight is lower than expected healthy value
	        	if(gender.equals("Male") && Integer.parseInt(outputMessage[4]) < 1200 || gender.equals("Female") && Integer.parseInt(outputMessage[4]) < 1000) {
	        		helper.showHealthyWarning();
	        	}
	        	
	        	// build HTML response
	        	String htmlResponse = helper.buildHtmlResponse(outputMessage);

	            // return response 
	            writer.println(htmlResponse);
	        }
		} catch (Exception exception) {

			JOptionPane.showMessageDialog(null, "Your input is not valid. Please don't leave empty fields and make sure you type number or text as instructed.");
			response.sendRedirect("index.html");
        } 
			
	        	
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);


	}

}

