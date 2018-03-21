package model;

import integration.Display;

/**
 * Manages and stores queue number.
 */
public class QueueNumber {
    private int queueNo = 0;
    
    
    public QueueNumber()
    {
        
    }
    
    /**
     * To increment Queue no
     */
    public void incrementQueueNo()
    {
      queueNo++;
    }
    /**
     * To get Current Queue No
     * @return 
     */
    public int getQueueNo()
    {
     return queueNo;
    }
}
