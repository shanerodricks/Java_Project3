public class FullTimeStaff extends AbstractStaff {

	private int yearlySalary;

	public FullTimeStaff(int id, String name, int age, String address, String phoneNumber, int yearArrived,
			String title, String building, int yearlySalary2) {
		super(id, name, age, address, phoneNumber, yearArrived,title,building);
		yearlySalary = yearlySalary2;
	}

	@Override
	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "FullTimeStaff,"+getAffiliateString()+getStaffString()+
				","+yearlySalary;
	}

}
