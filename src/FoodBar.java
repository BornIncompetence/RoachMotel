//A concrete decorator for Room
public class FoodBar extends HotelAmenity
{
	protected Room room;
	private static final int COST = 10;
	
	public FoodBar(Room room)
	{
		this.room = room;
	}
	
	public int getCost()
	{
		return room.getCost() + COST;
	}
	
	public String toString()
	{
		return room.toString() + ", with FoodBar";
	}
}
