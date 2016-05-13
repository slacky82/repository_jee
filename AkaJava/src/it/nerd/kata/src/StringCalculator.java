package it.nerd.kata.src;

import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class StringCalculator {

	/* TEST_GIT */
	/**
	 * The method can take 0, 1 or 2 numbers, and will return their sum (for an
	 * empty string it will return 0) for example “” or “1” or “1,2”
	 */
	public int Add(String text) {
		int numberOne;
		int numberTwo;
		if (text.isEmpty()) {
			return 0;
		}
		try {
			String[] numbers = text.split(",");
			if (numbers.length == 0) {
				return 0;
			}
			if (numbers.length == 1) {
				return new Integer(Integer.valueOf(numbers[0]));
			}
			if (!numbers[0].isEmpty() && !numbers[1].isEmpty()) {
				numberOne = new Integer(Integer.valueOf(numbers[0]));
				numberTwo = new Integer(Integer.valueOf(numbers[1]));
				return numberOne + numberTwo;
			} else if (!numbers[0].isEmpty()) {
				return Integer.valueOf(numbers[0]);
			} else {
				return Integer.valueOf(numbers[1]);
			}
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	private String clearString(String text) {
		String dummyString = text.trim();
		dummyString = StringUtils.replace(text, "\n", ",");
		dummyString = dummyString.replaceAll("\\s+","");
		if (StringUtils.contains(text, "//") && StringUtils.indexOf(text, "//") == 0) {
			char delimiter = text.charAt(2);
			dummyString = StringUtils.replace(dummyString, Character.toString(delimiter), ",");
		}
		return dummyString;
	}

	public int Add2(String text) {
		String[] numbers = null;
		List<Integer> negativeNnmbers = new ArrayList<Integer>();

		text = clearString(text);

		numbers = text.split(",");
		if (text.isEmpty()) {
			return 0;
		}

		if (numbers.length == 1) {
			return new Integer(Integer.valueOf(numbers[0]));
		}
		int tot = 0;
		for (String currNumber : numbers) {
			if (!NumberUtils.isNumber(currNumber)) {
				continue;
			}
			if (Integer.valueOf(currNumber) < 0) {
				negativeNnmbers.add(Integer.valueOf(currNumber));
				// throw new IllegalArgumentException("negatives not allowed");
			} else {
				int currParsedNumber = Integer.valueOf(currNumber);
				tot = tot + currParsedNumber;
			}
		}
		if (negativeNnmbers.isEmpty()) {
			return tot;
		} else {
			StringBuffer strBuffErr = new StringBuffer();
			for (Integer cuurInteger : negativeNnmbers) {
				strBuffErr.append(cuurInteger);
			}
			throw new IllegalArgumentException("negatives not allowed: values are= " + strBuffErr);
		}

	}

}
