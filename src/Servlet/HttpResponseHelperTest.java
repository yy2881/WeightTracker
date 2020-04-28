package Servlet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HttpResponseHelperTest {
	HttpResponseHelper helper = new HttpResponseHelper();

	@Test
	void testBuildHtmlResponse() {
		
		//test 13
		String[] input = new String[5];
		input[0] = "15"; // goal (lbs)
		input[1] = "30"; // target days
		input[2] = "1500";   // daily calorie intake to keep safe
		input[3] = "400"; // calorie intake that should be reduced
		input[4] = "1100"; // calorie intake that should be kept to lose weight
		String httpRes = helper.buildHtmlResponse(input);
		assertEquals(httpRes,"<html>" + 
				"<head><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\"></head>" + 
				"<body><div class=\"alert alert-secondary\" role=\"alert\">" + 
				"<h4 class=\"alert-heading\">Your Weight Loss Target Results Are:</h4>" + 
				"<p>Your goal is to lose <span class=\"alert-danger\">15lb's</span> in <span class=\"alert-danger\">30 days</span></p>" + 
				"<p>To maintain your current weight, your safe daily calories intake is around <span class=\"alert-success\">1500 calories</span></p>" + 
				"<p>To reach your goal, you will need to reduce your daily calories intake with <span class=\"alert-success\">400 calories</span>, which means to get <span class=\"alert-success\">1100 calories daily</span></p>" + 
				"</div>" + 
				"</body></html>");
		
		
	}
	
	@Test
	void testShowHealthyWarning() {
		//test 14
		assertNotNull(helper);
	}
	
	@Test
	void testShowReenterPrompt() {
		//test 15
		assertNotNull(helper);
	}


	


}
