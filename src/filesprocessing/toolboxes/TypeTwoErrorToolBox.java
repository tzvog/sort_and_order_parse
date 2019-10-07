package filesprocessing.toolboxes;
import filesprocessing.exceptions.typetwo.IOException;
import filesprocessing.exceptions.typetwo.InvalidUsage;
import filesprocessing.exceptions.typetwo.MissingFilter;
import filesprocessing.exceptions.typetwo.MissingOrder;

import java.io.File;

public class TypeTwoErrorToolBox {

    private TypeTwoErrorToolBox typeTwoErrorToolBox = new TypeTwoErrorToolBox();
    private static final int ARGUMENT_AMOUNT = 2;
    private static final String NOT_ENOUGH_ARGUMENTS = "not enough arguments supplied";
    private static final String NOT_ENOUGH_PERMISSIONS = "no reading permissions on the command files";
    private static final String SUB_SECTION_MISSING = "sub section is missing";
    private static final String FILTER = "FILTER";
    private static final String ORDER = "ORDER";

    /**
     * keeps it a singleton
     */
    private TypeTwoErrorToolBox() {
    }

    /**
     * keeps it a singleton
     * @return the instance
     */
    public TypeTwoErrorToolBox getInstnace(){
        return typeTwoErrorToolBox;
    }

    /**
     * checks if we have enough arguments to run the program
     * @param argsAmount the amount of arguments we can currently use
     * @throws InvalidUsage an invalid amount of problems was caused
     */
    public static void enoughArgs(int argsAmount) throws InvalidUsage {

        // checks if there are enough parameters
        if(argsAmount != TypeTwoErrorToolBox.ARGUMENT_AMOUNT){
            throw new InvalidUsage(TypeTwoErrorToolBox.NOT_ENOUGH_ARGUMENTS);
        }
    }

    /**
     * checks if we have enough permissions on our file to read the file
     * @param ourFile the file we wanna read
     * @throws IOException the file is unreadable
     */
    public static void enoughPermissions(File ourFile) throws IOException {

        // checks if we have permissions on that file
        if(!ourFile.canRead()){
            throw new IOException(TypeTwoErrorToolBox.NOT_ENOUGH_PERMISSIONS);
        }
    }

    /**
     * checks if it is not the filter
     * @param filter the word we wanna check
     * @throws MissingFilter the word is not what we are expecting
     */
    public static void wordEqualsFilter(String filter) throws MissingFilter {

        // checks if it is not the word filter
        if(!(filter.equals(TypeTwoErrorToolBox.FILTER))){
            throw new MissingFilter(TypeTwoErrorToolBox.SUB_SECTION_MISSING);
        }
    }

    /**
     * checks if it is not order
     * @param order the word we wanna check
     * @return if the word we are given equals order
     * @throws MissingOrder the word is not what we are expecting
     */
    public static boolean wordEqualsOrder(String order) throws MissingOrder {

        // checks if it is not the word filter
        if(!(order.equals(TypeTwoErrorToolBox.ORDER))){
            throw new MissingOrder(TypeTwoErrorToolBox.SUB_SECTION_MISSING);
        }

        return true;
    }
}
