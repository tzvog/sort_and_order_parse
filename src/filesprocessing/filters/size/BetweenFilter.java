package filesprocessing.filters.size;

import filesprocessing.toolboxes.TypeOneErrorToolBox;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * a class to implement the filter of between
 */
public class BetweenFilter implements SizeFilter {

    private double maxAsDouble;
    private double minAsDouble;

    /**
     * a constructor for the between class
     * @param max the max value for the value
     * @param min min a min value for the value
     * @throws NumberFormatException we could not convert the String Format
     */
    public BetweenFilter(String max, String min) throws NumberFormatException {
        this.minAsDouble = TypeOneErrorToolBox.convertValueToDouble(min) * SizeFilter.BYTE_CONVERSION;
        this.maxAsDouble = TypeOneErrorToolBox.convertValueToDouble(max) * SizeFilter.BYTE_CONVERSION;

        if(this.minAsDouble > this.maxAsDouble){
            throw new NumberFormatException();
        }
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
        return Files.size(entry) >= this.minAsDouble && Files.size(entry) <= this.maxAsDouble;
    }
}
