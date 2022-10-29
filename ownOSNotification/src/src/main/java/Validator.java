import jdk.jfr.Description;
import jdk.jfr.Unsigned;

import java.io.FileNotFoundException;
import java.util.List;

public class Validator {

	@Description("Überprüfen, ob ein Tag angegeben wurde!")
    private boolean checkDay(String day){
        try {
            if( !day.substring(0,2).isBlank()){
                return true;
            }
            return false;

        }catch (NullPointerException exception){
            System.out.println("Kein Eintrag vorhanden!");
            return false;
        }
    }
	@Description("Überprüfen, ob ein Monat angegeben wurde!")
    private boolean checkMonth(String month){
        try {
            if( !month.substring(0,2).isBlank()){
                return true;
            }
            return false;

        }catch (NullPointerException exception){
            System.out.println("Kein Eintrag vorhanden!");
            return false;
        }
    }

	@Description("Überprüfen, ob ein Jahr angegeben wurde!")
	private boolean checkYear(String year){
		try {
			if( !year.substring(0,2).isBlank()){
				return true;
			}
			return false;

		}catch (NullPointerException exception){
			System.out.println("Kein Eintrag vorhanden!");
			return false;
		}
    }

	@Description("Überprüfen des Formats der Uhrzeiteingabe")
	private boolean checkTime(String time){
		try{
			if (time.length() == "__:__ Uhr".length()) {
				return true;
			}
			return false;

		}catch (NullPointerException exception){
			System.out.println("Kein Eintrag vorhanden!");
			return false;
		}
	}

    public static void main(String[] args) throws FileNotFoundException {
        Validator validator = new Validator();
        boolean checkDay = validator.checkDay(new DateContent().getDay());
        boolean checkMonth = validator.checkMonth(new DateContent().getMonth());
		boolean checkYear = validator.checkYear(new DateContent().getYear());
		boolean checkTime = validator.checkTime(new TimeContent().getTime());
        System.out.println(checkDay);
        System.out.println(checkMonth);
        System.out.println(checkYear);
        System.out.println(checkTime);
    }
}
