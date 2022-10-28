import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class DateContentTest {
    @Test
    void test1() throws IOException {
        ProcessBuilder calendar1;
        Date date = new Date();
        calendar1 = date.generate();
        //String d = new DateContent(date.run(calendar1)).getDate();
        InputStream inputStream = date.run(calendar1).getInputStream();
        OutputStream outputStream = date.run(date.generate()).getOutputStream();






        Assertions.assertThat(inputStream).hasContent("26.10.2022");

    }

}