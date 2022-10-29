import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TimeContent {
    @Getter
    String time;
    private Scanner scanner = new Scanner(new File("/home/rezan/Schreibtisch/Terminplanner/ownOSNotification/src/src/main/resources/tmp/time.txt"));

    TimeContent() throws FileNotFoundException {
        String line = null;

		try {
			line = scanner.nextLine();

			if (line != null)
				this.time = line;
		}catch (NoSuchElementException exception){
			System.out.println("Kein Eintrag wurde hinterlegt!");
		}
    }

    public static void main(String[] args) throws FileNotFoundException {
        TimeContent timeContent = new TimeContent();
        System.out.println(timeContent.getTime());

    }
}
