public class Runner
{
	public static void main(String[] args)
	{
		Hotel california = Hotel.getInstance(3);
		// If starting population is higher than growRate, one party will
		// leave the population lower than what it started with.
		// A population of 0 is still able to check out of the Hotel
		RoachColony roach1 = new RoachColony(california, "roach1", 2, 10);
		RoachColony roach2 = new RoachColony(california, "roach2", 4, 6);
		RoachColony roach3 = new RoachColony(california, "roach3", 12, 2);
		RoachColony roach4 = new RoachColony(california, "roach4", 1, 0);
		roach1.party();
		roach2.party();
		roach3.party();
		california.nextDay();
		roach4.party();
		
		while(california.isVacant())
			california.nextDay();
	}
}
