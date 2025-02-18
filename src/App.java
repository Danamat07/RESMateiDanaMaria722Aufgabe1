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

    private static List<Ninja> filterNinjaByPunkte(List<Ninja> ninjas, int punkte) {
        List<Ninja> pkt = new ArrayList<>();
        for (Ninja ninja : ninjas) {
            if (ninja.getKraftpunkte() >= punkte)
                pkt.add(ninja);
        }
        return pkt;
    }

    private static void saveToJsonFile(List<Ninja> ninjas, String outputFile) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
        gson.toJson(ninjas, bufferedWriter);
        bufferedWriter.close();
    }

    public static void main(String[] args) {

        String inputFile = "src/ninja_events.json";
        String outputFile = "src/gesammtzahl.json";

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
            List<Ninja> ninjaList = filterNinjaByPunkte(ninjas, punkte);
            for (Ninja n: ninjaList) {
                System.out.println(n);
            }

            saveToJsonFile(ninjas, outputFile);


        } catch(IOException exception){
            System.err.println(exception.getMessage());
        }

    }
}
