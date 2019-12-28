package game;

import cards.Card;

import java.util.*;

public class Game {
    public Scanner sc = new Scanner(System.in);

    private ArrayList<Player> Joueur = new ArrayList<Player>();
    private String[][] Cell = {{"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}};
    private int victoryV;

    public String[][] getCell() {
        return Cell;
    }


    public void init(){
        int nbJoueur;
        do {
            System.out.println("Combien de joueur? (2, 3 ou 4)");
            nbJoueur = sc.nextInt();
            switch (nbJoueur) {  //Le switch ne sert à rien, c'est juste pour les tests
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

    public ArrayList<Player> initOrder(ArrayList<Player> JoueurBis){
        ArrayList<Player> SortedP = new ArrayList<Player>();
        int sizeListP = JoueurBis.size();
        while(SortedP.size() < sizeListP){
            for(Player P : JoueurBis){
                if (P.getPassageOrder() == SortedP.size()){
                    SortedP.add(P);
                }
            }
        }
        return SortedP;
    }

    public void viewCell() { //F
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
        //F
        ArrayList<Integer> NbO = new ArrayList<Integer>();
        if(P == 2) {
            Player P1 = new Player();
            Player P2 = new Player();
            P1.Player1();
            P2.Player2();
            P1.setpositon(1,0);
            P2.setpositon(5,0);
            NbO.add(0);
            NbO.add(1);
            Collections.shuffle(NbO);
            P1.setPassageOrder(NbO.get(0));
            P2.setPassageOrder(NbO.get(1));
            this.Joueur.add(P1);
            this.Joueur.add(P2);
        }

        else if(P == 3){
            Player P1 = new Player();
            Player P2 = new Player();
            Player P3 = new Player();
            P1.Player1();
            P2.Player2();
            P3.Player3();
            P1.setpositon(0,0);
            P2.setpositon(3,0);
            P3.setpositon(6,0);
            NbO.add(0);
            NbO.add(1);
            NbO.add(2);
            Collections.shuffle(NbO);
            P1.setPassageOrder(NbO.get(0));
            P2.setPassageOrder(NbO.get(1));
            P3.setPassageOrder(NbO.get(2));
            this.Joueur.add(P1);
            this.Joueur.add(P2);
            this.Joueur.add(P3);
        }

        else if(P == 4){
            Player P1 = new Player();
            Player P2 = new Player();
            Player P3 = new Player();
            Player P4 = new Player();
            P1.Player1();
            P2.Player2();
            P3.Player3();
            P4.Player4();
            P1.setpositon(0,0);
            P2.setpositon(2,0);
            P3.setpositon(5,0);
            P4.setpositon(7,0);
            NbO.add(0);
            NbO.add(1);
            NbO.add(2);
            NbO.add(3);
            Collections.shuffle(NbO);
            P1.setPassageOrder(NbO.get(0));
            P2.setPassageOrder(NbO.get(1));
            P3.setPassageOrder(NbO.get(2));
            P4.setPassageOrder(NbO.get(3));
            this.Joueur.add(P1);
            this.Joueur.add(P2);
            this.Joueur.add(P3);
            this.Joueur.add(P4);
        }

        for(Player elem : this.Joueur){
            System.out.println("Quel est le nom du joueur " + elem.getName() + " ?");
            String name = sc.nextLine();
            elem.setName(name);
        }
        setJoueur(initOrder(this.Joueur));
    }


    public void execute(Player P){
        for (Card card : P.getHandCards()){ //PF => getHandCards() : getProgram
            if (card.getCardName().equals("Blue Card")){
                int x = P.getX();
                int y = P.getY();
                removeCell(x,y);
                int [] newpos = card.playBlue(P.getDirection(), x, y);
                int x2 = newpos[0];
                int y2 = newpos[1];
                P.setpositon(x2,y2);
                setCell(P.getIcontest(), x2, y2);

            }
            else if (card.getCardName().equals("Purple Card") || card.getCardName().equals("Yellow Card")){         //Change la direction du player
                String newdir = card.play(P.getDirection());
                P.setDirection(newdir);
            }
        }

    }

    private void setVictoryV(int victoryV) {
        this.victoryV = victoryV;
    }

    private void setJoueur(ArrayList<Player> joueur) {
        Joueur = joueur;
    }

    private void removeCell(int x, int y) {
        Cell[x][y] = "     ";
    }

    public void setCell(String icon, int x, int y){
        Cell[x][y] = icon;
    }
}