package cards;

import cards.Obstacles;
import game.ConsoleColors;

import java.util.*;

//chaque joueur doit avoir 3
//interdit de bloquer l’accès aux joyaux & d’encercler un joyau ou un autre joueur

public class Pierre extends Obstacles {
    public Pierre(){
        this.cardName =(ConsoleColors.BLACK_UNDERLINED+"Pierre Card"+ ConsoleColors.RESET);
        this.description="Permet de posser un obstacle";
        this.destructible="indestructible !";
        this.icon=(ConsoleColors.BLACK_UNDERLINED+ "rock "+ ConsoleColors.RESET);
    }


    public int[] play() {
        System.out.println("Veuillez rentrer la coordonée X le d'obstacle");
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        System.out.println("Veuillez rentrer la coordonée Y le d'obstacle");
        int Y = sc.nextInt();
        return new int[] {X, Y} ;
    }


}