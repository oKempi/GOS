package Core;
import java.util.ArrayList;
import UI.CLI;
import Systems.SocialSystem;
import Systems.WeatherSystem;

public class World {
    private static ArrayList<Character> characters = new ArrayList<>();
    //number of how many has passed
    private static int day = 0; //max = 30
    private static int month = 0; // =30days (12 months in total)
    private static int year = 0; // =12 months (360 days = 1 year)
    private static String season = "";
    private static String weather = "";

    //update methods
    public static void updateSeason() {
        if (month == 3 || month == 4 || month == 5) {
            season = "Spring";
            CLI.setSeasonChanged();
        } else if (month == 6 || month == 7 || month == 8) {
            season = "Summer";
            CLI.setSeasonChanged();
        } else if (month == 9 || month == 10 || month == 11) {
            season = "Autumn";
            CLI.setSeasonChanged();
        } else if (month == 12 || month == 1 || month == 2) {
            season = "Winter";
            CLI.setSeasonChanged();
        }
    }

    public static void newDay(){
        day++;
        if(day == 30){month++;CLI.setMonthChanged();}
        if(month == 12 && day == 30){
            year++;
            month = 0;
            day = 0;
            updateSeason();
            CLI.setYearChanged();
        }
        WeatherSystem.rollWeather();
    }

    //getters
    public static int getDay() {
        return day;
    }
    public static int getMonth() {
        return month;
    }
    public static int getYear() {
        return year;
    }
    public static String getSeason() {
        return season;
    }
    public static ArrayList<Character> getCharacters() {
        return characters;
    }
    public static String getWeather() {
        return weather;
    }
    public static String getDate(){
        return day + "/" + month + "/" + year;
    }

    //setters
    public static void setWeather(String newWeather) {
        weather = newWeather;
        SocialSystem.update();
    }


    //actual story mechanics !Not the activation logic tho!

}
