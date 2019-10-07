package filesprocessing;
import filesprocessing.exceptions.typetwo.*;
import filesprocessing.toolboxes.TypeTwoErrorToolBox;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * a class to set up all basic stuff needed to read the files latter on
 */
public class ParseData {

    /**
     * the function to run the set up from reding the file to checking if we can work with it
     * @param args the arguments a user gets from the command line
     * @return the sections to analyze
     * @throws TypeTwoExceptions exceptions of type two
     */
    public ArrayList<SubSectionHolder> runSetUp(String [] args) throws TypeTwoExceptions {

        // checks if there are type two exceptions
        TypeTwoErrorToolBox.enoughArgs(args.length);

        // gets all the file lines
        ArrayList<String> fileLines = this.readFile(args[1]);

        // returns a an arraylist with all the values from the file
        return this.getReadyToParse(fileLines);
    }


    /**
     * reads the files content into an array
     * @param fileName the name of the file we are reading from
     */
    private ArrayList<String> readFile(String fileName) throws IOException {

        File commandFile = new File(fileName);
        ArrayList<String> allFileLines = new ArrayList<String>();

        // checking if we can read the file at all
        TypeTwoErrorToolBox.enoughPermissions(commandFile);

        try (Scanner reader = new Scanner(commandFile)){

            // keeps reading till the end of the file
            while (reader.hasNextLine()){
                allFileLines.add(reader.nextLine());
            }

        } catch (Exception e) {

            throw new IOException(" cant seem to read from command file");
        }

        return allFileLines;
    }

    /**
     * goes through the whole list and puts the values in the new array
     * @param fileLines the lines of the file
     * @return the values we will need to sort the files by each time
     * @throws MissingOrder an order is missing
     * @throws MissingFilter a filter is missing
     */
    private ArrayList<SubSectionHolder> getReadyToParse(ArrayList<String> fileLines)
            throws MissingOrder, MissingFilter {

        ArrayList<SubSectionHolder> allActions = new ArrayList<SubSectionHolder>();

        int counter = 0;

        // goes through all values of the lines of the file
        while (counter < fileLines.size()){


            // checks that the pattern is correct
            TypeTwoErrorToolBox.wordEqualsFilter(fileLines.get(counter));

            // try reaching for another one if we go out of bound we are good since we have the catch
            try {
                TypeTwoErrorToolBox.wordEqualsOrder(fileLines.get(counter + 2));
            }
            catch (IndexOutOfBoundsException ex){
                throw new MissingOrder(" we are missing the order");
            }

            // checks how much we need to increase the counter by and how the new node will look
            if((counter + 3) >= fileLines.size() || fileLines.get(counter + 3).equals("FILTER")) {
                allActions.add(new SubSectionHolder(fileLines.get(counter + 1), counter + 1));
                counter += 3;

            }
            else
            {
                allActions.add(new SubSectionHolder( fileLines.get(counter + 1), fileLines.get(counter + 3),
                        (counter + 1), (counter + 3)));
                counter += 4;
            }

        }

        return allActions;
    }
}
