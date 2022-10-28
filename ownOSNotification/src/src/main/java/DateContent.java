import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DateContent {
    @Getter
    private String day;
    @Getter
    private String month;
    @Getter
    private String year;

    private Scanner scanner = new Scanner(new File("/home/rezan/Schreibtisch/Terminplanner/ownOSNotification/src/src/main/resources/tmp/date.txt"));

    DateContent() throws FileNotFoundException {
        String line = null;

        line = scanner.nextLine();

        if (line != null)
            this.day = line.substring(0,3);
            this.month = line.substring(3,6);
            this.year = line.substring(6,10);
    }

    public static void main(String[] args) throws FileNotFoundException {
        DateContent date = new DateContent();
        System.out.println(date.getDay());
        System.out.println(date.getMonth());
        System.out.println(date.getYear());

    }



}
