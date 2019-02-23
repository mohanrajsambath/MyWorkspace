package mohan.com.chipviewcontacts;

import java.util.ArrayList;

import mohan.com.contactloader.ContactEmail;
import mohan.com.contactloader.ContactPhone;

public class ContactwithImage {
	public String id;
	public String name;
	private int drawableId;
	public ArrayList<ContactEmail> emails;
	public ArrayList<ContactPhone> numbers;

	public ContactwithImage(int drawableId,String id, String name) {
		this.drawableId = drawableId;
		this.id = id;
		this.name = name;
		this.emails = new ArrayList<ContactEmail>();
		this.numbers = new ArrayList<ContactPhone>();
	}

	public int getDrawableId() {
		return drawableId;
	}

	@Override
	public String toString() {
		String result = name;
		if (numbers.size() > 0) {
			ContactPhone number = numbers.get(0);
			result += " (" + number.number + " - " + number.type + ")";
		}
		if (emails.size() > 0) {
			ContactEmail email = emails.get(0);
			result += " [" + email.address + " - " + email.type + "]";
		}
		return result;
	}

	public void addEmail(String address, String type) {
		emails.add(new ContactEmail(address, type));
	}

	public void addNumber(String number, String type) {
		numbers.add(new ContactPhone(number, type));
	}
}
