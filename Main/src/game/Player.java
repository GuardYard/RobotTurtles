package game;

import cards.Card;
import cards.Deck;

import java.util.*;

public class Player {
    private String icontest = "";
    private String color = "";
    private int passageOrder;
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
        this.icontest = "  P1  ";
        this.color = "Red";
        this.passageOrder = 0;
        this.direction = "South";
        this.deck.setDeck();

    }

    public void Player2() {
        this.icontest = "  P2  ";
        this.color = "Blue";
        this.passageOrder = 0;
        this.direction = "North";
        this.deck.setDeck();

    }

    public void seeCardOnHand(){
        for(Card card : handCards){
            System.out.print("[   ");
            System.out.print(card.getCardName());
            System.out.println("   ]");
        }
    }

    public ArrayList<Card> getBlock() {
        return block;
    }

    public ArrayList<Card> getHandCards() {
        return handCards;
    }

    public void setpositon(int xtemp, int ytemp){
        this.X = xtemp;
        this.Y = ytemp;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void pickCardOnDeck() {
        Card pioche = deck.draw();
        handCards.add(pioche);
    }

    public void verifHand(Player P){
        int f  = P.getHandCards().size();
        if (f<5){
            int nbPioche = 5-f;
            for(int i = 0; i<nbPioche; i++){
                P.pickCardOnDeck();
            }
        }
    }



    public void addToProgram(Player P, Card action) {
        program.add(action);
        P.getHandCards().remove(action);
    }

    public void setBlock() {

    }

    public String getName() {
        return this.name;
    }

    public String getIcontest() {
        return this.icontest;
    }

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

    public void setDirection(String direction) {
        this.direction = direction;
    }

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
