package com.main;

import java.util.Scanner;

import com.model.Employee;
import com.service.ServicesMethods;

public class MainClass {

	public static void main(String[] args) {
		ServicesMethods service=new ServicesMethods();
		try(Scanner sc= new Scanner(System.in);){
			
			boolean isRunning=true;
			while (isRunning) {

				System.out.println("========================================\nEnter your Choice \n 1. Insert emplyee data \n 2. Show All employee data \n "
						+ "3. Show Employee data by id \n 4. Delete employee \n 5. Update employee data \n 6. Exit\n ===================================");
				
				int choice=Integer.parseInt(sc.nextLine());
				
				switch (choice) {
				
				case 1:
					System.out.println("Enter name ,location and salary of an Employee");
//					new Employee(sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine()));
					service.InsertEmployee(new Employee(sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine())));
					break;
				case 2:
					System.out.println("Displaying All Employee Data................");
					service.displayAll();
					break;
				case 3:System.out.println("Enter employee id to view details");
				service.getEmployeebyId(Integer.parseInt(sc.nextLine()));
				
					break;
				case 4:System.out.println("Enter employee id to delete the record");
				service.deleteEmployeeId(Integer.parseInt(sc.nextLine()));
					break;
				case 5:
					System.out.println("Enter employee id to update the record");
					int updateId = Integer.parseInt(sc.nextLine());
					boolean isFound=service.getEmployeebyId(updateId);
					  if(isFound) {
						  System.out.println("Enter name , location and salary to update ");
						  Employee emp=new Employee(updateId,sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine()));
						  service.updateEmployee(emp);
					  }
					
					break;
				case 6:isRunning=false;System.out.println("thank you visit again...................");
					break;
				default:
					break;
				}
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("..............");
		}

	}

}
