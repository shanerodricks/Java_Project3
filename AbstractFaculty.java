public abstract class AbstractFaculty extends AbstractAffiliate {
	private String department;
	private int yearlySalary;
	private int numberOfPapers;

	public AbstractFaculty(int id, String name, int age, String address, String phoneNumber, int yearArrived,
			String department2, int yearlySalary2, int numberOfPapers2) {
		super(id, name, age, address, phoneNumber, yearArrived);
		department = department2;
		yearlySalary = yearlySalary2;
		numberOfPapers = numberOfPapers2;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearlySalary() {
		return yearlySalary;
	}

	public int getNumberOfPapers() {
		return numberOfPapers;
	}

	public String getFacultyString() {
		return ","+getDepartment()+","+getNumberOfPapers()+","+getYearlySalary();
	}
}
