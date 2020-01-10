package cards;

import game.ConsoleColors;

public class YellowCard extends Card {

    //test
    public YellowCard() {
        this.cardName = (ConsoleColors.YELLOW+"Yellow Card"+ConsoleColors.RESET);
        this.description = "Allows to do a left-turn ( no going forward )";
    }


    public int[] playBlue(String direction, int X, int Y) {
        return new int[0];
    }

    public String play(String dir) {
        String direction = "";
        if (dir.equals("North")) {
            direction = "West";
        } else if (dir.equals("West")) {
            direction = "South";
        } else if (dir.equals("South")) {
            direction = "East";
        } else if (dir.equals("East")) {
            direction = "North";
        }
        return direction;
    }
}
