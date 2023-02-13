import jdk.jfr.Description;

import java.util.stream.IntStream;

public class Validator {

	@Description("Überprüfen, ob ein Tag angegeben wurde")
	public boolean checkDay(String day) {
		try {
			if (!day.substring(0, 2).isBlank()) {
				return true;
			}
			return false;

		} catch (NullPointerException exception) {
			System.out.println("Kein Eintrag vorhanden!");
			return false;
		}
	}

	@Description("Überprüfen, ob ein Monat angegeben wurde")
	public boolean checkMonth(String month) {
		try {
			if (!month.substring(0, 2).isBlank()) {
				return true;
			}
			return false;

		} catch (NullPointerException exception) {
			System.out.println("Kein Eintrag vorhanden!");
			return false;
		}
	}

	@Description("Überprüfen, ob ein Jahr angegeben wurde")
	public boolean checkYear(String year) {
		try {
			if (!year.substring(0, 2).isBlank()) {
				return true;
			}
			return false;

		} catch (NullPointerException exception) {
			System.out.println("Kein Eintrag vorhanden!");
			return false;
		}
	}

	@Description("Überprüfen des Formats der Uhrzeiteingabe sowie (teilweise) gültige Uhrzeitangabe")
	public boolean checkTime(String time) {
		IntStream hour1 = IntStream.range(0, 3);
		IntStream hour2 = IntStream.range(0, 10);

		IntStream minute1 = IntStream.range(0, 6);
		IntStream minute2 = IntStream.range(0, 10);

		try {
			if (time.length() == "__:__ Uhr".length()) {
				int[] checkHour1 = hour1.filter(i -> Integer.toString(i).equals(time.substring(0, 1))).toArray();
				int[] checkHour2 = hour2.filter(i -> Integer.toString(i).equals(time.substring(1, 2))).toArray();

				int[] checkMinute1 = minute1.filter(i -> Integer.toString(i).equals(time.substring(3, 4))).toArray();
				int[] checkMinute2 = minute2.filter(i -> Integer.toString(i).equals(time.substring(4, 5))).toArray();

				return checkHour1.length >= 1 && checkHour2.length >= 1 && checkMinute1.length >= 1 && checkMinute2.length >= 1
						&& Integer.parseInt(time.substring(0, 2)) >= 0 && Integer.parseInt(time.substring(0, 2)) <= 24
						&& Integer.parseInt(time.substring(3, 5)) >= 00 && Integer.parseInt(time.substring(3, 5)) <= 59;
			}

		} catch (NullPointerException exception) {
			System.out.println("Kein Eintrag vorhanden!");
			return false;
		}
		return false;
	}
}
