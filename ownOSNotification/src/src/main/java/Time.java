import lombok.Getter;

import java.io.File;
import java.io.IOException;

public class Time {
    private ProcessBuilder clock;
    private final String title = "time";
    private final String description = "choose a time";
	@Getter
	private final String destination = "/home/rezan/Schreibtisch/Terminplanner/ownOSNotification/src/src/main/resources/tmp/time.txt";


    public ProcessBuilder generate(){
        clock = new ProcessBuilder("zenity",
                "--entry",
                "--title=" + title,
                "--text=" + description + "like this: \"09:15 Uhr\"",
		        "--entry-text=" + "__:__ Uhr");
        return clock;
    }

    public Process run(ProcessBuilder clock) throws IOException {
		save(clock);
        return clock.start();
    }

	private void save(ProcessBuilder clock){
		clock.redirectOutput(new File(destination));
	}

    public static void main(String[] args) throws IOException {
        ProcessBuilder clock;
        Time time = new Time();
        clock = time.generate();

        time.run(clock);


    }
}
