import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class StudentList {

  
    private static int choice;

  
    private static Scanner input;
	
	
	Student[] students;
	int studentCount;
	
	
	public StudentList(){
		students = new Student[5000];	                            
		studentCount = 0;
	}
	
	

 
    private static ArrayList<Student> listStudent = new ArrayList<Student>();

  
    public static boolean isEmptyList() {
        return (listStudent.size() == 0);
    }

  
    public static boolean isIDExisted(final int id) {
       
        for (Student student : listStudent) {
            if (student.getID() == id) {
                return true;
            }
        }

        return false;
    }

   

  
    public static void init() {
        choice = 0;
        input = new Scanner(System.in);
        listStudent.clear();
    }

 
    public static void editList() {
        
      
        String tempString = "";
        int studentID = 0;

        while (true) {
            System.out.print("Enter Student ID: ");
            tempString = input.nextLine();

            if (InputChecker.CheckInteger(tempString)) {
                studentID = Integer.parseInt(tempString);
                break;
            }

            System.out.println("Sorry, your input contains wrong data type. Try again.");
        }

       
        if (isIDExisted(studentID)) {
            listStudent.add(createStudent(false));
            System.out.println("Successfully added");
        } else {
            System.out.println("Student ID does not exist");
        }
    }
	
	public void addStudent(Student student){
		students[studentCount++] = student;
	}


    public static void addList() {
        Student newStudent = createStudent(true);

        listStudent.add(newStudent);

        System.out.println("Add student successful");
    }

 
    private static Student createStudent(final boolean isCheckID) {

        
        Student newStudent = new Student();
        String tempString = "";

        while (true) {
            System.out.print("Student ID: ");
            tempString = input.nextLine();
            if (InputChecker.CheckInteger(tempString)) {
                int id = Integer.parseInt(tempString);
                if (isCheckID) {
                    if (isIDExisted(id)) {
                        System.out.println("This ID already existed");
                    } else {
                        newStudent.setID(id);
                        break;
                    }
                } else {
                    break;
                }
            } else {
                System.out.println("Sorry, your input contains wrong data type. Try again");
            }
        }

       
        while (true) {
            System.out.print("Student name: ");
            tempString = input.nextLine();
            if (tempString.length() != 0) {
                newStudent.setName(tempString);
                break;
            } else {
                System.out.println("Sorry, your input contains wrong data type. Try again");
            }
        }

       
        while (true) {
            System.out.print("Student marks: ");
            tempString = input.nextLine();
            if (InputChecker.CheckFloat(tempString)) {
                newStudent.setMarks(Float.parseFloat(tempString));
                break;
            } else {
                System.out.println("Sorry, your input contains wrong data type. Try again");
            }
        }

       
        while (true) {
            System.out.print("Student mobile number: ");
            tempString = input.nextLine();
            if (tempString.length() != 0) {
                newStudent.setMobileNo(tempString);
                break;
            } else {
                System.out.println("Sorry, your input contains wrong data type. Try again");
            }
        }

      
        while (true) {
            System.out.print("Student address: ");
            tempString = input.nextLine();
            if (tempString.length() != 0) {
                newStudent.setAddress(tempString);
                break;
            } else {
                System.out.println("Sorry, your input contains wrong data type. Try again");
            }
        }

      
        while (true) {
            System.out.print("Student description: ");
            tempString = input.nextLine();
            if (tempString.length() != 0) {
                newStudent.setDescription(tempString);
                break;
            } else {
                System.out.println("Sorry, your input contains wrong data type. Try again");
            }
        }

        
        return newStudent;
    }

    /*public static void deleteList() {
        
        
        String tempString = "";
        int studentID = 0;

        
        while (true) {
            System.out.print("Student ID: ");
            tempString = input.nextLine();

            if (InputChecker.CheckInteger(tempString)) {
                studentID = Integer.parseInt(tempString);
                break;
            }
            System.out.println("Sorry, your input contains wrong data type. Try again");
        }

       
        if (isIDExisted(studentID)) {
            listStudent.remove(studentID);
            System.out.println("Delete successful");
        } else {
            System.out.println("Student ID does not exist");
        }

    }*/
  
    public static void showList() {

        int size = listStudent.size();

        for (int i = 0; i < size; i++) {
			System.out.println("\n");
            System.out.println("			Student No." + (i + 1));
            System.out.println(listStudent.get(i).toString());
        }
    }

   
    public static void sortList() {

        System.out.println("			1." + Constants.SortInCodeFunction
                + ". Sort ascending by student ID.");
        System.out.println("			2." + Constants.SortOutCodeFunction
                + ". Sort descending by student ID.");
        System.out.println("			3." + Constants.SortInPointFunction
                + ". Sort ascending by student score.");
        System.out.println("			4." + Constants.SortOutPointFunction
                + ". Sort descending by student score.");

      
        while (true) {
            try {
                System.out.print("Your choice : ");
                choice = input.nextInt();
                input.nextLine();

                break;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input data");
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter data");
            }
        }

        switch (choice) {
        case Constants.SortInCodeFunction:
            SortStudentList.sortIDIncrease(listStudent);
            System.out.println("Sort success");
            break;
        case Constants.SortOutCodeFunction:
            SortStudentList.sortIDDecrease(listStudent);
            System.out.println("Sort success");
            break;
        case Constants.SortInPointFunction:
            SortStudentList.sortScoreIncrease(listStudent);
            System.out.println("Sort success");
            break;
        case Constants.SortOutPointFunction:
            SortStudentList.sortScoreDecrease(listStudent);
            System.out.println("Sort success");
            break;
        default:
            System.out.println("Invalid choice");
            break;
        }

    }

}