package CheckOutApp;


import java.math.BigDecimal;
import java.util.ArrayList;
public class Cart {
    private final ArrayList<Product>  items = new ArrayList<>();

    public ArrayList<Product> getItems() {
        return items;
    }

    public void addItems(String nameOfItem, BigDecimal amountOfItem, int numberOfItems) {
        this.items.add(new Product(nameOfItem, numberOfItems, amountOfItem));
    }

    public Product getItemByName(String name) {
        int position = findItem(name);
        if(position >= 0){
            return this.items.get(position);
        }
        return null;
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
        System.out.println(product.getNameOfItem() + " was deleted");
        return true;
    }

    public BigDecimal calculateTotal() {
        BigDecimal sum = BigDecimal.ZERO;

        for (Product product : items) {
            sum = sum.add(product.getAmountOfOneOrMoreItems());
        }
        return sum;
    }

    public int getTotalProducts() {
        return items.size();
    }

    public void printItems() {
        for (Product itemsToBuy : items) {
            System.out.println(itemsToBuy.getNameOfItem()
                    + " - " + itemsToBuy.getNumberOfItems() + " - "
                    + itemsToBuy.getAmountOfItem());
        }
    }
}







