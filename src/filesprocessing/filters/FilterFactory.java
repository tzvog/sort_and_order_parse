package filesprocessing.filters;
import filesprocessing.SubSectionHolder;
import filesprocessing.exceptions.typeone.TypeOneException;
import filesprocessing.filters.name.ContainsFilter;
import filesprocessing.filters.name.FileFilter;
import filesprocessing.filters.name.PrefixFilter;
import filesprocessing.filters.name.SuffixFilter;
import filesprocessing.filters.size.BetweenFilter;
import filesprocessing.filters.size.GreaterThanFilter;
import filesprocessing.filters.size.SmallerThanFilter;
import filesprocessing.filters.permissions.ExecutableFilter;
import filesprocessing.filters.permissions.HiddenFilter;
import filesprocessing.filters.permissions.WritableFilter;

import java.nio.file.DirectoryStream.*;
import java.nio.file.Path;

/**
 * a class to work as a factory for filters
 */
public class FilterFactory {

    private static FilterFactory filterFactory = new FilterFactory();

    /**
     * makes the class constructor private
     */
    private FilterFactory(){}

    /**
     * making this factory a singleton
     * @return the instance of the factory
     */
    public static FilterFactory getInstance(){
        return filterFactory;
    }


    /**
     * gets a filter from the subsection
     * @param subSection the name of the subsection we are analyzing
     * @return the filter type we need
     * @throws TypeOneException what happens when we dont get a good filter
     */
    public static Filter<Path> getFilter(SubSectionHolder subSection) throws TypeOneException {

        // checks that we have enough arguments
        if(!subSection.isFilterEnoughArguments()){
            throw new TypeOneException(subSection.getFilterLine());
        }

        try {
            // returns the type of of filter we need fot the
            switch (subSection.getFilterText()[0]){
                case "greater_than": {
                    return new GreaterThanFilter(subSection.getFilterText()[1]);
                }
                case "between": {
                    return new BetweenFilter(subSection.getFilterText()[2],
                            subSection.getFilterText()[1]);
                }
                case "smaller_than": {
                    return new SmallerThanFilter(subSection.getFilterText()[1]);
                }
                case "file": {
                    return new FileFilter(subSection.getFilterText()[1]);
                }
                case "contains": {
                    return new ContainsFilter(subSection.getFilterText()[1]);
                }
                case "prefix": {
                    return new PrefixFilter(subSection.getFilterText()[1]);
                }
                case "suffix": {
                    return new SuffixFilter(subSection.getFilterText()[1]);
                }
                case "writable": {
                    return new WritableFilter(subSection.getFilterText()[1]);
                }
                case "executable": {
                    return new ExecutableFilter(subSection.getFilterText()[1]);
                }
                case "hidden": {
                    return new HiddenFilter(subSection.getFilterText()[1]);
                }
                case "all": {
                    return new AllFilter();
                }
                default: {
                    throw new TypeOneException(subSection.getFilterLine());
                }
            }
        }
        catch (Exception ex){
            throw new TypeOneException(subSection.getFilterLine());
        }

    }

    /**
     * a default filter to be used
     * @return the default filter
     */
    public static Filter<Path> getDefaultFilter(){
        return new AllFilter();
    }

    /**
     * reverses a filter for us
     * @param filterToReverse the filter to reverse
     * @return the filter reversed
     */
    public static Filter<Path> reverseFilter(Filter<Path> filterToReverse){
        return new NotFilter(filterToReverse);
    }
}
