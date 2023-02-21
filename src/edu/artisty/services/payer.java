/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisty.services;


/**
 *
 * @author yessmine
 */
public class payer  {

 
  CashPayment cp1 = new CashPayment(100.00);
  CashPayment cp2 = new CashPayment(200.00);
  
  CreditCardPayment cc1= new CreditCardPayment(1000.00, "name1", "04/27", "123456789");
  CreditCardPayment cc2= new CreditCardPayment(2000.00, "name2", "03/27", "987654321");
  
  cp1.paymentDetails();
  cp2.paymentDetails();
  cc1.paymentDetails();
  cc2.paymentDetails();
 }

class Payment{
 double prix_tot;
 
 public double getAmount() {
  return prix_tot;
 }
 public void setAmount(double prix_tot) {
  this.prix_tot= prix_tot;
 }
 
 Payment(double val){
  this.prix_tot=Math.round(val * 100)/100.0;
 }
 public void paymentDetails() {
  System.out.println("The payment amount is= "+this.prix_tot);  
  cp1.paymentDetails();
  cp2.paymentDetails();
  cc1.paymentDetails();
  cc2.paymentDetails();
 }
}
class CashPayment extends Payment{
 CashPayment(double val){
  super(val);
 }
 @Override
 public void paymentDetails() {
  System.out.println("The payment amount is="+this.prix_tot);
 }
}
class CreditCardPayment extends Payment{
 String CardName, ExpirationDate,CreditCardNumber;
 
 CreditCardPayment(double Value, String CardName, String ExpirationDate, String CreditCardNumber){
  super(Value);
  this.CardName=CardName;
  this.ExpirationDate=ExpirationDate;
  this.CreditCardNumber= CreditCardNumber;
 }
 @Override
 public void paymentDetails() {
  System.out.println("The payment of Amount "+this.prix_tot + "by the card "+this.CreditCardNumber+ " with the expiry date "+this.ExpirationDate+ " by the card holder "+ this.CardName );
 }
}

