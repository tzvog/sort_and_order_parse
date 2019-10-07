package filesprocessing.filters;
import java.io.IOException;
import java.nio.file.DirectoryStream.*;
import java.nio.file.Path;

public class AllFilter implements Filter<Path> {

    /**
     * Decides if the given directory entry should be accepted or filtered.
     * @param entry the directory entry to be tested
     * @return {@code true} if the directory entry should be accepted
     * @throws IOException If an I/O error occurs
     */
    @Override
    public boolean accept(Path entry) throws IOException {
        return true;
    }


}
