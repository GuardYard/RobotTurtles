package game;

import cards.Card;

import java.util.*;

public class Game {
    public Scanner sc = new Scanner(System.in);

    private ArrayList<Player> Joueur = new ArrayList<Player>();
    private String[][] Cell = {{"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}};

    public String[][] getCell() {
        return Cell;
    }
    public void init(){
        int nbJoueur;
        do {
            System.out.println("Combien de joueur? (2, 3 ou 4)");
            nbJoueur = sc.nextInt();
            switch (nbJoueur) {
                case 2:
                    System.out.println(1);
                    break;
                case 3:
                    System.out.println(2);
                    break;
                case 4:
                    System.out.println(3);
                    break;
            }
        } while (nbJoueur != 2 && nbJoueur != 3 && nbJoueur != 4);
        addPlayer(nbJoueur);
    }


    public void viewCell() {
        for (int i = 0; i < Cell.length; i++) {
            System.out.print("[");
            for (String[] strings : Cell) {
                System.out.print(strings[i]);
                System.out.print(",");
            }
            System.out.println("]");
        }
    }

    private void addPlayer(int P){
        if(P == 2) {
            for (int i = 0; i < 2; i++) {
                Player P1 = new Player();
                // this.Joueur.add();
            }
        }
    }

    public void execute(Player P){
        for (Card card : P.getHandCards()){
            if (card.getCardName().equals("Blue Card")){
                int x = P.getX();
                int y = P.getY();
                removeCell(x,y);
                int [] newpos = card.play(P.getDirection(), x, y);
                int x2 = newpos[0];
                int y2 = newpos[1];
                P.setpositon(x2,y2);
                setCell(P.getIcontest(), x2, y2);

            }
            else if (card.getCardName().equals("Purple Card") || card.getCardName().equals("Yellow Card")){
                int x = P.getX();
                int y = P.getY();
                removeCell(x,y);
                String newdir = card.play(P.getDirection());
                P.setDirection(newdir);
            }
        }

    }

    private void removeCell(int x, int y) {
        Cell[x][y] = "     ";
    }

    public void setCell(String icon, int x, int y){
        Cell[x][y] = icon;
    }
}