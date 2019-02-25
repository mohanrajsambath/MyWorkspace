package mohan.com.chipviewcontacts.model;

import java.util.ArrayList;

public class ContactwithImage {
	public String id;
	public String name;
	private int drawableId;
	public ArrayList<ContactEmailwithImage> emails;
	public ArrayList<ContactPhonewithImage> numbers;

	public ContactwithImage(int drawableId,String id, String name) {
		this.drawableId = drawableId;
		this.id = id;
		this.name = name;
		this.emails = new ArrayList<ContactEmailwithImage>();
		this.numbers = new ArrayList<ContactPhonewithImage>();
	}

	public int getDrawableId() {
		return drawableId;
	}

	@Override
	public String toString() {
		String result = name;
		if (numbers.size() > 0) {
			ContactPhonewithImage number = numbers.get(0);
			result += " (" + number.number + " - " + number.type + ")";
		}
		if (emails.size() > 0) {
			ContactEmailwithImage email = emails.get(0);
			result += " [" + email.address + " - " + email.type + "]";
		}
		return result;
	}

	public void addEmail(String address, String type) {
		emails.add(new ContactEmailwithImage(address, type));
	}

	public void addNumber(String number, String type) {
		numbers.add(new ContactPhonewithImage(number, type));
	}
}
