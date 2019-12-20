package cards;

import cards.BlueCard;
import cards.Card;
import cards.PurpleCard;

import java.util.*;

public class Deck {
    private String description = "Ceci est votre deck";
    public ArrayList<Card> deck = new ArrayList<Card>();
    Card B1 = new BlueCard();
    Card P1 = new YellowCard();
    Card B2 = new BlueCard();

    public void setDeck() {
        this.deck.add(B1);
        this.deck.add(P1);
        this.deck.add(B2);
    }

    public String getDescription(){
        return this.description;
    }       //F

    public void showDeck(){         //F
        for (Card card : deck) {
            System.out.print("[");
            System.out.print(card.getCardName());
            System.out.print(", ");
        }
    }

    public Card draw(){         //A refaire
        Card pioche = deck.get(0);
        deck.remove(0);
        System.out.println("Vous avez pioché une " + pioche.getCardName());
        return pioche;
    }


}
