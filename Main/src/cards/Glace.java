package cards;


import game.ConsoleColors;

import java.util.Scanner;


public class Glace extends Obstacles {


    public Glace() {
        this.cardName = (ConsoleColors.CYAN_BOLD + "Ice Card" + ConsoleColors.RESET);
        this.description = "Allows to place an obstacle";
        this.destructible = "Distructable with a lazer beam!";
        this.icon = (ConsoleColors.CYAN_BOLD + " ice " + ConsoleColors.RESET);
    }

    public int[] play() {
        Scanner sc = new Scanner(System.in);
        int X;
        int Y;
        do {
            System.out.println("Please enter you X coordinate -->");
            X = sc.nextInt();
        }while(X<0 || X>7);
        do {
            System.out.println("Please enter you Y coordinate (down)");
            Y = sc.nextInt();
        }while (Y<0 || Y>7);
        return new int[]{X, Y};
    }
}