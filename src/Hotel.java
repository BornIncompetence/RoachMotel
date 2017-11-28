//Singleton Hotel

import java.lang.reflect.Constructor;

public class Hotel
{
	private static final int SIZE = 50;
	private static Hotel hotel = null;
	private Room room[] = null;

	private Hotel ()
	{
		room = new Room[SIZE];
		for (int i = 0; i < SIZE; i++)
			room[i] = new HotelRoom();
	}

	public static Hotel getInstance ()
	{
		if (hotel == null)
			hotel = new Hotel();
		return hotel;
	}
	// If any of the rooms are vacant, return true otherwise false
	public boolean isVacant ()
	{
		for (int i = 0; i < SIZE; i++)
		{
			if (room[i].isVacant())
				return true;
		}
		return false;
	}

	public Room get (int i)
	{
		return room[i];
	}
//Replaces a room in index i with a room decorated with class anyRoom
	public void set (int i, Class<? extends Room> anyRoom)
	{
		// This file should not know any of the Decorator names but be able
		// to invoke their constructors and decorate the Rooms in the array
		Constructor<? extends Room> ctor = null;
		try
		{
			ctor = anyRoom.getConstructor(Room.class);
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		// Once the constructor is determined in runtime, it should
		// try to override the Room in index i with a decorated one
		try
		{
			room[i] = ctor.newInstance(room[i]);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}