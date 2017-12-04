//A concrete decorator for Room
public class FoodBar extends HotelAmenity
{
	protected Room room = null;
	private static final int COST = 10;

	public FoodBar(Room room)
	{
		this.room = room;
	}

	public int getCost()
	{
		return room.getCost() + COST;
	}

	public boolean isVacant()
	{
		return room.isVacant();
	}

	public void book()
	{
		room.book();
	}

	public void vacate()
	{
		room.vacate();
	}

	public String toString()
	{
		return room.toString() + " with FoodBar";
	}
}
