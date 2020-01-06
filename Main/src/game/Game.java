package game;

import cards.Card;
import cards.Obstacles;

import java.util.*;

public class Game {
    public Scanner sc = new Scanner(System.in);

    private ArrayList<Player> Joueur = new ArrayList<Player>();
    private String[][] Cell = {{"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}, {"     ", "     ", "     ", "     ", "     ", "     ", "     ", "     "}};
    private int victoryV;
    private int nbTurn;

    public String[][] getCell() {
        return Cell;
    }


    public void init(){
        int nbJoueur;
        //Fonction de rappel les règles d'un jeu.
        do {
            System.out.println("Combien de joueur? (2, 3 ou 4)");
            nbJoueur = sc.nextInt();
        } while(nbJoueur != 2 && nbJoueur != 3 && nbJoueur != 4);
        addPlayer(nbJoueur);
        viewCell();
    }

    public void turn(){
        do {
            for (Player player : this.Joueur) {


                //faire ici une fonction qui verifie le nombre de cartes dans la main du joueur
                //si la main n'a pas 5 cartes faire piocher


                int commande = 0;
                do {
                    System.out.println("C'est au tour de " + player.getName() + ". Veuillez choisir une action à effectuer.");
                    System.out.println("Préparer vos déplacements   :   1");
                    System.out.println("Executer                    :   2");
                    System.out.println("Poser des obstacles         :   3");
                    commande = sc.nextInt();
                } while (commande != 1 && commande != 2 && commande != 3);
                if(commande == 1){
                    prepare(player);
                    //Fonction de préparation de la liste "programme" : Demande d'un ordre au joueur par rapport à sa main et demande un
                }
                else if(commande == 2){
                    execute(player);
                    viewCell();
                    //Fonction qui vérifie la victoire et change la valeur de victoryV (victoryV = 1 ===> Victoire)
                }
                else if(commande == 3){
                    //Fonction pour afficher les obstacles dont on dispose
                    //player.getBlock().get(0).play();
                    int [] position = player.getBlock().get(0).play();
                    System.out.println(position[0]);
                    System.out.println(position[1]);
                    setCell(player.getBlock().get(0).getIcon(), position[0], position[1]);
                    //Fonction pour poser des obstacles
                    //Montre le nouveau plateau :
                    viewCell();
                }
            }
        }while(victoryV == 0);
    }

    private void prepare(Player player) {
        System.out.println("Voici votre jeu !");
        player.seeCardOnHand();
        int finishPrep = 0;
            do{
                int chosenCard;
                do {
                    player.seeCardOnHand();
                    System.out.println("Choisissez l'ordre dans lequel vous voulez executer votre programme (1 : Premier carte de votre main, 2 : Deuxieme carte, etc...)");
                    chosenCard = sc.nextInt();
                    //fonction d'ajout de la carte au programme.
                }while (chosenCard >= 0 && chosenCard <= player.getHandCards().size());
                String choixContinue ="";
                do {
                    System.out.println("Voulez-vous continuer a mettre des cartes dans votre programme? (Oui : O; Non : N)");
                    choixContinue = sc.nextLine();
                }while (!choixContinue.equals("O") && !choixContinue.equals("N"));
            }while(finishPrep == 0);
    }

    private ArrayList<Player> initOrder(ArrayList<Player> JoueurBis){
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
                System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public void addPlayer(int P){
        //F
        ArrayList<Integer> NbO = new ArrayList<Integer>();
        if(P == 2) {
            Player P1 = new Player();
            Player P2 = new Player();
            Jewel J1 = new Jewel();
//            J1.setX(3);
//            J1.setY(7);
//            this.setCell(J1.getIcon(), J1.getX(),J1.getY());
            P1.Player1();
            P2.Player2();
            P1.initObstacle();
            P2.initObstacle();
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
        sc.nextLine();
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

    public void executeObstacles(Player P){
        for (Obstacles card : P.getBlock()){
            int [] position = card.play();
            setCell(card.getIcon(), position[0], position[1]);
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