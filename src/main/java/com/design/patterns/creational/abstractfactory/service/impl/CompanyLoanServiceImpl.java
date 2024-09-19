package com.design.patterns.creational.abstractfactory.service.impl;

import com.design.patterns.creational.abstractfactory.service.LoanService;

public class CompanyLoanServiceImpl implements LoanService {

  private double amount;

  public CompanyLoanServiceImpl(double amount) {
    this.amount = 0.0;
  }

  @Override
  public void process() {

  }
}
