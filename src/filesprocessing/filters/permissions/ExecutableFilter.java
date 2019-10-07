package filesprocessing.filters.permissions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * a class to decide if the file is executable
 */
public class ExecutableFilter extends PermissionsFilter {

    /**
     * checks if the file is executable like we want it
     * @param indicator if its a yes or no
     * @throws IllegalArgumentException we did not receive a yes or no
     */
    public ExecutableFilter(String indicator) throws IllegalArgumentException {
        super(indicator);
    }

    /**
     * Decides if the given directory entry should be accepted or filtered.
     *
     * @param entry the directory entry to be tested
     * @return {@code true} if the directory entry should be accepted
     * @throws IOException If an I/O error occurs
     */
    @Override
    public boolean accept(Path entry) throws IOException {
        return Files.isExecutable(entry) == this.isIndicator();
    }
}
