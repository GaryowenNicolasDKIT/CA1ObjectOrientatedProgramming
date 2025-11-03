import java.util.Comparator;

public class RunnerNameComparator implements Comparator<Runner>{
    public int compare(Runner r1, Runner r2)
    {
        return r1.getName().compareTo(r2.getName());
    }
}