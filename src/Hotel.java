//Singleton Hotel
import java.util.*;

public class Hotel implements Subject
{
	private static Hotel hotel = null;
	private static Room[] room = null;
	private static RoomFactory factory = new RoomFactory();
	private static LinkedList<Observer> observerQueue = new LinkedList<>();
	private static HashMap<Observer,Integer> guestList = new HashMap<>();
	private static int roomNumber = 0;
	private static int days = 0;
	private static int size = 0;
	
	private Hotel(int s)
	{
		size = s;
		room = new Room[size];
	}
	// Creates an instance of Hotel
	public static Hotel getInstance(int size)
	{
		if (hotel == null)
			hotel = new Hotel(size);
		return hotel;
	}
	// Advances to the next day, notifying Observers
	public void nextDay()
	{
		System.out.println("It is now the next day.");
		notifyObserver();
	}
	// Returns true if the Room occupied by Observer has a Shower, otherwise return false
	public boolean spray(Observer o)
	{
		roomNumber = guestList.get(o);
		return room[roomNumber].hasShower;
	}
	// Prompts user to add any extra amenities and duration of visit
	private void checkIn(Observer o)
	{
		roomNumber = 0;
		while (room[roomNumber] != null)
			roomNumber++;
		
		ArrayList<String> amenities = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to add a spa package for $20? (yes/no) :");
		if (in.next().equalsIgnoreCase("yes"))
			amenities.add("spa");
		System.out.println("Would you like to add a food bar for $10? (yes/no) :");
		if (in.next().equalsIgnoreCase("yes"))
		{
			amenities.add("bar");
			System.out.println("Would you like to add food bar auto refill for $5? (yes/no) :");
			if (in.next().equalsIgnoreCase("yes"))
				amenities.add("refill");
		}
		System.out.println("Would you like to add an anti-spray shower for $25? (yes/no) :");
		if (in.next().equalsIgnoreCase("yes"))
			amenities.add("shower");
		room[roomNumber] = factory.createRoom(amenities);
		
		System.out.println("How many days would you like to stay?");
		days = in.nextInt();
		in.nextLine();
		o.setDays(days);
		guestList.put(o, roomNumber);
	}
	// Returns true if any Room is open, otherwise return false
	public boolean isVacant()
	{
		for (int i = 0; i < size; i++)
		{
			if (room[i] == null)
				return true;
		}
		return false;
	}
	// Adds Observer to guestList if vacant, otherwise adds to wait-list
	public void registerObserver(Observer o)
	{
		if(isVacant())
		{
			System.out.println(o + " will now be checked in.");
			checkIn(o);
		}
		else
		{
			observerQueue.add(o);
			System.out.println(o + " has been put on the wait-list");
		}
	}
	// Removes Observer from guestList and adds an Observer in front of the queue, if any
	public void removeObserver(Observer o)
	{
		roomNumber = guestList.remove(o);
		days = o.getDays();
		int totalCost = days * room[roomNumber].getCost();
		System.out.println("The price of your visit is $" + totalCost);
		room[roomNumber] = null;
		
		if(!observerQueue.isEmpty())
			registerObserver(observerQueue.remove());
	}
	// Calls each Observer's update, except those that are added the same day
	public void notifyObserver()
	{
		// The Set MUST be initialized with "new" otherwise
		// we accidentally modify its contents while modifying
		// the guestList, causing a ConcurrentModificationException
		Set<Observer> copy = new HashSet<>(guestList.keySet());
		for (Observer c : copy)
		{
			c.update();
		}
	}
}
