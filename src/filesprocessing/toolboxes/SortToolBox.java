package filesprocessing.toolboxes;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * a class  to use as a sorting tool box
  */
public class SortToolBox {

    // to keep it singleton
    private static SortToolBox sortToolBox = new SortToolBox();

    /**
     * to keep it singleton
     */
    private SortToolBox() { }

    /**
     * a function that get the instance
     * @return the instance
     */
    private static SortToolBox getInstance(){
        return sortToolBox;
    }

    /**
     * implements the quick sort algorithm for the list of paths we want to sort
     * @param paths the paths to sort
     * @param compare the comparator we used to sort
     * @param low our low index
     * @param high the high index
     */
    public static void quickSort(ArrayList<Path> paths, Comparator<Path> compare, int low, int high) {

        // checks if our high is less than our low
        if (low < high) {

            // gets the partition
            int partitionIndex = partition(paths, low, high, compare);

            // sorts each half up until the partition
            quickSort(paths, compare, low, partitionIndex - 1);
            quickSort(paths, compare,partitionIndex + 1, high);
        }
    }


    /**
     * puts all values under pivot
     * @param paths the paths we are dealing with
     * @param low the low point of the section we want to analize
     * @param high the high point we want to analyze
     * @param comparator the thing we will compare with
     * @return the where the pivots stand
     */
    private static int partition(ArrayList<Path> paths, int low, int high, Comparator<Path> comparator) {

        // sets the pivot as our high point
        Path pivot = paths.get(high);

        // location to put the elements
        int i = low - 1;

        // goes through the whole section
        for (int j = low; j < high; j++) {

            // checks if its smaller or equal to our pivot using the comparator
            if (comparator.compare(pivot, paths.get(j)) >= 0){

                // raise the indication of where less or equal is
                i++;

                // add the path to the less or equal part of the array list
                Path temp = paths.get(i);
                paths.set(i, paths.get(j));
                paths.set(j, temp);
            }
        }

        // adds the pivot into its location in the array
        Path temp = paths.get(i + 1);
        paths.set(i + 1, paths.get(high));
        paths.set(high, temp);

        // returns the location where the pivot stands
        return i + 1;
    }
}

