package Systems;
import Core.World;
import Core.Character;

public class SocialSystem {
    public static int moodChanged = 0;
    public static int oldMood = 0;
    public static int newMood = 0;

    public static void update() { //should be run only ONCE a day!!!
        for(Character person : World.getCharacters()){
            oldMood += person.getMood();
        }
        switch (World.getWeather()){ //should only run once a day
            case "Sunny":
                for(Core.Character person : World.getCharacters()) {person.changeMood(15);}
                break;
            case "Cloudy", "Cold and sunny":
                for(Core.Character person : World.getCharacters()) {person.changeMood(0);}
                break;
            case "Clear":
                for(Core.Character person : World.getCharacters()) {person.changeMood(5);}
                break;
            case "Rain":
                for(Core.Character person : World.getCharacters()) {person.changeMood(-10);}
                break;
            case "Storm":
                for(Core.Character person : World.getCharacters()) {person.changeMood(-15);}
                break;
            case "Thunder":
                for(Core.Character person : World.getCharacters()) {person.changeMood(-20);}
                break;
            case "Windy":
                for(Core.Character person : World.getCharacters()) {person.changeMood(-5);}
                break;
            case "Snow":
                for(Core.Character person : World.getCharacters()) {person.changeMood(0);}
                //maybe check if they like snow? Check for rain as well
                break;
            case "Hail":
                for(Core.Character person : World.getCharacters()) {person.changeMood(-25);}
                break;
        }
    }

    public static String checkMood(int mood) {
        if (mood == 50) {
            return "Neutral";
        } else if (mood < 25) {
            return "Angry";
        } else if (mood < 50) {
            return "Annoyed";
        } else if (mood > 50) {
            return "Happy";
        } else if (mood > 75) {
            return "Excited";
        }
        else {return null;}
    }

    public static void changeMood(int mood) {
        for(Core.Character person : World.getCharacters()) {person.changeMood(mood);}
        //add a special message stating that everyone is a bit happier now or angrier
    }

    public static int overallMood(){
        for(Core.Character person : World.getCharacters()){
            newMood += person.getMood();
        }
        return newMood;
    }
}
