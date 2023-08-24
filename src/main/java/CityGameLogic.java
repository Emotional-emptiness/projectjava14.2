import java.util.HashSet;
import java.util.List;

public class CityGameLogic {
    private Database database;
    private HashSet<String> usedCities;
    private String lastCity;

    public CityGameLogic(Database database) {
        this.database = database;
        usedCities = new HashSet<>();
    }

    public String makeMove(String input) {
        List<String> cities = database.getCities();

        if (usedCities.contains(input)) {
            return "This city has already been used. Try another city.";
        }

        if (lastCity != null && !input.startsWith(lastCity.substring(lastCity.length() - 1).toUpperCase())) {
            return "The city should start with the last letter of the previous city. Try another city.";
        }

        usedCities.add(input);

        String nextCity = "";
        for (String city : cities) {
            if (!usedCities.contains(city) && city.startsWith(input.substring(input.length() - 1).toUpperCase())) {
                nextCity = city;
                break;
            }
        }

        if (nextCity.isEmpty()) {
            return "You win! The computer can't find the next city.";
        }

        lastCity = nextCity;
        usedCities.add(nextCity);

        return nextCity;
    }
}
