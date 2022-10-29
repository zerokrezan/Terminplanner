import java.io.*;

//TODO: priuate Methode für redirectOutput erstellen -> siehe Time.java
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
        return calendar.start();
    }

    public static void main(String[] args) throws IOException {
        ProcessBuilder calendar1;
        Date date = new Date();
        calendar1 = date.generate();

        calendar1.redirectOutput(new File("/home/rezan/Schreibtisch/Terminplanner/ownOSNotification/src/src/main/resources/tmp/date.txt"));
        date.run(calendar1);


    }

}
