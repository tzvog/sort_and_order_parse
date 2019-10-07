package filesprocessing.orders;

import java.nio.file.Path;
import java.util.Comparator;

/**
 * compares file by the extension
 */
public class TypeCompare implements Comparator<Path> {

    /**
     * finds who should come before who
     * @param first the first path
     * @param second the second path
     * @return who should go first
     */
    @Override
    public int compare(Path first, Path second) {

        // breaks the down the extensions to the last part of the file
        String firstFileName = first.getFileName().toString();
        String secondFileName = second.getFileName().toString();
        String firstExtension = firstFileName.substring(firstFileName.lastIndexOf(".") + 1);
        String secondExtension = secondFileName.substring(secondFileName.lastIndexOf(".") + 1);

        // gets what there are compared to
        int compareTo = firstExtension.compareTo(secondExtension);

        // if they are equal
        if(compareTo == 0){
            return new AbsCompare().compare(first, second);
        }

        return compareTo;
    }
}
