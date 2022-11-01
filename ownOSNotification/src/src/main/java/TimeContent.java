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

		while (!checkTime){
			this.time = setTime(clock);
			checkTime = validator.checkTime(this.time);
		}
    }

	private String setTime(Time clock) throws IOException, InterruptedException {

		PrintWriter pw = new PrintWriter(clock.getDestination());
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

	public static void main(String[] args) throws IOException, InterruptedException {
        TimeContent timeContent = new TimeContent(new Validator(), new Time());
        //System.out.println(timeContent.getTime());

    }
}
