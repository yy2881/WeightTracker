package Servlet;
import javax.swing.JOptionPane;

public class HttpResponseHelper {

	public String buildHtmlResponse(String outputMessage[]){
		String htmlRespone = "<html>";
        htmlRespone += "<head><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\"></head>";      
        htmlRespone += "<body><div class=\"alert alert-secondary\" role=\"alert\">";  
        htmlRespone += "<h4 class=\"alert-heading\">Your Weight Loss Target Results Are:</h4>";  
        htmlRespone += "<p>Your goal is to lose <span class=\"alert-danger\">"+outputMessage[0] +"lb's</span> in <span class=\"alert-danger\">"+outputMessage[1]+" days</span></p>";
        htmlRespone += "  <p>To maintain your current weight, your safe daily calories intake is around <span class=\"alert-success\">"+outputMessage[2]+" calories</span></p>";  
        htmlRespone += "<p>To reach your goal, you will need to reduce your daily calories intake with <span class=\"alert-success\">"+outputMessage[3]+" calories</span>, which means to get <span class=\"alert-success\">"+outputMessage[4]+" calories daily</span></p>";  
        htmlRespone += "</div></body></html>";
		return htmlRespone;
		
	}
	
	public void showHealthyWarning(){
		JOptionPane.showMessageDialog(null, "You are attempting a low-calorie diet. There are huge health risks associated with such diets, and is not recommended. Please consult with a dietician before proceeding");
	}
	
	public void showReenterPrompt() {
		JOptionPane.showMessageDialog(null, "You should try to lose around 5 to 10% of your current body weight, one to two pounds per week or try to reduce your calorie intake by 500 - 1,000 calories a day.\n" + 
    			"Please reenter your information");
	}
}
