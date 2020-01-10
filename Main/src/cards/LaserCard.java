package cards;

import game.ConsoleColors;

public class LaserCard extends Card {           //F
    public LaserCard(){
        this.cardName =(ConsoleColors.RED+"Laser Card"+ ConsoleColors.RESET);
        this.description="Destroy the obstacle that's just in front of a player!";
    }

    public int[] playBlue(String direction, int X, int Y) {
        if (Y != 0 && direction.equals("North")) {
            Y = (Y - 1);
        } else if (Y != 7 && direction.equals("South")) {
            Y = (Y + 1);
        } else if (X != 7 && direction.equals("East")) {
            X = X + 1;
        } else if (X != 0 && direction.equals("West")) {
            X = X - 1;
        }
        return new int[]{X, Y};
    }


    public String play(String dir) {
        String direction = "";
        if(dir.equals("North")){
            direction = "South";
        }
        else if(dir.equals("West")){
            direction = "East";
        }
        else if(dir.equals("South")){
            direction = "North";
        }
        else if(dir.equals("East")){
            direction = "West";
        }
        return direction;
    }


}
