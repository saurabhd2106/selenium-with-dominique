package testData;

import org.testng.annotations.DataProvider;

public class DataGenerator {

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][3];

		data[0][0] = "Dominique";
		data[0][1] = "Ouedraogo";
		data[0][2] = "Cypress";

		data[1][0] = "Müller";
		data[1][1] = "Maryam";
		data[1][2] = "Selenium";

		return data;

	}

}
