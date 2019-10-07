package filesprocessing.filters.permissions;

import filesprocessing.toolboxes.TypeOneErrorToolBox;

import java.nio.file.DirectoryStream.*;
import java.nio.file.Path;

/**
 * an abstract class to make all permissions class easier to deal with
 */
public abstract class PermissionsFilter implements Filter<Path> {

    private boolean indicator;

    /**
     * a constructor for a permissions filter
     * @param indicator the indicator to test if we want it or not
     */
    public PermissionsFilter(String indicator) throws IllegalArgumentException {
        this.indicator = TypeOneErrorToolBox.convertValueToYesOrNo(indicator);
    }

    /**
     * a getter to retrieve our indicator
     * @return our indicator boolean value
     */
    public boolean isIndicator() {
        return indicator;
    }
}
