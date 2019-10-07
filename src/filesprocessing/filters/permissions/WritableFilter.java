package filesprocessing.filters.permissions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * checks if the file is writable
 */
public class WritableFilter extends PermissionsFilter {

    /**
     * gets the indicator we want
     * @param indicator yes or no if we want it to be writable
     */
    public WritableFilter(String indicator) throws IllegalArgumentException {
        super(indicator);
    }

    /**
     * Decides if the given directory entry should be accepted or filtered.
     * @param entry the directory entry to be tested
     * @return {@code true} if the directory entry should be accepted
     * @throws IOException If an I/O error occurs
     */
    @Override
    public boolean accept(Path entry) throws IOException {

        // checks if we want that permission type
        return Files.isWritable(entry) == this.isIndicator();
    }
}
