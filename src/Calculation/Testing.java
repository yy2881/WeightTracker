import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testing {
	Calculator calculator = new Calculator();

	@Test
	void testCalculateBMI() {


		//test1
		double curWeight1 = 165.1;
		double curHeight1 = 72.3;
		double bmi1 = calculator.calculateBMI(curWeight1,curHeight1);
		assertEquals(bmi1,22.10897,0.001);

		//test2
		double curWeight2 = 200.13;
		double curHeight2 = 88.7;
		double bmi2 = calculator.calculateBMI(curWeight2,curHeight2);
		assertEquals(bmi2,17.80587,0.001);
	}

	@Test
	void testCalculateInactiveBMR() {

		//test3
		String gender1 = "MALE";
		double currentWeight1 = 165.1;
		double currentHeight1 = 72.3;
		int age1 = 24;
		assertEquals(calculator.calculateInactiveBMR(gender1, currentWeight1, currentHeight1, age1),1849.58299,0.001);

		//test4
		String gender2 = "f";
		double currentWeight2 = 132.1;
		double currentHeight2 = 63.3;
		int age2 = 18;
		assertEquals(calculator.calculateInactiveBMR(gender2, currentWeight2, currentHeight2, age2),1442.545,0.001);

	}

		@Test
		void calculateDailyEnergyExpenditure() {

			//test5
			double inactiveBMR = 1442.545;
			int activityLevel = 1;
			assertEquals(calculator.calculateDailyEnergyExpenditure(inactiveBMR, activityLevel),1731.05,0.1);

			//test6
			double inactiveBMR = 1600;
			int activityLevel = 2;
			assertEquals(calculator.calculateDailyEnergyExpenditure(inactiveBMR, activityLevel),2200.00,0.1);

			//test7
			double inactiveBMR = 1849.58299;
			int activityLevel = 3;
			assertEquals(calculator.calculateDailyEnergyExpenditure(inactiveBMR, activityLevel),2866.85,0.1);

			//test8
			double inactiveBMR = 1849.58299;
			int activityLevel = 4;
			assertEquals(calculator.calculateDailyEnergyExpenditure(inactiveBMR, activityLevel),3190.53,0.1);

			//test9
			double inactiveBMR = 1442.545;
			int activityLevel = 5;
			assertEquals(calculator.calculateDailyEnergyExpenditure(inactiveBMR, activityLevel),2,740.84,0.1);

		}

		@Test
		void calculateCalorieDeficit() {

			//test10
			double currentWeight = 143.30;
			double targetWeight = 135.00;
			assertEquals(calculator.calculateCalorieDeficit(currentWeight, targetWeight),29050.00,0.1);

		}

		@Test
		void calculateDailyCalorieLoss() {

			//test11
			double totalPoundDeficit = 15000;
			int targetDays = 30;
			assertEquals(calculator.calculateDailyCalorieLoss(totalPoundDeficit, targetDays),500,1);

		}

		@Test
		void calculateDailyCaloricIntake() {

			//test12
			int dailyCaloriesLoss = 500;
			double dailyEnergyExpenditure = 2650;
			assertEquals(calculator.calculateDailyCaloricIntake(dailyCaloriesLoss, dailyEnergyExpenditure),2150,1);

		}

}
