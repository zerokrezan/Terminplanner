import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TimeContent {
    @Getter
    private String time;
	TimeContent(Validator validator, Time clock) throws IOException, InterruptedException {

		this.time = setTime(clock);

		boolean checkTime = validator.checkTime(this.time);
		boolean firstAttempt = true;

		while (!checkTime){
			this.time = setTime(clock);
			checkTime = validator.checkTime(this.time);
			firstAttempt = false;
			}
    }

	private String setTime(Time clock) throws IOException, InterruptedException {

		Scanner scanner = new Scanner(new File(clock.getDestination()));
		String line = null;
		String timeX = null;

		Process process = clock.run(clock.generate());

		synchronized (scanner){
			try {
				process.waitFor();
				line = scanner.nextLine();

				if (line != null)
					timeX = line;

			}catch (NoSuchElementException exception){
				System.out.println("Kein Eintrag wurde hinterlegt!");
			}
		}
		return timeX;
	}
}
