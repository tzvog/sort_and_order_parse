package filesprocessing.filters.permissions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * a class to decide if the file is Hidden
 */
public class HiddenFilter extends PermissionsFilter {

    /**
     * a filter to check if the file is hidden
     * @param indicator the indicator yes or no
     */
    public HiddenFilter(String indicator) throws IllegalArgumentException {
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

        // checks if we want it equaling that filter
        return Files.isHidden(entry) == this.isIndicator();
    }
}
