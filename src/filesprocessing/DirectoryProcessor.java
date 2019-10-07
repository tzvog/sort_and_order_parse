package filesprocessing;
import filesprocessing.exceptions.typetwo.*;
import java.util.ArrayList;


/**
 * the main class to run the program
 */
public class DirectoryProcessor {

    public static void main(String[] args) {

        // creates an object to load the data from the file
        ParseData dataFromCommandFile = new ParseData();
        FilterAndOrderFiles filterAndOrderFiles = new FilterAndOrderFiles();

        try {
            // reads the file and gets the commands needed to be done
            ArrayList<SubSectionHolder> actionsToExecute = dataFromCommandFile.runSetUp(args);

            // orders and prints the files in needed order
            filterAndOrderFiles.sectionAnalyze(actionsToExecute, args[0]);

        }catch (TypeTwoExceptions e){
            System.err.println(e.toString());
        }
    }


}
