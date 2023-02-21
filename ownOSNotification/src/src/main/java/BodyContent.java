import lombok.Getter;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BodyContent {
	@Getter
	private String bodyContent;

	BodyContent(Body body) throws IOException, InterruptedException {
		this.bodyContent = setBodyContent(body);
		while (this.bodyContent == null || this.bodyContent.isEmpty())
			this.bodyContent = setBodyContent(body);
	}


	private String setBodyContent(Body body) throws IOException, InterruptedException {
		PrintWriter pw = new PrintWriter(body.getDestination());
		Scanner scanner = new Scanner(new File(body.getDestination()));
		String line = null;
		String bodyContentX = "";

		Process process = body.run(body.generate());
		//set the content of the file after the process terminated -> break lines will be identified by "/" and finall added to the file:
		synchronized (scanner) {
			try {
				process.waitFor();
				line = scanner.nextLine();

				if (line != null && !line.isEmpty()) {
					String[] partsLineBreak = line.split("/");

					for (int i = 0; i < partsLineBreak.length; i++) {
						pw.println(partsLineBreak[i]);
					}
					pw.close();
					scanner.close();
				} else
					return null;
			} catch (NoSuchElementException exception) {
				System.out.println("Kein Eintrag wurde hinterlegt!");
			}

			//read all lines from the file with seperated line breaks; that is the body content sent per Mail:
			FileInputStream fileInputStream = null;
			BufferedReader bufferedReader = null;
			try {
				fileInputStream = new FileInputStream(body.getDestination());
				bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
				String line1 = bufferedReader.readLine();
				while (line1 != null) {
					bodyContentX += line1 + "\n";
					System.out.println(line1);
					line1 = bufferedReader.readLine();
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.toString());
			}
		}
		return bodyContentX;
	}
}
