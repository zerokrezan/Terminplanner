import java.io.IOException;

public class Notification {
	ProcessBuilder processBuilder;
	String notificationName;
	String notificationContent;

	public Notification(String notificationName, String notificationContent) {
		this.notificationName = notificationName;
		this.notificationContent = notificationContent;
	}

	private ProcessBuilder generate() {
		processBuilder = new ProcessBuilder("zenity",
				"--calendar",
				"--title=" + notificationName,
				"--text=" + notificationContent);
		return processBuilder;
	}

	private void run(ProcessBuilder processBuilder) throws IOException {
		processBuilder.inheritIO().start();
	}

}
