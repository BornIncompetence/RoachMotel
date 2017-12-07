public class RoachColony implements Observer
{
	private String name;
	private int population;
	private int growRate;
	private Hotel home;
	private int room;
	private int days;
	
	public RoachColony(Hotel hotel, String colonyName, int numOfGuest, int growthFactor)
	{
		home = hotel;
		name = colonyName;
		population = numOfGuest;
		growRate = growthFactor;
	}
	
	public void party()
	{
		population = population + growRate;
		double sprayReduction = (home.spray(this)) ? 0.75 : 0.5;
		population = (int)(population * sprayReduction);
	}
	
	public void update(boolean vacant)
	{
		/*isVacant = vacant;*/
		//Perhaps use this function to check in or check out.
	}
	
	public int getRoom()
	{
		return room;
	}
	
	public void setDays(int days)
	{
		this.days = days;
	}
	
	public int getDays()
	{
		return days;
	}
	
	public void setRoom(int room)
	{
		this.room = room;
	}
}
