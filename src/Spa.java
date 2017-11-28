//A concrete decorator for Room
public class Spa extends HotelAmenity
{
	protected Room room = null;
	private static final double COST = 20;

	public Spa (Room room)
	{
		this.room = room;
	}

	public double getCost ()
	{
		return room.getCost() + COST;
	}

	public boolean isVacant ()
	{
		return room.isVacant();
	}

	public String toString ()
	{
		return room.toString() + " with Spa";
	}
}
