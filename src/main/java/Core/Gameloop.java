package Core;
import UI.CLI;

import java.util.Random;

public class Gameloop {
    private static final Random rand = new Random();
    public static int nextTurn = rand.nextInt(1, 6);

    private static void advance() {
        World.newDay();
        CLI.print();
        nextTurn = nextTurn - 1;
    }
    private static void processChoice() { //connect it to the world cuz this aint gonna work :l
        String x = CLI.getPlayerInput();
        switch (x) {
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

    private static void rollNextTurn(){
        nextTurn =  rand.nextInt(1, 6);
    }

    //first loop
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){ //first 5 turns just show you what is happening, only after those you can interact
            advance();
            processChoice(); //only to continue when player is ready
            CLI.print();
        }
        //forever loop
        while(true) {
            if (nextTurn == 0) {
                CLI.print();
                Event.presentChoice();
                //!!(and check for illegal outcomes and outcomes in general ofc)!!
                Event.processChoice(CLI.getPlayerInput());
                rollNextTurn();
                advance();
            }
            else{
                CLI.print();
                Event.processChoice(CLI.getPlayerInput());
                advance();
            }
        }
    }
}
