//A concrete Component of Room
public class HotelRoom extends Room
{
	// All responsibility for vacancy in a
	// single room must be handled by here
	private boolean vacant;

	public HotelRoom ()
	{
		vacant = true;
	}

	public double getCost ()
	{
		return 50;
	}

	public boolean isVacant ()
	{
		return vacant;
	}

	public String toString ()
	{
		return "Hotel Room";
	}
}