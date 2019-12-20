public class LaserCard extends Carte {
    public LaserCard(){
        this.Cardname="Laser Card";
        this.description="Détruit l'obstacle devant le joueur";
    }

    int[] play(String direction, int X, int Y) {
        return new int[0];
    }

    String play(String dir) {
        return null;
    }
}
