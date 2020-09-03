package Benford;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BenfordApplication {
	static Scanner userInput = new Scanner(System.in);
	static int comma = 0;
	static double decimalRemove = 0;
	static int digitOne = 0;
	static double amountOfDigits = 0;
	static BufferedReader reader = null;
	static String[] splitNum;


	public static void main(String[] args) throws IOException {

		List<String> lines = new ArrayList<String>();
		File inputFile = getInputFileFromUser();

		if (inputFile != null) {
			try {

				reader = new BufferedReader(new FileReader(inputFile));
				String line = null;
				while ((line = reader.readLine()) != null) {
					lines.add(line);
				}
			} catch (IOException e) {

				e.printStackTrace();
			} finally {
				reader.close();
			}
			Object[] src = lines.toArray();
			splitNum = new String[src.length];
			System.arraycopy(src, 0, splitNum, 0, src.length);

		}
		 int size = splitNum.length;
		 int[] numArray = new int[size];
		 int[] digitArray = new int[size];
		
		for (int i = 0; i < splitNum.length; i++) {
			String noSpace = splitNum[i].replaceAll("\\s+", "");
			if (noSpace.contains(",")) {
				comma = Integer.parseInt(noSpace.replaceAll(",", ""));
				numArray[i] = comma;
			}
			else if(noSpace.contains(".")) {
				decimalRemove = Double.parseDouble(noSpace);
				numArray[i] = (int) decimalRemove;
			}
			
			else
				numArray[i] = Integer.parseInt(noSpace);
		}

		for (int i = 0; i < numArray.length; i++) {

			digitOne = firstDigit(numArray[i]);
			if (digitOne > 0)
				digitArray[i] = digitOne;
		}

		double ones = 0;
		double twos = 0;
		double threes = 0;
		double fours = 0;
		double fives = 0;
		double sixes = 0;
		double sevens = 0;
		double eights = 0;
		double nines = 0;
		amountOfDigits = digitArray.length;

		for (int j = 0; j < digitArray.length; j++) {

			if (digitArray[j] == 1)
				ones++;
			if (digitArray[j] == 2)
				twos++;
			if (digitArray[j] == 3)
				threes++;
			if (digitArray[j] == 4)
				fours++;
			if (digitArray[j] == 5)
				fives++;
			if (digitArray[j] == 6)
				sixes++;
			if (digitArray[j] == 7)
				sevens++;
			if (digitArray[j] == 8)
				eights++;
			if (digitArray[j] == 9)
				nines++;
		}

		double percentOfOnes = (ones / amountOfDigits) * 100.0;
		double percentOfTwos = (twos / amountOfDigits) * 100.0;
		double percentOfThrees = (threes / amountOfDigits) * 100.0;
		double percentOfFours = (fours / amountOfDigits) * 100.0;
		double percentOfFives = (fives / amountOfDigits) * 100.0;
		double percentOfSixes = (sixes / amountOfDigits) * 100.0;
		double percentOfSevens = (sevens / amountOfDigits) * 100.0;
		double percentOfEights = (eights / amountOfDigits) * 100.0;
		double percentOfNines = (nines / amountOfDigits) * 100.0;

		NumberFormat formatter = new DecimalFormat("#0.00");

		System.out.println("\nPercentage of ones: " + formatter.format(percentOfOnes));
		System.out.println("Percentage of twos: " + formatter.format(percentOfTwos));
		System.out.println("Percentage of threes: " + formatter.format(percentOfThrees));
		System.out.println("Percentage of fours: " + formatter.format(percentOfFours));
		System.out.println("Percentage of fives: " + formatter.format(percentOfFives));
		System.out.println("Percentage of sixes: " + formatter.format(percentOfSixes));
		System.out.println("Percentage of sevens: " + formatter.format(percentOfSevens));
		System.out.println("Percentage of eights: " + formatter.format(percentOfEights));
		System.out.println("Percentage of nines: " + formatter.format(percentOfNines));

	}


	private static File getInputFileFromUser() {
		

		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();

		File inputFile = new File(path);
		if (inputFile.exists() == false) { 
			System.out.println(path + " does not exist");
			inputFile = null;
		} else if (inputFile.isFile() == false) {
			System.out.println(path + " is not a file");
			inputFile = null;
		}

		return inputFile;

	}

	public static Integer firstDigit(int n) {
		while (n >= 10)
			n /= 10;
		return n;
	}

	public boolean isBenford;

}
