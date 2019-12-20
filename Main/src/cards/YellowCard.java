package cards;

public class YellowCard extends Card {

    //test
    public YellowCard() {
        this.cardName = "Yellow Card";
        this.description = "Permet de tourner à gauche (l'action d'avancer n'est pas comprise avec cette carte)";
    }


    public int[] play(String direction, int X, int Y) {
        return new int[0];
    }

    public String play(String dir) {
        String direction = "";
        if (dir.equals("North")) {
            direction = "West";
        } else if (dir.equals("West")) {
            direction = "South";
        } else if (dir.equals("South")) {
            direction = "East";
        } else if (dir.equals("East")) {
            direction = "North";
        }
        return direction;
    }
}
