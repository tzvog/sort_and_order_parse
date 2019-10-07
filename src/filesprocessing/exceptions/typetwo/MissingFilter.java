package filesprocessing.exceptions.typetwo;

/**
 * Missing filter exception
 */
public class MissingFilter extends TypeTwoExceptions {

    /**
     * a missing filter exception
     * @param cause the cause that it failed
     */
    public MissingFilter(String cause) {
        super(" FILTER ", cause);
    }

}
