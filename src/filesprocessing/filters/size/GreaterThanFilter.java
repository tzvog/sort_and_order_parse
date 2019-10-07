package filesprocessing.filters.size;

import filesprocessing.toolboxes.TypeOneErrorToolBox;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * a filter to be greater then a certain number
 */
public class GreaterThanFilter implements SizeFilter {

    private Double minAsDouble;

    /**
     * a filter that we must be greater than
     * @param number the number to be larger than it
     * @throws NumberFormatException we couldn't convert the number to a number to work with
     */
    public GreaterThanFilter(String number) throws NumberFormatException {
        this.minAsDouble = TypeOneErrorToolBox.convertValueToDouble(number) * SizeFilter.BYTE_CONVERSION;
    }

    /**
     * Decides if the given directory entry should be accepted or filtered.
     * @param entry the directory entry to be tested
     * @return {@code true} if the directory entry should be accepted
     * @throws IOException If an I/O error occurs
     */
    @Override
    public boolean accept(Path entry) throws IOException, NumberFormatException {

        // checks if we are on range of size
        return Files.size(entry) > this.minAsDouble;
    }
}
