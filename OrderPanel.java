package cp213;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.print.PrinterJob;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;


/**
 * The GUI for the Order class.
 *
 * @author Jidaan Dahiya
 * @version 2022-05-20
 */
@SuppressWarnings("serial")
public class OrderPanel extends JPanel {

    /**
     * Implements an ActionListener for the 'Print' button. Prints the current
     * contents of the Order to a system printer or PDF.
     */
    private class PrintListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {
		PrinterJob printer = PrinterJob.getPrinterJob();
		printer.setPrintable(order);
		if (printer.printDialog()) {
			try {
				printer.print();
			}	
			catch (Exception printerException) {
				System.out.println(printerException);
			}
		}
		}
    }
    
    /**
     * Implements an Focusistener for the all textfields. Changes the value and
     * shows updated reciept after user leaves the textfield.
     */
    private class QuantityListener implements FocusListener {

	@Override
	public void focusGained(final FocusEvent f) {
		final JTextField source = (JTextField) f.getSource();
		source.selectAll();
	}

	@Override
	public void focusLost(final FocusEvent f) {
		final JTextField source = (JTextField) f.getSource();
		int i = 0; 
		if (source == hotdogValue) 
			i = 0;
		else if (source == hamburgerValue) 
			i = 1;
		else if (source == cheeseburgerValue)
			i = 2;
		else if (source == friesValue)
			i = 3;
		else if (source == poutineValue)
			i = 4;
		else if (source == pizzaValue) 
			i = 5;
		else if (source == drinkValue) 
			i = 6;
		
		// Checking for inputs
		if (Integer.valueOf(source.getText()) >= 0) {
			order.update(menu.getItem(i), Integer.valueOf(source.getText()));
			OrderPanel.this.subtotal.setText(NumberFormat.getCurrencyInstance(Locale.CANADA).format(order.getSubTotal()));
			OrderPanel.this.taxes.setText(NumberFormat.getCurrencyInstance(Locale.CANADA).format(order.getTaxes()));
			OrderPanel.this.total.setText(NumberFormat.getCurrencyInstance(Locale.CANADA).format(order.getTotal()));
		}
		else {
			source.setText("0");
			order.update(menu.getItem(i), Integer.valueOf(source.getText()));
		}
	}
	}

    
    // -------------------------------------------------------------------------------
    /**
     * Displays the names for each item and the labels
     */
    private Menu menu = null;
    private Order order = new Order();

   
    
   
    /**
     * Displays the quantities for each item
     */
    private final JTextField hotdogValue = new JTextField("0");
    private final JTextField hamburgerValue = new JTextField("0");
    private final JTextField cheeseburgerValue = new JTextField("0");
    private final JTextField friesValue = new JTextField("0");
    private final JTextField poutineValue = new JTextField("0");
    private final JTextField pizzaValue = new JTextField("0");
    private final JTextField drinkValue = new JTextField("0");
    /**
     * Displays the value for subtotal,taxes,total
     */
    private final JLabel subtotal = new JLabel(NumberFormat.getCurrencyInstance(Locale.CANADA).format(order.getSubTotal()));
    private final JLabel taxes = new JLabel(NumberFormat.getCurrencyInstance(Locale.CANADA).format(order.getTaxes()));
    private final JLabel total = new JLabel(NumberFormat.getCurrencyInstance(Locale.CANADA).format(order.getTotal()));
    /**
     * Prints the final result
     */
    private final JButton printButton = new JButton("Print");

    /**
     * The view constructor.
     *
     * @param menu Menu
     */
    public OrderPanel(final Menu menu) {
	this.menu = menu;
	this.layoutView();
	this.registerListeners();
    }

    /**
     * Uses the GridLayout to place the labels and buttons.
     */
    private void layoutView() {
	// Define the panel border.
	this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	GridLayout grid = new GridLayout(menu.size() + 5, 3);
	this.setLayout(grid);
	this.add(new JLabel("Item"));
	this.add(new JLabel("Price"));
	this.add(new JLabel("Quantity"));
	
	this.add(new JLabel("hot dog"));
	this.add(new JLabel("$1.25", SwingConstants.RIGHT));
	this.hotdogValue.setHorizontalAlignment(SwingConstants.RIGHT);
	this.add(hotdogValue);
	
	this.add(new JLabel("hamburger"));
	this.add(new JLabel("$2.00", SwingConstants.RIGHT));
	this.hamburgerValue.setHorizontalAlignment(SwingConstants.RIGHT);
	this.add(hamburgerValue);
	
	this.add(new JLabel("cheeseburger"));
	this.add(new JLabel("$2.75", SwingConstants.RIGHT));
	this.cheeseburgerValue.setHorizontalAlignment(SwingConstants.RIGHT);
	this.add(cheeseburgerValue);
	
	this.add(new JLabel("fries"));
	this.add(new JLabel("$1.75", SwingConstants.RIGHT));
	this.friesValue.setHorizontalAlignment(SwingConstants.RIGHT);
	this.add(friesValue);
	
	this.add(new JLabel("poutine"));
	this.add(new JLabel("$3.75", SwingConstants.RIGHT));
	this.poutineValue.setHorizontalAlignment(SwingConstants.RIGHT);
	this.add(poutineValue);
	
	this.add(new JLabel("pizza"));
	this.add(new JLabel("$10.00", SwingConstants.RIGHT));
	this.pizzaValue.setHorizontalAlignment(SwingConstants.RIGHT);
	this.add(pizzaValue);
	
	this.add(new JLabel("drink"));
	this.add(new JLabel("$1.50", SwingConstants.RIGHT));
	this.drinkValue.setHorizontalAlignment(SwingConstants.RIGHT);
	this.add(drinkValue);
	
	this.add(new JLabel("Subtotal:"));
	this.add(new JLabel());
	this.subtotal.setHorizontalAlignment(SwingConstants.RIGHT);
	this.add(subtotal);
	
	this.add(new JLabel("Taxes:"));
	this.add(new JLabel());
	this.taxes.setHorizontalAlignment(SwingConstants.RIGHT);
	this.add(taxes);
	
	this.add(new JLabel("Total:"));
	this.add(new JLabel());
	this.total.setHorizontalAlignment(SwingConstants.RIGHT);
	this.add(total);
	
	this.add(new JLabel());
	this.printButton.setHorizontalAlignment(SwingConstants.CENTER);
	this.add(printButton);
	
    }

    /**
     * Assigns listeners to the view widgets and the model.
     */
    private void registerListeners() {
	// Add textfield Listeners.
	this.hotdogValue.addFocusListener(new QuantityListener());
	this.hamburgerValue.addFocusListener(new QuantityListener());
	this.cheeseburgerValue.addFocusListener(new QuantityListener());
	this.friesValue.addFocusListener(new QuantityListener());
	this.poutineValue.addFocusListener(new QuantityListener());
	this.pizzaValue.addFocusListener(new QuantityListener());
	this.drinkValue.addFocusListener(new QuantityListener());
	
	// Add Button listeners.
	this.printButton.addActionListener(new PrintListener());
    }


}