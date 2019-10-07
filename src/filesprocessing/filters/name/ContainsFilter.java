package filesprocessing.filters.name;

import java.io.IOException;
import java.nio.file.Path;

/**
 * a class to filter if it contains it
 */
public class ContainsFilter extends NameFilter {

    /**
     * a constructor for the class
     * @param comparisonString the string to compare to
     */
    public ContainsFilter(String comparisonString) {
        super(comparisonString);
    }

    /**
     * Decides if the given directory entry should be accepted or filtered.
     * @param entry the directory entry to be tested
     * @return {@code true} if the directory entry should be accepted
     * @throws IOException If an I/O error occurs
     */
    @Override
    public boolean accept(Path entry) throws IOException {
        return entry.getFileName().toString().contains(this.getCompareTo());
    }
}
