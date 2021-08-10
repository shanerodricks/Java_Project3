public class Undergraduate extends AbstractStudent {

	private int numberOfCoursesTaken;
	private int scholarshipAmount;

	public Undergraduate(int id, String name, int age, String address, String phoneNumber, int yearArrived,
			String major, String minor, String classStanding, int numberOfCoursesTaken2, int scholarshipAmount2) {
		super(id, name, age, address, phoneNumber, yearArrived, major, minor, classStanding);
		numberOfCoursesTaken = numberOfCoursesTaken2;
		scholarshipAmount = scholarshipAmount2;
	}

	@Override
	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Undergraduate,"+getAffiliateString()+getStudentString()+
				","+numberOfCoursesTaken+","+scholarshipAmount;
	}

}
