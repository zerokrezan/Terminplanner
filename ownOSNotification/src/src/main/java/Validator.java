import jdk.jfr.Description;

import java.io.FileNotFoundException;
import java.util.List;

public class Validator {

@Description("Überprüfen, ob ein Tag angegeben wurde!")
    private boolean checkDay(String day){
        List days = List.of("01","02","03","04","05","06","07","08","09",
                "10","11","12","13","14","15","16","17","18","19","20","21","22","23","24",
                "25","26","27","28","29","30","31");
        try {
            for (int i = 0; i < days.size(); i++) {
                if (day.substring(0, 2).contains(days.get(i).toString()))
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
        boolean check = validator.checkDay(new DateContent().getDay());
        System.out.println(check);
    }
}
