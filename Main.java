import java.util.Scanner;

public final class Main {


    private static Scanner scanner;


    private static int ch;

    public Main() {

    }


    public static void MainFunction() {
		

        
        ch = 0;
        scanner = new Scanner(System.in);

        StudentList.init();

        Boolean isExit = false;
        String temp = "";

        while (true) {
            System.out.println("Student Management System");
            System.out.println(
                    "			==>" + Constants.AddStudent + ". Add student");
            System.out.println("			==>" + Constants.UpdateStudent
                    + ". Update student info");
            /*System.out.println("==>" + Constants.DeleteStudent
                    + ". Delete sudent");*/
            System.out.println("			==>" + Constants.ShowStudent
                    + ". Show student list");
            System.out.println("			==>" + Constants.SortStudent
                    + ". Sort student list");
            System.out.println("			==>" + Constants.Exit + ". Exit");
			System.out.println("\n");

            
            while (true) {
                System.out.print("Please Enter your choice: ");
                temp = scanner.nextLine();
                if (InputChecker.CheckInteger(temp)) {
                    ch = Integer.parseInt(temp);
                    break;
                } else {
                    System.out.println("Sorry, your input contains wrong data type. Try again");
                }
            }
            
            
            switch (ch) {
            case Constants.AddStudent:
                StudentList.addList();
                break;
            case Constants.UpdateStudent:
                StudentList.editList();
                break;
				
				/*
					Error
				*/
            /*case Constants.DeleteStudent:
                StudentList.deleteList();
                break;*/
            case Constants.ShowStudent:
                StudentList.showList();
                break;
            case Constants.SortStudent:
                StudentList.sortList();
                break;
           
            case Constants.Exit:
                isExit = true;
                break;
            default:
                System.out.println("Invalid choice. Try again...");
                break;
            }

            
            if (isExit) {
                break;
            }

            
            clearConsole();
            System.out.println("Press enter to continue...");

            while (temp != null) {
                if (temp.isEmpty()) {
                    break;
                }

                if (scanner.hasNextLine()) {
                    temp = scanner.nextLine();
                } else {
                    temp = null;
                }
            }
        }

        clearConsole();
    }

    public static void clearConsole() {
        System.out.println("-------------------------------------------------");
    }
	
}