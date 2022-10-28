import java.io.File;
import java.io.IOException;

public class Time {
    ProcessBuilder clock;
    final String title = "time";
    final String description = "choose a time";


    public ProcessBuilder generate(){
        clock = new ProcessBuilder("zenity",
                "--entry",
                "--title=" + title,
                "--text=" + description);
        return clock;
    }

    public Process run(ProcessBuilder calendar) throws IOException {
        return calendar.start();
    }

    public static void main(String[] args) throws IOException {
        ProcessBuilder calendar1;
        Time time = new Time();
        calendar1 = time.generate();

        calendar1.redirectOutput(new File("/home/rezan/Schreibtisch/Terminplanner/ownOSNotification/src/src/main/resources/tmp/time.txt"));
        time.run(calendar1);


    }
}
