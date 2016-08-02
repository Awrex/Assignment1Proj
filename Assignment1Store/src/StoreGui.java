import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.DropMode;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JToggleButton;

public class StoreGui {

	private JFrame frame;
	private JTextField itemSearch;
	static Items itemList = new Items();

	public static JPanel jBox;
	Items cart = new Items();
	
	Item currentItem = new Item();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Item i1 = new Item(001,"Steve","A thing called steve","Bananas",2,5,"");
		Item i2 = new Item(002,"Steven","A thing called steven","Bananas",2,5,"");
		Item i3 = new Item(003,"Fred","Freddy","Person",5,0,"Tim Duncan");
		
		itemList.addItem(i1);
		itemList.addItem(i2);
		itemList.addItem(i3);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreGui window = new StoreGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public StoreGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {



		frame = new JFrame();
		frame.setBounds(100, 100, 560, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 184, 524, 216);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel itemName = new JLabel("");
		itemName.setBounds(300, 5, 100, 20);
		panel.add(itemName);
		itemName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel itemDesc = new JLabel("");
		itemDesc.setVerticalAlignment(SwingConstants.TOP);
		itemDesc.setBounds(300, 22, 150, 20);
		panel.add(itemDesc);
		itemDesc.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel itemStock = new JLabel("");
		itemStock.setBounds(300, 50, 200, 20);
		panel.add(itemStock);
		
		JLabel itemPrice = new JLabel("");
		itemPrice.setBounds(300, 70, 100, 20);
		panel.add(itemPrice);
		
		JLabel itemDate = new JLabel("");
		itemDate.setBounds(300, 90, 200, 20);
		panel.add(itemDate);
		
		itemSearch = new JTextField();
		itemSearch.setBounds(10, 6, 150, 26);
		panel.add(itemSearch);
		itemSearch.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(171, 8, 89, 23);
		panel.add(searchButton);
		
		JLabel cartName = new JLabel("");
		cartName.setVerticalAlignment(SwingConstants.TOP);
		cartName.setBounds(165, 15, 100, 158);
		frame.getContentPane().add(cartName);
		
		JLabel cartPrice = new JLabel("");
		cartPrice.setVerticalAlignment(SwingConstants.TOP);
		cartPrice.setBounds(270, 15, 100, 158);
		frame.getContentPane().add(cartPrice);
		
		JToggleButton cartBtn = new JToggleButton("Cart(0)");
		cartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!!cartBtn.isSelected())
				{
					cartName.setText(cart.printNames());
					cartPrice.setText(cart.printPrices());
				}
				else
				{
					cartName.setText("");
				}
				
			}
		});
		cartBtn.setToolTipText("Click to display cart");
		cartBtn.setBounds(10, 11, 121, 23);
		frame.getContentPane().add(cartBtn);
		
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCart(currentItem);
				cartBtn.setText(("Cart(" + cart.printSize() +")"));
				currentItem.resetID();
				itemName.setText("");
				itemDesc.setText("Added item to cart");
				itemStock.setText("");
				itemPrice.setText("");
				itemDate.setText("");
			}
		});
		btnAddToCart.setBounds(414, 182, 100, 23);
		panel.add(btnAddToCart);		
		

		

		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currentItem = itemList.searchItems(itemSearch.getText());
				
				if(currentItem.getID() == 000)
				{
					itemName.setText(currentItem.getName());
					itemDesc.setText(currentItem.getDescription());
					itemStock.setText("");
					itemPrice.setText("");
					itemDate.setText("");
				}
				else
				{
					itemName.setText(currentItem.getName());
					itemDesc.setText(currentItem.getDescription());
					itemStock.setText(currentItem.printStock());
					itemPrice.setText("Price: " + currentItem.printPrice());
					itemDate.setText(currentItem.getNewStockDate());
				}
			}
		});
	}
	public void addCart(Item i)
	{
		if(currentItem.getID() != 000)
		{
			cart.addItem(currentItem);
		}
		else
		{
			
		}
	}
}
