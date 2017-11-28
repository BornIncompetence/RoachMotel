/*
* Sorry guys, I got carried away and called the Motel "Hotel"
* instead. It made more sense in my head when the teacher was
* talking about amenities. This is a RoachHotel now.
*/
public class Runner
{
	public static void main (String[] args)
	{
		Hotel california = Hotel.getInstance();
		california.set(0, FoodBar.class);
		california.set(1, FoodBar.class);
		california.set(1, Spa.class);
		System.out.println(california.get(0));
		System.out.println(california.get(0).getCost());
		System.out.println(california.get(1));
		System.out.println(california.get(1).getCost());
		String vacancy = (california.isVacant()) ? "true" : "false";
		System.out.println("Hotel vacancy status: " + vacancy);
	}
}
