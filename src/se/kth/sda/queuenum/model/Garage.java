package se.kth.sda.queuenum.model;

/**
 * This is a facade to the hardware of the GARAGE, namely the door and the queue
 * number display on the outside wall.
 */
public class Garage {
    private Door door = new Door();
    
    /**
     * Creates an instance and connects to the door and queue number display.
     */
    public Garage() {
    }

    /**
     * Opens the door and displays the next queue number.
     */
    public void nextCustomer() {
        door.open();
    }

    /**
     * Closes the door
     */
    public void closeDoor() {
        door.close();
    }

}

