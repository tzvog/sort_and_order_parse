package filesprocessing.toolboxes;

/**
 * a class to work as a tool box for the type one errors
 */
public class TypeOneErrorToolBox {

    /**
     * keeps it a singleton
     */
    private static TypeOneErrorToolBox typeOneErrorToolBox = new TypeOneErrorToolBox();

    /**
     * keeps it a singleton
     */
    private TypeOneErrorToolBox(){}

    /**
     * keeps it a singleton
     * @return the instance
     */
    public TypeOneErrorToolBox getInstance(){
        return typeOneErrorToolBox;
    }


    /**
     * converts the value of the string to a number
     * @param value the value we want to convert
     * @return the string converted to a double
     * @throws NumberFormatException could not convert the string to double or if
     * the number is negative throw the error
     */
    public static double convertValueToDouble(String value) throws NumberFormatException{

        double returnDouble = Double.parseDouble(value);

        // checks that the number is not negative
        if(returnDouble < 0){
            throw new NumberFormatException();
        }

        return returnDouble;
    }

    /**
     * checks if we can convert the value to yes or no
     * @param indicator if we want a yes or no
     * @return the value in a boolean format
     * @throws IllegalArgumentException we got something else then yes or no
     */
    public static Boolean convertValueToYesOrNo(String indicator) throws IllegalArgumentException{

        // if we got the right type throw one of these exceptions else throw an illegal argument exception
        if (indicator.equals("YES")){
            return true;
        }
        else if(indicator.equals("NO")){
            return false;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * a function to check if wwe have enough arguments for the filter we have
     * @param filterText our sub section
     * @return yes or no if we have enough arguments
     */
    public static boolean isFilterEnoughArguments(String [] filterText){

        int expectedArgumentAmount = 1;

        // checks that there is enough arguments
        if(filterText.length == 0){
            return false;
        }

        // checks if we are not using the all filter
        if (!filterText[0].equals("all")){
            expectedArgumentAmount++;
        }

        // checks if the last value is not
        if (filterText[filterText.length - 1].equals("NOT")){
            expectedArgumentAmount++;
        }

        // checks if the
        if (filterText[0].equals("between")){
            expectedArgumentAmount++;
        }

        // checks if we have reached the desired length
        return filterText.length == expectedArgumentAmount;
    }

    /**
     * checks if the amount of arguments is correct for the order
     * @param orderText the subsection we are working on
     * @return if its enough
     */
    public static boolean isOrderEnoughArgument(String [] orderText){

        int expectedArgumentAmount = 1;

        if(orderText.length == 0){
            return false;
        }

        if(orderText[orderText.length - 1].equals("REVERSE")){
            expectedArgumentAmount ++;
        }

        return orderText.length == expectedArgumentAmount;
    }
}
