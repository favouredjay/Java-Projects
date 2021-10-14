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
                press 5 to Pay for items
                press 6 to check out

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
                press 6 to leave

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

                          if(decision.equalsIgnoreCase("yes")) {

                          }
                          else if (decision.equalsIgnoreCase("no")){
                                    yn = true;

                          }else {
                              System.out.println("You can only choose yes or no");
                              System.out.println("Enter yes to add more products and no to do other things");
                              decision = input.next();

                              yn = false;


                          }


                    }


                    break;
                case 2:
                    System.out.println("Items in your cart are: \n ");
                    shoppingCart.printItems();
                    System.out.println("Enter item Name");
                    String currentItem = input.next();
                    Product oldItem = shoppingCart.getItemByName(currentItem);
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

                    if(shoppingCart.changeItem(oldItem, newItem)){
                        System.out.println(oldItem.toString() + " changed for " + newItem);
                        break;
                    }

                case 3:

                    System.out.println("Enter Existing item");
                    String nameToDelete = input.next();
                    Product existingItem = shoppingCart.getItemByName(nameToDelete);
                    if(existingItem == null){
                        System.out.println("item not found");
                        return;
                    }
                    if(shoppingCart.removeItems(existingItem)){
                        System.out.println("successful");
                    }
                    else {
                        System.out.println("unable to delete item");
                    }


                case 4:
                    shoppingCart.printItems();
                    break;

                case 5:
                    System.out.println(items);
                    System.out.println("Your Total is " + shoppingCart.calculateTotal());
                    System.out.println("Please pay for your goods");
                    BigDecimal amountPaid = input.nextBigDecimal();
                    BigDecimal balance = amountPaid.subtract(shoppingCart.calculateTotal());
                    System.out.println("Your balance is " + balance);
                    System.out.println();



                case 6:

                    quit = true;
                    System.out.println("Thank you for shopping with us");
                    System.exit(0);






            }

            printOthers();
            shoppingChoice = input.nextInt();

        }
    }
}
