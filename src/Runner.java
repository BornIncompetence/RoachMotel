/* Christopher , Marcus, Mathew Cunningham
   December 11, 2017
   Purpose: 
   Inputs: 
   Output: 
*/
public class Runner
{
	public static void main(String[] args)
	{
		Hotel california = Hotel.getInstance(2);
		// If starting population is higher than growRate, one party will
		// leave the population lower than what it started with.
		// A population of 0 is still able to check out of the Hotel
		RoachColony roach1 = new RoachColony(california, "roach1", 2, 10);
		RoachColony roach2 = new RoachColony(california, "roach2", 2, 10);
		RoachColony roach3 = new RoachColony(california, "roach3", 12, 2);
		RoachColony roach4 = new RoachColony(california, "roach4", 1, 3);
                RoachColony roach5 = new RoachColony(california, "roach5", 100, 25);
                california.nextDay();                
		roach1.party();
		roach2.party();
                california.nextDay();
		roach3.party();
		california.nextDay();
		roach4.party();
                california.nextDay();
                roach5.party();
	}
}
