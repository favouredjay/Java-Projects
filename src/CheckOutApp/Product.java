package CheckOutApp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Product {
    private String nameOfItem;
    private int numberOfItems;
    private BigDecimal amountOfItem;
    private LocalDate date = LocalDate.now();

    public Product(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }


    public Product(String nameOfItem, int numberOfItems, BigDecimal amountOfItem) {
        this.nameOfItem = nameOfItem;
        this.numberOfItems = numberOfItems;
        this.amountOfItem = amountOfItem;

    }

    public Product() {
        this.nameOfItem = null;
        this.numberOfItems = 0;
        this.amountOfItem = BigDecimal.ZERO;


    }


    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        if (numberOfItems > 0) {
            this.numberOfItems = numberOfItems;
        }
    }


    public BigDecimal getAmountOfItem() {
        return amountOfItem;
    }

    public void setAmountOfItem(BigDecimal amountOfItem) {
        this.amountOfItem = amountOfItem;
    }

    public BigDecimal getAmountOfOneOrMoreItems() {
        return getAmountOfItem().multiply(BigDecimal.valueOf(getNumberOfItems()));

    }


//    @Override
//    public String toString() {
//        Cart shoppingCart = new Cart();
//        return "Maven Supermarket Teller\n" +
//                "______________________________________________\n" +
//                "                                   " + date.toString() + "\n" +
//                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
//                "ITEMS " + " Amount per Item " + " Quantity " + " Total Amount \n" +
//                getNameOfItem() + " -      " + getAmountOfItem() + "         " + getNumberOfItems() + "        " + getAmountOfOneOrMoreItems() + "\n" +
//                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n" +
//                "SUB-TOTAL                               " + shoppingCart.calculateTotal() + "\n";


    @Override
    public String toString() {
        return String.format("Product Name: %s%n Price: %.2f%n Quantity: %d%n Cost: %.2f%n"
                ,getNameOfItem(),getAmountOfItem(),getNumberOfItems(),getAmountOfOneOrMoreItems());
    }



}


