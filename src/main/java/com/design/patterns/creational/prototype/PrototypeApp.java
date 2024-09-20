package com.design.patterns.creational.prototype;

import com.design.patterns.creational.prototype.form1.BankAccount;
import com.design.patterns.creational.prototype.form2.BankAccountOptional;

public class PrototypeApp {

  public static void main(String[] args) {
    protoType_form1();
    protoType_form2();
  }

  private static void protoType_form1() {
    System.out.println("*****START FORM 1*******************************");
    BankAccount originalAccount = new BankAccount("John Doe", "Savings Account", 1500.0);
    BankAccount clonedAccount = (BankAccount) originalAccount.clone();

    System.out.println("************************************");
    printData(originalAccount, null);
    printData(null, clonedAccount);

    System.out.println("**********MODIFY CLONE**************************");
    clonedAccount.setBalance(12000.00);
    printData(null, clonedAccount);
    System.out.println("********************************************");
    System.out.println("**********ACCOUNTS**************************");
    printData(originalAccount, null);
    printData(null, clonedAccount);
    System.out.println("*****END FORM 1*******************************");
  }

  private static void protoType_form2() {
    try {
      System.out.println("*****START FORM 2*******************************");
      BankAccountOptional originalAccount = new BankAccountOptional("John Doe", "Savings Account",
          1500.0);
      BankAccountOptional clonedAccount = (BankAccountOptional) originalAccount.clone();
      System.out.println("************************************");
      printData(originalAccount, null);
      printData(null, clonedAccount);
      System.out.println("**********MODIFY CLONE**************************");
      clonedAccount.setBalance(12000.00);
      printData(null, clonedAccount);

      System.out.println("********************************************");
      System.out.println("**********ACCOUNTS**************************");
      printData(originalAccount, null);
      printData(null, clonedAccount);
      System.out.println("*****END FORM 2*******************************");
    } catch (Exception e) {
      System.out.println("Error in clone object");
    }

  }

  private static void printData(BankAccount original, BankAccount clone) {
    System.out.println("************************************");
    if (original != null) {
      System.out.println("Original Account: " + original);
      System.out.println("owner: " + original.getOwner());
      System.out.println("accountType: " + original.getAccountType());
      System.out.println("balance: " + original.getBalance());

    } else {
      System.out.println("Clone Account: " + clone);
      System.out.println("owner: " + clone.getOwner());
      System.out.println("accountType: " + clone.getAccountType());
      System.out.println("balance: " + clone.getBalance());
    }
  }

  private static void printData(BankAccountOptional original, BankAccountOptional clone) {
    System.out.println("************************************");
    if (original != null) {
      System.out.println("Original Account: " + original);
      System.out.println("owner: " + original.getOwner());
      System.out.println("accountType: " + original.getAccountType());
      System.out.println("balance: " + original.getBalance());

    } else {
      System.out.println("Clone Account: " + clone);
      System.out.println("owner: " + clone.getOwner());
      System.out.println("accountType: " + clone.getAccountType());
      System.out.println("balance: " + clone.getBalance());
    }
  }
}
