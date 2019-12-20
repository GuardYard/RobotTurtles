public class BlueCard extends Carte {
    public BlueCard(){
        this.Cardname="Blue Card";
        this.description="Permet d'avancer en avant d'une case !";
    }

    int[] play(String direction, int X, int Y) {
        if(Y!=0 && direction.equals("North")){
            Y=(Y-1);
        }
        else if(Y!=7 && direction.equals("South")){
            Y=(Y+1);
        }
        else if(X!=7 && direction.equals("East")){
            X=X+1;
        }
        else if(X !=0 && direction.equals("West")){
            X=X-1;
        }

        return new int[]{X,Y};

    }

    String play(String dir) {
        return null;
    }
}
