//Singleton Hotel
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hotel implements Subject
{
	private static final int SIZE = 50;
	private static Hotel hotel = null;
	private boolean vacant = true;
	private Room[] room = new Room[SIZE];
	private RoomFactory factory = new RoomFactory();
	private ArrayList<Observer> observers = new ArrayList<>();
	private Queue<RoachColony> queue = new LinkedList<>();
	
	private Hotel() {}
	
	public static Hotel getInstance()
	{
		if (hotel == null) hotel = new Hotel();
		return hotel;
	}
	
	public void checkIn(RoachColony r)
	{
		if (this.isVacant())
		{
			int roomFinder = 0;
			while (room[roomFinder] != null)
			{
				roomFinder++;
			}
			ArrayList<String> amenities = new ArrayList<>();
			Scanner in = new Scanner(System.in);
			System.out.println("Would you like to add a spa package for $20? (yes/no) :");
			if (in.next().equalsIgnoreCase("yes"))
			{
				amenities.add("spa");
			}
			System.out.println("Would you like to add a food bar for $10? (yes/no) :");
			if (in.next().equalsIgnoreCase("yes"))
			{
				amenities.add("bar");
				System.out.println("Would you like to add food bar auto refill for $5? (yes/no) :");
				if (in.next().equalsIgnoreCase("yes"))
				{
					amenities.add("refill");
				}
			}
			System.out.println("Would you like to add an antispray shower for $25? (yes/no) :");
			if (in.next().equalsIgnoreCase("yes"))
			{
				amenities.add("shower");
			}
			room[roomFinder] = factory.createRoom(amenities);
			System.out.println("How many days would you like to stay?");
			int days = in.nextInt();
			in.nextLine();
			r.setDays(days);
			r.setRoom(roomFinder);
			//registerObserver(r);
		}
		else
		{
			queue.add(r);
			System.out.println("No Vacany, you have been added to the waitinglist");
		}
	}
	
	public boolean spray(RoachColony r)
	{
		int roomFinder = r.getRoom();
		return room[roomFinder].hasShower;
	}
	
	public void checkOut(RoachColony r)
	{
		int roomFinder = r.getRoom();
		int totalCost = r.getDays() * room[roomFinder].getCost();
		System.out.println("Your price is:" + totalCost);
		
		if (queue.isEmpty()) room[roomFinder] = null;
		else checkIn(queue.remove());
	}
	
	// If any of the rooms are vacant, return true otherwise false
	public boolean isVacant()
	{
		for (int i = 0; i < SIZE; i++)
		{
			if (room[i] == null) // changed from if (room[i].isVacant())
				return true;
		}
		return false;
	}
	
	public void registerObserver(Observer o)
	{
		observers.add(o);
	}
	
	public void removeObserver(Observer o)
	{
		observers.remove(o);
	}
	
	public void notifyObserver()
	{
		for (Observer o : observers)
		{
			o.update(vacant);
		}
	}
}
