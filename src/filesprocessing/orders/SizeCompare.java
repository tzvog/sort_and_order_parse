package filesprocessing.orders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

/**
 * compares by size
 */
public class SizeCompare implements Comparator<Path> {

    /**
     * finds who should come before who
     * @param first the first path
     * @param second the second path
     * @return who should go first
     */
    @Override
    public int compare(Path first, Path second){

        // checks size of the files
        try {
            if(Files.size(first) > Files.size(second)){

                return 1;
            }
            else if(Files.size(first) < Files.size(second)){
                return -1;
            }
        }
        catch (IOException ex){}

        return new AbsCompare().compare(first, second);
    }
}
