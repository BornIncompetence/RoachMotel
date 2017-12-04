/*
* Sorry guys, I got carried away and called the Motel "Hotel"
* instead. It made more sense in my head when the teacher was
* talking about amenities. This is a RoachHotel now.
*/
// Possibly add a day cycle as part of an Observer design pattern, so that hotel cost can increase and colony can grow
public class Runner
{
	public static void main(String[] args)
	{
		Hotel california = Hotel.getInstance();
		california.set(0, FoodBar.class);
		california.set(1, FoodBar.class);
		california.set(1, FoodBarRefill.class);
		california.set(1, Spa.class);
		california.set(2, Spa.class);
		california.set(3, ShowerUpgrade.class);
		california.book(0);
		california.book(1, 2);
		california.book(3);
		System.out.println(california.get(0));
		System.out.println(california.getCost(0));
		System.out.println(california.get(1));
		System.out.println(california.getCost(1));
		System.out.println(california.get(2));
		System.out.println(california.getCost(3));
		System.out.println(california.get(3));
		System.out.println(california.getCost(3));
		String vacancy = (california.isVacant()) ? "true" : "false";
		System.out.println("Hotel vacancy status: " + vacancy);
	}
}
