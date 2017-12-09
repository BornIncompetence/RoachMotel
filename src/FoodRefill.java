//A concrete decorator for Room
public class FoodRefill extends HotelAmenity
{
	protected Room room;
	private static final int COST = 5;
	
	public FoodRefill(Room room)
	{
		this.room = room;
	}
	
	public int getCost()
	{
		return room.getCost() + COST;
	}
	
	public String toString()
	{
		return room.toString() + ", with FoodBar auto refill";
	}
}
