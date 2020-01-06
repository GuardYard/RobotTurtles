package cards;

import cards.Obstacles;
import java.util.*;

//chaque joueur doit avoir 3
//interdit de bloquer l’accès aux joyaux & d’encercler un joyau ou un autre joueur

public class Pierre extends Obstacles {
    public Pierre(){
        this.cardName ="Pierre Card";
        this.description="Permet de posser un obstacle";
        this.destructible="indestructible !";
        this.icon="pierre";
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