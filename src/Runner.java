public class Runner
{
	public static void main(String[] args)
	{
		Hotel california = Hotel.getInstance();
		RoachColony roach1 = new RoachColony(california, "roach1", 2, 10);
		california.checkIn(roach1);
		roach1.party();
		california.checkOut(roach1);
		RoachColony roach2 = new RoachColony(california, "roach2", 4, 6);
		RoachColony roach3 = new RoachColony(california, "roach3", 12, 2);
		california.checkIn(roach2);
		california.checkIn(roach3);
		roach2.party();
		roach3.party();
		california.checkOut(roach2);
		california.checkOut(roach3);
	}
}
