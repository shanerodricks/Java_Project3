public class GraduateStudent extends AbstractStudent {

	private int numberOfPapersPublished;
	private String thesisAdvisor;

	public GraduateStudent(int id, String name, int age, String address, String phoneNumber, int yearArrived,
			String major, String minor, String classStanding, int numberOfPapersPublished2, String thesisAdvisor2) {
		super(id, name, age, address, phoneNumber, yearArrived, major, minor, classStanding);
		numberOfPapersPublished = numberOfPapersPublished2;
		thesisAdvisor = thesisAdvisor2;
	}

	@Override
	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "GraduateStudent,"+getAffiliateString()+getStudentString()+
				","+numberOfPapersPublished+","+thesisAdvisor;
	}

}
