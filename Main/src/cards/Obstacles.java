//needs work, based off Card.java


//interdit de bloquer l’accès aux joyaux & d’encercler un joyau ou un autre joueur
package cards;

public abstract class Obstacles {
    String description;
    String cardName;

    public String getCardName(){
        return this.cardName;
    }

    public abstract int[] playCard(int X, int Y);

}