import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TimeContent {
    @Getter
    String time;
    private Scanner scanner;
	private Validator validator;
	private Time clock;

    TimeContent(Validator validator, Time clock) throws IOException, InterruptedException {

	    this.time = setTime(clock);

	    this.validator = validator;
		this.clock = clock;

		boolean f = new Validator().checkTime(this.time);

		while (!f){
			clock = new Time();
			//clock.run(clock.generate());
			//validator = new Validator();
			this.time = setTime(clock);
			f = validator.checkTime(this.time);
		}

    }

	private String setTime(Time clock) throws IOException, InterruptedException {

		PrintWriter pw = new PrintWriter(clock.getDestination());
		scanner = new Scanner(new File(clock.getDestination()));
		String line = null;
		String i = null;

		Process process = clock.run(clock.generate());

		synchronized (scanner){
			try {

				process.waitFor();
				//scanner.wait(process.waitFor());
				line = scanner.nextLine();
				//scanner.wait();
				//scanner.nextLine();


				if (line != null)
					i = line;

			}catch (NoSuchElementException exception){
				System.out.println("Kein Eintrag wurde hinterlegt!");
			/*clock = new Time();
			clock.run(clock.generate());
			validator = new Validator();*/
			}
			//process.exitValue();
		}


		this.time = null;
		return i;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
        TimeContent timeContent = new TimeContent(new Validator(), new Time());
        //System.out.println(timeContent.getTime());

    }
}
