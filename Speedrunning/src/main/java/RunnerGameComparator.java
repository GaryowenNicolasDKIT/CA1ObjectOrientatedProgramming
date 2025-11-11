import java.util.Comparator;

public class RunnerGameComparator implements Comparator<Runner> {
    public int compare(Runner r1, Runner r2)
    {
        if (r1.getGame().equals(r2.getGame())){
            return r1.getName().compareTo(r2.getName());
        }
        return r1.getGame().compareTo(r2.getGame());
    }
}