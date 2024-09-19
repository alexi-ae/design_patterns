package com.design.patterns.creational.abstractfactory.service.impl;

import com.design.patterns.creational.abstractfactory.service.AccountService;
import com.design.patterns.creational.abstractfactory.service.CardService;
import com.design.patterns.creational.abstractfactory.service.FinancialProductAbstractFactory;
import com.design.patterns.creational.abstractfactory.service.LoanService;

public class PersonalProductFactory implements FinancialProductAbstractFactory {

  @Override
  public AccountService accountInstance() {
    System.out.println("PersonalProductFactory new accountInstance()");
    return new PersonalAccountServiceImpl();
  }

  @Override
  public CardService cardInstance() {
    System.out.println("PersonalProductFactory new cardInstance()");
    return new PersonalCardServiceImpl();
  }

  @Override
  public LoanService loadInstance(double amount) {
    System.out.println("PersonalProductFactory new loadInstance()");
    return new PersonalLoanServiceImpl(amount);
  }
}
