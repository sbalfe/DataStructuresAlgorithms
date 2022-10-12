import java.time.LocalDate;

/**
 * @author Anonymous (do not change)
 *
 *         Question 8:
 *
 *         You are given the following information, but you may prefer to do
 *         some research for yourself. • 1 Jan 1900 was a Monday. • Thirty days
 *         has September, April, June and November. All the rest have
 *         thirty-one, saving February alone, which has twenty-eight, rain or
 *         shine. And on leap years, twenty-nine. • A leap year occurs on any
 *         year evenly divisible by 4, but not on a century unless it is
 *         divisible by 400.
 *
 *         How many Tuesdays fell on the first of the month during the twentieth
 *         century (1 Jan 1901 to 31 Dec 2000)?
 *
 *         Note, this problem is inspired by Project Euler so, as stated in the
 *         rules of Project Euler, your solution should return an answer under
 *         60 seconds.
 */

public class CWK2Q8 {

	public static int howManyTuesdays() {
		int tuesday = 0;
		// use local date to find out which day it was on said date
		LocalDate dt;
		String dateFormat;
		String date = "{0}-{1}-{2}";

		// cycle through the specified years and months
		for (int year = 1901; year <= 2000; year++) {
			for (int month = 1; month <= 12; month++) {
				// convert month to a string
				String monthString = String.valueOf(month);
				// the date must be of 01,02,... for month therefore reformat with this added, 11 and 12 are fine however.
				if (month < 10) {
					monthString = String.format("0%s", monthString);
				}
				// build the formatted data
				dateFormat = java.text.MessageFormat.format(date, String.valueOf(year).replaceAll(",", ""), monthString,"01");
				// parse the date
				dt = LocalDate.parse(dateFormat);

				// fetch the current day of week and its value, 2 is tuesday thus simply increment if 2 as the date formatted just reads the
				// first of every month
				if (dt.getDayOfWeek().getValue() == 2) {
					tuesday++;
				}
			}
		}
		// return number , should be 171
		return tuesday;
	}

	public static void main(String[] args) {
		int result = CWK2Q8.howManyTuesdays();
		System.out.println("Number of Tuesdays = " + result);
	}
}
