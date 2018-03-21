package integration;

/**
 * Controls the queue number display. This is the only class updating the display.
 */
public class Display {
    
    /**
     * Connects to the display and shows the number zero.
     */
    public Display() {
        displayNo(0);
    }

    /**
     * When this method returns, the display is showing the specified number.
     * 
     * @param number The number to show. 
     */
    public void displayNo(int number) {
        System.out.println("The display is now showing: " + number);
    }
}
