package pasoripi.external;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Common {
        public static Stream<String> execute(String command) {
            Runtime runtime = Runtime.getRuntime();
            List<String> list = new ArrayList<String>();
            try {
                Process process = runtime.exec(command);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String string;
                while ((string = reader.readLine()) != null) {
                    list.add(string);
                }
            } catch (IOException e) {
                throw new RuntimeException();
            }
            return list.stream();
        }
}
