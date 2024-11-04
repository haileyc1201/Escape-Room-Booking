public class erbooking
{
	private int month;
	private int day;
	private int year;
	private String name;
	private String phoneNum;
	private String email;
	private int gameSlot;
	private int roomChoice;
	private int numPlayers;
	private double cost;
	private double discount;
	private boolean waivers;
	String timeSlot [] = {"12:00", "1:15", "2:30", "3:45", "5:00", "6:15", "7:30", "8:45", "10:00"};
	String room [] = {"Mafia Takedown", "CSI: Case Reopened", "Melbourne Institutional Asylum (MENTAL)", "Shipwrecked"};
	
	public erbooking(int monthA, int dayA, int yearA, String nameA, String phoneNumA, String emailA, int gameSlotA, int roomChoiceA, int numPlayersA, double discountA, boolean waiversA)
	{
		month = monthA;
		day = dayA;
		year = yearA;
		name = nameA;
		phoneNum = phoneNumA;
		email = emailA;
		gameSlot = gameSlotA;
		roomChoice = roomChoiceA;
		numPlayers = numPlayersA;
		discount = discountA;
		waivers = waiversA;
		cost = (((numPlayersA)*33)-(((numPlayersA)*33)*discountA));
	}
	
	//accessors
	public void getInfo()
	{
		System.out.println("Name: " + name);
		System.out.println("Date: " + getDate());
		System.out.println("Phone Number: " + phoneNum);
		System.out.println("Email: " + email);
		System.out.println("Game slot: " + gameSlot + ", Time: " + timeSlot[gameSlot-1]);
		System.out.println("Room choice: " + roomChoice + ", Room name: " + room[roomChoice-1]);
		System.out.println("Number of players: " + numPlayers);
		System.out.println("Total cost: $" + cost);
		System.out.println("Waivers complete? " + waivers);
	}
	
	public String getDate()
	{
		return(month + "/" + day + "/" + year);
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return day;
	}
	public int getYear()
	{
		return year;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPhoneNum()
	{
		return phoneNum;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public int getGameSlot()
	{
		return gameSlot;
	}
	
	public int getRoomChoice ()
	{
		return roomChoice;
	}
	
	public int getNumPlayers ()
	{
		return numPlayers;
	}
	
	public boolean getWaivers ()
	{
		return waivers;
	}
	
	public double getCost ()
	{
		return cost;
	}
	
	//mutators
	public void changeDate(int monthB, int dayB, int yearB)
	{
		System.out.print("Date changed from " + month + "/" + day + "/" + year + " to ");
		month = monthB;
		day = dayB;
		year = yearB;
		System.out.println(month + "/" + day + "/" + year + ".");
	}
	
	public void changeName(String nameB)
	{
		System.out.print("Name changed from " + name + " to ");
		name = nameB;
		System.out.println(name + ".");
	}
	
	public void changePhoneNum(String phoneNumB)
	{
		System.out.print("Phone number changed from " + phoneNum + " to ");
		phoneNum = phoneNumB;
		System.out.println(phoneNum + ".");
	}
	
	public void changeEmail(String emailB)
	{
		System.out.print("Email changed from " + email + " to ");
		email = emailB;
		System.out.println(email + ".");
	}
	
	public void changeGameSlot(int gameSlotB)
	{
		System.out.print("Game slot changed from slot " + gameSlot + " to slot ");
		gameSlot = gameSlotB;
		System.out.println(gameSlot + ".");
	}
	
	public void changeRoomChoice (int roomChoiceB)
	{
		System.out.print("Room choice changed from room " + roomChoice + " to room ");
		roomChoice = roomChoiceB;
		System.out.println(roomChoice + ".");
	}
	
	public void changeNumPlayers (int numPlayersB)
	{
		System.out.print("Number of players changed from " + numPlayers + " to ");
		numPlayers = numPlayersB;
		System.out.println(numPlayers + ".");
	}
	
	public void changeWaivers (boolean waiversB)
	{
		if(waivers)
		{
			if(!waiversB)
			{
				System.out.println("Waiver status changed from complete to incomplete");
			}
		}
		
		if(!waivers)
		{
			if(waiversB)
			{
				System.out.println("Waiver status changed from incomplete to complete");
			}
		}
	}
}