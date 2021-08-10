import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	private static HashMap<Integer, AbstractAffiliate> affiliatesByID;

	public static void main(String[] args) throws IOException {

		affiliatesByID = new HashMap<>();

	
		int input = 0;
		while (input != 7) {
			System.out.println("Enter a number 1-7:");
			System.out.println("1)	Create an affiliate record");
			System.out.println("2)	Print information for an Affiliate given the id");
			System.out.println("3)	List all affiliates in order of seniority");
			System.out.println("4)	Delete a record given the id");
			System.out.println("5)	Save your database to a file");
			System.out.println("6)	Restore your database from a file");
			System.out.println("7)	Exit");
			Scanner scnr = new Scanner(System.in);
			input = scnr.nextInt();
			System.out.println(input);
			if (input < 1 || input > 7) {
				System.out.println("ERROR: number must be between 1 and 7");
				continue;
			}

			if (input == 1) {
				createAffiliateRecord();
			} else if (input == 2) {
				printAffiliateGivenID();
			} else if (input == 3) {
				listInOrderOfSenority();
			} else if (input == 4) {
				deleteRecordByID();
			} else if (input == 5) {
				saveToFile();
			} else if (input == 6) {
				getDBFromFile();
			}
		}

	}

	private static void getDBFromFile() throws FileNotFoundException {
		String filename = getStringFromUser("file name");
		File file = new File(filename);
		Scanner scnr = new Scanner(file);

		while(scnr.hasNext()) {
			String line = scnr.nextLine();
			String[] tokens = line.split(",");
			AbstractAffiliate a = constructAffiliateFromTokens(tokens);
			affiliatesByID.put(a.getId(), a);
		}
	}

	private static AbstractAffiliate constructAffiliateFromTokens(String[] tokens) {
		AbstractAffiliate a = null;
		String className = tokens[0];
		String address = tokens[1];
		int age = Integer.valueOf(tokens[2]);
		int id = Integer.valueOf(tokens[3]);
		String name = tokens[4];
		String phoneNumber = tokens[5];
		int yearArrived = Integer.parseInt(tokens[6]);

		if(className.equals("AssistantProfessor")) {
			String department = tokens[7];
			int numberOfPapers = Integer.parseInt(tokens[8]);
			int yearlySalary = Integer.parseInt(tokens[9]);
			int yearsUntilTenure = Integer.parseInt(tokens[10]);
			a = new AssistantProfessor(id, name, age, address, phoneNumber, yearArrived,
					department, yearlySalary, numberOfPapers,
					yearsUntilTenure);
		}
		else if(className.equals("AssociateProfessor")) {
			String department = tokens[7];
			int numberOfPapers = Integer.parseInt(tokens[8]);
			int yearlySalary = Integer.parseInt(tokens[9]);
			int yearsSinceTenure = Integer.parseInt(tokens[10]);
			a = new AssociateProfessor(id, name, age, address, phoneNumber, yearArrived,
					department, yearlySalary, numberOfPapers,
					yearsSinceTenure);
		}
		else if(className.equals("FullProfessor")) {
			String department = tokens[7];
			int numberOfPapers = Integer.parseInt(tokens[8]);
			int yearlySalary = Integer.parseInt(tokens[9]);
			int yearsUntilRetirement = Integer.parseInt(tokens[10]);
			a = new FullProfessor(id, name, age, address, phoneNumber, yearArrived,
					department, yearlySalary, numberOfPapers,
					yearsUntilRetirement);
		}
		else if(className.equals("Undergraduate")) {
			String classStanding = tokens[7];
			String major = tokens[8];
			String minor = tokens[9];

			int numCoursesTaken = Integer.parseInt(tokens[10]);
			int scholarshipAmount = Integer.parseInt(tokens[11]);

			a = new Undergraduate(id, name, age, address, phoneNumber, yearArrived,
					major, minor,classStanding,
					numCoursesTaken,scholarshipAmount);
		}
		else if(className.equals("GraduateStudent")) {
			String classStanding = tokens[7];
			String major = tokens[8];
			String minor = tokens[9];

			int numPapersPublished = Integer.parseInt(tokens[10]);
			String thesisAdvisor = tokens[11];

			a = new GraduateStudent(id, name, age, address, phoneNumber, yearArrived,
					major, minor,classStanding,
					numPapersPublished,thesisAdvisor);
		}
		else if(className.equals("FullTimeStaff")) {
			String building = tokens[7];
			String title = tokens[8];

			int yearlySalary = Integer.parseInt(tokens[9]);

			a = new FullTimeStaff(id, name, age, address, phoneNumber, yearArrived,
					title, building,
					yearlySalary);
		}
		else if(className.equals("PartTimeStaff")) {
			String building = tokens[7];
			String title = tokens[8];

			int hourlySalary = Integer.parseInt(tokens[9]);

			a = new PartTimeStaff(id, name, age, address, phoneNumber, yearArrived,
					title, building,
					hourlySalary);
		}
		return a;
	}

	private static void saveToFile() throws IOException {
		String filename = getStringFromUser("file name");
		FileWriter writer = new FileWriter(filename);
		for(AbstractAffiliate a : affiliatesByID.values()) {
			writer.write(a.toString() + "\n");
		}
		writer.close();
	}

	private static void deleteRecordByID() {
		int id = getIntFromUser("id");
		affiliatesByID.remove(id);
	}

	private static void listInOrderOfSenority() {
		ArrayList<AbstractAffiliate> sorted = sort();
		for(AbstractAffiliate a : sorted) {
			a.print();
		}
	}

	private static ArrayList<AbstractAffiliate> sort() {
		ArrayList<AbstractAffiliate> sorted = new ArrayList<>();
		for(AbstractAffiliate a : affiliatesByID.values()) {
			sorted.add(a);
		}
		Collections.sort(sorted);
		return sorted;
	}

	private static void printAffiliateGivenID() {
		int id = getIntFromUser("id");
		affiliatesByID.get(id).print();
	}

	private static void createAffiliateRecord() {
		AbstractAffiliate affiliate = null;
		System.out.println("Enter a number 1-7 for which affiliate type you would like to create:");
		System.out.println("1) Assistant Professor");
		System.out.println("2) Associate Professor");
		System.out.println("3) Full Professor");
		System.out.println("4) Undergraduate");
		System.out.println("5) Graduate Student");
		System.out.println("6) Full Time Staff");
		System.out.println("7) Part Time Staff");
		int input = 0;
		Scanner scnr = new Scanner(System.in);
		input = scnr.nextInt();

		if (input < 1 || input > 7) {
			System.out.println("ERROR: number must be between 1 and 7");
			createAffiliateRecord();
			return;
		}

		int id = getIntFromUser("id");
		String name = getStringFromUser("name");
		int age = getIntFromUser("age");
		String address = getStringFromUser("address");
		String phoneNumber = getStringFromUser("phone number");
		int yearArrived = getIntFromUser("year arrived");

		if (input == 1 || input == 2 || input == 3) {

			String department = getStringFromUser("department");
			int yearlySalary = getIntFromUser("yearly salary");
			int numberOfPapers = getIntFromUser("number of papers");
			if(input == 1) {
				int yearsUntilTenure = getIntFromUser("years until tenure");
				affiliate = new AssistantProfessor(id, name, age, address, phoneNumber, yearArrived,
						department, yearlySalary, numberOfPapers,
						yearsUntilTenure);
			}
			else if(input == 2) {
				int yearsSinceTenure = getIntFromUser("years since tenure");
				affiliate = new AssociateProfessor(id, name, age, address, phoneNumber, yearArrived,
						department, yearlySalary, numberOfPapers,
						yearsSinceTenure);
			}
			else if(input == 3) {
				int yearsUntilRetirement = getIntFromUser("years until retirement");
				affiliate = new FullProfessor(id, name, age, address, phoneNumber, yearArrived,
						department, yearlySalary, numberOfPapers,
						yearsUntilRetirement);
			}

		} else if (input == 4 || input == 5) {
			String major = getStringFromUser("major");
			String minor = getStringFromUser("minor");
			String classStanding = getStringFromUser("class standing");
			if(input == 4) {
				int numberOfCoursesTaken = getIntFromUser("number of courses taken");
				int scholarshipAmount = getIntFromUser("scholarship amount");
				affiliate = new Undergraduate(id, name, age, address, phoneNumber, yearArrived,
						major,minor,classStanding,
						numberOfCoursesTaken,scholarshipAmount);
			}
			else if(input == 5) {
				int numberOfPapersPublished = getIntFromUser("number of papers published");
				String thesisAdvisor = getStringFromUser("thesis advisor");
				affiliate = new GraduateStudent(id, name, age, address, phoneNumber, yearArrived,
						major,minor,classStanding,
						numberOfPapersPublished,thesisAdvisor);
			}
		} else if (input == 6 || input == 7) {
			String title = getStringFromUser("title");
			String building = getStringFromUser("building");
			if(input == 6) {
				int yearlySalary = getIntFromUser("yearly salary");
				affiliate = new FullTimeStaff(id, name, age, address, phoneNumber, yearArrived,
						title,building,
						yearlySalary);
			}
			else if(input == 7) {
				int hourlySalary = getIntFromUser("hourly salary");
				affiliate = new PartTimeStaff(id, name, age, address, phoneNumber, yearArrived,
						title,building,
						hourlySalary);
			}
		}
		affiliatesByID.put(id, affiliate);
	}

	private static String getStringFromUser(String inputPrompt) {
		System.out.println("Please enter " + inputPrompt + ":");
		Scanner scnr = new Scanner(System.in);
		String response = scnr.nextLine();
		return response;
	}

	private static int getIntFromUser(String inputPrompt) {
		System.out.println("Please enter " + inputPrompt + ":");
		Scanner scnr = new Scanner(System.in);
		int response = scnr.nextInt();
		return response;
	}

}
