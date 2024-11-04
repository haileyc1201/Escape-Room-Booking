public class Employee
{
	//private instance variables
	private String name;
	private double wage;
	private String workPerformance;
	
	//constructors
	public Employee (String eName, double eWage, String ePerformance)
	{
		name = eName;
		wage = eWage;
		workPerformance = ePerformance;
	}
	
	public Employee (String eName, double eWage)
	{
		name = eName;
		wage = eWage;
		workPerformance = "";
	}
	
	
	//accessor methods
	public String getName ()
	{
		return name;
	}
	
	public Double getWage ()
	{
		return wage;
	}
	
	public String getPerformance ()
	{
		return workPerformance;
	}
	
	//mutator methods
	public void changeName(String eName)
	{
		System.out.println(name + "'s name has been successfully changed to " + eName);
		name = eName;
	}
	
	public void changeWage(double eWage)
	{
		System.out.println(name + "'s hourly wage has been successfully changed from $" + wage + " to $" + eWage);
		wage = eWage;
	}
	
	public void changePerformance(String ePerformance)
	{
		System.out.println(name + "'s performance report has been successfully changed");
		workPerformance = ePerformance;
	}
}