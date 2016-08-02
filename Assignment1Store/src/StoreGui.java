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

public class StoreGui {

	private JFrame frame;
	private JTextField itemSearch;
	public static JPanel jBox;
	private Items itemList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
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
		itemStock.setBounds(300, 50, 100, 20);
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
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Items itemList = new Items(); 
				Item currentItem = new Item();
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
					itemPrice.setText(currentItem.printPrice());
					itemDate.setText(currentItem.getNewStockDate());
				}
			}
		});
	}
}
