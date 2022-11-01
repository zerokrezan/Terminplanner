import lombok.Getter;

import java.io.File;
import java.io.IOException;

public class Subject {

	private String subjectName;
	private ProcessBuilder subject;
	private final String title = "subject";
	private final String description = "specify a subject";
	@Getter
	private final String destination = "/home/rezan/Schreibtisch/Terminplanner/ownOSNotification/src/src/main/resources/tmp/subject.txt";

	public ProcessBuilder generate(){
		subject = new ProcessBuilder("zenity",
				"--entry",
				"--title=" + title,
				"--text=" + description,
				"--entry-text=" );
		return subject;
	}

	public Process run(ProcessBuilder subject) throws IOException {
		save(subject);
		return subject.start();
	}

	private void save(ProcessBuilder subject){
		subject.redirectOutput(new File(destination));
	}
}
