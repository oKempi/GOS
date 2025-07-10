package Core;
import Core.World;
import Systems.SocialSystem;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;
import java.util.List;
import java.nio.file.Paths;


public class Event {

    public static void april() {
        World.setWeather("April"); //add this option in checking system
        //make everyone a bit annoyed
    }
    public static void christmas() {
        World.setWeather("Snow");
        SocialSystem.changeMood(30);
    }
    public static void newYear() {
        World.setWeather("Clear");
    }

    public static void presentChoice(){
        try{
            List<String> lines = Files.readAllLines(Paths.get("Data/choices.txt"));
            System.out.println(lines.get(new Random().nextInt(lines.size())));
        }catch (IOException e){return;}
    }
    public static void processChoice(String choice){
        switch (choice) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "", " ":
                break;
        }
    }
    private static void actUpon(){ //actually does something (maybe implement right into process choice)
        return;
    }
}
