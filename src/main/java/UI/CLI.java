package UI;

import Core.Gameloop;
import Core.World;

import java.util.Scanner;

public class CLI {
    private static Boolean monthChanged = false;
    private static Boolean seasonChanged = false;
    private static Boolean yearChanged = false;
    private static final Scanner scanner = new Scanner(System.in);

    public static void print(){
        //Day/Date <= 1st line
        if(World.getMonth() == 0){
            System.out.println("Day " + World.getDay());
        }
        if(monthChanged)
        {System.out.println("It is now " + World.getMonth());}

        if(monthChanged && seasonChanged)
        {System.out.println(World.getSeason() + " just came around!");}

        if(yearChanged && monthChanged)
        {System.out.println("Happy new year! It is now year " +  World.getYear());}

        else{System.out.println(World.getDate());}

        //Weather <= 2nd line
        System.out.println("It is currently" + World.getWeather());

        //Next action in
        System.out.println("Your next action is in " + Gameloop.nextTurn);

        //Little overview of what has happened
        resetBooleans();
    }

    public static void setMonthChanged(){
        monthChanged = true;
    }
    public static void setSeasonChanged(){
        seasonChanged = true;
    }
    public static void setYearChanged(){
        yearChanged = true;
    }
    private static void resetBooleans(){
        monthChanged = false;
        seasonChanged = false;
        yearChanged = false;
    }
    public static String getPlayerInput(){
        return scanner.nextLine();
    }
}
