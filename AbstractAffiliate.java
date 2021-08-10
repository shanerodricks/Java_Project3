public abstract class AbstractAffiliate implements Printable, Comparable<AbstractAffiliate>{
	private int id;
	private String name;
	private int age;
	private String address;
	private String phoneNumber;
	private int yearArrived;

	public AbstractAffiliate(int id2, String name2, int age2, String address2, String phoneNumber2, int yearArrived2) {
		id = id2;
		name = name2;
		age = age2;
		address = address2;
		phoneNumber = phoneNumber2;
		yearArrived = yearArrived2;
	}

	@Override
	public int compareTo(AbstractAffiliate abstractAffiliate) {
		if(yearArrived > abstractAffiliate.yearArrived) {
			return 1;
		}
		else if (yearArrived < abstractAffiliate.yearArrived) {
			return -1;
		}
		return 0;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getYearArrived() {
		return yearArrived;
	}

	@Override
	public abstract String toString();

	public String getAffiliateString() {
		return getAddress()+"," + getAge() + "," + getId() + "," + getName() +
				","+getPhoneNumber()+","+getYearArrived();
	}


}
