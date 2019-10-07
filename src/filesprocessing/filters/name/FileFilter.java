package filesprocessing.filters.name;

import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Matcher;


/**
 * a class of the filter to compare with
 */
public class FileFilter extends NameFilter{

    /**
     * a constructor for the file to compare to
     * @param compareTo the value to compare to
     */
    public FileFilter(String compareTo) {
        super(compareTo);
    }

    /**
     * Decides if the given directory entry should be accepted or filtered.
     * @param entry the directory entry to be tested
     * @return {@code true} if the directory entry should be accepted
     * @throws IOException If an I/O error occurs
     */
    @Override
    public boolean accept(Path entry) throws IOException {

        return entry.getFileName().toString().matches(this.getCompareTo());
    }
}
