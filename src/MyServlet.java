import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



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
		double currentWeight = Double.parseDouble(request.getParameter("form_curWeight"));
		double targetWeight = Double.parseDouble(request.getParameter("form_tarWeight"));
		int activityLevel = Integer.parseInt(request.getParameter("form_activityLevel"));
		int age = Integer.parseInt(request.getParameter("form_age"));
		int days = Integer.parseInt(request.getParameter("form_days"));
		String gender = request.getParameter("form_gender");
		double height = Double.parseDouble(request.getParameter("form_height"));
		
		
		//calculate nutrition message
		Calculator calculator = new Calculator();
		String[] outputMessage = calculator.generateOutput(activityLevel,days,currentWeight,height,targetWeight,age,gender);

		// get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<head><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\"></head>";      
        htmlRespone += "<body><div class=\"alert alert-secondary\" role=\"alert\">";  
        htmlRespone += "<h4 class=\"alert-heading\">Your Weight Loss Target Results Are:</h4>";  
        htmlRespone += "<p>Your goal is to lose <span class=\"alert-danger\">"+outputMessage[0] +"lb's</span> in <span class=\"alert-danger\">"+outputMessage[1]+" days</span></p>";
        htmlRespone += "  <p>To maintain your current weight, your safe daily calories intake is around <span class=\"alert-success\">"+outputMessage[2]+" calories</span></p>";  
        htmlRespone += "<p>To reach your goal, you will need to reduce your daily calories intake with <span class=\"alert-success\">"+outputMessage[3]+" calories</span>, which means to get <span class=\"alert-success\">"+outputMessage[4]+" calories daily</span></p>";  
        htmlRespone += "</div></body></html>";
        
        // return response
        writer.println(htmlRespone);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);


	}

}

