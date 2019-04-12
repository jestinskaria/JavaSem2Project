import java.io.*; 
import java.util.Scanner;
public class StudentData {

	public static void main(String[] args) throws IOException{
		Scanner keyboard = new Scanner(System.in);
	
		int menu;
		menu = MenuDisplay();
		if(menu == 1) {
			WriteStudentData();
		}

	}
	public static int MenuDisplay() {
		int menuOption;
		Scanner keyboard = new Scanner(System.in);
		System.out.println(" -------------------------------------------------------WELECOME TO STUDENT DATA MENU-------------------------------------------------------------------" );
		
		System.out.println("PLEAE SELECT ONE OF THE OPTIONS");
		
		System.out.println("1 --- To Enter new data");
		System.out.println("2 --- To Display All data");
		System.out.println("3 --- To Sort Data");
		System.out.println("4 --- To Search Data");
		System.out.println("5 --- To Edit Data");
		menuOption = keyboard.nextInt();
		return menuOption;
	}
	public static void WriteStudentData() throws IOException {
		
		int noOfDatas;
		double studentId;
	    String firstName;
	    String lastName;
	    String major;
	    String phone;
	    double gpa;
	    String dob;
	    
	   
	
		FileWriter fw =   new FileWriter("D:\\CSAT-SEM2\\JAVA\\FinalProject\\studentData.txt", true);

		 PrintWriter outputFile = new PrintWriter(fw);
		
		   Scanner keyboard = new Scanner(System.in);
		    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		    System.out.println("Enter the number of student datas needs to be added");
		    noOfDatas =  keyboard.nextInt();
		    
		    for(int i=0 ; i<noOfDatas; i++) {
		    System.out.println("Enter the student id:");
		    studentId = Double.parseDouble(input.readLine());
		    System.out.println("Enter student firstName:");
		    firstName = input.readLine();
		    System.out.println("Enter student last Name:");
		    lastName = input.readLine();
		    System.out.println("Enter the student major:");
		    major = input.readLine();
		    System.out.println("Enter the student phone:");
		    phone = input.readLine();
		    System.out.println("Enter the student GPA");
		    gpa = Double.parseDouble(input.readLine());
		    System.out.println("Enter the student DOB");
		    dob = input.readLine();
		    
		    outputFile.println(eid+"_"+firstName+'_'+lastName+'_'+jobTitle+'_'+salary);

	}
	}
}
