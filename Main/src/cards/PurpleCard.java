package cards;

import game.ConsoleColors;

public class PurpleCard extends Card {
    public PurpleCard(){
        this.cardName =(ConsoleColors.PURPLE+"Purple Card"+ConsoleColors.RESET);
        this.description="Allows to do a right-trun! ( no going forward )";
    }


    public int[] playBlue(String direction, int X, int Y) {
        return new int[0];
    }

    public String play(String dir) {
        String direction = "";
        if(dir.equals("North")){
            direction = "East";
        }
        else if(dir.equals("West")){
            direction = "North";
        }
        else if(dir.equals("South")){
            direction = "West";
        }
        else if(dir.equals("East")){
            direction = "South";
        }
        return direction;
    }
}
