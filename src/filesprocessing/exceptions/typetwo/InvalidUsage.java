package filesprocessing.exceptions.typetwo;

/**
 * a class to represent the invalid usage
 */
public class InvalidUsage extends TypeTwoExceptions{

    /**
     * an invalid usage exception
     * @param cause the cause of the exception
     */
    public InvalidUsage(String cause){
        super(" InvalidUsage ", cause);
    }
}
