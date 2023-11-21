package study.lld;

import java.util.*;

class ContactData {
	String name;
	String birthdate;
	List<String> phones;
	int lastUpdatedTime;

	public ContactData(String name, String birthdate, List<String> phones, int lastUpdatedTime) {
		this.name = name;
		this.birthdate = birthdate;
		this.phones = phones;
		this.lastUpdatedTime = lastUpdatedTime;
	}
}

public class MergeContacts {
	public static void main(String[] args) {
		List<ContactData> dummyData = new ArrayList<>();
		dummyData.add(new ContactData("Alice", "13-10-1999", Arrays.asList("8888888888", "+919999999999", "102"), 10256));
		dummyData.add(new ContactData("Bob Parson", "05-06-2000", Collections.singletonList("123456"), 10));
		dummyData.add(new ContactData("Alice Weasley", "", Arrays.asList("8888888888", "12345678", "98765432"), 20));

		Map<String, ContactData> contactMap = new HashMap<>();

		for (ContactData contact : dummyData) {
            String key = contact.name;
            if (contactMap.containsKey(key)) {
            	ContactData existingContact = contactMap.get(key);
                // Check if phone numbers match
                boolean isDuplicate = false;
                for (String phone : contact.phones) {
                    if (!existingContact.phones.contains(phone)) {
                        existingContact.phones.add(phone);
                        isDuplicate = true;
                    }
                }
                // Update the last updated time
                existingContact.lastUpdatedTime = Math.max(existingContact.lastUpdatedTime, contact.lastUpdatedTime);
            } else {
                contactMap.put(key, contact);
            }
        }

		List<ContactData> mergedContacts = new ArrayList<>(contactMap.values());
		// Sort the mergedContacts by name
		mergedContacts.sort(Comparator.comparing(contact -> contact.name));

		for (ContactData contact : mergedContacts) {
			System.out.println(contact.name);
			System.out.println(contact.birthdate.isEmpty() ? "empty" : contact.birthdate);
			Collections.sort(contact.phones);
			System.out.println(String.join(" ", contact.phones));
			System.out.println(contact.lastUpdatedTime);
		}
	}
}

