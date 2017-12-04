public class FoodBarRefill extends HotelAmenity
{
	protected Room room = null;
	private static final int COST = 5;

	public FoodBarRefill(Room room)
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
		return room.toString() + " with a daily refill of the food bar";
	}
}
