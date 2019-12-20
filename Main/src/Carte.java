abstract class Carte {
    protected String description;
    protected String Cardname;

    protected String getName() {
        return this.Cardname;
    }

    protected String getCardname(){
        return this.Cardname;
    }

    protected String getDescription() {
        return this.description;
    }

    abstract int[] play(String direction, int X, int Y);

    abstract String play(String dir);
}