import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class YzmHomeWork {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        List<String> command = new ArrayList<>();
        command.add("arp");
        command.add("-a");
        processBuilder.command(command);
        processBuilder.redirectErrorStream(true);
        Process start = processBuilder.start();
        System.out.println(start);
        InputStream inputStream = start.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");
        int len = -1;
        char[] c = new char[1024];
        StringBuffer outputString = new StringBuffer();
        while ((len = inputStreamReader.read(c)) != -1) {
            String s = new String(c, 0, len);
            outputString.append(s);
            System.out.print(s);
        }
        inputStream.close();

    }
}
