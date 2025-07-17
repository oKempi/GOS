package Core;

import Systems.SocialSystem;

public class Character {
    private String name;
    private int age = 0;
    private int moodInt = 100; //baseline
    private String mood = "neutral";
    private String birthDate;

    //for game mechanics (technically mood should be here as well :D)
    private int money = 0; //aka coins
    private


    public Character(String name, String birthDate) {
        this.name = name;
        this.age = 0;
        this.birthDate = birthDate;
    }

    public void changeMood(int mood) {
        this.moodInt = this.moodInt + mood; //allows for +x || -x
        this.mood = SocialSystem.checkMood(this.moodInt);
        SocialSystem.moodChanged++;
    }

    public int getMood(){
        return this.moodInt;
    }
}
