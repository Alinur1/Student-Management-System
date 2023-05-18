/*
	Admin's user name = admin
	Admin's password = 987
*/


import java.util.Scanner;


public class MainActivity{
	public static void main(String[] args){
		
		Scanner input = new Scanner (System.in);
		
		StudentList.init();
		Boolean isExit = false;
		String temp = "";
		
		
		System.out.println("\n\n");
		System.out.println("WELCOME TO THE");
		System.out.println("STUDENT MANAGEMENT SYSTEM");
		
		System.out.println("\n");
		System.out.println("---GROUP MEMBERS---");
		System.out.println("\n1. Md. Alinur Hossain == 20-41855-1");
		System.out.println("2. Hasnayeem Sarker == 18-36462-1");
		System.out.println("3. Sudipta Mani == 18-38177-1");
		System.out.println("\n\n");
		System.out.println("If you are Admin, then press 1 to continue...");
		while(true){
			
			
			System.out.println("			==>1. Admin");
			System.out.println("			==>2. Exit");
			System.out.print("\nEnter your choice: ");
		
			String ch = input.nextLine();
		
			switch(ch){
			
				case "1":{
					
					String user = "admin";
					String password = "987";
					
					String u, p;
					
					
					System.out.print("\nEnter user name: ");
					u = input.nextLine();
					System.out.print("\nEnter the password: ");
					p = input.nextLine();
					
					if(u.equals(user) && p.equals(password)){
						
						System.out.println("\n\n");
						Admin a = new Admin();
						a.login();
						
					}
					else{
						System.out.println("Sorry, wrong credentials, try again...");
						System.out.println("\n\n");
					}
					
					break;
				}					

				case "2":{
					isExit = true;
					break;
				}
		
				default:{
					System.out.println("Invalid choice. Try again...");
					break;
				}
			}
		
			if(isExit){
				break;
			}
		
			
		
			while (temp != null){
				if(temp.isEmpty()){
					break;
				}
			
				if(input.hasNextLine()){
					temp = input.nextLine();
				}
				else{
					temp = null;
				}
			}
		}
		
		clearConsole();
	}
	
	public static void clearConsole(){
		System.out.println();
		System.out.println("------Thanks for using Student Management System-----");
		System.out.println("----------------------------------------------------------");
	}
}