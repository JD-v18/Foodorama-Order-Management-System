package cp213;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Stores a List of MenuItems and provides a method return these items in a
 * formatted String. May be constructed from an existing List or from a file
 * with lines in the format:
 *
 * <pre>
1.25 hot dog
10.00 pizza
...
 * </pre>
 *
 * @author Jidaan Dahiya
 * @version 2022-05-20
 */
public class Menu {

    // Attributes.
	private final ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
    

    /**
     * Creates a new Menu from an existing Collection of MenuItems. MenuItems are
     * copied into the Menu List.
     *
     * @param items an existing Collection of MenuItems.
     */
    public Menu(Collection<MenuItem> items) {
    	Menu.this.menu.addAll(items);
    	return;
    }
    	
    

    /**
     * Constructor from a Scanner of MenuItem strings. Each line in the Scanner
     * corresponds to a MenuItem. You have to read the Scanner line by line and add
     * each MenuItem to the List of items.
     *
     * @param fileScanner A Scanner accessing MenuItem String data.
     */
    public Menu(Scanner fileScanner) {
    	String dataset = "";
    	while(fileScanner.hasNextLine()) {
    		dataset = fileScanner.nextLine();
    		String[] strarr = dataset.split(" ",2);
    		MenuItem data = new MenuItem(strarr[1], Double.parseDouble(strarr[0]));
    		Menu.this.menu.add(data);
    	}
    	return;
    }

    /**
     * Returns the List's i-th MenuItem.
     *
     * @param i Index of a MenuItem.
     * @return the MenuItem at index i
     */
    public MenuItem getItem(int i) {
	return Menu.this.menu.get(i);
    }

    /**
     * Returns the number of MenuItems in the items List.
     *
     * @return Size of the items List.
     */
    public int size() {
    	return Menu.this.menu.size();
    }

    /**
     * Returns the Menu items as a String in the format:
     *
     * <pre>
    5) poutine      $ 3.75
    6) pizza        $10.00
     * </pre>
     *
     * where n) is the index + 1 of the MenuItems in the List.
     */
    @Override
    public String toString() {
    	int n = 0;
    	String output = "";
    	while (n < Menu.this.menu.size()) {
    		output += String.format("%d) %s\n", n+1, Menu.this.menu.get(n).toString());
    		n ++;
    	}
	return output;
    }
}