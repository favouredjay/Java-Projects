package CheckOutApp;

import java.math.BigDecimal;
import java.util.Scanner;

public class CheckOut {
    public static void main(String[] args) {
    User user = new User();
    Product items = new Product();
    Cart shoppingCart = new Cart();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = input.next();
        user.setNameOfCustomer(name);
        System.out.println("Welcome" + user.getNameOfCustomer());
//        System.out.println(items);

        int shoppingChoice = input.nextInt();
        boolean yn;
        switch (shoppingChoice){
            case 1:
                while (true) {
                    System.out.println("What do you want to buy");
                    String addItem = input.nextLine();
                    items.setNameOfItem(addItem);
                    System.out.println("How much is one?");
                    BigDecimal amount= input.nextBigDecimal();
                    System.out.println("What quantity do you want?");
                    int quantity = input.nextInt();
                    items.setAmountOfItem(amount, quantity);
                    shoppingCart.addItems(items);
                    System.out.println("Enter yes to add more products and no to");
                    String decision = input.nextLine();
                    switch (decision) {
                        case "yes" -> yn = false;
                        case "no" -> yn = true;
                    }
                }
            case 2:

                System.out.println("Ënter item number");
                int currentItem = input.nextInt();
                Product oldItem = shoppingCart.getItemByIndex(currentItem);
                System.out.println("Enter the name of the Product you want to buy");
                String nameOfProduct = input.next();
                Product newItem = new Product(nameOfProduct);
                System.out.println("How much is one?");
                BigDecimal amount= input.nextBigDecimal();
                System.out.println("What quantity do you want?");
                int quantity = input.nextInt();
                newItem.setAmountOfItem(amount, quantity);
                shoppingCart.changeItem(oldItem, newItem);

            case 3:
                System.out.println("Enter item to delete");
                String name
        }
    }
}
