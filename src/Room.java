//The abstract Component Room
public abstract class Room
{
	public abstract int getCost();

	public abstract boolean isVacant();

	public abstract void book();

	public abstract void vacate();
}
