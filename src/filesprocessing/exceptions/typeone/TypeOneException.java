package filesprocessing.exceptions.typeone;

/**
 * creates an exception for type one
 */
public class TypeOneException extends Exception {

    private int line;

    /**
     * constructor that takes the the line the exception was on
     * @param line the number the exception had on
     */
    public TypeOneException(int line) {
        this.line = line;
    }

    /**
     * creates a string to represent the error
     * @return the Exceptions to string
     */
    @Override
    public String toString() {
        return "Warning in line " + this.line;
    }
}
