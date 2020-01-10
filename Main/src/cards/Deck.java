package cards;

import cards.BlueCard;
import cards.Card;
import cards.PurpleCard;

import java.util.*;

public class Deck {
    private String description = "Ceci est votre deck";
    public ArrayList<Card> deck = new ArrayList<Card>();
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
        Collections.shuffle(this.deck);
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
        System.out.println("Vous avez pioché une " + pioche.getCardName());
        return pioche;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
}
