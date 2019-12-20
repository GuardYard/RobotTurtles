package cards;

public class PurpleCard extends Card {
    public PurpleCard(){
        this.cardName ="Purple Card";
        this.description="Permet de tourner à droite (l'action d'avancer n'est pas comprise avec cette carte)";
    }


    public int[] play(String direction, int X, int Y) {
        return new int[0];
    }

    public String play(String dir) {
        String direction = "";
        if(dir.equals("North")){
            direction = "East";
        }
        else if(dir.equals("West")){
            direction = "North";
        }
        else if(dir.equals("South")){
            direction = "West";
        }
        else if(dir.equals("East")){
            direction = "South";
        }
        return direction;
    }
}
