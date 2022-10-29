import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DateContent {
    @Getter
    private String day;
    @Getter
    private String month;
    @Getter
    private String year;

    private Validator validator;

    private Scanner scanner = new Scanner(new File("/home/rezan/Schreibtisch/Terminplanner/ownOSNotification/src/src/main/resources/tmp/date.txt"));

    DateContent() throws FileNotFoundException {

        String line = null;

        try {
            line = scanner.nextLine();

            if (line != null)
                this.day = line.substring(0,3);
            this.month = line.substring(3,6);
            this.year = line.substring(6,10);

        }catch (NoSuchElementException exception){
            System.out.println("Kein Eintrag wurde hinterlegt!");
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        DateContent date = new DateContent();
        System.out.println(date.getDay());
        System.out.println(date.getMonth());
        System.out.println(date.getYear());

    }



}
