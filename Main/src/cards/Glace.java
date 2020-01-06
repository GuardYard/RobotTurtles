package cards;
//chaque joueur doit avoir 2

import java.util.Scanner;

//interdit de bloquer l’accès aux joyaux & d’encercler un joyau ou un autre joueur
public class Glace extends Obstacles {

    //test
    public Glace() {
        this.cardName = "Glace Card";
        this.description = "Permet de posser un obstacle";
        this.destructible="destructible avec un lazer!";
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