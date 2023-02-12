import lombok.Getter;

import java.io.*;

public class Body {
	private ProcessBuilder body;

	private final String title = "body";
	private final String description = "fill out body";


	@Getter
	private final String destination = "/home/rezan/Schreibtisch/Terminplanner/ownOSNotification/src/src/main/resources/tmp/body.txt";

	public ProcessBuilder generate(){
		body = new ProcessBuilder("zenity",
				"--entry",
				"--title=" + title,
				"--text=" + description,
				"--entry-text=");
		return body;
	}

	public Process run(ProcessBuilder body) throws IOException {
		save(body);
		return body.start();
	}

	private void save(ProcessBuilder body) {
		body.redirectOutput(new File(destination));


	}


}
