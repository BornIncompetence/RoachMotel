//A concrete decorator for Room
public class Spa extends HotelAmenity
{
	protected Room room;
	private static final int COST = 20;
  
	public Spa(Room room)
	{
		this.room = room;
	}

	public int getCost()
	{
		return room.getCost() + COST;
	}
	
	public String toString()
	{
		return room.toString() + ", with Spa";
	}
}
