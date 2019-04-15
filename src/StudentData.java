import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class StudentData {

	public static void main(String[] args) throws IOException, ParseException{
	
	/* Calling Method to load control menu*/
		 ProgramControl() ;

	}
	
	/*  Method to load control menu*/
	
	public static void ProgramControl() throws IOException, ParseException {
		int menu;
		menu = MenuDisplay();
		if(menu == 1) {
	/* Calling Method to write data to file*/		
			WriteStudentData();
		}else if(menu==2) {
	/* Calling Method to read data from file*/			
			ReadStudentData();
		}
		else if(menu==3) {
	/* Calling Method to get sort menu*/			
			SortStudentDataMenu();
		}
		else if(menu==4) {
			SearchStudentDataMenu();
		}
		else if(menu==5) {
			EditStudentDataMenu();
		}
		else if(menu==6) {
			System.out.println(" THANK YOU");
		}
	}
	
	// Function to display menu
	public static int MenuDisplay() {
		int menuOption;
		Scanner keyboard = new Scanner(System.in);
		System.out.println(" -------------------------------------------------------WELECOME TO STUDENT DATA MENU-------------------------------------------------------------------" );
		
		System.out.println("PLEAE SELECT ONE OF THE OPTIONS");
		System.out.println("-----------------------------------");
		System.out.println("1 <--->To Enter new data");
		System.out.println("2 <---> To Display All data");
		System.out.println("3 <---> To Sort Data");
		System.out.println("4 <---> To Search Data");
		System.out.println("5 <---> To Edit Data");
		System.out.println("6 <---> End Program");
		System.out.println("-----------------------------------");
		menuOption = keyboard.nextInt();
		return menuOption;
	}
	
	//  Function to write data to file
	public static void WriteStudentData() throws IOException, ParseException {
		
		int noOfDatas;
		String studentId;
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
		    studentId = input.readLine();
		    System.out.println("Enter student firstName:");
		    firstName = input.readLine();
		    System.out.println("Enter student last Name:");
		    lastName = input.readLine();
		    System.out.println("Enter the student major:");
		    major = input.readLine();
		    System.out.println("Enter the student phone:");
		    phone = input.readLine();
		    System.out.println("Enter the student GPA:");
		    gpa = Double.parseDouble(input.readLine());
		    System.out.println("Enter the student DOB (yyyy-mm-dd):");
		    dob = input.readLine();
		    
	/* Formatting date format using Date class */
		    SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = oldFormat.parse(dob);
		    SimpleDateFormat newFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
		    String formatDOB = newFormat.format(date);
	
	/* Writing data to file */
		    
		    outputFile.println(studentId+"_"+firstName+'_'+lastName+'_'+major+'_'+phone+'_'+gpa+'_'+formatDOB);

	}
		    outputFile.close(); 
		    
		    System.out.println("All data stored to file successfully");
		    
		    ProgramControl();
	}
	
	// Function to read data from file
	
	public static void ReadStudentData() throws IOException, ParseException{
		
		Scanner keyboard = new Scanner(System.in);
        File myFile = new File("D:\\CSAT-SEM2\\JAVA\\FinalProject\\studentData.txt");
		
		 Scanner inputFile = new Scanner(myFile); 
		
		  ArrayList<Student> studentList = new ArrayList<Student>();
		
		
		while (inputFile.hasNext())
		{
		   String str = inputFile.nextLine();
		   String[] data = str.split("_");
		  
		   studentList.add(new Student(data[0],data[1],data[2],data[3],data[4],Double.parseDouble(data[5]),data[6]));
		   
		   
		}
		inputFile.close();
		 printStudentData(studentList,2);
		
	}
	
	
	// Function to print student data
	public static void printStudentData(ArrayList<Student>studentList,int option)throws IOException, ParseException
    {
		// Print the list objects in tabular format.
	    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	    System.out.printf("%10s %30s %20s %15s %15s  %15s %15s ", "STUDENT ID", "FIRST NAME", "LAST NAME", "MAJOR", "PHONE","GPA","DOB");
	    System.out.println();
	    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	    for(Student details: studentList){
	        System.out.format("%10s %30s %20s %15s %20s %10s %20s",
	        		details.getId(), details.getFirstName(), details.getLastName(), details.getMajor(), details.getPhone(),details.getGPA(),details.getDOB());
	        System.out.println();
	        System.out.println();
	    }
	    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	    
	    if(option ==2) {
	    ProgramControl();
	    }
	    else if (option ==3) {
	    	SortStudentDataMenu();
	    }
		
    }
	
	public static void SortStudentDataMenu() throws IOException, ParseException{
		Scanner keyboard = new Scanner(System.in);
		int sortMenu;
		System.out.println("PLEAE SELECT ONE OF THE OPTIONS");
		System.out.println("-----------------------------------");
		System.out.println("1 <--->To Sort by First Name Ascending");
		System.out.println("2 <--->To Sort by First Name Descending");
		System.out.println("3 <--->To Sort by Last Name Ascending");
		System.out.println("4 <--->To Sort by Last Name Descending");
		System.out.println("5 <--->To Sort by Major Ascending");
		System.out.println("6 <--->To Sort by Major Descending");
		System.out.println("7 <---> Back to Main Menu");
		System.out.println("-----------------------------------------");
		
		
        File myFile = new File("D:\\CSAT-SEM2\\JAVA\\FinalProject\\studentData.txt");
		
		 Scanner inputFile = new Scanner(myFile); 
		
		  ArrayList<Student> studentListForSort = new ArrayList<Student>();
		
		
		while (inputFile.hasNext())
		{
		   String str = inputFile.nextLine();
		   String[] data = str.split("_");
		  
		   studentListForSort.add(new Student(data[0],data[1],data[2],data[3],data[4],Double.parseDouble(data[5]),data[6]));
		   
		   
		}
		inputFile.close();
		sortMenu = keyboard.nextInt();
		if(sortMenu ==1) {
			SortByFirstNameAZ(studentListForSort);
			printStudentData(studentListForSort,3);
		}
		else if(sortMenu ==2) {
			SortByFirstNameZA(studentListForSort);
			printStudentData(studentListForSort,3);
		}
		else if(sortMenu ==3) {
			SortByLastNameAZ(studentListForSort);
			printStudentData(studentListForSort,3);
		}
		else if(sortMenu ==4) {
			SortByLastNameZA(studentListForSort);
			printStudentData(studentListForSort,3);
		}
		else if(sortMenu ==5) {
			SortByMajorAZ(studentListForSort);
			printStudentData(studentListForSort,3);
		}
		else if(sortMenu ==6) {
			SortByMajorZA(studentListForSort);
			printStudentData(studentListForSort,3);
		}
		else if(sortMenu ==7) {
			  ProgramControl();
		}
		
	}
	
	 public static void SortByFirstNameAZ(ArrayList<Student>stdList)
	    {
	        Student temp;
	        for(int i = 0; i < stdList.size() -1; i++)
	            for(int j= i+1; j < stdList.size(); j++)
	            {
	                if(stdList.get(i).getFirstName().compareTo(stdList.get(j).getFirstName()) > 0)
	                {
	                    temp =  stdList.get(i);
	                    stdList.set(i,stdList.get(j));
	                    stdList.set(j,temp);
	                }
	            }
	    }
	 
	 public static void SortByFirstNameZA(ArrayList<Student>stdList)
	    {
	        Student temp;
	        for(int i = 0; i < stdList.size() -1; i++)
	            for(int j= i+1; j < stdList.size(); j++)
	            {
	                if(stdList.get(i).getFirstName().compareTo(stdList.get(j).getFirstName()) < 0)
	                {
	                    temp =  stdList.get(i);
	                    stdList.set(i,stdList.get(j));
	                    stdList.set(j,temp);
	                }
	            }
	    }
	 public static void SortByLastNameAZ(ArrayList<Student>stdList)
	    {
	        Student temp;
	        for(int i = 0; i < stdList.size() -1; i++)
	            for(int j= i+1; j < stdList.size(); j++)
	            {
	                if(stdList.get(i).getLastName().compareTo(stdList.get(j).getLastName()) > 0)
	                {
	                    temp =  stdList.get(i);
	                    stdList.set(i,stdList.get(j));
	                    stdList.set(j,temp);
	                }
	            }
	    }
	 public static void SortByLastNameZA(ArrayList<Student>stdList)
	    {
	        Student temp;
	        for(int i = 0; i < stdList.size() -1; i++)
	            for(int j= i+1; j < stdList.size(); j++)
	            {
	                if(stdList.get(i).getLastName().compareTo(stdList.get(j).getLastName()) < 0)
	                {
	                    temp =  stdList.get(i);
	                    stdList.set(i,stdList.get(j));
	                    stdList.set(j,temp);
	                }
	            }
	    }
	 
	 public static void SortByMajorAZ(ArrayList<Student>stdList)
	    {
	        Student temp;
	        for(int i = 0; i < stdList.size() -1; i++)
	            for(int j= i+1; j < stdList.size(); j++)
	            {
	                if(stdList.get(i).getMajor().compareTo(stdList.get(j).getMajor()) > 0)
	                {
	                    temp =  stdList.get(i);
	                    stdList.set(i,stdList.get(j));
	                    stdList.set(j,temp);
	                }
	            }
	    }
	 public static void SortByMajorZA(ArrayList<Student>stdList)
	    {
	        Student temp;
	        for(int i = 0; i < stdList.size() -1; i++)
	            for(int j= i+1; j < stdList.size(); j++)
	            {
	                if(stdList.get(i).getMajor().compareTo(stdList.get(j).getMajor()) < 0)
	                {
	                    temp =  stdList.get(i);
	                    stdList.set(i,stdList.get(j));
	                    stdList.set(j,temp);
	                }
	            }
	    }
	  
	
	 
	 public static void SearchStudentDataMenu() throws IOException, ParseException{
			Scanner keyboard = new Scanner(System.in);
			int searchMenu;
			System.out.println("PLEAE SELECT ONE OF THE OPTIONS");
			System.out.println("-----------------------------------");
			System.out.println("1 <--->To Search by Student Id");
			System.out.println("2 <--->To Search by Last Name ");
			System.out.println("3 <--->To Search by Major ");
			System.out.println("4 <---> Back to Main Menu");
			System.out.println("-----------------------------------------");
			
			
	        File myFile = new File("D:\\CSAT-SEM2\\JAVA\\FinalProject\\studentData.txt");
			
			 Scanner inputFile = new Scanner(myFile); 
			
			  ArrayList<Student> studentListForSearch = new ArrayList<Student>();
			
			
			while (inputFile.hasNext())
			{
			   String str = inputFile.nextLine();
			   String[] data = str.split("_");
			  
			   studentListForSearch.add(new Student(data[0],data[1],data[2],data[3],data[4],Double.parseDouble(data[5]),data[6]));
			   
			   
			}
			inputFile.close();
			searchMenu = keyboard.nextInt();
			if(searchMenu ==1) {
				SearchByStudentId(studentListForSearch);
				
			}
			else if(searchMenu ==2) {
				SearchByLastName(studentListForSearch);
				
			}
			else if(searchMenu ==3) {
				SearchByMajor(studentListForSearch);
				
			}
			else if(searchMenu ==4) {
				 ProgramControl();
			}
			
			
			
		}
	 
	 
	 public static void SearchByStudentId(ArrayList<Student>stdList) throws IOException, ParseException
	    {
		 Scanner keyboard = new Scanner(System.in);   
		 String  studentId;
		 int foundFlag = -1;
	        System.out.println("PLEAE ENTER THE STUDENT ID NEEDS TO BE SEARCHED :");
	        studentId = keyboard.nextLine();
	        studentId.trim();
	        
	        for(Student details: stdList){
	        	if(details.getId().length() == studentId.length()) {
	        	
	        		if(details.getId().compareToIgnoreCase(studentId)==0) {
	        			
	        			 System.out.println("STUDENT DATA FOUND");
	        			 
	        			 System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	        			    System.out.printf("%10s %30s %20s %15s %15s  %15s %15s ", "STUDENT ID", "FIRST NAME", "LAST NAME", "MAJOR", "PHONE","GPA","DOB");
	        			    System.out.println();
	        			    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	        			    System.out.format("%10s %30s %20s %15s %20s %10s %20s",
	        		        		details.getId(), details.getFirstName(), details.getLastName(), details.getMajor(), details.getPhone(),details.getGPA(),details.getDOB());
	        		        System.out.println();
	        		        foundFlag =0;
	        		}
	        		
	        			
	        		}
	        }
	        if(foundFlag ==-1) {
	        	
        			System.out.println("---------STUDENT DATA NOT FOUND----------");
        		
	        }
	        SearchStudentDataMenu();
	        }
	    
	 
	 
	 public static void SearchByLastName(ArrayList<Student>stdList) throws IOException, ParseException
	    {
		 Scanner keyboard = new Scanner(System.in);   
		 String  lName;
		 int foundFlag = -1;
	        System.out.println("PLEAE ENTER THE STUDENT LAST NAME NEEDS TO BE SEARCHED :");
	        lName = keyboard.nextLine();
	        lName.trim();
	        
	        for(Student details: stdList){
	        	if(details.getLastName().length() == lName.length()) {
	        	
	        		if(details.getLastName().compareToIgnoreCase(lName)==0) {
	        			
	        			 System.out.println("STUDENT DATA FOUND");
	        			 
	        			 System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	        			    System.out.printf("%10s %30s %20s %15s %15s  %15s %15s ", "STUDENT ID", "FIRST NAME", "LAST NAME", "MAJOR", "PHONE","GPA","DOB");
	        			    System.out.println();
	        			    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	        			    System.out.format("%10s %30s %20s %15s %20s %10s %20s",
	        		        		details.getId(), details.getFirstName(), details.getLastName(), details.getMajor(), details.getPhone(),details.getGPA(),details.getDOB());
	        		        System.out.println();
	        		        foundFlag =0;
	        		}
	        		
	        			
	        		}
	        }
	        if(foundFlag ==-1) {
	        	
     			System.out.println("---------STUDENT DATA NOT FOUND----------");
     		
	        }
	        SearchStudentDataMenu();
	        }
	 public static void SearchByMajor(ArrayList<Student>stdList) throws IOException, ParseException
	    {
		 Scanner keyboard = new Scanner(System.in);   
		 String  mjr;
		 int foundFlag = -1;
	        System.out.println("PLEAE ENTER THE STUDENT MAJOR NEEDS TO BE SEARCHED :");
	        mjr = keyboard.nextLine();
	        mjr.trim();
	        
	        for(Student details: stdList){
	        	if(details.getMajor().length() == mjr.length()) {
	        	
	        		if(details.getMajor().compareToIgnoreCase(mjr)==0) {
	        			
	        			 System.out.println("STUDENT DATA FOUND");
	        			   
	        				
	        			 System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	        			    System.out.printf("%10s %30s %20s %15s %15s  %15s %15s ", "STUDENT ID", "FIRST NAME", "LAST NAME", "MAJOR", "PHONE","GPA","DOB");
	        			    System.out.println();
	        			    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	        			    System.out.format("%10s %30s %20s %15s %20s %10s %20s",
	        		        		details.getId(), details.getFirstName(), details.getLastName(), details.getMajor(), details.getPhone(),details.getGPA(),details.getDOB());
	        		        System.out.println();
	        		        foundFlag =0;
	        		}
	        		
	        			
	        		}
	        }
	        if(foundFlag ==-1) {
	        	
     			System.out.println("---------STUDENT DATA NOT FOUND----------");
     		
	        }
	        SearchStudentDataMenu();
	        }
	 public static void EditStudentDataMenu() throws IOException, ParseException {
		 
		 Scanner keyboard = new Scanner(System.in);   
		 int saveOption;
		 String editedStudentFname;
		 String editedStudentLname;
		 String editedPhone;
		 String editedMajor;
		 String editedDOB;
		 String editedGPA;
		 int fileWriteFlag = 0;
		 
		 String  studentId;
		  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
	        System.out.println("PLEAE ENTER THE ID OF STUDENT :");
	        studentId = keyboard.nextLine();
	        
	        File myFile = new File("D:\\CSAT-SEM2\\JAVA\\FinalProject\\studentData.txt");
			
			 Scanner inputFile = new Scanner(myFile); 
			
			  ArrayList<Student> studentList = new ArrayList<Student>();
			
			
			while (inputFile.hasNext())
			{
			   String str = inputFile.nextLine();
			   String[] data = str.split("_");
			  if(studentId.compareToIgnoreCase(data[0])==0) {
				
				System.out.println("STUDENT DATA FOUND, SELECT FROM FOLLOWING OPTIONS");
  			    System.out.println("1 <--->To Edit Student  First Name");
  				System.out.println("2 <--->To Edit Student  Last Name");
  				System.out.println("3 <--->To Edit Student   MAJOR");
  				System.out.println("4 <---> To Edit Student  PHONE NO");
  				System.out.println("5 <---> To Edit Student  GPA");
  				System.out.println("6 <---> To Edit Student  DOB");
  				System.out.println("7 <---> To EXIT");
  				
  				saveOption = Integer.parseInt(input.readLine());
  				if(saveOption == 1) {
  					System.out.println("Enter First Name:");
  					editedStudentFname = input.readLine();
  					data[1] = editedStudentFname;
  				
  				}else if(saveOption == 2) {
  					System.out.println("Enter Last Name:");
  					editedStudentLname = input.readLine();
  					data[2] = editedStudentLname;
  				
  				}
  				else if(saveOption == 3) {
  					System.out.println("Enter Student Major:");
  					editedMajor = input.readLine();
  					data[3] = editedMajor;
  					
  				}
  				else if(saveOption == 4) {
  					System.out.println("Enter Student  MAJOR:");
  					editedPhone =input.readLine();
  					data[4] = editedPhone;
  				
  				}
  				else if(saveOption == 5) {
  					System.out.println("Enter Student  GPA:");
  					editedGPA = input.readLine();
  					data[5] = editedGPA;
  				
  				}
  				else if(saveOption == 6) {
  					System.out.println("Enter Student  DOB(yyyy-mm-dd):");
  					editedDOB = input.readLine();
  				    
  					/* Formatting date format using Date class */
  						    SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd");
  						    Date date = oldFormat.parse(editedDOB);
  						    SimpleDateFormat newFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
  						    String formatedEditedDOB = newFormat.format(date);
  					data[6] = formatedEditedDOB;
  				
  				}
  				else if (saveOption == 7) {
  					 ProgramControl();
  				}
  				if(saveOption != 7) {
  	 			 studentList.add(new Student(data[0],data[1],data[2],data[3],data[4],Double.parseDouble(data[5]),data[6]));
	
  				}
  				fileWriteFlag = 1;

			  }else {
	  	 		 studentList.add(new Student(data[0],data[1],data[2],data[3],data[4],Double.parseDouble(data[5]),data[6]));

			  }
			  
			   
			   
			}
			inputFile.close();
			if(fileWriteFlag ==1) {
				myFile.delete();
				
				FileWriter fw =   new FileWriter("D:\\CSAT-SEM2\\JAVA\\FinalProject\\studentData.txt", true);

				 PrintWriter outputFile = new PrintWriter(fw);
				 for(Student details: studentList){
					 outputFile.println(details.getId()+"_"+details.getFirstName()+'_'+details.getLastName()+'_'+details.getMajor()+'_'+details.getPhone()+'_'+details.getGPA()+'_'+details.getDOB());
				 }
				  outputFile.close(); 
				    
				    System.out.println("Data updated successfully");
				    
				    ProgramControl();
				
			}else {
				System.out.println("Sorry Student Id not found");
				 ProgramControl();
			}
	 }
}
