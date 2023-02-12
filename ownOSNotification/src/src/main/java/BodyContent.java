import lombok.Getter;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BodyContent {
	@Getter
	private String bodyContent;

	BodyContent(Body body) throws IOException, InterruptedException {

		this.bodyContent = setBodyContent(body);
		while ( this.bodyContent == null || this.bodyContent.isEmpty() )
			this.bodyContent = setBodyContent(body);
	}

	private String setBodyContent(Body body) throws IOException, InterruptedException {
		PrintWriter pw = new PrintWriter(body.getDestination());
		Scanner scanner = new Scanner(new File(body.getDestination()));
		String line = null;
		String bodyContentX = null;

		Process process = body.run(body.generate());

		synchronized (scanner){
			try {
				process.waitFor();
				line = scanner.nextLine();

				if (line != null) {
					bodyContentX = line;
					String[] partsLineBreak = line.split("/");

					for (int i = 0; i < partsLineBreak.length; i++) {
						pw.println(partsLineBreak[i]);
					}
					pw.close();
				}
			}catch (NoSuchElementException exception){
				System.out.println("Kein Eintrag wurde hinterlegt!");
			}
		}
		return bodyContentX;
	}
}
