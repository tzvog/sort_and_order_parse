package filesprocessing;

import filesprocessing.toolboxes.TypeOneErrorToolBox;

/**
 * this class is made to hold the filter and orders we need
 */
public class SubSectionHolder {

    private static final int BAD_LINE = -1;
    private static final String DEFAULT_FILTER = "abs";
    private static final String SPLITTER_INDICATOR = "#";
    private String filter;
    private String order;
    private int orderLine;
    private int filterLine;


    /**
     * a constructor for the files processing.SubSectionHolder without an order
     * @param filter the we wanna filter it by
     * @param filterLine the line the filter is in on the file
     */
    public SubSectionHolder(String filter, int filterLine) {
        this(filter, SubSectionHolder.DEFAULT_FILTER, filterLine, SubSectionHolder.BAD_LINE);
    }


    /**
     * the constructor for when we have an order to order by
     * @param filter the filter we wanna use
     * @param order the order we want
     * @param filterLine the line the filter sits on
     * @param orderLine the line the order sits one
     */
    public SubSectionHolder(String filter, String order, int filterLine, int orderLine) {
        this.filter = filter;
        this.order = order;
        this.filterLine = filterLine + 1;
        this.orderLine = orderLine + 1;
    }

    /**
     * gets the order we wanna filter by
     * @return the new order
     */
    public String getOrder() {
        return order;
    }

    /**
     * gets the line the order is in
     * @return the line the order is in
     */
    public int getOrderLine() {
        return orderLine;
    }

    /**
     * gets the line the filter is in
     * @return the line the filter is on
     */
    public int getFilterLine() {
        return filterLine;
    }

    /**
     * gets our filter split up into parts
     * @return the filter
     */
    public String [] getFilterText() {
        return filter.split(SubSectionHolder.SPLITTER_INDICATOR);
    }

    /**
     * check for if we need to use the not version of the filter
     * @return if it ends with a not
     */
    public boolean isNot(){
        return this.getFilterText()[this.getFilterText().length - 1].equals("NOT");
    }

    /**
     * splits the order text for us
     * @return the order split by the indicator
     */
    public String [] getOrderText() { return order.split(SubSectionHolder.SPLITTER_INDICATOR);}

    /**
     * checks if we have enough arguments
     * @return if we have enough arguments
     */
    public boolean isFilterEnoughArguments() {

        // checks if we have a good amount of arguments
        return TypeOneErrorToolBox.isFilterEnoughArguments(this.getFilterText());
    }

    /**
     * checks if we have enough arguments
     * @return if we have enough arguments
     */
    public boolean isOrderEnoughArguments(){
        return TypeOneErrorToolBox.isOrderEnoughArgument(this.getOrderText());
    }

    /**
     * checks if its a reverse
     * @return if it has a reverse in the end
     */
    public boolean isReverse(){
        return this.getOrderText()[this.getOrderText().length - 1].equals("REVERSE");
    }
}