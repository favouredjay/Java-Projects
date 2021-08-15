package MobilePhone;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        MobilePhone mobilePhone = new MobilePhone("");
        boolean quit = false;
        startPhone();
        printOptions();

        while (!quit){
            System.out.println("Enter 7 to print out options");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0 -> {
                    System.out.println("Phone is shutting down");
                    quit = true;
                    break;
                }
                case 1 -> {
                    mobilePhone.printContact();
                }
                case 2 -> {
                    System.out.println("Enter new contact Name");
                    String name = scanner.nextLine();
                    System.out.println("Enter new Phone Number");
                    String phoneNumber = scanner.nextLine();
                    Contact newContact = Contact.createContact(name,phoneNumber);
                    if(mobilePhone.addNewContact(newContact)){
                        System.out.println("New Contact added: name =" + name + "Phone Number =" + phoneNumber);
                    }
                    else {
                        System.out.println("Cannot add " + name + "already on the file");
                    }
                }
                case 3 -> {
                    System.out.println("Enter name or Number");
                    String nameOrNumber = scanner.nextLine();
                    if(mobilePhone.findContact(nameOrNumber)){

                    }
                }
                case 4 -> {
                    System.out.println("Enter Existing contact");
                    String name = scanner.nextLine();
                    Contact existingContact = mobilePhone.queryContact(name);
                    if(existingContact == null){
                        System.out.println("Contact not found");
                        return;
                    }
                    System.out.println("Enter new contact Name");
                    String newContactName = scanner.nextLine();
                    System.out.println("Enter new contact Number");
                    String newNumber = scanner.nextLine();
                    Contact newContact = Contact.createContact(newContactName, newNumber);
                    if(mobilePhone.updateContact(existingContact, newContact)){
                        System.out.println("Successful");
                    }
                    else{
                        System.out.println("Error updating");
                    }

                }

            }


        }

    }






    public static void startPhone() throws InterruptedException {

        System.out.println("Phone is starting ....");
        Thread.sleep(10000);
        System.out.println();
    }
    public static void printOptions(){
        System.out.println("""
                Welcome
                please press 0 - 6
                press 0 to shutdown
                press 1 to show list
                press 2 to add new contacts
                press 3 to find contacts
                press 4 to update list
                press 5 to query contact
                press 6 to remove contact
                press 7 to print out options
                """);

    }
}
