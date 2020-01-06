import cards.Obstacles;

package cards;

import java.util.*;

//chaque joueur doit avoir 3
//interdit de bloquer l’accès aux joyaux & d’encercler un joyau ou un autre joueur

public class Pierre extends Obstacles {
    public Pierre(){
        this.cardName ="Pierre Card";
        this.description="Permet de posser un obstacle";
        int x;
        int y;
    }


    public int[] playPierre() {
        System.out.println("Veuillez rentrer la coordonée X le d'obstacle");
        Scanner sc = new Scanner;
        int X = sc.nextInt();
        System.out.println("Veuillez rentrer la coordonée Y le d'obstacle");
        int Y = sc.nextInt();
        
        return new int[x][y];
    }
}