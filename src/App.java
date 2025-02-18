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

    private static void filterNinjaByPunkte(List<Ninja> ninjas, int punkte) {
        for (Ninja ninja : ninjas) {
            if (ninja.getKraftpunkte() >= punkte)
                System.out.println(ninja.getKraftpunkte());
        }
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

            // b) filter ninjas by punkte given from user
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter punkte: ");
            int punkte = Integer.parseInt(scanner.nextLine());
            filterNinjaByPunkte(ninjas, punkte);


        } catch(IOException exception){
            System.err.println(exception.getMessage());
        }

    }
}
