package se.kth.sda.queuenum.model;

/**
 * To handle cash payment
 *
 * @author tmp-sda-1160
 */
public class CashRegistry {

    private double purchase;
    private double payment;

    /**
     * To set initial cost and payment as zero
     */
    public CashRegistry() {
        purchase = 0;
        payment = 0;

    }

    /**
     * To set total cost as Purchase
     *
     * @param amount
     */
    public void recordPurchase(double amount) {
        purchase += amount;
    }

    /**
     * To enter cash user paid
     *
     * @param amount
     */
    public void enterPayment(double amount) {
        payment = amount;
    }

    /**
     * To calculate refund
     *
     * @return
     */
    public double giveChange() {
        double change = payment - purchase;
        purchase = 0;
        payment = 0;
        return change;
    }

}
