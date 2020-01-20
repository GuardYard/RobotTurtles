package game;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Game Jeu = new Game();
        Jeu.init();
        Jeu.turn();

    }

}