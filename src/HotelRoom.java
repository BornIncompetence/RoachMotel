//A concrete Component of Room
public class HotelRoom extends Room
{
	// All responsibility for vacancy in a
	// single room must be handled by here
	private boolean vacant;

	public HotelRoom()
	{
		vacant = true;
	}

	public int getCost()
	{
		return 50;
	}

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

	public String toString()
	{
		return "Hotel Room";
	}
}