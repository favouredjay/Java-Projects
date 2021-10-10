package CheckOutApp;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;


public class Cart {
   private ArrayList<Product> items = new ArrayList<>();
    Product item;

    public ArrayList<Product> getItems() {
        return items;
    }
    public String getItemByName(String name) {
//            return items.get(number);
        return item.getNameOfItem();
        }
        public Product getItemByIndex(int number){
        return  items.get(number);
        }


//    public void setItems(ArrayList<Product> items) {
//        this.items = items;
//    }

    public Product getItem() {

        return item;
    }

//    public void setItem(Product item) {
//        item=new Product();
//        this.item = item;
//    }

    public void addItems(String nameOfItem, BigDecimal amountOfItem, int numberOfItems) {
        this.items.add(new Product(nameOfItem, numberOfItems, amountOfItem));
//        System.out.println(order);
    }

    public boolean changeItem(Product item, Product newItem) {
        int foundItem = findItem(item);
        if (foundItem < 0) {
            System.out.println("Choose what's in your cart");
            return false;
        } else {
            items.remove(item);
            items.add(newItem);
            System.out.println(item + "was replaced with" + newItem);
            return true;
        }
    }

    private int findItem(Product item) {
        return this.items.indexOf(item);
    }

    public boolean removeItems(String itemName) {
        boolean foundItem = false;
        if (itemName.equalsIgnoreCase(item.getNameOfItem())) {
            Product itemToDelete= new Product(itemName);
            items.remove(itemToDelete);
            foundItem = true;
        }
        System.out.println("The Product you are trying to remove is not in your cart ");
        return !foundItem;
    }

    public BigDecimal calculateTotal() {
        BigDecimal sum = BigDecimal.ZERO;

        for (int i = 0; i < items.size(); i++) {
           sum = sum.add(item.getAmountOfItem());
        }
        return sum;
    }
    public int getTotalProducts(){
        return items.size();
    }
    public void printItems() {
        for (Product itemsToBuy : items) {
                System.out.println( itemsToBuy.getNameOfItem() + " - " + itemsToBuy.getNumberOfItems() + " - " + itemsToBuy.getAmountOfItem());
            }

    }


}



