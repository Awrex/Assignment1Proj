import java.util.ArrayList;

public class Items {
ArrayList<Item> inven = new ArrayList<Item>();
Item notFound = new Item(000,"Item not found","Please try searching again","",0,0,"");
public Items()
{
	inven.add(new Item(001,"Steve","A thing called steve","Bananas",2,5,""));
	inven.add(new Item(002,"Steven","A thing called steven","Bananas",2,5,""));
	inven.add(new Item(003,"Fred","Freddy","Person",5,10,""));
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

public void addItem(int id, String name, String desc, String type, int price, int stock, String newStockDate)
{
	inven.add(new Item(id,name,desc,type,price,stock,newStockDate));
}

public Item getItem()
{
	return inven.get(0);
}

}
