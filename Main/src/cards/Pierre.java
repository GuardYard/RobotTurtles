package cards;

import cards.Obstacles;
import game.ConsoleColors;

import java.util.*;

//chaque joueur doit avoir 3
//interdit de bloquer l’accès aux joyaux & d’encercler un joyau ou un autre joueur

public class Pierre extends Obstacles {
    public Pierre(){
        this.cardName =(ConsoleColors.BLACK_UNDERLINED+"Rock Card"+ ConsoleColors.RESET);
        this.description="Allows to place an obstacle!";
        this.destructible="indestructible !";
        this.icon=(ConsoleColors.BLACK_UNDERLINED+ "rock "+ ConsoleColors.RESET);
    }


    public int[] play() {
        System.out.println("Please enter you X coordinate -->");
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        System.out.println("Please enter you Y coordinate (down)");
        int Y = sc.nextInt();
        return new int[] {X, Y} ;
    }


}