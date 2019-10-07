package filesprocessing.filters;

import java.io.IOException;
import java.nio.file.DirectoryStream.*;
import java.nio.file.Path;

/**
 * a filter to do the opposite of the received filter
 */
public class NotFilter implements Filter<Path>{

    private Filter<Path>  filterToReverse;

    /**
     * an opposite filter
     * @param filter the filter to reverse
     */
    public NotFilter(Filter<Path> filter) {
        this.filterToReverse = filter;
    }

    /**
     * Decides if the given directory entry should be accepted or filtered.
     * @param entry the directory entry to be tested
     * @return {@code true} if the directory entry should be accepted
     * @throws IOException If an I/O error occurs
     */
    public boolean accept(Path entry) throws IOException {

        return !filterToReverse.accept(entry);
    }
}
