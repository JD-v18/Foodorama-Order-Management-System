package cp213;

import java.util.Scanner;

/**
 * Wraps around an Order object to ask for MenuItems and quantities.
 *
 * @author Jidaan Dahiya
 * @version 2022-05-20
 */
public class Cashier {

    // Attributes
	private Menu menu = null;
	private final Order order = new Order();
	
    /**
     * Constructor.
     *
     * @param menu A Menu.
     */
    public Cashier(Menu menu) {
	this.menu = menu;
    }

    /**
     * Prints the menu.
     */
    private void printCommands() {
	System.out.println("\nMenu:");
	System.out.println(menu.toString());
	System.out.println("Press 0 when done.");
	System.out.println("Press any other key to see the menu again.\n");
    }

    /**
     * Asks for commands and quantities. Prints a receipt when all orders have been
     * placed.
     *
     * @return the completed Order.
     */
//    public Order takeOrder() {
//        System.out.println("Welcome to WLU Foodorama!");
//        Scanner keyboard = new Scanner(System.in);
//        Cashier.this.printCommands();
//        System.out.println();
//        boolean check = true;
//        while (check) {
//        	System.out.print("Command: ");
//        	if (keyboard.hasNextInt()) {
//        		int command = keyboard.nextInt();
//        		if (command == 0) {
//        			check = false;
//        		}
//        		else if (command >= 1 && command <= menu.size()) {
//        			System.out.print("How many do you want? ");
//        			if (keyboard.hasNextInt()) {
//        				int quant = keyboard.nextInt();
//        				if (quant > 0)
//        					order.add(menu.getItem(command), quant);
//        			}
//        			else {
//        				System.out.println("Not a valid number");
//        				keyboard.next();
//        			}
//        		}
//        		else {
//        			printCommands();
//        		}
//        	}
//        	else {
//        		System.out.println("Not a valid number");
//        		keyboard.next();
//        		printCommands();
//        	}
//        }
//        System.out.println("----------------------------------------");
//    	System.out.println("Receipt");
//        System.out.println(order.toString());
//        keyboard.close();
//        return order;
//    }


    public Order takeOrder() {
		System.out.println("Welcome to WLU Foodorama!");
		printCommands();
		final Scanner keyboard = new Scanner(System.in);
		Order(keyboard);
		keyboard.close();
		System.out.println("----------------------------------------");
		System.out.println("Receipt");
		System.out.println(order.toString());
		return order;
	}

    /**
     * Asks for commands and quantities. Returns a HashMap for Order.
     *
     * @param  Scanner keyboard
     */
    // Command text checked           
    private void Order(final Scanner keyboard) {
    	while (true) {
    		System.out.print("Command: ");
    		if (keyboard.hasNextInt()) {
    			int index = keyboard.nextInt();
    			if (index == 0) {
    				break;
    			}
    			else if (index >= 1 && index <= 7) {
    				System.out.print("How many do you want? ");
    				if (keyboard.hasNextInt()) {
    					int quantity = keyboard.nextInt();
    					if (quantity > 0) {
    						order.add(menu.getItem(index - 1), quantity);
    					}
    				}
    				else {
    					System.out.println("Not a valid number");
    					keyboard.next();
    				}
    			}
    			else {
    				printCommands();
    			}
    		}
    		else {
    			System.out.println("Not a valid number");
    			printCommands();
    			keyboard.next();
    		}
    	}
    	return;
    }
}