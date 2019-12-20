public class YellowCard extends Carte {
    public YellowCard(){
        this.Cardname="Yellow Card";
        this.description="Permet de tourner à gauche (l'action d'avancer n'est pas comprise avec cette carte)";
    }


    int[] play(String direction, int X, int Y) {
        return new int[0];
    }

    String play(String dir) {
        String direction = "";
        if(dir.equals("North")){
            direction = "West";
        }
        else if(dir.equals("West")){
            direction = "South";
        }
        else if(dir.equals("South")){
            direction = "East";
        }
        else if(dir.equals("East")){
            direction = "North";
        }
        return direction;
    }
}
