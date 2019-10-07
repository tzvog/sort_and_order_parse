package filesprocessing.exceptions.typetwo;

/**
 * exceptions that will work with type two problems
 */
public abstract class TypeTwoExceptions extends Exception {

    private String errorMessage;
    private String errorCause;

    /**
     * creates the type two exceptions
     * @param errorType the type of error
     * @param errorCause the cause of the error
     */
    public TypeTwoExceptions(String errorType, String errorCause){

        this.errorMessage = errorType;
        this.errorCause = errorCause;
    }

    /**
     * creates a string to work with to represent our string
     * @return the string represent of the error
     */
    @Override
    public String toString() {
        return "ERROR: " + this.errorMessage + " " + this.errorCause;
    }
}
