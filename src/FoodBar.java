public class FoodBar extends HotelAmenity
{
    protected Room room;
    public static final double COST = 10;

    public FoodBar(Room room)
    {
        this.room = room;
    }

    public void getDescription()
    {

    }

    public double getCost()
    {
        return COST;
    }
}
