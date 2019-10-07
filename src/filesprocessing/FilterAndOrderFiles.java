package filesprocessing;
import filesprocessing.exceptions.typeone.TypeOneException;
import filesprocessing.filters.FilterFactory;
import filesprocessing.orders.OrderFactory;
import filesprocessing.toolboxes.SortToolBox;

import java.nio.file.DirectoryStream.*;
import java.nio.file.Paths;
import java.nio.file.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * this class prints the values in our needed order by the filter
 */
public class FilterAndOrderFiles {

    /**
     * analyzes every subsection of the file
     * @param subSections a list of the subsections
     * @param directory the directory we want to filter
     */
    public void sectionAnalyze(ArrayList<SubSectionHolder> subSections, String directory){

        // sets the directory into a Path object
        Path directoryPath = Paths.get(directory);

        // go through all the sub sections
        for(SubSectionHolder section:subSections){

            // the list to hold all the files to be printed
            ArrayList<Path> filteredFiles = new ArrayList<Path>();

            //  gets us a filter
            Filter<Path> currentFilter = getFilter(section);

            // filters our list
            filterList(directoryPath, filteredFiles, currentFilter);

            // gets the orders for the files and orders them
            orderPaths(section, filteredFiles);

            // prints out the  results
            filteredFiles.forEach((x) -> System.out.println(x.getFileName()));
        }
    }

    /**
     * orders the path in the way that we want
     * @param section the section we are working with
     * @param filteredFiles the filtered files
     */
    private void orderPaths(SubSectionHolder section, ArrayList<Path> filteredFiles) {
        Comparator<Path> currentOrder;

        // tries getting an order for the file
        try {
            currentOrder = OrderFactory.getOrder(section);

            if(section.isReverse()){
                currentOrder = OrderFactory.reverseOrder(currentOrder);
            }
        }
        catch (TypeOneException ex){

            // print the error and get a default filter from the factory
            System.err.println(ex.toString());
            currentOrder = OrderFactory.getDefault();
        }

        // sorts the files and prints them
        //            SortToolBox.sort(filteredFiles, currentOrder);
        SortToolBox.quickSort(filteredFiles, currentOrder, 0 , filteredFiles.size() - 1);
        filteredFiles.sort(currentOrder);
    }

    /**
     * filters the files by a filter that we have
     * @param directoryPath the path of our directory
     * @param filteredFiles the files that need to be filtered
     * @param currentFilter the filter to work with
     */
    private void filterList(Path directoryPath, ArrayList<Path> filteredFiles, Filter<Path> currentFilter) {
        // try filtering the files
        try {

            // gets only files that are not directory
            Files.newDirectoryStream(directoryPath, currentFilter).forEach(x ->
            {if (!Files.isDirectory(x)) filteredFiles.add(x);});
        }
        catch (Exception e){}
    }

    /**
     * gets the filter we want to work with
     * @param section the section we are currently working with
     * @return the filter
     */
    private Filter<Path> getFilter(SubSectionHolder section) {

        Filter<Path> currentFilter;

        // tries getting a filter from the factory if something goes wrong it uses a default filter
        try {
            currentFilter = FilterFactory.getFilter(section);

            // checks if need there is a not in the end
            if(section.isNot()){
                currentFilter =  FilterFactory.reverseFilter(currentFilter);
            }

        }catch (TypeOneException ex){

            // print the error and get a default filter from the factory
            System.err.println(ex.toString());
            currentFilter = FilterFactory.getDefaultFilter();
        }

        // returns the filter
        return currentFilter;
    }
}
