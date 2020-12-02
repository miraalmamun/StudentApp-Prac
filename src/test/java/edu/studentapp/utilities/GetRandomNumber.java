package edu.studentapp.utilities;

import java.util.Random;

public class GetRandomNumber {

	public static String getRandomString() {

		Random random = new Random();
		int ranNumber = random.nextInt(1000);
		String stringNumber = Integer.toString(ranNumber);

		return stringNumber;
	}

}
