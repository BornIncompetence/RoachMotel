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
	public String toString()
	{
		return "Hotel Room";
	}
}
