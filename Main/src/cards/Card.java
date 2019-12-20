package cards;

public abstract class Card {
    String description;
    String cardName;

    public String getCardName(){
        return this.cardName;
    }

    public abstract int[] playBlue(String direction, int X, int Y);

    public abstract String play(String dir);
}