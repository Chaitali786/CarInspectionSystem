package se.kth.sda.queuenum.model;

import se.kth.sda.queuenum.integration.Display;

/**
 * Manages and stores queue number.
 */
public class QueueNumber {
    private int queueNo = 0;
    
    
    public QueueNumber()
    {
        
    }
    
    public void incrementQueueNo()
    {
      queueNo++;
    }
    public int getQueueNo()
    {
     return queueNo;
    }
}
