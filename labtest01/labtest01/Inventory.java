package labtest01;


import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Represents the inventory of a 
 * physical grocery store.
 */
public class Inventory implements Comparator<Item>
{
	private final String aName; // Unique
	private final HashMap<Item, Integer> aInventory = new HashMap<>();
	
	/**
	 * Creates a new inventory with no items in it,
	 * and identified uniquely with pName.
	 * @param pName A unique identifier for this inventory.
	 */
	public Inventory(String pName)
	{
		aName = pName;
	}
	
	/**
	 * @return The unique name of this inventory.
	 */
	public String getName()
	{
		return aName;
	}
	
	/**
	 * Adds pQuantity number of items to the inventory.
	 * @param pItem The type of item to add.
	 * @param pQuantity The amount to add.
	 */
	public void stock(Item pItem, int pQuantity)
	{
		int amount = 0;
		if( aInventory.containsKey(pItem))
		{
			amount = aInventory.get(pItem);
		}
		amount += pQuantity;
		aInventory.put(pItem, amount);
	}
	
	/**
	 * Removes pQuantity of items from the inventory,
	 * for example by selling them or tossing them in
	 * the garbage.
	 * @param pItem The type of item to dispose of
	 * @param pQuantity The amount to dispose.
	 * @pre aInventory.containsKey(pItem) && pQuantity >= aInventory.get(pItem)
	 */
	public void dispose(Item pItem, int pQuantity)
	{
		assert aInventory.containsKey(pItem) && pQuantity >= aInventory.get(pItem);
		int amount = aInventory.get(pItem);
		amount -= pQuantity;
		aInventory.put(pItem, amount);
	}
	
	/**
	 * @param pItem The item to check for availability.
	 * @return How many of the items are available in the inventory.
	 */
	public int pAvailable(Item pItem)
	{
		if( aInventory.containsKey(pItem))
		{
			return aInventory.get(pItem);
		}
		else
		{
			return 0;
		}
	}

	@Override
	/**
	 * @params - two items o1 and o2
	 * takes two items, if the first item is more expensive than the other item then return 1, vice versa 
	 */
	public int compare(Item po1, Item po2)
	{
		if (po1.getPrice()>po2.getPrice()) 
		{
			return 1; 
		}
		else if (po1.getPrice()<po2.getPrice())
		{
			return -1; 
		}
		else
		{
		return 0;
		}
	}
	
	/**
	 * 
	 * @return the totalvalue of all inventory
	 */
	public int totalValue()
		{
		int size = 0;
		Collection<Integer> total = aInventory.values();
		for (int j : total) 
		{ 
			size += j;
			
		}
		return size; 
		
		
	}
}
