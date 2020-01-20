package cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private String description = "This is your deck";
    public ArrayList<Card> deck = new ArrayList<Card>(); //liste qui contient les cartes
    Card B = new BlueCard();
    Card P = new PurpleCard();
    Card Y = new YellowCard();
    Card L = new LaserCard();

    public void setDeck() {
        for(int i=0; i<18;i++){
            this.deck.add(B);
        }
        for(int i=0; i<8; i++) {
            this.deck.add(P);
        }
        for(int i=0; i<8; i++) {
            this.deck.add(Y);
        }
        for(int i=0; i<3; i++) {
            this.deck.add(L);
        }
        Collections.shuffle(this.deck); //Qpourqoui on fait un shuffle 3 fois?
        Collections.shuffle(this.deck);
        Collections.shuffle(this.deck);
    }

    public String getDescription(){
        return this.description;
    }       //F

    public void showDeck(){         //F
        System.out.print("[   ");
        for (Card card : deck) {
            System.out.print(card.getCardName());
            System.out.println(", ");
        }
        System.out.println("   ]");
    }

    public Card draw(){         //F
        Card pioche = deck.get(0);
        deck.remove(0);
        System.out.println("You picked a " + pioche.getCardName());
        return pioche;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
}
