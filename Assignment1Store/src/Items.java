import java.util.ArrayList;

public class Items {
ArrayList<Item> inven = new ArrayList<Item>();
public void searchItems(String s)
{
	
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
