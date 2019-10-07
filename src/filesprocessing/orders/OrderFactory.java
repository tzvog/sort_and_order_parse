package filesprocessing.orders;

import filesprocessing.SubSectionHolder;
import filesprocessing.exceptions.typeone.TypeOneException;

import java.nio.file.Path;
import java.util.Comparator;

/**
 * a class to get an order we need to filter by
 */
public class OrderFactory {

    private static OrderFactory orderFactory = new OrderFactory();

    /**
     * keeping the factory a singleton
     */
    private OrderFactory(){}

    /**
     * keeps the factory a singleton
     * @return the instance of the object
     */
    private static OrderFactory getInsatce(){
        return orderFactory;
    }

    /**
     *  gets the comparator we need
     * @param subSection the sub section we are working with
     * @return the comparator we need
     * @throws TypeOneException we could not get the order
     */
    public static Comparator<Path> getOrder(SubSectionHolder subSection) throws TypeOneException{

        // checks if we have enough arguments
        if(!subSection.isOrderEnoughArguments()){
            throw new TypeOneException(subSection.getOrderLine());
        }

        // checks what we have to throw
        switch (subSection.getOrderText()[0]){
            case "abs":
                return new AbsCompare();
            case "type":
                return new TypeCompare();
            case "size":
                return new SizeCompare();
            default:
                throw new TypeOneException(subSection.getOrderLine());
        }
    }

    /**
     * reverse the order of the filter
     * @param orderToReverse the order to reverse
     * @return the order reversed
     */
    public static Comparator<Path> reverseOrder(Comparator<Path> orderToReverse){

        return new ReverseCompare(orderToReverse);
    }

    /**
     * gets a default comparator
     * @return the default comparer
     */
    public static Comparator<Path> getDefault(){
        return new AbsCompare();
    }
}
