public class RoachColony implements Observer
{
	private Hotel home;
	private String name;
	private int population;
	private int growRate;
	private int days;
	private int daysLeft;
	
	public RoachColony(Hotel hotel, String colonyName, int numOfGuest, int growthFactor)
	{
		home = hotel;
		name = colonyName;
		population = numOfGuest;
		growRate = growthFactor;
		home.registerObserver(this);
	}
	// Modifies the population of RoachColony
	public void party()
	{
//		if(home == null)
//		{
//			System.out.println("This Roach doesn't have a Room to party in!");
//			return;
//		}
		population = population + growRate;
                try
                {
                    double sprayReduction = (home.spray(this)) ? 0.75 : 0.5;
                    population = (int)(population * sprayReduction);
                    System.out.println(name + " just threw a wild party!");                    
                }
                catch(NullPointerException e)
                {
                    System.out.println("This Roach doesn't have a Room to party in!");
                }
	}
	// Decrements the daysLeft and calls removeObserver if it reaches 0
	public void update()
	{
		daysLeft--;
		System.out.println(name + " will be staying for " + daysLeft + " more day(s)");
		if(daysLeft == 0)
			home.removeObserver(this);
	}
	// Sets days and daysLeft to stayTime
	public void setDays(int stayTime)
	{
		days = stayTime;
		daysLeft = stayTime;
	}
	// Returns days, not daysLeft
	public int getDays()
	{
		return days;
	}
	
	public String toString()
	{
		return name;
	}
}
