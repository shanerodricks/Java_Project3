public class PartTimeStaff extends AbstractStaff {

	private int hourlySalary;

	public PartTimeStaff(int id, String name, int age, String address, String phoneNumber, int yearArrived,
			String title, String building, int hourlySalary2) {
		super(id, name, age, address, phoneNumber, yearArrived,title,building);
		hourlySalary = hourlySalary2;
	}

	@Override
	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "PartTimeStaff,"+getAffiliateString()+getStaffString()+
				","+hourlySalary;
	}

}
