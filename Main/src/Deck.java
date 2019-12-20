import java.util.*;

public class Deck {
    private String description = "Ceci est votre deck";
    public ArrayList<Carte> deck = new ArrayList<Carte>();
    Carte B1 = new BlueCard();
    Carte P1 = new PurpleCard();
    Carte B2 = new BlueCard();

    public void setDeck() {
        this.deck.add(B1);
        this.deck.add(P1);
        this.deck.add(B2);
    }

    public String getDescription(){
        return this.description;
    }

    public void showDeck(){
        for (Carte cartes : deck) {
            System.out.print("[");
            System.out.print(cartes.getName());
            System.out.print(", ");
        }
    }

    public Carte draw(){
        Carte pioche = deck.get(0);
        deck.remove(0);
        System.out.println("Vous avez pioché une " + pioche.Cardname);
        return pioche;
    }


}
