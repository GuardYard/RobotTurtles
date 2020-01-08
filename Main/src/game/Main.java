package game;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        Game game = new Game();
//        System.out.println("Quel le nom du joueur 1?");
//        String name=sc.nextLine();
//        Player P1 = new Player();
//        P1.Player1();
//        P1.setName(name);
//        P1.pickCardOnDeck();
//        P1.pickCardOnDeck();
//        P1.pickCardOnDeck();
//        P1.seeCardOnHand();
//        System.out.println("Suite ?");
//        sc.nextLine();
//
//
//        int x = P1.getX();
//        int y = P1.getY();
//
//        game.setCell(P1.getIcontest(),x,y);
//        game.viewCell();
//
//        game.execute(P1);
//
//        game.viewCell();
// //       ArrayList<Player> P = new ArrayList<Player>();
// //       Player P1 = new Player();
// //      P1.Player1();
//        P1.setPassageOrder(2);
//        Player P2 = new Player();
//        P2.Player2();
//        P2.setPassageOrder(3);
//        Player P3 = new Player();
//        P3.Player3();
//        P3.setPassageOrder(0);
//        Player P4 = new Player();
//        P4.Player4();
//        P4.setPassageOrder(1);
//        P.add(P1);
//        P.add(P2);
//        P.add(P3);
//        P.add(P4);
//        System.out.print("[   ");
//        for(Player f : P){
//            System.out.print(f.getName() + ",");
//        }
//        System.out.println("   ]");
//        int sizeListP = P.size();
//        System.out.println(sizeListP);
//        ArrayList<Player> SortedP = new ArrayList<Player>();
//        while(SortedP.size() < sizeListP){
//            for(Player t : P){
//                if (t.getPassageOrder() == SortedP.size()){
//                    SortedP.add(t);
//                }
//            }
//        }
//        System.out.print("[   ");
//        for(Player f : SortedP){
//            System.out.print(f.getName() + ",");
//        }
// //       System.out.println("   ]");
// Player P1 = new Player();
// P1.Player1();
// P1.getDeck().showDeck();

        //Test Obstacle
        Game Jeu = new Game();
        Jeu.init();
        Jeu.turn();

    }

}