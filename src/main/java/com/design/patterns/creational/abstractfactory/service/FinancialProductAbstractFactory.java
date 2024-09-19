package com.design.patterns.creational.abstractfactory.service;

public interface FinancialProductAbstractFactory {

  AccountService accountInstance();

  CardService cardInstance();

  LoanService loadInstance(double amount);

}
