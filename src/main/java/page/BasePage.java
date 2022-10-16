package page;

import java.util.Random;

public class BasePage {

	
	public int genRandomNum(int boundaryNum) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(boundaryNum);
		return generatedNum;
	}	
}
