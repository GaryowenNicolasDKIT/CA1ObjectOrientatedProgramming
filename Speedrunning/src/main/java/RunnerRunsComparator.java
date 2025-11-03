import java.util.Comparator;

public class RunnerRunsComparator implements Comparator<Runner>{
    public int compare(Runner r1, Runner r2) {
        if (r1.getRuns_Amount() == r2.getRuns_Amount())
            return r1.getName().compareTo(r2.getName());
        else {
            return Integer.compare(r1.getRuns_Amount(), r2.getRuns_Amount());
        }
    }
}