package cards;

import game.ConsoleColors;

import java.util.Scanner;


public class Pierre extends Obstacles {
    public Pierre() {
        this.cardName = (ConsoleColors.BLACK_UNDERLINED + "Rock Card" + ConsoleColors.RESET);
        this.description = "Allows to place an obstacle!";
        this.destructible = "indestructible !";
        this.icon = (ConsoleColors.BLACK_UNDERLINED + "rock " + ConsoleColors.RESET);
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