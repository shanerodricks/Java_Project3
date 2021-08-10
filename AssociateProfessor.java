public class AssociateProfessor extends AbstractFaculty {

	private int yearsSinceTenure;

	public AssociateProfessor(int id, String name, int age, String address, String phoneNumber, int yearArrived,
			String department, int yearlySalary, int numberOfPapers, int yearsSinceTenure) {
		super(id, name, age, address, phoneNumber, yearArrived, department, yearlySalary, numberOfPapers);
		this.yearsSinceTenure = yearsSinceTenure;
	}

	@Override
	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "AssociateProfessor,"+getAffiliateString() + getFacultyString()+
				","+yearsSinceTenure;
	}

}
