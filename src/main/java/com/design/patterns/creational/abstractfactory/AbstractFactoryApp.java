package com.design.patterns.creational.abstractfactory;

import com.design.patterns.creational.abstractfactory.service.AccountService;
import com.design.patterns.creational.abstractfactory.service.CardService;
import com.design.patterns.creational.abstractfactory.service.FinancialProductAbstractFactory;
import com.design.patterns.creational.abstractfactory.service.LoanService;

public class AbstractFactoryApp {

  public static void main(String[] args) {
    FinancialProductAbstractFactory personalFactory = FactoryProducer.getFactory("PERSONAL");
    AccountService personalAccountService = personalFactory.accountInstance();
    CardService personalCardService = personalFactory.cardInstance();
    LoanService personalLoanService = personalFactory.loadInstance(1000.00);
    personalAccountService.deposit(800.00);
    personalAccountService.withdraw(200);
    personalAccountService.getBalance();
    personalCardService.create();
    personalLoanService.process();

    System.out.println("****************************************");

    FinancialProductAbstractFactory factory = FactoryProducer.getFactory("COMPANY");
    AccountService companyAccountService = factory.accountInstance();
    CardService companyCardService = factory.cardInstance();
    LoanService companyLoanService = factory.loadInstance(500000.00);
    companyAccountService.deposit(45000.00);
    companyAccountService.withdraw(30000.00);
    companyAccountService.getBalance();
    companyCardService.create();
    companyLoanService.process();
  }
}
