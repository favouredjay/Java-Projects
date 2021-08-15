package MobilePhone;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact>myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }
        else {
            myContacts.add(contact);
            return true;
        }
    }
    public int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }
    public int findContact(String contact){
        for (int i = 0; i < this.myContacts.size(); i++) {
      Contact contactName = this.myContacts.get(i);
      if(contactName.getName().equals(contact)){
          return i;
      }
        }return -1;
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition< 0){
            System.out.println("Can't update what's not there");
            return false;
        }
        else {
            this.myContacts.set(foundPosition, newContact);
            System.out.println(oldContact.getName() + "was replaced with " + newContact);
            return true;
        }
    }
    public String queryContact(Contact contact){
        if(findContact(contact)>=0){
            return contact.getName();
        }
        else return null;
    }
    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }
    public  void printContact(){

        for (int i = 0; i <this.myContacts.size() ; i++) {

            System.out.println("Contacts are :" + myContacts.get(i).getName() + " -> " + myContacts.get(i).getNumber() );

        }
    }
}
