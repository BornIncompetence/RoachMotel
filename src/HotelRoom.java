//A concrete Component of Room
public class HotelRoom extends Room
{
	private boolean vacant;
	
	public HotelRoom()
	{
		vacant = false;
	}
	
	public int getCost()
	{
		return 50;
	}
	/*
	public boolean isVacant()
	{
		return vacant;
	}
	
	public void book()
	{
		vacant = false;
	}
	
	public void vacate()
	{
		vacant = true;
	}
	*/
	public String toString()
	{
		return "Hotel Room";
	}
}