package filesprocessing.orders;
import java.nio.file.Path;
import java.util.Comparator;

/**
 * the comparator for abs
 */
public class AbsCompare implements Comparator<Path> {

    /**
     * finds who should come before who
     * @param first the first path
     * @param second the second path
     * @return who should go first
     */
    @Override
    public int compare(Path first, Path second) {

        // compares absolute paths
        return first.toString().compareTo(second.toString());
    }
}
