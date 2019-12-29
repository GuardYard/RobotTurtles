package game;

import cards.Card;
import cards.Deck;
import java.util.*;

import java.util.*;

public class Player {
    private String icontest = "";
    private String color = "";
    private int passageOrder;//Random order
    private String name = "";
    private String direction = "";
    private ArrayList<Card> handCards = new ArrayList<Card>();
    private ArrayList<Card> program = new ArrayList<Card>();
    private ArrayList<Card> cardPicked = new ArrayList<Card>();
    private ArrayList<Card> blockCardNumber = new ArrayList<Card>();
    private ArrayList<Card> block = new ArrayList<Card>();
    private int X;
    private int Y;


    public Deck deck = new Deck();

    //    block = {}
    public void Player1() {
        this.name = "Player 1";
        this.icontest = "  P1 ";
        this.color = "Red";
        this.direction = "South";
        this.deck.setDeck();

    }

    public void Player2() {
        this.name = "Player 2";
        this.icontest = "  P2  ";
        this.color = "Blue";
        this.direction = "South";
        this.deck.setDeck();
    }

    public void Player3() {
        this.name = "Player 3";
        this.icontest = "  P3  ";
        this.color = "Green";
        this.direction = "South";
        this.deck.setDeck();
    }

    public void Player4() {
        this.name = "Player 4";
        this.icontest = "  P4  ";
        this.color = "Pink";
        this.direction = "South";
        this.deck.setDeck();
    }

    public Deck getDeck() {
        return deck;
    }

    public void seeCardOnHand(){            //F
        System.out.print("[   ");
        for(Card card : handCards){
            System.out.print(card.getCardName());
        }
        System.out.println("   ]");
    }

    public void seeCardOnProgram(){            //F
        System.out.print("[   ");
        for(Card card : program){
            System.out.print(card.getCardName());
        }
        System.out.println("   ]");
    }

    public ArrayList<Card> getBlock() {     //F
        return block;
    }

    public ArrayList<Card> getHandCards() {         //F
        return handCards;
    }

    public void setpositon(int xtemp, int ytemp){       //F
        this.X = xtemp;
        this.Y = ytemp;
    }

    public int getX() {
        return X;
    }       //F

    public int getY() {
        return Y;
    }       //F

    public void setName(String name) {      //F
        this.name = name;
    }

    public void pickCardOnDeck() {      //F
        Card pioche = deck.draw();
        handCards.add(pioche);
    }

    public void verifHand(Player P){            //A vérifier- dp we need an else
        int f  = P.getHandCards().size();
        if (f<5){
            int nbPioche = 5-f;
            for(int i = 0; i<nbPioche; i++){
                P.pickCardOnDeck();
            }
        }
    }



    public void addToProgram(Player P, Card action) {  //PF- what order does the player want
        program.add(action);
        P.getHandCards().remove(action);
    }

    public void setBlock() {

    }
    public void setDirection(String direction) {        //F
        this.direction = direction;
    }

    public void setPassageOrder(int passageOrder) {
        this.passageOrder = passageOrder;
    }

    public String getName() {           //F
        return this.name;
    }

    public String getIcontest() {           //F
        return this.icontest;
    }
// no use-just for calling
    public ArrayList<Card> getProgram() {
        return program;
    }

    public String getColor() {
        return this.color;
    }

    public String getDirection() {
        return this.direction;
    }


    public int getPassageOrder() {
        return this.passageOrder;
    }
//end


    //    public int size() {
//        return 0;
//    }
//
//    public boolean isEmpty() {
//        return false;
//    }
//
//    public boolean contains(Object o) {
//        return false;
//    }
//
//    public Iterator<cards.Carte> iterator() {
//        return null;
//    }
//
//    public Object[] toArray() {
//        return new Object[0];
//    }
//
//    public <T> T[] toArray(T[] a) {
//        return null;
//    }
//
//    public boolean add(cards.Carte carte) {
//        return false;
//    }
//
//    public boolean remove(Object o) {
//        return false;
//    }
//
//    public boolean containsAll(Collection<?> c) {
//        return false;
//    }
//
//    public boolean addAll(Collection<? extends cards.Carte> c) {
//        return false;
//    }
//
//    public boolean addAll(int index, Collection<? extends cards.Carte> c) {
//        return false;
//    }
//
//    public boolean removeAll(Collection<?> c) {
//        return false;
//    }
//
//    public boolean retainAll(Collection<?> c) {
//        return false;
//    }
//
//    public void clear() {
//
//    }
//
//    public cards.Carte get(int index) {
//        return null;
//    }
//
//    public cards.Carte set(int index, cards.Carte element) {
//        return null;
//    }
//
//    public void add(int index, cards.Carte element) {
//
//    }
//
//    public cards.Carte remove(int index) {
//        return null;
//    }
//
//    public int indexOf(Object o) {
//        return 0;
//    }
//
//    public int lastIndexOf(Object o) {
//        return 0;
//    }
//
//    public ListIterator<cards.Carte> listIterator() {
//        return null;
//    }
//
//    public ListIterator<cards.Carte> listIterator(int index) {
//        return null;
//    }
//
//    public List<cards.Carte> subList(int fromIndex, int toIndex) {
//        return null;
//    }
}
