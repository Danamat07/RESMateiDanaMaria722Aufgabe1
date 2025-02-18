import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

public class App {
    private static List<Ninja> readFromJsonFile(String file) throws IOException {
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<Ninja> ninjas = gson.fromJson(bufferedReader, new TypeToken<List<Ninja>>() {}.getType());
        bufferedReader.close();
        return ninjas;
    }

    public static void main(String[] args) {

        String inputFile = "src/ninja_events.json";
        String outputFile = "src/ninja_events.json";

        try {
            // a) read data from JSON file
            List<Ninja> ninjas = readFromJsonFile(inputFile);
            for (Ninja ninja: ninjas) {
                System.out.println(ninja);
            }



        } catch(IOException exception){
            System.err.println(exception.getMessage());
        }

    }
}
