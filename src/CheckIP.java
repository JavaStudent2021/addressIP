import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIP {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayBlackList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("blacklist.txt"));
        while (reader.ready()) {
            String line = reader.readLine();
            arrayBlackList.add(line);
        }
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String lineEnter = "";
        String lineE = "";
        boolean bl = false;
        System.out.print("Welcom ");
        while (!bl) {
            System.out.print("Added IP: ");
            lineEnter = bufferedReader.readLine();
            Pattern addressIp = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
            Matcher matcher = addressIp.matcher(lineEnter);
            if (matcher.matches()) {
                if (arrayBlackList.contains(lineEnter)) {
                    System.out.println("Access disallowed");
                } else {
                    System.out.println("Access allowed");
                }
            } else {
                System.out.println("Invalid IP address");
            }

            System.out.println("Enter or quit?");
            lineE = bufferedReader.readLine();

            if (lineE.equals("quit")) {
                bl = true;
            } else if (lineE.equals("y")) {
                bl = false;
            }
        }
    }
}



