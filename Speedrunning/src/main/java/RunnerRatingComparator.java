import java.util.Comparator;

public class RunnerRatingComparator implements Comparator<Runner>{
    public int compare(Runner r1, Runner r2) {
        if (r1.getCommunity_Rating() == r2.getCommunity_Rating())
            return r1.getName().compareTo(r2.getName());
        else {
            return Double.compare(r1.getCommunity_Rating(), r2.getCommunity_Rating());
        }
    }
}