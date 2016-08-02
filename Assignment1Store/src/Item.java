
public class Item {
private int ID;
private String name;
private String description;
private String type;
private int price;
private int stock;
private String newStockDate;

public Item(int iD, String name, String description, String type, int price, int stock, String newStockDate) {
	ID = iD;
	this.name = name;
	this.description = description;
	this.type = type;
	this.price = price;
	this.stock = stock;
	this.newStockDate = newStockDate;
}

public boolean searchItem(String n)
{
	if (n.equals(name)) 
	{
		return true;
	}
	else
		return false;
}



public String getName() {
	return name;
}

public String getDescription() {
	return description;
}

public String getType() {
	return type;
}



public int getID() {
	return ID;
}

public int getPrice() {
	return price;
}

public int getStock() {
	return stock;
}

public String printID() {
	return Integer.toString(ID);
}
public String printPrice() {
	return "Price: $" + Integer.toString(price) +".00";
}
public String printStock() {
	if (stock == 0)
	{
		return "Currently no stock";
	}
	return "Stock - " + Integer.toString(stock);
}

public String getNewStockDate() {
	if (stock == 0)
	{
		return newStockDate;
	}
	else
	{
		return "";
	}
}


}