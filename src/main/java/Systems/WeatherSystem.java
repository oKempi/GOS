package Systems;
import Core.World;
import java.util.Random;

public class WeatherSystem {
    private static final String[] Spring = {"Sunny", "Cloudy",  "Clear", "Rain", "Storm", "Thunder", "Windy"};
    private static final String[] Summer = {"Sunny", "Cloudy",  "Clear", "Rain", "Storm", "Thunder", "Windy"};
    private static final String[] Autumn = {"Sunny", "Cloudy",  "Rain", "Cloudy", "Storm", "Windy", "Thunder", "Windy"};
    private static final String[] Winter = {"Cold and sunny", "Cloudy",  "Clear", "Snow", "Rain", "Storm", "Snow", "Thunder", "Snow", "Hail", "Windy"};

    public static void rollWeather(){ //should be run only ONCE a day!!!
        Random rand = new Random();
        if(World.getDay() == 1 && World.getMonth() == 4){
            World.setWeather("Rain");
        }
        else if (World.getSeason().equals("Spring")) {
            World.setWeather(Spring[rand.nextInt(Spring.length)]);
        }
        else if (World.getSeason().equals("Summer")) {
            World.setWeather(Summer[rand.nextInt(Summer.length)]);
        }
        else if (World.getSeason().equals("Autumn")) {
            World.setWeather(Autumn[rand.nextInt(Autumn.length)]);
        }
        else if (World.getSeason().equals("Winter")) {
            World.setWeather(Winter[rand.nextInt(Winter.length)]);
        }
    }
}
