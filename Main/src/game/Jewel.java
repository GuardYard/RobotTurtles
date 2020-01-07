package game;

public class Jewel {

    String name = "J";
    String icon = "  *  ";
    int X;
    int Y;

    public String getIcon() {
        return icon;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setPosition(int x , int y){
        this.X = x;
        this.Y = y;

    }

    //set X
    //set Y
    //get icon (return)
}
