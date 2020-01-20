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
        System.out.println("Please enter you X coordinate -->");
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        System.out.println("Please enter you Y coordinate (down)");
        int Y = sc.nextInt();
        return new int[]{X, Y};
    }
}