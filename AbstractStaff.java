
public abstract class AbstractStaff extends AbstractAffiliate {


	private String title;
	private String building;

	public AbstractStaff(int id, String name, int age, String address, String phoneNumber, int yearArrived,
			String title2, String building2) {
		super(id, name, age, address, phoneNumber, yearArrived);
		title = title2;
		building = building2;
	}

	public String getStaffString() {
		return ","+building+","+title;
	}
}
