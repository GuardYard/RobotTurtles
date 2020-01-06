//needs work, based off Card.java


//interdit de bloquer l’accès aux joyaux & d’encercler un joyau ou un autre joueur
package cards;

public abstract class Obstacles {
    String description;
    String cardName;
    String destructible;

    public String getCardName(){
        return this.cardName;
    }

    public abstract int[] play();

}