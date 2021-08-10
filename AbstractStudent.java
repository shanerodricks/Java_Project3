public abstract class AbstractStudent extends AbstractAffiliate {

	private String major;
	private String minor;
	private String classStanding;

	public AbstractStudent(int id, String name, int age, String address, String phoneNumber, int yearArrived,
			String major2, String minor2, String classStanding2) {
		super(id, name, age, address, phoneNumber, yearArrived);
		major = major2;
		minor = minor2;
		classStanding = classStanding2;
	}

	public String getStudentString() {
		return ","+classStanding+","+major+","+minor;
	}
}
