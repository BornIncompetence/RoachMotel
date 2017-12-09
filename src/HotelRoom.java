//A concrete Component of Room
public class HotelRoom extends Room
{	
	public HotelRoom()
	{
		hasShower = false;
	}
	
	public int getCost()
	{
		return 50;
	}
	
	public String toString()
	{
		return "Basic Hotel Room";
	}
}
