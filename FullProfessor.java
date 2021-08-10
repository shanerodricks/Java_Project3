public class FullProfessor extends AbstractFaculty {

	private int yearsUntilRetirement;

	public FullProfessor(int id, String name, int age, String address, String phoneNumber, int yearArrived,
			String department, int yearlySalary, int numberOfPapers, int yearsUntilRetirement2) {
		 super(id, name, age, address, phoneNumber, yearArrived, department, yearlySalary, numberOfPapers);
		 yearsUntilRetirement = yearsUntilRetirement2;
	}

	@Override
	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "FullProfessor,"+getAffiliateString()+getFacultyString()+
				","+yearsUntilRetirement;
	}

}
