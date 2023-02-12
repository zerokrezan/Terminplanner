import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DateContent {
    @Getter
    private String day;
    @Getter
    private String month;
    @Getter
    private String year;

    DateContent(Validator validator, Date date) throws IOException {
		String[] content = setContent(date);
	    this.day = content[0];
	    this.month = content[1];
	    this.year = content[2];

	    boolean checkDay = validator.checkDay(this.day);
	    boolean checkMonth = validator.checkMonth(this.month);
	    boolean checkYear = validator.checkYear(this.year);

	    while (!checkDay || !checkMonth || !checkYear){

		    content = setContent(date);
		    this.day = content[0];
		    this.month = content[1];
		    this.year = content[2];

		    checkDay = validator.checkDay(this.day);
			checkMonth = validator.checkMonth(this.month);
			checkYear = validator.checkYear(this.year);
	    }
    }

	private String[] setContent(Date date) throws IOException {
		Scanner scanner = new Scanner(new File(date.getDestination()));
		String line;
		String i = null;

		Process process = date.run(date.generate());

		synchronized (scanner){
			try {
				process.waitFor();
				line = scanner.nextLine();

				if (line != null)
					this.day = line.substring(0,3);
					this.month = line.substring(3,6);
					this.year = line.substring(6,10);

			}catch (NoSuchElementException | InterruptedException exception){
				System.out.println("Kein Eintrag wurde hinterlegt!");
			}
		}

		return new String[]{day, month,year};
	}



}
