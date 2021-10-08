package CheckOutApp;


import java.math.BigDecimal;
import java.util.ArrayList;


public class Cart {
    ArrayList<Product> items = new ArrayList<>();
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


    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public void addItems(Product item) {
        this.items.add(item);
    }

    public boolean changeItem(Product item, Product newItem) {
        int foundItem = findItem(item);
        if (foundItem < 0) {
            System.out.println("Choose what's in your cart");
            return false;
        } else {
            removeItems(item);
            addItems(newItem);
            System.out.println(item + "was replaced with" + newItem);
            return true;
        }
    }

    private int findItem(Product item) {
        return this.items.indexOf(item);
    }

    private boolean removeItems(Product itemName) {
        boolean foundItem = false;
        if (itemName.equals(item.getNameOfItem())) {
            items.remove(itemName);
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

}



