package filesprocessing.exceptions.typetwo;

/**
 * a class for an IO exception
 */
public class IOException extends TypeTwoExceptions {

    /**
     * an io exception accorded
     * @param cause the reason it happened
     */
    public IOException(String cause){
        super(" IO EXCEPTION", cause);
    }
}
