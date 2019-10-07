package filesprocessing.exceptions.typetwo;

/**
 * filter for missing output line
 */
public class MissingOrder extends TypeTwoExceptions{

    /**
     * a missing order exception
     * @param cause the reason it didnt work
     */
    public MissingOrder(String cause){
        super(" ORDER ", cause);
    }
}
