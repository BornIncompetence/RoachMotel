public class RoachColony
{
	//A Roach Colony has a name, an initial population, and a growth rate.
	private String name = null;
	private int population = 0;
	private int growth = 0;

	RoachColony(int growth)
	{
		this.growth = growth;
		population += growth;
	}
}
