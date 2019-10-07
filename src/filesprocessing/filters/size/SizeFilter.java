package filesprocessing.filters.size;

import java.nio.file.DirectoryStream.*;
import java.nio.file.Path;

/**
 * an abstract class for a size filter
 */
public interface SizeFilter extends Filter<Path> {

    // the size to convert the files with
    Double BYTE_CONVERSION = 1024.0;
}
