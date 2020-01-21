package game;

import cards.Card;
import cards.Obstacles;
import cards.Pierre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    public Scanner sc = new Scanner(System.in);

    private ArrayList<Player> Joueur = new ArrayList<Player>();
    private ArrayList<Jewel> Jewel = new ArrayList<Jewel>();
    private ArrayList<Player> Winners = new ArrayList<Player>();
    private int victoryV = 1;
    private int nbTurn;  //variable qui stock le nombre de tours
    private int cashPrize;
    private String[][] Cell = {{"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "},
            {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "},
            {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "},
            {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "},
            {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "},
            {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "},
            {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "},
            {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}};

    public String[][] getCell() {
        return Cell;
    }


    public void init() {
        int nbJoueur;
        do {
            System.out.println("How many players? (2, 3 or 4)");
            nbJoueur = sc.nextInt();
        } while (nbJoueur != 2 && nbJoueur != 3 && nbJoueur != 4);
        addPlayer(nbJoueur);
        viewCell();
    }

    public void turn() {
        while (Winners.size() < Joueur.size() - 1) {
            for (Player player : this.Joueur) {
                if (player.getUltimatum() == 0) {
                    player.verifHand(player);
                    player.verifDeck(player);
                    int commande = 0;
                    do {
                        System.out.println("Your turtle is facing : " + player.getDirection());
                        System.out.println("It's " + player.getName() + "'s turn! Please select an action.");
                        System.out.println("Prepare your moves   :   1");
                        System.out.println("Execute moves        :   2");
                        System.out.println("Place obstacles      :   3");
                        commande = sc.nextInt();
                    } while (commande != 1 && commande != 2 && commande != 3);
                    if (commande == 1) {
                        prepare(player);//Fonction de préparation de la liste "programme" : Demande d'un ordre au joueur par rapport à sa main
                    } else if (commande == 2) {
                        execute(player);
                        viewCell();
                    } else if (commande == 3) {
                        viewCell();
                        player.seeObstacleOnHand();
                        executeObstacles(player);
                        viewCell();
                    }
                }
                if (Winners.size() == Joueur.size() - 1) {
                    break;
                }
            }
        }
        endTurn();
    }

    public void endTurn() {
        System.out.println("Congratulations!! " + Winners.get(0).getName() + " finished first! with " + Winners.get(0).getScore() + " points.");
        System.out.print("Our winners are: ");
        for (Player win : Winners) {
            System.out.print(win.getName() + ", ");
        }

    }

    private void prepare(Player player) {
        viewCell();
        System.out.println("This is your hand! ");
        int finishPrep = 0;
        do {
            int chosenCard;
            do {
                player.seeCardOnHand();
                player.seeCardOnProgram();
                System.out.println("Your turtle is facing : " + player.getDirection());
                System.out.println("Please enter the order in which you want to execute your program!" + "" +
                        "\n" + " (1 : First card on hand, 2 : Second card, etc...)");
                chosenCard = sc.nextInt() - 1;
            } while (chosenCard < 0 || chosenCard >= player.getHandCards().size()); //on met ChosenCard parce que ça verifie qu'on demande une position qui existe
            player.addToProgram(player, player.getHandCards().get(chosenCard));  //fonction d'ajout de la carte au programme. F

            String choixContinue = "";

            do {
                System.out.println("Do you want to continue to add cards in your program? (Yes : Y; No : N)");
                choixContinue = sc.nextLine();
                choixContinue = choixContinue.toUpperCase(); //securité
            } while (!choixContinue.equals("Y") && !choixContinue.equals("N"));
            if (choixContinue.equals("N")) {
                finishPrep = 1;
            }
        } while (finishPrep == 0);
    }

    private ArrayList<Player> initOrder(ArrayList<Player> JoueurBis) {
        ArrayList<Player> SortedP = new ArrayList<Player>();
        int sizeListP = JoueurBis.size();
        while (SortedP.size() < sizeListP) {
            for (Player P : JoueurBis) {
                if (P.getPassageOrder() == SortedP.size()) {
                    SortedP.add(P);
                }
            }
        }
        return SortedP;
    }


    public void addPlayer(int P) {
        //F
        ArrayList<Integer> NbO = new ArrayList<Integer>();
        if (P == 2) { //cas pour 2 players
            Player P1 = new Player();
            Player P2 = new Player();
            Jewel J1 = new Jewel();
            J1.setPosition(3, 7);
            P1.Player1();
            P2.Player2();
            P1.initObstacle();
            P2.initObstacle();
            P1.setpositon(1, 0);
            P2.setpositon(5, 0);
            NbO.add(0);
            NbO.add(1);
            Collections.shuffle(NbO);
            P1.setPassageOrder(NbO.get(0));
            P2.setPassageOrder(NbO.get(1));
            this.Jewel.add(J1);
            this.Joueur.add(P1);
            this.Joueur.add(P2);
            Obstacles stoneWall = new Pierre();
            for (int i = 0; i < 8; i++) {
                setCell(stoneWall.getIcon(), 7, i);
            }
        } else if (P == 3) { //cas pour 3 players
            Player P1 = new Player();
            Player P2 = new Player();
            Player P3 = new Player();
            Jewel J1 = new Jewel();
            J1.setPosition(0, 7);
            Jewel J2 = new Jewel();
            J2.setPosition(3, 7);
            Jewel J3 = new Jewel();
            J3.setPosition(6, 7);
            P1.Player1();
            P2.Player2();
            P3.Player3();
            P1.initObstacle();
            P2.initObstacle();
            P3.initObstacle();
            P1.setpositon(0, 0);
            P2.setpositon(3, 0);
            P3.setpositon(6, 0);
            NbO.add(0);
            NbO.add(1);
            NbO.add(2);
            Collections.shuffle(NbO);
            P1.setPassageOrder(NbO.get(0));
            P2.setPassageOrder(NbO.get(1));
            P3.setPassageOrder(NbO.get(2));
            this.Jewel.add(J1);
            this.Jewel.add(J2);
            this.Jewel.add(J3);
            this.Joueur.add(P1);
            this.Joueur.add(P2);
            this.Joueur.add(P3);
            Obstacles stoneWall = new Pierre();
            for (int i = 0; i < 8; i++) {
                setCell(stoneWall.getIcon(), 7, i);
            }
        } else if (P == 4) { //cas pour 4 players
            Player P1 = new Player();
            Player P2 = new Player();
            Player P3 = new Player();
            Player P4 = new Player();
            Jewel J1 = new Jewel();
            J1.setPosition(1, 7);
            Jewel J2 = new Jewel();
            J2.setPosition(6, 7);
            P1.Player1();
            P2.Player2();
            P3.Player3();
            P4.Player4();
            P1.initObstacle();
            P2.initObstacle();
            P3.initObstacle();
            P4.initObstacle();
            P1.setpositon(0, 0);
            P2.setpositon(2, 0);
            P3.setpositon(5, 0);
            P4.setpositon(7, 0);
            NbO.add(0);
            NbO.add(1);
            NbO.add(2);
            NbO.add(3);
            Collections.shuffle(NbO);
            P1.setPassageOrder(NbO.get(0));
            P2.setPassageOrder(NbO.get(1));
            P3.setPassageOrder(NbO.get(2));
            P4.setPassageOrder(NbO.get(3));
            this.Jewel.add(J1);
            this.Jewel.add(J2);
            this.Joueur.add(P1);
            this.Joueur.add(P2);
            this.Joueur.add(P3);
            this.Joueur.add(P4);
        }
        this.cashPrize = P;
        sc.nextLine();
        for (Player elem : this.Joueur) {
            System.out.println("What is player " + elem.getName() + "'s name ?");
            String name = sc.nextLine();
            elem.setName(name);
        }
        setJoueur(initOrder(this.Joueur));
    }

    private void increaseVictoryV() {
        this.victoryV++;
    }

    public void decreaseCashPrize() {
        this.cashPrize--;
    }



    public void winners(Player p) {
        this.Winners.add(p);
        p.setUltimatum(victoryV);
        increaseVictoryV();
        //this.Joueur.remove(p);//pb
    }

    //VERIFICATIONS
    private void verif(Player P, Card card, int x2, int y2) {
        if (this.getCell(x2, y2).equals("     ") /*cas Rien*/ || this.getCell(x2, y2).equals((ConsoleColors.BLACK_UNDERLINED + "rock " + ConsoleColors.RESET)) /*cas Pierre*/) {

            System.out.println("Sorry! one of your actions is not possible!");

        } else if (this.getCell(x2, y2).equals(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "  *  " + ConsoleColors.RESET)) {
            //verifié si il y a une tortue et cas jewel
            if (this.getJoueur().size() == 2) { //cas ou 2 players
                P.setDirection(card.play(P.getDirection()));

            } else if (this.getJoueur().size() == 3) {
                if (P.getNb() == 1) {
                    P.setpositon(0, 0);
                } else if (P.getNb() == 2) {
                    P.setpositon(3, 0);
                } else if (P.getNb() == 3) {
                    P.setpositon(6, 0);
                }
            } else if (this.getJoueur().size() == 4) {
                if (P.getNb() == 1) {
                    P.setpositon(0, 0);
                } else if (P.getNb() == 2) {
                    P.setpositon(2, 0);
                } else if (P.getNb() == 3) {
                    P.setpositon(5, 0);
                } else if (P.getNb() == 4) {
                    P.setpositon(7, 0);
                }
            }
        } else if (this.getCell(x2, y2).equals("  P1 ") || this.getCell(x2, y2).equals("  P2 ") || this.getCell(x2, y2).equals("  P3 ") || this.getCell(x2, y2).equals("  P4 ")) {

            if (this.getJoueur().size() == 2) { //cas ou 2 players
//              String str = getCell(x2,y2);
//              int rang = getPlayer(str); rang equals to the players position in Joueur (List)
                this.getJoueur().get(getPlayer(getCell(x2, y2))).setDirection(card.play(P.getDirection())); //Pour code equivalent getPlayer(getCell(x2,y2)) ==> rang

            } else if (this.getJoueur().size() == 3) {

                if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 1) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(0, 0);

                } else if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 2) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(3, 0);

                } else if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 3) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(6, 0);

                }

            } else if (this.getJoueur().size() == 4) {

                if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 1) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(0, 0);

                } else if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 2) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(2, 0);

                } else if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 3) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(5, 0);

                } else if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 4) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(7, 0);

                }
            }

        } else if (this.getCell(x2, y2).equals(ConsoleColors.CYAN_BOLD + " ice " + ConsoleColors.RESET)) {
            removeCell(x2, y2);

        } else {
            System.out.println("Sorry,  your action is not possible !");
        }
    }

    private void verifBlue(Player P, Card card, int x2, int y2) {

        if (this.getCell(x2, y2).equals(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "  *  " + ConsoleColors.RESET)) {//we know that there will be a jewel in front
            P.setScore(this.cashPrize);
            winners(P);
            decreaseCashPrize();


        } else if (this.getCell(x2, y2).equals("  P1 ") || this.getCell(x2, y2).equals("  P2 ") || this.getCell(x2, y2).equals("  P3 ") || this.getCell(x2, y2).equals("  P4 ")) {
            if (this.getJoueur().size() == 2) { //cas ou 2 players
                if (P.getNb() == 1) {
                    P.setpositon(1, 0);
                } else if (P.getNb() == 2) {
                    P.setpositon(5, 0);
                }
                if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 1) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(1, 0);

                } else if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 2) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(5, 0);
                }

            } else if (this.getJoueur().size() == 3) {
                if (P.getNb() == 1) {
                    P.setpositon(0, 0);
                } else if (P.getNb() == 2) {
                    P.setpositon(3, 0);
                } else if (P.getNb() == 3) {
                    P.setpositon(6, 0);
                }
                if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 1) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(0, 0);

                } else if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 2) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(3, 0);

                } else if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 3) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(6, 0);

                }

            } else if (this.getJoueur().size() == 4) {
                if (P.getNb() == 1) {
                    P.setpositon(0, 0);
                } else if (P.getNb() == 2) {
                    P.setpositon(2, 0);
                } else if (P.getNb() == 3) {
                    P.setpositon(5, 0);
                } else if (P.getNb() == 4) {
                    P.setpositon(7, 0);
                }
                if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 1) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(0, 0);

                } else if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 2) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(2, 0);

                } else if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 3) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(5, 0);

                } else if (this.getJoueur().get(getPlayer(getCell(x2, y2))).getNb() == 4) {

                    this.getJoueur().get(getPlayer(getCell(x2, y2))).setpositon(7, 0);

                }

            }

        } else if (this.getCell(x2, y2).equals(ConsoleColors.BLACK_UNDERLINED + "rock " + ConsoleColors.RESET) || this.getCell(x2, y2).equals(ConsoleColors.CYAN_BOLD + " ice " + ConsoleColors.RESET)) {// rule in front of a wall
            P.setDirection(card.play(P.getDirection()));
        } else if (this.getCell(x2, y2).equals("     ")) {
            P.setpositon(x2, y2);
        }
    }

    //EXECUTE
    public void execute(Player P) { //on execute chauqe type de cartes
        for (Card card : P.getProgram()) { //F => getHandCards() : getProgram
            if (card.getCardName().equals(ConsoleColors.BLUE + "Blue Card" + ConsoleColors.RESET)) {
                int x = P.getX();
                int y = P.getY();
                removeCell(x, y);
                int[] newpos = card.playBlue(P.getDirection(), x, y);
                int x2 = newpos[0];
                int y2 = newpos[1];
                verifBlue(P, card, x2, y2);
            } else if (card.getCardName().equals(ConsoleColors.PURPLE + "Purple Card" + ConsoleColors.RESET) || card.getCardName().equals(ConsoleColors.YELLOW + "Yellow Card" + ConsoleColors.RESET)) {         //Change la direction du player
                String newdir = card.play(P.getDirection());
                P.setDirection(newdir);
            } else if (card.getCardName().equals(ConsoleColors.RED + "Laser Card" + ConsoleColors.RESET)) {
                int[] posLaser = card.playBlue(P.getDirection(), P.getX(), P.getY());
                int x2 = posLaser[0];
                int y2 = posLaser[1];
                verif(P, card, x2, y2);
            }
            P.addCardPicked(card);
        }
        P.getProgram().clear();
    }

    public void executeObstacles(Player P) {
        int pos;
        do {
            System.out.println("Please enter what obstacle you want");
            pos = sc.nextInt();
        } while (pos > P.getBlock().size());
        int[] position = P.getBlock().get(pos).play();
        if (!this.getCell(position[0], position[1]).equals("     ")) {
            System.out.println("This place is taken, please choose another");
            executeObstacles(P);
        } else {
            setCell(P.getBlock().get(pos).getIcon(), position[0], position[1]);
            P.getBlock().remove(pos);
        }
    }

    public void viewCell() { //F
        update();
        //echelle axe sur X
        System.out.print("    ");
        for (int i = 0; i < Cell.length; i++) {
            System.out.print("[ " + i + " ] ");
        }
        System.out.print('\n');

        for (int i = 0; i < Cell.length; i++) {
            System.out.print("[" + i + "]["); // on met l'echelle en Y
            for (String[] strings : Cell) {
                System.out.print(strings[i]);
                System.out.print(",");
            }
            System.out.println("]");
        }
    }

    private void update() { //F
        for (Player P : Joueur) {
            if(P.getUltimatum()==0) {
                setCell(P.getIcontest(), P.getX(), P.getY());
            }
        }
        for (Jewel jewel : Jewel) {
            setCell(jewel.getIcon(), jewel.getX(), jewel.getY());
        }
    }

    public void setCell(String icon, int x, int y) {
        Cell[x][y] = icon;
    }

    private void removeCell(int x, int y) {
        Cell[x][y] = "     ";
    }


    //GETTERS
    public int getPlayer(String str) {
        int i = 0;
        for (Player p : Joueur) {
            if (p.getIcontest().equals(str)) {
                i = Joueur.indexOf(p);
            }
        }
        return i;
    }

    public String getCell(int x, int y) {
        return Cell[x][y];
    }

    public ArrayList<Player> getJoueur() {
        return Joueur;
    }

    //SETTERS
    private void setJoueur(ArrayList<Player> joueur) {
        Joueur = joueur;
    }


}
