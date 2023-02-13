import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SubjectContent {
	@Getter
	private String subjectName;

	SubjectContent(Subject subject) throws IOException, InterruptedException {

		this.subjectName = setSubjectName(subject);
		while (this.subjectName == null || this.subjectName.isEmpty())
			this.subjectName = setSubjectName(subject);

	}

	private String setSubjectName(Subject subject) throws IOException, InterruptedException {

		PrintWriter pw = new PrintWriter(subject.getDestination());
		Scanner scanner = new Scanner(new File(subject.getDestination()));
		String line = null;
		String subjectNameX = null;

		Process process = subject.run(subject.generate());

		synchronized (scanner) {
			try {

				process.waitFor();
				line = scanner.nextLine();

				if (line != null)
					subjectNameX = line;

			} catch (NoSuchElementException exception) {
				System.out.println("Kein Eintrag wurde hinterlegt!");

			}
		}

		return subjectNameX;
	}

}
