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

    public Product getItemByName(String name) {
        int position = findItem(name);
        if(position >= 0){
            return this.items.get(position);
        }

        return null;
    }

    public Product getItemByIndex(int number) {
        return items.get(number);
    }


    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }

    public Product getItem() {

        return item;
    }

    public void setItem(Product item) {
        item=new Product();
        this.item = item;
    }

    public void addItems(String nameOfItem, BigDecimal amountOfItem, int numberOfItems) {
        this.items.add(new Product(nameOfItem, numberOfItems, amountOfItem));

    }

    public boolean changeItem(Product item, Product newItem) {
        int foundItem = findItem(item);
        if (foundItem < 0) {
            System.out.println("Choose what's in your cart");
            return false;
        } else {
            items.remove(item);
            items.add(newItem);

            return true;
        }
    }

    private int findItem(Product item) {
        return this.items.indexOf(item);
    }
    private int findItem(String itemName){
        for (int i = 0; i< items.size(); i++){
            Product itemToBuy = this.items.get(i);
            if(itemName.equalsIgnoreCase(itemToBuy.getNameOfItem())){
                return i;
            }
        }return -1;
    }

    public boolean removeItems(Product product) {

        int position = findItem(product);
        if(position <= 0){
            System.out.println(product.getNameOfItem() + " not found");
            return false;
        }
        this.items.remove(position);
        System.out.println(product.getNameOfItem() + "was deleted");
        return true;

    }

    public BigDecimal calculateTotal() {
        BigDecimal sum = BigDecimal.ZERO;

        for (int i = 0; i < items.size(); i++) {

            sum = sum.add(items.get(i).getAmountOfOneOrMoreItems());
        }
        return sum;
    }

    public int getTotalProducts() {
        return items.size();
    }

    public void printItems() {
        for (Product itemsToBuy : items) {
            System.out.println(itemsToBuy.getNameOfItem() + " - " + itemsToBuy.getNumberOfItems() + " - " + itemsToBuy.getAmountOfItem());
        }

    }
}







