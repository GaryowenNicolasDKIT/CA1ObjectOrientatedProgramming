import java.util.Comparator;

public class RunnerJoinComparator implements Comparator<Runner>{
    public int compare(Runner r1, Runner r2) {
        if (r1.getJoinDate().equals(r2.getJoinDate()))
            return r1.getName().compareTo(r2.getName());
        else {
            return r1.getJoinDate().compareTo(r2.getJoinDate());
        }
    }
}