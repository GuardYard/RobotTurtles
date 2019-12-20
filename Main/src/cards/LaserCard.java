package cards;

public class LaserCard extends Card {           //F
    public LaserCard(){
        this.cardName ="Laser Card";
        this.description="Détruit l'obstacle devant le joueur";
    }

    public int[] playBlue(String direction, int X, int Y) {
        return new int[0];
    }

    public String play(String dir) {
        return null;
    }
}
