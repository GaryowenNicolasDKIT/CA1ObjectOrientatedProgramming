public class Runner {
    private String Name;
    private String Game;
    private int Runs_Ammount;
    private double Community_Rating;
    private boolean Recrod_or_Not;
    //private LocalDate Join_Date;
    //private LocalDateTime LastSubbimission;


    public Runner(String name, String game, int runs_Ammount, double community_Rating, boolean recrod_or_Not) {
        Name = name;
        Game = game;
        Runs_Ammount = runs_Ammount;
        Community_Rating = community_Rating;
        Recrod_or_Not = recrod_or_Not;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGame() {
        return Game;
    }

    public void setGame(String game) {
        Game = game;
    }

    public int getRuns_Ammount() {
        return Runs_Ammount;
    }

    public void setRuns_Ammount(int runs_Ammount) {
        Runs_Ammount = runs_Ammount;
    }

    public double getCommunity_Rating() {
        return Community_Rating;
    }

    public void setCommunity_Rating(double community_Rating) {
        Community_Rating = community_Rating;
    }

    public boolean isRecrod_or_Not() {
        return Recrod_or_Not;
    }

    public void setRecrod_or_Not(boolean recrod_or_Not) {
        Recrod_or_Not = recrod_or_Not;
    }
}
