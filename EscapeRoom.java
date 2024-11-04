//Hailey Clark escape room
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class EscapeRoom
{
		//	
		public static Scanner myIn = new Scanner(System.in);
		public static ArrayList<Employee> myEmployees = new ArrayList<>();
		public static ArrayList<erbooking> myBookings = new ArrayList<>();
		public static String StringInput = "";
		public static int IntegerInput;
		public static double DoubleInput;
		public static int repeat = 1;
		public static int EmployeeNumber = 0;
		public static void main (String args[])
		{
			System.out.println("Welcome to Escape Room Entertainment.");
			mainMenu();
			System.out.println("Thank you, goodbye!");
			System.exit(0);
		}
		
		public static void mainMenu()
		{
			while (repeat == 1)
			{
				System.out.println("Enter a Category: Employees, Bookings, or Exit.");
				StringInput = null;
				StringInput = myIn.nextLine().toLowerCase();
				while(StringInput.equals(null))
				{StringInput = myIn.nextLine();}
				if (StringInput.equals("employees"))
				{
					employees();
				}
				else if (StringInput.equals("bookings"))
				{
					bookings();
				}
				else if (StringInput.equals("exit"))
				{
					repeat = 0;
				}
				else
				{
					System.out.println("The phrase you entered does not match any of the categories. Please type and enter any of the three categories specified to be redirected.");
				}
			}
		}
		
		public static void employees ()
		{
			
			System.out.println("Enter a Category: New (add a new employee to database), Wages (view or edit employees wages), Comments (view or edit employees performance comments), or Exit (return to main menu category select).");
			StringInput = null;
			StringInput = myIn.nextLine().toLowerCase();
			while(StringInput.equals(null))
			{StringInput = myIn.nextLine();};
			if (StringInput.equals("wages"))
			{
				wages();
			}
			else if (StringInput.equals("comments"))
			{
				comments();
			}
			else if (StringInput.equals("new"))
			{
				newEmployee();
			}
			else if (StringInput.equals("exit"))
			{
					mainMenu();
			}
			else
			{
				System.out.println("The phrase you entered does not match any of the options. Please type and enter any of the three options specified to be redirected.");
				employees();
			}
		}
		
		public static void wages ()
		{
			//print each empolyees name with wages
			EmployeeNumber = 1;
			for (Employee myEmployee : myEmployees)
			{
				System.out.println(EmployeeNumber + ") " + myEmployee.getName() + " makes $" +  myEmployee.getWage() + " per hour.");
				EmployeeNumber++;
			}
			
			//edit wages?
			System.out.println("Would you like to edit the wages of any employees? Yes or No.");
			StringInput = myIn.nextLine().toLowerCase();
			while((!(StringInput.equals("yes")))&&(!(StringInput.equals("no"))))
			{
				StringInput = myIn.nextLine().toLowerCase();
			}
			//if yes, employee name? new wage? 
			if (StringInput.equals("yes"))
			{
				String repeat1 = "yes";
				while(repeat1.equals("yes"))
				{
					System.out.println("What is the number of the employee you would like to edit the wage of?");
					IntegerInput = myIn.nextInt();
					IntegerInput--;
					System.out.println("What is the new hourly wage for this employee?");
					DoubleInput = myIn.nextDouble();
					myEmployees.get(IntegerInput).changeWage(DoubleInput);
					System.out.println("Change another employees wage? Yes or No.");
					repeat1 = myIn.nextLine().toLowerCase();
					while((!(repeat1.equals("yes")))&&(!(repeat1.equals("no"))))
					{
						repeat1 = myIn.nextLine().toLowerCase();
					}
				}
				employees();
			}
			else if (StringInput.equals("no"))
			{
				employees();
			}
			else
			{
				System.out.println("The phrase you entered does not match any of the options. You will be redirected.");
				wages();
			}
		}
		
		public static void comments ()
		{
			//print list of employee names
			EmployeeNumber = 1;
			for (Employee myEmployee : myEmployees)
			{
				System.out.println(EmployeeNumber + ") " + myEmployee.getName());
				EmployeeNumber++;
			}
			//user input employee
			System.out.println("What is the number of the employee you would like to view the comments of?");
			IntegerInput = myIn.nextInt();
			IntegerInput--;
			//print comments
			System.out.println(myEmployees.get(IntegerInput).getName() + "'s comments: " + myEmployees.get(IntegerInput).getPerformance());
			//edit comments?
			String repeat8 = "";
			System.out.println("Would you like to edit the comments for this employee? Yes or No.");
			while((!(repeat8.equals("yes")))&&(!(repeat8.equals("no"))))
			{
				repeat8 = myIn.nextLine().toLowerCase();
			}
			
			//if yes, new comment? 
			if (repeat8.equals("yes"))
			{
				System.out.println("Please input new comment for this employee.");
				StringInput = "";
				StringInput = myIn.nextLine();
				while(StringInput.equals(""))
				{StringInput = myIn.nextLine();};
				myEmployees.get(IntegerInput).changePerformance(StringInput);
			}
			else if (StringInput.equals("no"))
			{
				employees();
			}
			else
			{
				System.out.println("The phrase you entered does not match any of the options. You will be redirected.");
				comments();
			}
			String repeat2 = "";
			System.out.println("View or edit another employees comments? Yes or No.");
			while((!(repeat2.equals("yes")))&&(!(repeat2.equals("no"))))
			{
				repeat2 = myIn.nextLine().toLowerCase();
			}
			if(repeat2.equals("yes"))
			{
				comments();
			}
			else
			{
				employees();
			}
		}
		
		public static void newEmployee()
		{
			//ask employee name
			System.out.println("Enter new employee name");
			String name = myIn.nextLine();
			//ask employee wage
			System.out.println("Enter new employee hourly wage");
			double wage = myIn.nextDouble();
			//create new employee
			myEmployees.add(new Employee(name, wage));
			String repeat3 = "";
			System.out.println("Create another new employee? Yes or No.");
			while((!(repeat3.equals("yes")))&&(!(repeat3.equals("no"))))
			{
				repeat3 = myIn.nextLine().toLowerCase();
			}
			if(repeat3.equals("yes"))
			{
				newEmployee();
			}
			else
			{
				employees();
			}
		}
		
		public static void bookings ()
		{
			//choose category: add products, restock, or products info
			System.out.println("Enter a Category: New (create a new booking), View (see current bookings), or Exit.");
			StringInput = myIn.nextLine().toLowerCase();
			if (StringInput.equals("new"))
			{
				newBooking();
			}
			else if (StringInput.equals("view"))
			{
				viewBookings();
			}
			else if (StringInput.equals("exit"))
			{
				mainMenu();
			}
			else
			{
				System.out.println("The phrase you entered does not match any of the options. Please type and enter any of the three options specified to be redirected.");
				bookings();
			}
		}
		
		public static void newBooking ()
		{
			//ask month of booking
			System.out.println("Enter month of booking in number format");
			int month = 0;
			while(month == 0)
			{
				month = myIn.nextInt();
			}
			//ask day of booking
			System.out.println("Enter day of booking");
			int day = 0;
			while(day == 0)
			{
				day = myIn.nextInt();
			}
			//ask year of booking
			System.out.println("Enter year of booking");
			int year = 0;
			while(year==0)
			{
				year = myIn.nextInt();
			}
			//ask name for booking
			System.out.println("Enter name of customer");
			String name = "";
			while(name.equals(""))
			{
				name = myIn.nextLine();	
			}
			//ask phone number
			System.out.println("Enter customer's phone number");
			String phoneNum = "";
			while(phoneNum.equals(""))
			{
				phoneNum = myIn.nextLine();
			}
			//ask for email
			System.out.println("Enter customer's email");
			String email = "";
			while(email.equals(""))
			{
				email = myIn.nextLine();
			}
			//ask for game slot
			System.out.println("Enter customer's time slot number");
			int gameSlot = 0;
			while(gameSlot == 0)
			{
				gameSlot = myIn.nextInt();
			}
			//ask for room choice
			System.out.println("Enter room number");
			int roomChoice = 0;
			while(roomChoice == 0)
			{
				roomChoice = myIn.nextInt();
			}
			//ask for num players
			System.out.println("Enter number of players");
			int numPlayers = 0;
			while(numPlayers == 0)
			{
				numPlayers = myIn.nextInt();
			}
			//ask discount
			System.out.println("Enter discount in decimal form");
			double discount = -1;
			while(discount == -1)
			{
				discount = myIn.nextDouble();
			}
			//ask if waivers complete
			System.out.println("Has the customer completed their waivers? Yes or no");
			String waiversYN = "";
			while(waiversYN.equals(""))
			{
				waiversYN = myIn.nextLine();
			}
			boolean waiversTF;
			if(waiversYN.toLowerCase().equals("yes"))
				waiversTF = true;
			else
				waiversTF = false;
			
			
			//create new booking
			myBookings.add(new erbooking(month, day, year, name, phoneNum, email, gameSlot, roomChoice, numPlayers, discount, waiversTF));
			
			try
			{
				FileWriter writer4 = new FileWriter("receipts.txt", true);
				BufferedWriter writer5 = new BufferedWriter(writer4);
				writer5.write(".........ESCAPE ROOM ENTERTAINMENT.........");
				writer5.newLine();
				writer5.write("Name: " + myBookings.get(myBookings.size()-1).getName());
				writer5.newLine();
				writer5.write("Date of participation: " + myBookings.get(myBookings.size()-1).getDate());
				writer5.newLine();
				writer5.write("Cost: $" + myBookings.get(myBookings.size()-1).getCost());
				writer5.newLine();
				writer5.write("............................................");
				writer5.newLine();
				writer5.close();
				
			}
			catch (IOException g)
			{
				g.printStackTrace();
			} 
			
			
			String repeat4 = "";
			
			System.out.println("Create another booking? Yes or No.");
			while((!(repeat4.equals("yes")))&&(!(repeat4.equals("no"))))
			{
				repeat4 = myIn.nextLine().toLowerCase();
			}
			if(repeat4.equals("yes"))
			{
				newBooking();
			}
			else
			{
				bookings();
			}
		}
		
		public static void viewBookings ()
		{
			//sorting list of bookings
			for (int a = 0; a<myBookings.size()-1; a++)
			{
				for (int b = myBookings.size()-1; b>a; b--)
				{
					if(myBookings.get(a).getYear()>myBookings.get(b).getYear())
					{
						myBookings.add(b+1, myBookings.get(a));
						myBookings.remove(a);
					}
					else if((myBookings.get(a).getYear()==myBookings.get(b).getYear())&&(myBookings.get(a).getMonth()>myBookings.get(b).getMonth()))
					{
						myBookings.add(b+1, myBookings.get(a));
						myBookings.remove(a);
					}
					else if(((myBookings.get(a).getYear()==myBookings.get(b).getYear())&&((myBookings.get(a).getMonth()==myBookings.get(b).getMonth())))&&(myBookings.get(a).getDay()>myBookings.get(b).getYear()))
					{
						myBookings.add(b+1, myBookings.get(a));
						myBookings.remove(a);
					}
					else if((myBookings.get(a).getDate().equals(myBookings.get(b).getYear()))&&(myBookings.get(a).getYear()>myBookings.get(b).getYear()))
					{
						myBookings.add(b+1, myBookings.get(a));
						myBookings.remove(a);
					}
				}
			}
			
			//print list of bookings
			int BookingNumber = 1;
			for (erbooking booking : myBookings)
			{
				System.out.println(BookingNumber + ") ");
				booking.getInfo();
				System.out.println();
				BookingNumber++;
			}
		}
}