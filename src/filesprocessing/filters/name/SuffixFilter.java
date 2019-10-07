package filesprocessing.filters.name;

import java.io.IOException;
import java.nio.file.Path;

/**
 * checks if its in the suffix
 */
public class SuffixFilter extends NameFilter {

    /**
     * the constructor to work with
     * @param comparisonString the string we want to compare
     */
    public SuffixFilter(String comparisonString) {
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
        return entry.getFileName().toString().endsWith(this.getCompareTo());
    }
}
