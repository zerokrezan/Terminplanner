import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TimeContent {
    @Getter
    String time;
    private final Scanner scanner = new Scanner(new File("/home/rezan/Schreibtisch/ownOSNotification/src/src/main/resources/tmp/time.txt"));

    TimeContent() throws FileNotFoundException {
        String line = null;

        line = scanner.nextLine();

        if (line != null)
            this.time = line;
    }

    public static void main(String[] args) throws FileNotFoundException {
        TimeContent timeContent = new TimeContent();
        System.out.println(timeContent.getTime());

    }
}
