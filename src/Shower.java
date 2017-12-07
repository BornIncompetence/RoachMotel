//A concrete decorator for Room
public class Shower extends HotelAmenity
{
	protected Room room;
	private static final int COST = 25;
	
	public Shower(Room room)
	{
		this.room = room;
		this.hasShower = true;
	}
	
	public int getCost()
	{
		return room.getCost() + COST;
	}
	/*
	public boolean isVacant()
	{
		return room.isVacant();
	}
	
	public void book()
	{
	
	}
	
	public void vacate()
	{
	
	}
	*/
	public String toString()
	{
		return room.toString() + ", with spray resistant shower";
	}
}
