import java.io.*;

public class Date {

    ProcessBuilder calendar;
    final String title = "calendar";
    final String description = "choose a date";


    public ProcessBuilder generate(){
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

	private void save(ProcessBuilder calendar){
		calendar.redirectOutput(new File("/home/rezan/Schreibtisch/Terminplanner/ownOSNotification/src/src/main/resources/tmp/date.txt"));
	}


	public static void main(String[] args) throws IOException {
        ProcessBuilder calendar1;
        Date date = new Date();
        calendar1 = date.generate();

        date.run(calendar1);


    }

}
