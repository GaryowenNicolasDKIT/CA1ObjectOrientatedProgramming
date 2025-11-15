import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Runner {
    private String Name;
    private String Game;
    private int Runs_Amount;
    private double Community_Rating;
    private boolean Has_World_Record;
    private LocalDate Join_Date;
    private LocalDateTime LastSubmission;


    public Runner(String name, String game, int runs_Amount, double community_Rating, boolean has_world_Record, LocalDate join_date, LocalDateTime last_submission) {
        Name = name;
        Game = game;
        Runs_Amount = runs_Amount;
        Community_Rating = community_Rating;
        Has_World_Record = has_world_Record;
        Join_Date = join_date;
        LastSubmission = last_submission;
    }

    public Runner(String name, String game, int runs_Amount, double community_Rating, boolean has_world_Record) {
        Name = name;
        Game = game;
        Runs_Amount = runs_Amount;
        Community_Rating = community_Rating;
        Has_World_Record = has_world_Record;
        Join_Date = LocalDate.now();
        LastSubmission = LocalDateTime.now();
    }

    public Runner(String name, String game) {
        Name = name;
        Game = game;
        Runs_Amount = 0;
        Community_Rating = 0;
        Has_World_Record = false;
        Join_Date = LocalDate.now();
        LastSubmission = LocalDateTime.now();
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


    public int getRuns_Amount() {
        return Runs_Amount;
    }

    public void setRuns_Amount(int runs_Amount) {
        Runs_Amount = runs_Amount;
    }


    public double getCommunity_Rating() {
        return Community_Rating;
    }

    public void setCommunity_Rating(double community_Rating) {
        Community_Rating = community_Rating;
    }


    public boolean getHas_World_Record() {
        return Has_World_Record;
    }

    public void setHas_World_Record(boolean has_World_Record) {
        Has_World_Record = has_World_Record;
    }


    public LocalDate getJoinDate() {
        return Join_Date;
    }

    public void setJoinDate(LocalDate joinDate) {
        Join_Date = joinDate;
    }

    public LocalDateTime getLastSubmission() { return LastSubmission; }

    public void setLastSubmission(LocalDateTime lastSubmission) { LastSubmission = lastSubmission; }

    @Override
    public String toString() {
        return "\n============\nName: " + this.Name + "\nGame: " + this.Game + "\nRuns Amount: "
                + this.Runs_Amount + "\nCommunity Rating: " + this.Community_Rating
                + "\nHas World Record: " + this.Has_World_Record + "\nJoin Date: " + this.Join_Date
                + "\nLast Submission: " + this.LastSubmission + "\n============";
    }

    public String toStringForList(String delimiter) {
        return this.Name + delimiter + this.Game + delimiter + this.Runs_Amount + delimiter
                + this.Community_Rating +  delimiter + this.Has_World_Record + delimiter + this.Join_Date + delimiter + this.LastSubmission;
    }

    public boolean equals(Runner otherObject){
        if(otherObject == null){ return false;}
        else if(getClass() != otherObject.getClass()){ return false;}
        Runner other = (Runner) otherObject;

        return Name.equals(other.Name)
                && Runs_Amount == other.Runs_Amount
                && Community_Rating == other.Community_Rating
                && Join_Date.equals(other.Join_Date);
    }

    public double RatingChange (double change){
        this.Community_Rating = this.Community_Rating + change;
        return this.Community_Rating;
    }

    public int RunChange (int change, String WR){
        this.Runs_Amount = this.Runs_Amount + change;
        if(WR.equalsIgnoreCase("yes") || WR.equalsIgnoreCase("y")){
            this.Has_World_Record = true;
        }
        return this.Runs_Amount;
    }

    /*public int DisplayByName(String name, String ChosenName){
        if(name.equals(ChosenName)){
            return 1;
        }
        else{
            return 0;
        }
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(Name, Game, Runs_Amount, Community_Rating, Has_World_Record, Join_Date, LastSubmission);
    }
}
