package com.personal.tutorial;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
public static void main(String[] args) {
   loanCalculator();

}

public static void loanCalculator(){
     final byte percent = 100;
    final byte month_in_year = 12;
    Scanner scanner = new Scanner(System.in);
    System.out.print("Price of the house - ");
    int housePrice = scanner.nextInt();
    System.out.print("How much downpayment you are planning - ");
    int downpayment = scanner.nextInt();

    int loanAmount = housePrice - downpayment ; 

    System.out.print("What is the interest rate  - ");
    float annulInterestRate = scanner.nextFloat();
    float monthlyInterest  = annulInterestRate / percent / month_in_year ;

    System.out.print("Period (Years) - ");
    byte years = scanner.nextByte();
    scanner.close();
    int numberOfPayments = years * month_in_year ; 
    double mortgage = loanAmount * (monthlyInterest * Math.pow(1+ monthlyInterest, numberOfPayments))/ (Math.pow(1+ monthlyInterest, numberOfPayments)-1);

    String monthly = java.text.NumberFormat.getCurrencyInstance().format(mortgage);
    System.out.println("Monthly payment - " + monthly);
    double interestPaid = ((mortgage * numberOfPayments)- loanAmount);
    String interestPaidInCurrency = NumberFormat.getCurrencyInstance().format(interestPaid);
    System.out.println("Total interest paid - " + interestPaidInCurrency);
}
    
}
