package CheckOutApp;

import java.math.BigDecimal;

import java.util.Scanner;

public class CheckOut {

    public static void printOptions(){
        System.out.println("""
                Welcome to Maven Supermarket
                please press 1 - 6
                press 1 to add new contact to the cart
                press 2 to change an item
                press 3 to remove an item
                press 4 to show items in the cart
                press 5 to Pay for items and checkout
                press 6 to leave

                """);

    }
    public static void printOthers(){
        System.out.println("""
                please press 1 - 5
                press 1 to add new contact to the cart
                press 2 to change an item
                press 3 to remove an item
                press 4 to show items in the cart
                press 5 to Pay for items and checkout

                """);
    }

    public static void main(String[] args) {
        User user = new User();
        Product items = new Product();
        Cart shoppingCart = new Cart();
        Scanner input = new Scanner(System.in);


        System.out.println("Enter your name");
        String name = input.next();
        user.setNameOfCustomer(name);
        System.out.println("Welcome " + user.getNameOfCustomer());
//        System.out.println(items);
        System.out.println();

        printOptions();
        int shoppingChoice = input.nextInt();
        boolean quit = false;

        while (!quit) {

            switch (shoppingChoice) {
                case 1:
                    boolean yn = false;

                    while (!yn){
                        shoppingCart.printItems();
                        System.out.println("What do you want to buy");
                        String addItem = input.next();
                        items.setNameOfItem(addItem);
                        System.out.println("How much is one?");
                        BigDecimal amount = input.nextBigDecimal();
                        items.setAmountOfItem(amount);
                        System.out.println("What quantity do you want?");
                        int quantity = input.nextInt();
                        items.setNumberOfItems(quantity);
                        shoppingCart.addItems(addItem, amount, quantity);
                        System.out.println("Enter yes to add more products and no to do other things");
                        String decision = input.next();
                        switch (decision) {
                            case "yes" -> yn = false;
                            case "no" -> {
                                yn = true;
                                printOthers();
                            }
                            default -> throw new IllegalStateException("Unexpected value: " + decision);
                        }


                    }
                    shoppingCart.printItems();
                    break;
                case 2:
                    System.out.println("Items in your cart are: \n ");
                    shoppingCart.printItems();
                    System.out.println("Enter item number");
                    int currentItem = input.nextInt();
                    Product oldItem = shoppingCart.getItemByIndex(currentItem);
                    Product newItem = new Product();
                    System.out.println("Enter the name of the Product you want to buy");
                    String nameOfProduct = input.next();
                    newItem.setNameOfItem(nameOfProduct);
                    System.out.println("How much is one?");
                    BigDecimal amount = input.nextBigDecimal();
                    newItem.setAmountOfItem(amount);
                    System.out.println("What quantity do you want?");
                    int quantity = input.nextInt();
                    newItem.setNumberOfItems(quantity);

                    shoppingCart.changeItem(oldItem, newItem);

                case 3:
                    System.out.println("Enter item to delete");
                    String nameOfItemToDelete = input.nextLine();
                    shoppingCart.removeItems(nameOfItemToDelete);

                case 4:
                    shoppingCart.printItems();

                case 5:

                case 6:
                    System.out.println("Thank you for shopping with us"); quit = true;

            }
        }
    }
}
