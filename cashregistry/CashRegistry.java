/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashregistry;

/**
 *
 * @author yannick
 */
public class CashRegistry {
    private double purchase;
    private double payment;
    
    public CashRegistry (){
        purchase=0;
        payment=0;
    
}
    public void recordPurchase(double amount){
        purchase+=amount;
    }
    
    public void enterPayment(double amount){
        payment=amount;
    }
    public double giveChange(){
    double change=payment-purchase;
    purchase=0;
    payment=0;
    return change;
    }
    

    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
        // TODO code application logic here
    }
    
