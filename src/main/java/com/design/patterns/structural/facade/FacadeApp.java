package com.design.patterns.structural.facade;

import com.design.patterns.structural.facade.service.BankingProcessFacade;

public class FacadeApp {

  public static void main(String[] args) {

    BankingProcessFacade bankingProcessFacade = new BankingProcessFacade();
    bankingProcessFacade.openAccount("test user", "Ahorro", "test@gmail.com");
    bankingProcessFacade.transferFunds("123456", "987654", 250.00, "test@gmail.com");

    BankingProcessFacade bankingProcessFacade2 = new BankingProcessFacade();
    bankingProcessFacade2.openAccount("test user 2", "Ahorro", "test2@gmail.com");
    bankingProcessFacade2.transferFunds("456456", "987654", 600, "test2@gmail.com");

  }
}
