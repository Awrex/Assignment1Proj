import java.util.ArrayList;

public class Items {
ArrayList<Item> inven = new ArrayList<Item>();
Item notFound = new Item(000,"Item not found","Please try searching again","",0,0,"");
public Items()
{
}
public Item searchItems(String s)
{
	boolean isItem = false;
	int j = inven.size();
	Item cur = new Item();
	int i = 0;
	while (i < j && isItem == false)
	{
		cur = inven.get(i);
		isItem = cur.searchItem(s);
		i++;
	}
	if (isItem == true)
	{
		return cur;
	}
	else
		return notFound;
}

public void addItem(Item i)
{
	inven.add(new Item(i));
}

public Item getItem()
{
	return inven.get(0);
}

public String printSize()
{
	int n;
	n = inven.size();
	return Integer.toString(n);
}

public String printNames()
{
	Item curr = new Item();
	String s = "<html> <b>NAME:</b> <br>";
	for (int i = 0;i < inven.size(); i++)
	{
		curr = inven.get(i);
		s += curr.getName() + "<br>";
	}
	s += "</html>";
	return s;
}
public String printPrices()
{
	Item curr = new Item();
	String s = "<html> <b>PRICE:</b> <br>";
	for (int i = 0;i < inven.size(); i++)
	{
		curr = inven.get(i);
		s += curr.printPrice() + "" + "<br>";
	}
	s += "</html>";
	return s;
}
}
