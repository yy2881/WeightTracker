
import javax.swing.JOptionPane;
import java.lang.Math;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Calculator {
	private double inactiveBMR; //BMR stands for Basal Metabolic Rate
	private double dailyEnergyExpenditure;
	private double weightToLose;
	private double totalPoundDeficit;
	private double targetWeightToLose;
	private int targetDays;
	private int dailyCaloriesLoss;
	private int dailyCaloricIntake;

	/**
	 * Calculate user's BMI using Metrics measures
	 * @param currentWeight
	 * @param currentHeight
	 * @return
	 */
	private static double calculateBMI(double currentWeight, double currentHeight) {
		double BMI = (currentWeight * 700) / (currentHeight * currentHeight);
		return BMI;
	}

	/**
	 * Calculate user's inactiveBMR using Metrics measures
	 * @param gender
	 * @param currentWeight
	 * @param currentHeight
	 * @param age
	 * @return
	 */
	private double calculateInactiveBMR(String gender, double currentWeight, double currentHeight, int age) {
		if ( gender.toLowerCase().equals("male") || gender.toLowerCase().equals("m") ) {
			inactiveBMR = 66 + (6.23 * currentWeight) + (12.7 * currentHeight) - (6.8 * age); //height is in inches
		}
		else if (gender.toLowerCase().equals("female") || gender.toLowerCase().equals("f")){
			inactiveBMR = 655 + (4.35 * currentWeight) + (4.7 * currentHeight) - (4.7 * age);
		}
		else {
			JOptionPane.showMessageDialog(null, "You have entered an invalid choice. Please select \"male\" or \"female\"");
		}
		return inactiveBMR;

	}

	/**
	 * Calculates the minimum number of calories to maintain current weight - Based off BMR and Activity Level
	 * (In other words, this is the users Daily Calorie Needs)
	 * @param activityLevel
	 * @return
	 */
	public double calculateDailyEnergyExpenditure(double inactiveBMR, int activityLevel) {

		if (activityLevel == 1) { //Sendary BMR (little or no exercise, desk job)
			dailyEnergyExpenditure = inactiveBMR * 1.2;
		}else if (activityLevel == 2) { //Lightly active BMR (light exercise/sports 1-3 days/wk)
			dailyEnergyExpenditure = inactiveBMR * 1.375;
		}else if (activityLevel == 3) { //Mod. active BMR (moderate exercise/sports 3-5 days/wk)
			dailyEnergyExpenditure = inactiveBMR * 1.55;
		}else if (activityLevel == 4) { //Very active BMR (hard exercise/sports 6-7 days/wk)
			dailyEnergyExpenditure = inactiveBMR * 1.725;
		}else if (activityLevel == 5) { //Extra active BMR (hard daily exercise/sports & physical job)
			dailyEnergyExpenditure = inactiveBMR * 1.9;
		}
		return dailyEnergyExpenditure;
	}

	/**
	 * This Method Calculates how much weight i need to lose to get to my targeted weight
	 * @param currentWeight
	 * @param targetWeight
	 * @return
	 */
	public double calculateTargetWeightToLose(double currentWeight, double targetWeight) {
		weightToLose = currentWeight - targetWeight; //How many lbs i would need to lose to get to my target weight
		return weightToLose;
	}


	/**
	 * Method calculates number of calories to lose to achieve targeted weight
	 * @param currentWeight
	 * @param targetWeight
	 * @param dailyEnergyExpenditure
	 * @return
	 */
	public double calculateCalorieDeficit(double currentWeight, double targetWeight, double dailyEnergyExpenditure) {
		totalPoundDeficit = weightToLose * 3500; // Number of calories i need to lose to get to my target weight
		return totalPoundDeficit;
	}

	/**
	 * This Method calculates the total amount of calories a user needs to lose in order to achieve his target weight
	 * @param totalPoundDeficit
	 * @param targetDays
	 * @return
	 */
	public int calculateDailyCalorieLoss(double totalPoundDeficit, int targetDays) {
		dailyCaloriesLoss = (int) Math.round(totalPoundDeficit / targetDays); // Rounds to close calories
		return dailyCaloriesLoss;
	}

	/**
	 * This method calculates the daily calories a user can intake in order to achieve his target weight
	 * @param dailyEnergyExpenditure
	 * @return
	 */
	public int calculateDailyCaloricIntake(int dailyCaloriesLoss, double dailyEnergyExpenditure) {
		dailyCaloricIntake = (int) Math.round(dailyEnergyExpenditure - dailyCaloriesLoss); // How much calories user can intake a day
		return dailyCaloricIntake;
	}

	//Should we return a warning if dailyCaloricIntake is less than 50% of dailyEnergyExpenditure?
		// EG: Be aware that you are intaking less than 50% of your daily energy expenditure and this might be unhealthy in the long run

	/**
	 * This method returns all the output required for the HTML output
	 * @param weightToLose
	 * @param targetDays
	 * @param dailyEnergyExpenditure
	 * @param dailyCaloriesLoss
	 * @param dailyCaloricIntake
	 * @return
	 */
	public String[] generateOutput(int activityLevel, int targetDays, double curWeight, double height, double tarWeight,int age,String gender) {
		String [] myArrayOutput = new String [5];
		double dailyEnergyExpenditure = calculateDailyEnergyExpenditure(calculateInactiveBMR(gender,curWeight,height,age),activityLevel);
		int dailyCalorieLoss = calculateDailyCalorieLoss(calculateCalorieDeficit(curWeight,tarWeight,dailyEnergyExpenditure),targetDays);
		myArrayOutput[0] = String.valueOf(curWeight-tarWeight);
		myArrayOutput[1] = String.valueOf(targetDays);
		myArrayOutput[2] = String.valueOf(dailyEnergyExpenditure);
		myArrayOutput[3] = String.valueOf(dailyCalorieLoss);
		myArrayOutput[4] = String.valueOf(calculateDailyCaloricIntake(dailyCalorieLoss,dailyEnergyExpenditure));
		return myArrayOutput;

	}

}
