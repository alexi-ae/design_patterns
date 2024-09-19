package com.design.patterns.creational.abstractfactory.service.impl;

import com.design.patterns.creational.abstractfactory.service.AccountService;
import com.design.patterns.creational.abstractfactory.service.CardService;
import com.design.patterns.creational.abstractfactory.service.FinancialProductAbstractFactory;
import com.design.patterns.creational.abstractfactory.service.LoanService;

public class CompanyProductFactory implements FinancialProductAbstractFactory {

  @Override
  public AccountService accountInstance() {
    System.out.println("CompanyProductFactory new accountInstance()");
    return new CompanyAccountServiceImpl();
  }

  @Override
  public CardService cardInstance() {
    System.out.println("CompanyProductFactory new accountInstance()");
    return new CompanyCardServiceImpl();
  }

  @Override
  public LoanService loadInstance(double amount) {
    System.out.println("CompanyProductFactory new accountInstance()");
    return new CompanyLoanServiceImpl(amount);
  }
}
