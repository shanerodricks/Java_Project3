public class AssistantProfessor extends AbstractFaculty {

	private int yearsUntilTenure;

	public AssistantProfessor(int id, String name, int age, String address, String phoneNumber, int yearArrived,
			String department, int yearlySalary, int numberOfPapers, int yearsUntilTenure2) {
		super(id, name, age, address, phoneNumber, yearArrived, department, yearlySalary, numberOfPapers);
		yearsUntilTenure = yearsUntilTenure2;
	}

	@Override
	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "AssistantProfessor,"+getAffiliateString()+getFacultyString()+
				","+yearsUntilTenure;
	}

}
