package filesprocessing.filters.size;

import filesprocessing.toolboxes.TypeOneErrorToolBox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * a class to generate a less than filter
 */
public class SmallerThanFilter implements SizeFilter{

    private Double maxAsDouble;

    /**
     * a filter we want to be less than it
     * @param number the number we want to be less than
     */
    public SmallerThanFilter(String number) throws NumberFormatException{
        this.maxAsDouble = TypeOneErrorToolBox.convertValueToDouble(number) * SizeFilter.BYTE_CONVERSION;
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
        return Files.size(entry) < this.maxAsDouble;
    }
}
