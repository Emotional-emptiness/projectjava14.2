import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<String> cities;

    public Database() {
        cities = new ArrayList<>();
        loadCitiesFromFile();
    }

    private void loadCitiesFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("cities.txt"), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                cities.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getCities() {
        return cities;
    }
}
