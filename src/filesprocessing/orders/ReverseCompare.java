package filesprocessing.orders;

import java.nio.file.Path;
import java.util.Comparator;

/**
 * a comparator to revers a function
 */
public class ReverseCompare implements Comparator<Path> {

    private Comparator<Path> compare;

    /**
     * a constructor for the reverse comparator
     * @param comparator the comparator we want to reverse
     */
    public ReverseCompare(Comparator<Path> comparator) {

        this.compare = comparator;
    }

    /**
     * finds who should come before who
     * @param first the first path
     * @param second the second path
     * @return who should go first
     */
    @Override
    public int compare(Path first, Path second) {

        // returns it backwards
        return this.compare.compare(first, second) * -1;
    }
}
