import lombok.Getter;

import java.io.*;

public class Date {

	ProcessBuilder calendar;
	private final String title = "calendar";
	private final String description = "choose a date";
	@Getter
	private final String destination = "/home/rezan/Schreibtisch/Terminplanner/ownOSNotification/src/src/main/resources/tmp/date.txt";

	public ProcessBuilder generate() {
		calendar = new ProcessBuilder("zenity",
				"--calendar",
				"--title=" + title,
				"--text=" + description);
		return calendar;
	}

	public Process run(ProcessBuilder calendar) throws IOException {
		save(calendar);
		return calendar.start();
	}

	private void save(ProcessBuilder calendar) {
		calendar.redirectOutput(new File(destination));
	}


}
