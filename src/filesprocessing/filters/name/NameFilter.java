package filesprocessing.filters.name;

import java.nio.file.DirectoryStream.*;
import java.nio.file.Path;

/**
 * a class for all the File name compare items
 */
public abstract class NameFilter implements Filter<Path> {

    private String compareTo;

    /**
     * the constructor
     * @param comparisonString what string to compare to
     */
    public NameFilter(String comparisonString) {
        this.compareTo = comparisonString;
    }

    /**
     * gets the string to compare to
     * @return the string to compare to
     */
    public String getCompareTo() {
        return compareTo;
    }
}
