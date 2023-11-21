package study.lld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContactMerger {
    public static void main(String[] args) {
        // Create a list of dummy Contact objects for demonstration
        List<Contact> contacts = createDummyData();

        // Merge duplicate contacts
      //  List<Contact> mergedContacts = mergeDuplicateContacts(contacts);
        
        // Remove duplicate contacts
        List<Contact> uniqueContacts = removeDuplicateContacts(contacts);
        
     // Print the unique contacts
        for (Contact contact : uniqueContacts) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Birthdate: " + contact.getBirthdate());
            System.out.println("Phone Numbers: " + String.join(", ", contact.getPhones()));
            System.out.println("Last Updated Time: " + contact.getLastUpdatedTime());
            System.out.println();
        }

        // Sort merged contacts by name
       // mergedContacts.sort(Comparator.comparing(Contact::getName));
        
        

        // Print the merged contacts
      /*  for (Contact contact : mergedContacts) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Birthdate: " + contact.getBirthdate());
            System.out.println("Phone Numbers: " + String.join(", ", contact.getPhones()));
            System.out.println("Last Updated Time: " + contact.getLastUpdatedTime());
            System.out.println();
        }*/
    }
    
 // Method to remove duplicate contacts
    public static List<Contact> removeDuplicateContacts(List<Contact> contacts) {
        Map<String, Contact> contactMap = new HashMap<>();

        for (Contact contact : contacts) {
            String name = contact.getName();
            if (!contactMap.containsKey(name)) {
                contactMap.put(name, contact);
            }
        }

        return new ArrayList<>(contactMap.values());
    }

    // Method to create dummy data for Contact objects
    public static List<Contact> createDummyData() {
        List<Contact> dummyData = new ArrayList<>();
        // Add your dummy data here
        dummyData.add(new Contact("Alice", "13-10-1999", Arrays.asList("8888888888", "+919999999999", "102"), 1));
        dummyData.add(new Contact("Bob Parson", "05-06-2000", Collections.singletonList("123456"), 10));
        dummyData.add(new Contact("Alice Weasley", "", Arrays.asList("8888888888","12345678", "98765432"), 2));
        return dummyData;
    }

    // Method to merge duplicate contacts
    public static List<Contact> mergeDuplicateContacts(List<Contact> contacts) {
        Map<String, Contact> contactMap = new HashMap<>();

        for (Contact contact : contacts) {
            String name = contact.getName();
            if (!contactMap.containsKey(name)) {
                contactMap.put(name, contact);
            } else {
                Contact existingContact = contactMap.get(name);
                if (contact.getLastUpdatedTime() > existingContact.getLastUpdatedTime()) {
                    // Replace the existing contact with the more recent one
                    contactMap.put(name, contact);
                }
                // Merge phone numbers (assuming no duplicates within the same contact)
                existingContact.getPhones().addAll(contact.getPhones());
            }
        }

        return new ArrayList<>(contactMap.values());
    }

    // Method to merge phone numbers of duplicate contacts
    public static List<String> mergePhoneNumbers(List<String> phones1, List<String> phones2) {
        Set<String> mergedPhones = new HashSet<>(phones1);
        mergedPhones.addAll(phones2);
        return new ArrayList<>(mergedPhones);
    }
}

/*
 * class Contact { private String name; private String birthdate; private
 * List<String> phones; private int lastUpdatedTime;
 * 
 * public Contact(String name, String birthdate, List<String> phones, int
 * lastUpdatedTime) { this.name = name; this.birthdate = birthdate; this.phones
 * = phones; this.lastUpdatedTime = lastUpdatedTime; }
 * 
 * public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public String getBirthdate() { return birthdate; }
 * 
 * public void setBirthdate(String birthdate) { this.birthdate = birthdate; }
 * 
 * public List<String> getPhones() { return phones; }
 * 
 * public void setPhones(List<String> phones) { this.phones = phones; }
 * 
 * public int getLastUpdatedTime() { return lastUpdatedTime; }
 * 
 * public void setLastUpdatedTime(int lastUpdatedTime) { this.lastUpdatedTime =
 * lastUpdatedTime; }
 * 
 * // Getter and Setter methods for the Contact class
 * 
 * }
 */

